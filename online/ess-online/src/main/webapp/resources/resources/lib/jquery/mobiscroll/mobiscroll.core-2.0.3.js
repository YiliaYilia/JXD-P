/*!
 * jQuery MobiScroll v2.0.2
 * http://mobiscroll.com
 *
 * Copyright 2010-2011, Acid Media
 * Licensed under the MIT license.
 *
 */
(function($) {
	function Scroller(elm, settings) {
		function getDocHeight() {
			var body = document.body,
			html = document.documentElement;
			return Math.max(body.scrollHeight, body.offsetHeight, html.clientHeight, html.scrollHeight, html.offsetHeight)
		}
		function setGlobals(t) {
			min = $("li.dw-v", t).eq(0).index(),
			max = $("li.dw-v", t).eq( - 1).index(),
			index = $("ul", dw).index(t),
			h = s.height,
			inst = that
		}
		function formatHeader(v) {
			var t = s.headerText;
			return t ? typeof t == "function" ? t.call(e, v) : t.replace(/{value}/i, v) : ""
		}
		function read() {
			that.temp = input && that.val !== null && that.val != elm.val() || that.values === null ? s.parseValue(elm.val() ? elm.val() : "", that) : that.values.slice(0),
			that.setValue(!0)
		}
		function scrollToPos(time, orig, index, manual, dir) {
			s.validate.call(e, dw, index, time),
			$(".dww ul", dw).each(function(i) {
				var t = $(this),
				cell = $('li[data-val="' + that.temp[i] + '"]', t),
				x = cell.index(),
				v = scrollToValid(cell, x, i, dir),
				sc = i == index || index === undefined;
				v != t.data("pos") && that.scroll($(this), v, sc ? time: .2, orig, i)
			}),
			that.change(manual)
		}
		function scrollToValid(cell, val, i, dir) {
			if (!cell.hasClass("dw-v")) {
				var cell1 = cell,
				cell2 = cell,
				dist1 = 0,
				dist2 = 0;
				while (cell1.prev().length && !cell1.hasClass("dw-v")) cell1 = cell1.prev(),
				dist1++;
				while (cell2.next().length && !cell2.hasClass("dw-v")) cell2 = cell2.next(),
				dist2++; (dist2 < dist1 && dist2 && !dir == 1 || !dist1 || !cell1.hasClass("dw-v") || dir == 1) && cell2.hasClass("dw-v") ? (cell = cell2, val += dist2) : (cell = cell1, val -= dist1),
				that.temp[i] = cell.attr("data-val")
			}
			return val
		}
		function position() {
			var totalw = 0,
			minw = 0,
			ww = $(window).width(),
			wh = $(window).height(),
			st = $(window).scrollTop(),
			o = $(".dwo", dw),
			d = $(".dw", dw),
			w,
			h;
			$(".dwc", dw).each(function() {
				w = $(this).outerWidth(!0),
				totalw += w,
				minw = w > minw ? w: minw
			}),
			w = totalw > ww ? minw: totalw,
			d.width(w + 1),
			w = d.outerWidth(),
			h = d.outerHeight(),
			d.css({
				"left": (ww - w) / 2,
				"top": st + (wh - h) / 2
			}),
			o.height(0).height(getDocHeight())
		}
		function plus(t) {
			var p = +t.data("pos"),
			val = p + 1;
			calc(t, val > max ? min: val, 1)
		}
		function minus(t) {
			var p = +t.data("pos"),
			val = p - 1;
			calc(t, val < min ? max: val, 2)
		}
		var that = this,
		e = elm,
		elm = $(e),
		theme,
		lang,
		s = $.extend({},
		defaults),
		m,
		dw,
		iv = {},
		input = elm.is("input"),
		visible = !1;
		that.enable = function() {
			s.disabled = !1,
			input && elm.prop("disabled", !1)
		},
		that.disable = function() {
			s.disabled = !0,
			input && elm.prop("disabled", !0)
		},
		that.scroll = function(t, val, time, orig, index) {
			function getVal(t, b, c, d) {
				return c * Math.sin(t / d * (Math.PI / 2)) + b
			}
			var px = (m - val) * s.height;
			t.attr("style", (time ? prefix + "-transition:all " + time.toFixed(1) + "s ease-out;": "") + (has3d ? prefix + "-transform:translate3d(0," + px + "px,0);": "top:" + px + "px;")),
			clearInterval(iv[index]);
			if (time && orig !== undefined) {
				var i = 0;
				iv[index] = setInterval(function() {
					i += .1,
					t.data("pos", Math.round(getVal(i, orig, val - orig, time))),
					i >= time && (clearInterval(iv[index]), t.data("pos", val).closest(".dwwl").removeClass("dwa"))
				},
				100)
			} else t.data("pos", val)
		},
		that.setValue = function(sc, fill, time) {
			that.values = that.temp.slice(0),
			visible && sc && scrollToPos(time);
			if (fill) {
				var v = s.formatResult(that.temp);
				that.val = v,
				input && elm.val(v).trigger("change")
			}
		},
		that.validate = function(time, orig, i, dir) {
			scrollToPos(time, orig, i, !0, dir)
		},
		that.change = function(manual) {
			var v = s.formatResult(that.temp);
			s.display == "inline" ? that.setValue(!1, manual) : $(".dwv", dw).html(formatHeader(v)),
			manual && s.onChange.call(e, v, that)
		},
		that.hide = function() {
			if (s.onClose.call(e, that.val, that) === !1) return ! 1;
			$(".dwtd").prop("disabled", !1).removeClass("dwtd"),
			elm.blur(),
			dw && dw.remove(),
			visible = !1,
			$(window).unbind(".dw")
		},
		that.show = function() {
			if (s.disabled || visible) return ! 1;
			var hi = s.height,
			l;
			read();
			var html = '<div class="' + s.theme + '">' + (s.display == "inline" ? '<div class="dw dwbg dwi"><div class="dwwr">': '<div class="dwo"></div><div class="dw dwbg"><div class="dwwr">' + (s.headerText ? '<div class="dwv"></div>': ""));
			for (var i = 0; i < s.wheels.length; i++) {
				html += '<div class="dwc' + (s.mode != "scroller" ? " dwpm": " dwsc") + (s.showLabel ? "": " dwhl") + '"><div class="dwwc dwrc"><table cellpadding="0" cellspacing="0"><tr>',
				l = 0;
				for (var label in s.wheels[i]) {
					html += '<td><div class="dwwl dwrc dwwl' + l + '">' + (s.mode != "scroller" ? '<div class="dwwb dwwbp" style="height:' + hi + "px;line-height:" + hi + 'px;"><span>+</span></div><div class="dwwb dwwbm" style="height:' + hi + "px;line-height:" + hi + 'px;"><span>&ndash;</span></div>': "") + '<div class="dwl">' + label + '</div><div class="dww dwrc" style="height:' + s.rows * hi + "px;min-width:" + s.width + 'px;"><ul>';
					for (var j in s.wheels[i][label]) html += '<li class="dw-v" data-val="' + j + '" style="height:' + hi + "px;line-height:" + hi + 'px;">' + s.wheels[i][label][j] + "</li>";
					html += '</ul><div class="dwwo"></div></div><div class="dwwol"></div></div></td>',
					l++
				}
				html += "</tr></table></div></div>"
			}
			html += (s.display != "inline" ? '<div class="dwbc"><span class="dwbw dwb-s"><a href="#" class="dwb">' + s.setText + '</a></span><span class="dwbw dwb-c"><a href="#" class="dwb">' + s.cancelText + "</a></span></div>": '<div class="dwcc"></div>') + "</div></div></div>",
			dw = $(html),
			scrollToPos(),
			s.display != "inline" ? dw.appendTo("body") : elm.is("div") ? elm.html(dw) : dw.insertAfter(elm),
			visible = !0,
			theme.init(dw, that),
			s.display != "inline" && ($(".dwb-s a", dw).click(function() {
				return that.setValue(!1, !0),
				that.hide(),
				s.onSelect.call(e, that.val, that),
				!1
			}), $(".dwb-c a", dw).click(function() {
				return that.hide(),
				s.onCancel.call(e, that.val, that),
				!1
			}), $("input,select").each(function() {
				$(this).prop("disabled") || $(this).addClass("dwtd")
			}), $("input,select").prop("disabled", !0), position(), $(window).bind("resize.dw", position)),
			dw.delegate(".dwwl", "DOMMouseScroll mousewheel",
			function(e) {
				if (!s.readonly) {
					e.preventDefault(),
					e = e.originalEvent;
					var delta = e.wheelDelta ? e.wheelDelta / 120 : e.detail ? -e.detail / 3 : 0,
					t = $("ul", this),
					p = +t.data("pos"),
					val = Math.round(p - delta);
					setGlobals(t),
					calc(t, val, delta < 0 ? 1 : 2)
				}
			}).delegate(".dwb, .dwwb", START_EVENT,
			function(e) {
				$(this).addClass("dwb-a")
			}).delegate(".dwwb", START_EVENT,
			function(e) {
				if (!s.readonly && !$(this).closest(".dwwl").hasClass("dwa")) {
					e.preventDefault(),
					e.stopPropagation();
					var t = $(this).closest(".dwwl").find("ul"),
					func = $(this).hasClass("dwwbp") ? plus: minus;
					click = !0,
					setGlobals(t),
					clearInterval(timer),
					timer = setInterval(function() {
						func(t)
					},
					s.delay),
					func(t)
				}
			}).delegate(".dwwl", START_EVENT,
			function(e) { ! move && !s.readonly && !click && s.mode != "clickpick" && (e.preventDefault(), move = !0, target = $("ul", this), target.closest(".dwwl").addClass("dwa"), pos = +target.data("pos"), setGlobals(target), clearInterval(iv[index]), start = getY(e), startTime = new Date, stop = start, that.scroll(target, pos))
			}),
			s.onShow.call(e, dw, that)
		},
		that.init = function(ss) {
			theme = $.extend({
				"defaults": {},
				"init": empty
			},
			$.scroller.themes[ss.theme ? ss.theme: s.theme]),
			lang = $.scroller.i18n[ss.lang ? ss.lang: s.lang],
			$.extend(s, theme.defaults, lang, settings, ss),
			that.settings = s,
			m = Math.floor(s.rows / 2);
			var preset = $.scroller.presets[s.preset];
			elm.unbind(".dw");
			if (preset) {
				var p = preset.call(e, that);
				$.extend(s, p, settings, ss),
				$.extend(methods, p.methods)
			}
			elm.data("dwro") !== undefined && (e.readOnly = bool(elm.data("dwro"))),
			visible && that.hide(),
			s.display == "inline" ? that.show() : (read(), input && s.showOnFocus && (elm.data("dwro", e.readOnly), e.readOnly = !0, elm.bind("focus.dw", that.show)), input && s.showOnClick && (elm.data("dwro", e.readOnly), e.readOnly = !0, elm.bind("click.dw", that.show)))
		},
		that.values = null,
		that.val = null,
		that.temp = null,
		that.init(settings)
	}
	function testProps(props) {
		for (var i in props) if (mod[props[i]] !== undefined) return ! 0;
		return ! 1
	}
	function testPrefix() {
		var prefixes = ["Webkit", "Moz", "O", "ms"];
		for (var p in prefixes) if (testProps([prefixes[p] + "Transform"])) return "-" + prefixes[p].toLowerCase();
		return ""
	}
	function getInst(e) {
		return scrollers[e.id]
	}
	function getY(e) {
		return e.changedTouches || e.originalEvent && e.originalEvent.changedTouches ? e.originalEvent ? e.originalEvent.changedTouches[0].pageY: e.changedTouches[0].pageY: e.pageY
	}
	function bool(v) {
		return v === !0 || v == "true"
	}
	function calc(t, val, dir, anim, orig) {
		val = val > max ? max: val,
		val = val < min ? min: val;
		var cell = $("li", t).eq(val);
		inst.temp[index] = cell.attr("data-val"),
		inst.validate(anim ? val == orig ? .1 : Math.abs((val - orig) * .1) : 0, orig, index, dir)
	}
	var scrollers = {},
	timer, empty = function() {},
	h,
	min,
	max,
	inst,
	date = new Date,
	uuid = date.getTime(),
	move,
	click,
	target,
	index,
	start,
	stop,
	startTime,
	endTime,
	pos,
	mod = document.createElement("modernizr").style,
	has3d = testProps(["perspectiveProperty", "WebkitPerspective", "MozPerspective", "OPerspective", "msPerspective"]) && "webkitPerspective" in document.documentElement.style,
	prefix = testPrefix(),
	START_EVENT = "touchstart mousedown",
	MOVE_EVENT = "touchmove mousemove",
	END_EVENT = "touchend mouseup",
	defaults = {
		"width": 70,
		"height": 40,
		"rows": 3,
		"delay": 300,
		"disabled": !1,
		"readonly": !1,
		"showOnFocus": !1,
		"showOnClick": !0,
		"showLabel": !0,
		"wheels": [],
		"theme": "",
		"headerText": "{value}",
		"display": "modal",
		"mode": "scroller",
		"preset": "",
		"lang": "en-US",
		"setText": "Set",
		"cancelText": "Cancel",
		"onShow": empty,
		"onClose": empty,
		"onSelect": empty,
		"onCancel": empty,
		"onChange": empty,
		"formatResult": function(d) {
			var out = "";
			for (var i = 0; i < d.length; i++) out += (i > 0 ? " ": "") + d[i];
			return out
		},
		"parseValue": function(val, inst) {
			var w = inst.settings.wheels,
			val = val.split(" "),
			ret = [],
			j = 0;
			for (var i = 0; i < w.length; i++) for (var l in w[i]) {
				if (w[i][l][val[j]] !== undefined) ret.push(val[j]);
				else for (var v in w[i][l]) {
					ret.push(v);
					break
				}
				j++
			}
			return ret
		},
		"validate": empty
	},
	methods = {
		"init": function(options) {
			return options === undefined && (options = {}),
			this.each(function() {
				this.id || (uuid += 1, this.id = "scoller" + uuid),
				scrollers[this.id] = new Scroller(this, options)
			})
		},
		"enable": function() {
			return this.each(function() {
				var inst = getInst(this);
				inst && inst.enable()
			})
		},
		"disable": function() {
			return this.each(function() {
				var inst = getInst(this);
				inst && inst.disable()
			})
		},
		"isDisabled": function() {
			var inst = getInst(this[0]);
			if (inst) return inst.settings.disabled
		},
		"option": function(option, value) {
			return this.each(function() {
				var inst = getInst(this);
				if (inst) {
					var obj = {};
					typeof option == "object" ? obj = option: obj[option] = value,
					inst.init(obj)
				}
			})
		},
		"setValue": function(d, fill, time) {
			return this.each(function() {
				var inst = getInst(this);
				inst && (inst.temp = d, inst.setValue(!0, fill, time))
			})
		},
		"getInst": function() {
			return getInst(this[0])
		},
		"getValue": function() {
			var inst = getInst(this[0]);
			if (inst) return inst.values
		},
		"show": function() {
			var inst = getInst(this[0]);
			if (inst) return inst.show()
		},
		"hide": function() {
			return this.each(function() {
				var inst = getInst(this);
				inst && inst.hide()
			})
		},
		"destroy": function() {
			return this.each(function() {
				var inst = getInst(this);
				inst && (inst.hide(), $(this).unbind(".dw"), delete scrollers[this.id], $(this).is("input") && (this.readOnly = bool($(this).data("dwro"))))
			})
		}
	};
	$(document).bind(MOVE_EVENT,
	function(e) {
		if (move) {
			e.preventDefault(),
			stop = getY(e);
			var val = pos + (start - stop) / h;
			val = val > max + 1 ? max + 1 : val,
			val = val < min - 1 ? min - 1 : val,
			inst.scroll(target, val)
		}
	}),
	$(document).bind(END_EVENT,
	function(e) {
		if (move) {
			e.preventDefault();
			var time = new Date - startTime,
			val = pos + (start - stop) / h;
			val = val > max + 1 ? max + 1 : val,
			val = val < min - 1 ? min - 1 : val;
			if (time < 300) {
				var speed = (stop - start) / time,
				dist = speed * speed / .0012;
				stop - start < 0 && (dist = -dist)
			} else var dist = stop - start;
			calc(target, Math.round(pos - dist / h), 0, !0, Math.round(val)),
			move = !1,
			target = null
		}
		click && (clearInterval(timer), click = !1),
		$(".dwb-a").removeClass("dwb-a")
	}),
	$.fn.scroller = function(method) {
		if (methods[method]) return methods[method].apply(this, Array.prototype.slice.call(arguments, 1));
		if (typeof method == "object" || !method) return methods.init.apply(this, arguments);
		$.error("Unknown method")
	},
	$.scroller = {
		"setDefaults": function(o) {
			$.extend(defaults, o)
		},
		"presets": {},
		"themes": {},
		"i18n": {}
	}
})(jQuery)