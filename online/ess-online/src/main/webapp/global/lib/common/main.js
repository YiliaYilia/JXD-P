+function eventAdapt(){

	var touchAble = 'ontouchstart' in window;
		window.tap = 'click';
	
	if(touchAble){
		window.tap = 'tap';
	}
	
	if(!window.console){
		window.console = {};
		
		console.log = function(){
			//TODO
		};
	}
	
	window.modal_alert = function(str,callback){
		alert(str);
		if(callback){
			callback();
		}
	};
	
	window.modal_dialog = function(str,callback){
		if(!confirm(str)){
			return;
		}
		
		if(callback){
			callback();
		}
	};
}();

$.ajaxSetup({
	contentType: "application/x-www-form-urlencoded",
	timeout:60000
});

+function(){
	
	var global = this;
	
	if (typeof sino === 'undefined') {
        global.sino = {};
    }
	
	sino.global = global;
	
	sino.apply = function(object, config, defaults) {
        if (defaults) {
        	sino.apply(object, defaults);
        }

        if (object && config && typeof config === 'object') {
            for (var i in config) {
                object[i] = config[i];
            }
        }
        return object;
    };
	
    //基础功能
    sino.apply(sino,{
    	emptyFn: function(){},
    	namespaceRewrites: [{
            from: 'sino.',
            to: sino
        }],
    	parseNamespace: function(namespace) {
            if (typeof namespace != 'string') {
                throw new Error("[sino] Invalid namespace, must be a string");
            }

            var parts = [],
            	rewrites = this.namespaceRewrites,
                root = global,
                name = namespace,
                rewrite, from, to, i, ln;

            for (i = 0, ln = rewrites.length; i < ln; i++) {
                rewrite = rewrites[i];
                from = rewrite.from;
                to = rewrite.to;

                if (name === from || name.substring(0, from.length) === from) {
                    name = name.substring(from.length);
                    
                    if (typeof to != 'string') {
                        root = to;
                    } else {
                        parts = parts.concat(to.split('.'));
                    }
                    
                    break;
                }
            }

            parts.push(root);

            parts = parts.concat(name.split('.'));
            return parts;
        },
        namespace: function(){
    		var root = global,
    		    parts, part, i, j, ln, subLn;
    		
    		for (i = 0, ln = arguments.length; i < ln; i++) {
    		    parts = this.parseNamespace(arguments[i]);
    		
    		    for (j = 0, subLn = parts.length; j < subLn; j++) {
    		        part = parts[j];
    		
    		        if (typeof part != 'string') {
    		            root = part;
    		        } else {
    		            if (!root[part]) {
    		                root[part] = {};
    		            }
    		
    		            root = root[part];
    		        }
    		    }
    		}
    		return root;
    	},
    	RunTime : function(){
    		var beg = null,
    			end = null,
    			step = 0;
    		
    		this.start = function(){
    			beg = new Date().getTime();
    			step = 0;
    		};
    		
    		this.printTime = function(str){
    			end = new Date().getTime();
    			step ++;
    			var extraStr = '';
    			if(str){
    				extraStr = str + ' ';
    			}else{
    				extraStr = 'step' + step + ' : ';
    			}
    			if(console){
    				console.log(extraStr +(end-beg));
    			}
    		};
    	},
    	loader: {
			ver:1,
			w_i: function(s,o){
				o.onload = null;
				window.setTimeout(function(){
					o.src=s;
				},100);
			},
			w_s:function(s,o,writeSelf){
				if (!writeSelf){
					o = o.parentNode;
				}
				if (s.indexOf(':')==-1){
					if (s.charAt(0)==' ')
						window.setTimeout(function(){
							o.className=o.className+s;
						},100);
					else
						window.setTimeout(function(){
							o.className=s;
						},100);
					}
				else{
					if (s.charAt(0)==';'){
						window.setTimeout(function(){
							o.style.cssText=o.style.cssText+s;
						},100);
					}
					else{
						window.setTimeout(function(){
							o.style.cssText=s;
						},100);
					}
				}
			},
			scriptPath : function(name){
				var path = '';
				
				var el=document.getElementsByTagName("script");
				for(var i=el.length;i>0;i--){
					if(el[i-1].src.indexOf(name)>-1){
						path=el[i-1].src.substring(0,el[i-1].src.lastIndexOf("/")+1);
					}
				}
				return path;
			},
			css:function (src,sync){
				if(sync){
					sync = "<link rel='stylesheet' href='"+src+"' type='text/css'/>";
					if(document._documentWirteBak){
						document._documentWirteBak(sync);
					}
					else{
						document.write(sync);
					}
					return;
				}
				var x = document.createElement('link');
				x.href = src;
				x.rel = 'stylesheet';
				x.type = 'text/css';
				var h = document.getElementsByTagName('head')[0];
				h.insertBefore(x,h.firstChild);
			},
			
			scriptTpl:null,
			script:function(src,callback,charset,sync){
				if(typeof(arguments[0])=='object'){
					var o = arguments[0];
					if(o.src){
						src = o.src;
					}else{
						return;
					}
					
					if(o.callback){
						callback = o.callback;
					}
					
					if(o.charset){
						charset = o.charset;
					}
					
					if(o.sync){
						sync = o.sync;
					}
				}
				if(!this.scriptTpl){
					this.scriptTpl = document.createElement('script');
				}
				if(sync){
					if(callback){
						var k='call'+Math.random().toString().substr(2);
						var c;
						this.callback[k]=callback;
						if(this.scriptTpl.readyState)
							c=" onreadystatechange='if(this.readyState && this.readyState != \"loaded\" && this.readyState != \"complete\")return;window.loader.callback."+k+".call(this)' ";
						else
							c=" onload='window.loader.callback."+k+".call(this)' ";
						}
					else{
						c='';
					}
					sync = "<scr"+"ipt src='"+src+"' "+(charset ? "charset='"+charset+"'" : '')+" "+c+" type='text/javasc"+"ript'></scr"+"ipt>";
					if(document._documentWirteBak){
						document._documentWirteBak(sync);
					}
					else{ 
						document.write(sync);
					}
					return;
				}
				var x = this.scriptTpl.cloneNode(0);
				x.src=src;
				if(charset){
					x.charset = charset;
				}
				if (callback) {
					if(x.readyState){
						x.onreadystatechange = function() {
							if (this.readyState && this.readyState != 'loaded' && this.readyState != 'complete'){
								return;
							}
							callback.call(this);
						};
					}
					else{
						x.onload = function(){
							callback.call(this);
						};
					}
				}
				
				var h = document.getElementsByTagName('head')[0];
				h.insertBefore(x,h.firstChild);
			},
			callback:{}
		}
//		browser:{
//			name:function(){
//				var userAgent = navigator.userAgent.toLowerCase();
//				if(/webkit/.test( userAgent ) && /safari/.test( userAgent ) && !/chrome/.test( userAgent )){
//					return 'safari';
//				}
//				if(/webkit/.test( userAgent ) && /chrome/.test( userAgent )){
//					return 'chrome';
//				}
//				if(/opera/.test( userAgent )){
//					return 'opera';
//				}
//				if(/msie/.test( userAgent ) && !/opera/.test( userAgent )){
//					return 'msie';
//				}
//				if(/mozilla/.test( userAgent ) && !/(compatible|webkit)/.test( userAgent )){
//					return 'mozilla';
//				}
//				return 'other';
//			},
//			version:function(){
//				var userAgent = navigator.userAgent.toLowerCase();
//				console.log(userAgent);
//				
//				var ua = 'mozilla/4.0 (compatible; msie 8.0; windows nt 6.1; wow64; trident/4.0; qqdownload 718; mozilla/4.0 (compatible; msie 6.0; windows nt 5.1; sv1) ; slcc2; .net clr 2.0.50727; .net clr 3.5.30729; .net clr 3.0.30729; .net4.0c; .net4.0e; mddc; media center pc 6.0; staticlogin:product=cboxf2010&act=login&info=zmlszw5hbwu9ug93zxjxb3jkmjaxme94zl9vbhrpbwf0zs5legumbwfjpumzmji4qjbdmjjbrtremde4mtdfnkneneqynjfdndrcjnbhc3nwb3j0psz2zxjzaw9uptiwmtauni4zljyumizjcmfzahr5cgu9mq==&verify=3e181615556553b366a02c4a336e6f0f)';
//				console.log(userAgent.match( /.+(?:rv|it|ra|ie)[\/: ]([\d.]+)/ ));
//				return (userAgent.match( /.+(?:rv|it|ra|ie)[\/: ]([\d.]+)/ ) || [0,'0'])[1];
//			}
//		}
    });
    
    
    //初始化浏览器参数
    +function initBrowser(){
    	// Useragent RegExp
		var rwebkit = /(webkit)[ \/]([\w.]+)/,
			ropera = /(opera)(?:.*version)?[ \/]([\w.]+)/,
			rmsie = /(msie) ([\w.]+)/,
			rmozilla = /(mozilla)(?:.*? rv:([\w.]+))?/;
    	
    	var ua = navigator.userAgent.toLowerCase();
    	
    	var match = rwebkit.exec( ua ) ||
			ropera.exec( ua ) ||
			rmsie.exec( ua ) ||
			ua.indexOf("compatible") < 0 && rmozilla.exec( ua ) ||
			[];
    	
    	browserMatch = { browser: match[1] || "", version: match[2] || "0" };
    	
    	if ( browserMatch.browser ) {
    		sino.apply(sino,{
    			browser:{}
    		});
    		sino.browser[ browserMatch.browser ] = true;
    		sino.browser.version = browserMatch.version;
    	}
    }();
    
    var OS = function(){
    	var userAgent = navigator.userAgent,
	    	names = {
	            ios: 'iOS',
	            android: 'Android',
	            webos: 'webOS',
	            blackberry: 'BlackBerry',
	            rimTablet: 'RIMTablet',
	            mac: 'MacOS',
	            win: 'Windows',
	            linux: 'Linux',
	            bada: 'Bada',
	            other: 'Other'
	        },
	        prefixes = {
	            ios: 'i(?:Pad|Phone|Pod)(?:.*)CPU(?: iPhone)? OS ',
	            android: '(Android |HTC_|Silk/)',
	            blackberry: 'BlackBerry(?:.*)Version\/',
	            rimTablet: 'RIM Tablet OS ',
	            webos: '(?:webOS|hpwOS)\/',
	            bada: 'Bada\/'
	        },
	        name,
	        version = '',
	        i, prefix, match, item, is;
        
    	this.is = function(osname){
    		if(osname == name){
    			return true;
    		}else{
    			return false;
    		}
    	};
    	
    	for (i in prefixes) {
            if (prefixes.hasOwnProperty(i)) {
                prefix = prefixes[i];

                match = userAgent.match(new RegExp('(?:'+prefix+')([^\\s;]+)'));
                if (match) {
                    name = names[i];
                    break;
                }
            }
        }
    	
    	if (!name) {
            name = names[(userAgent.toLowerCase().match(/mac|win|linux/) || ['other'])[0]];
        }
    	
    	this.name = name;
        this.version = version;
        
        this.names = names;
    };
    
    sino.os = new OS();
    
    sino.keyboard = {
    	open:false
    };
    
    //待封装，移动软键盘相关功能
    var Keyboard = new function(){};
}();
