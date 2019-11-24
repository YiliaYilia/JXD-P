+function($) {

	var modals = {},
		openModal = [] ;
	
	
	var Modal = function(element, options) {
		this.options = options;
		this.$element = $(element);
		this.$backdrop = this.isShown = null;

		if (this.options.remote)
			this.$element.load(this.options.remote);
	};
	
	Modal.DEFAULTS = {
		closeOnBackClick : false,
		backdrop : true,
		closePrevModal:true,
		show : true
	};
	Modal.prototype.toggle = function(_relatedTarget) {
		return this[!this.isShown ? 'show' : 'hide'](_relatedTarget);
	};

	Modal.prototype.show = function(_relatedTarget) {
		var that = this;
		var e = $.Event('show.modal', {
			relatedTarget : _relatedTarget
		});
		this.$element.trigger(e);

		if (this.isShown || e.isDefaultPrevented())
			return;

		this.isShown = true;

		this.$element.on('click.dismiss.modal', '[data-dismiss="modal"]', $.proxy(this.hide, this));
		
		if(openModal.length > 0 && this.options.closePrevModal){
			var id = this.id;
			
			while(openModal.length >0 ){
				var md = openModal.pop();
				
				if(md.data && md.id != id){
					md.data.hide();
				}
			}
		}
		
		if(!this.options.closePrevModal){
			this.$element.css({
				"z-index":1050 + openModal.length*100
			});
		}
		
		this.backdrop(function() {
			var transition = $.support.transition
					&& that.$element.hasClass('fade');

			if (!that.$element.parent().length) {
				that.$element.appendTo(document.body);// don't move modals dom
				// position
			}

			that.$element.show();

			that.middleDialog();
			
			if (transition) {
				that.$element[0].offsetWidth; // force reflow
			}

			that.$element.addClass('in').attr('aria-hidden', false);

			that.enforceFocus();

			var e = $.Event('shown.modal', {
				relatedTarget : _relatedTarget
			});

			that.$element.one('shown.modal',function(){
				that.options.onShow && that.options.onShow(that);
			});
			
			transition ? that.$element.find('.modal-dialog') // wait for modal to slide in
			.one($.support.transition.end, function() {
				that.$element.focus().trigger(e);
			}).emulateTransitionEnd(300) : that.$element.focus().trigger(e);
		});
		
		openModal.push({
			data:this,
			id:this.id
		});
	};

	Modal.prototype.hide = function(e) {
		if (e)
			e.preventDefault();

		e = $.Event('hide.modal');

		this.$element.trigger(e);

		if (!this.isShown || e.isDefaultPrevented())
			return;

		this.isShown = false;
		$(document).off('focusin.modal');

		this.$element.removeClass('in').attr('aria-hidden', true).off(
				'click.dismiss.modal');

		$.support.transition && this.$element.hasClass('fade') ? this.$element
				.one($.support.transition.end, $.proxy(this.hideModal, this))
				.emulateTransitionEnd(300) : this.hideModal();
	};

	Modal.prototype.enforceFocus = function() {
		$(document).off('focusin.modal') // guard against infinite focus loop
		.on(
				'focusin.modal',
				$.proxy(function(e) {
					if (this.$element[0] !== e.target
							&& !this.$element.has(e.target).length) {
						this.$element.focus();
					}
				}, this));
	};

	Modal.prototype.middleDialog = function(){
		var $dialog = this.$element.find('.modal-dialog');
		
		var dh = $dialog.outerHeight(),
			bh = document.documentElement.clientHeight;
		if(dh < bh){
			$dialog.css('margin-top',(bh - dh)/2);
		}
	};
	
	Modal.prototype.hideModal = function() {
		var that = this;
		this.$element.hide();
		this.backdrop(function() {
			that.removeBackdrop();
			that.$element.trigger('hidden.modal');
		});
	};

	Modal.prototype.removeBackdrop = function() {
		this.$backdrop && this.$backdrop.remove();
		this.$backdrop = null;
	};

	Modal.prototype.backdrop = function(callback) {
		var animate = this.$element.hasClass('fade') ? 'fade' : '';

		if (this.isShown && this.options.backdrop) {
			var doAnimate = $.support.transition && animate;

			this.$backdrop = $('<div class="modal-backdrop ' + animate + '" />').appendTo(document.body);
			
			if(!this.options.closePrevModal){
				this.$backdrop.css({
					"z-index":1040 + openModal.length*100
				});
			}
			
			if(this.options.closeOnBackClick){
				this.$element.on('click.dismiss.modal', $.proxy(function(e) {
					if (e.target !== e.currentTarget)
						return;
					this.options.backdrop == 'static' ? this.$element[0].focus
							.call(this.$element[0]) : this.hide.call(this);
				}, this));
			}

			if (doAnimate)
				this.$backdrop[0].offsetWidth;// force reflow

			this.$backdrop.addClass('in');

			if (!callback)
				return;

			doAnimate ? this.$backdrop.one($.support.transition.end, callback)
					.emulateTransitionEnd(150) : callback();

		} else if (!this.isShown && this.$backdrop) {
			this.$backdrop.removeClass('in');

			$.support.transition && this.$element.hasClass('fade') ? this.$backdrop
					.one($.support.transition.end, callback)
					.emulateTransitionEnd(150)
					: callback();

		} else if (callback) {
			callback();
		}
	};

	// MODAL PLUGIN DEFINITION
	// =======================

	var old = $.fn.modal;

	$.fn.modal = function(option, _relatedTarget) {
		
		return this.each(function() {
			var $this = $(this);
			var data = $this.data('modal');
			var options = $.extend({}, Modal.DEFAULTS, $this.data(), typeof option == 'object' && option);

			if (!data){
				$this.data('modal', (data = new Modal(this, options)));
			}
			
			if(!modals[this.id]){
				modals[this.id] = data;
			}
			
			data.id = this.id;
			
			if (typeof option == 'string') {
				data[option](_relatedTarget);
			} else if (options.show)
				data.show(_relatedTarget);
		});
	};
	
	$.fn.modal.Constructor = Modal;
	

	$.fn.modal.noConflict = function() {
		$.fn.modal = old;
		return this;
	};
	$(document).on(
			tap,
			'[data-toggle="modal"]',
			function(e) {
				var $this = $(this);
				var href = $this.attr('href');
				var $target = $($this.attr('data-target') || (href && href.replace(/.*(?=#[^\s]+$)/, ''))) ;// strip for ie7
				
				var option = $target.data('modal') ? 'toggle' : $.extend({
					remote : !/#/.test(href) && href
				}, $target.data(), $this.data());

				e.preventDefault();

				$target.modal(option, this).one('hide', function() {
					$this.is(':visible') && $this.focus();
				});
			});
	  
	 $(document)
	 	.on('show.modal',  '.modal', function () {
	 		$(document.body).addClass('modal-open');
	 	})
	    .on('hidden.modal', '.modal', function () { 
	    	openModal.pop();
	    	
	    	if(openModal.length > 0){
	    		return;
	    	}
	    	
	    	$(document.body).removeClass('modal-open');
	    });
	 
	 $(document).ready(function(){
		 $('[data-rule=modal]').each(function(){
			 var that = $(this);
			 var id = this.id;
			 
			 window['dialog_'+id] = function(options){
				 that.modal(options);
			 };
		 });
		 
		 //生成loading方法
		 $('[data-rule=loading]').each(function(){
			 var that = $(this);
			 /**
			  * option: 
			  * 	null 			: to open the loading modal
			  * 	ajaxObject 	: open the modal, then close at ajax completed 
			  * 	string 		: call modal inner function
			  */
			 window.modal_loading = function(option){
				 var timeout = 1000;
				 var data = that.data('auto');
				 
				 if(!data){
					 data = {
						 autoClose:false,
						 canClose:false
					 };
					 that.data('auto',data);
				 }
				 
				 if(typeof option == 'string' && option === 'hide'){
					 data.autoClose = true;
					 if(data.canClose){
						 that.modal('hide');
					 }
				 }else{
					 
					 if(data.seed){
						 clearTimeout(data.seed);
						 data.autoClose = false;
						 data.canClose = false;
						 data.seed = 0;
					 }
					 
					 that.modal({
						 closeOnBackClick : false
					 });
					 
					 data.canClose = false;
					 data.seed = setTimeout(function(){
						 if(data.autoClose){
							 that.modal('hide');
						 }
						 data.canClose = true;
					 },timeout);
				 }
			 };
			 $(window).on('resize',function(){
				 that.modal('middleDialog');
			 });
		 });
		 //生成alert方法
		 $('[data-rule=alert]').each(function(){
			 var that = $(this);
			 
			 window.modal_alert = function(option){
				 
				 var closeOnBackClick = false;
				 if(typeof option == 'string' || typeof option == 'number' ){

					 that.find('[data-content="modal"]').html(option);
					 
					 that.find('[data-btn="modal"]').text('确定');
					//处理回调函数
					 var callback;
					 if( (callback = arguments[1]) && typeof callback == 'function'){
						 that.find('[data-btn="modal"]').off('click.dismiss.modal');
						 that.find('[data-btn="modal"]').on('click.dismiss.modal',callback);
					 }
				 }else if(typeof option == 'object'){
					 
					 if(option.content || option.content == 0){
						 that.find('[data-content="modal"]').html(option.content);
					 }
					 if(option.title || option.title == 0){
						 that.find('[data-title="modal"]').text(option.title);
					 }
					 if(option.callback && typeof option.callback == 'function'){
						 that.find('[data-btn="modal"]').off('click.dismiss.modal');
						 that.find('[data-btn="modal"]').on('click.dismiss.modal',option.callback);
					 }
					 
					 if(option.btn){
						 that.find('[data-btn="modal"]').text(option.btn);
					 }
				 }else{
					 return;
				 }
				 
				 that.modal({
					 closeOnBackClick : closeOnBackClick
				 });
			 };
			 
			 $(window).on('resize',function(){
				 that.modal('middleDialog');
			 });
		 });
		 
		//生成dialog方法
		 $('[data-rule=dialog]').each(function(){
			 var that = $(this);
			 
			 window.modal_dialog = function(option){
				 
				 if(typeof option == 'string'){

					 that.find('[data-content="modal"]').html(option);
					 
					//处理回调函数
					 var okFunc,cancelFunc;
					 var closeOnBackClick = false;
					 if( (okFunc = arguments[1]) && typeof okFunc == 'function'){
						 that.find('[data-btn="ok"]').off('click.dismiss.modal');
						 that.find('[data-btn="ok"]').on('click.dismiss.modal',okFunc);
					 }
					 
					 if( (cancelFunc = arguments[2]) && typeof cancelFunc == 'function'){
						 that.find('[data-btn="cancel"]').off('click.dismiss.modal');
						 that.find('[data-btn="cancel"]').on('click.dismiss.modal',cancelFunc);
					 }
					 
					 that.modal({
						 closeOnBackClick : closeOnBackClick,
						 closePrevModal : false
					 });
					 
				 }else if(typeof option == 'object'){
					 
				 }
			 };
			 
			 $(window).on('resize',function(){
				 that.modal('middleDialog');
			 });
		 });
	 });
}(jQuery);