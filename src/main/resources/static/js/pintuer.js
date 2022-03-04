$(function(){
	$(".win-homepage").click(function(){ 
        if(document.all){
        document.body.style.behavior = 'url(#default#homepage)'; 
        document.body.setHomePage(document.URL); 
        }else{alert("设置首页失败，请手动设置！");} 
	});
	$(".win-favorite").click(function(){
		var sURL=document.URL; 
		var sTitle=document.title; 
		try {window.external.addFavorite(sURL, sTitle);} 
		catch(e){ 
			try{window.sidebar.addPanel(sTitle, sURL, "");} 
			catch(e){alert("加入收藏失败，请使用Ctrl+D进行添加");} 
		}
	});
	$(".win-forward").click(function(){
		window.history.forward(1);
	});
	$(".win-back").click(function(){
		window.history.back(-1);
	});
	$(".win-backtop").click(function(){$('body,html').animate({scrollTop:0},1000);return false;});
	$(".win-refresh").click(function(){
		window.location.reload();
	});
	$(".win-print").click(function(){
		window.print();
	});
	$(".win-close").click(function(){
		window.close();
	});
	$('.checkall').click(function(){
		var e=$(this);
		var name=e.attr("name");
		var checkfor=e.attr("checkfor");
		var type;
		if (checkfor!='' && checkfor!=null && checkfor!=undefined){
			type=e.closest('form').find("input[name='"+checkfor+"']");
		}else{
			type=e.closest('form').find("input[type='checkbox']");
		};
		if (name=="checkall"){
			$(type).each(function(index, element){
				element.checked=true;
			});
			e.attr("name","ok");
		}else{
			$(type).each(function(index, element){
				element.checked=false;
			});
			e.attr("name","checkall");
		}	
	});
	$('.dropdown-toggle').click(function(){
		$(this).closest('.button-group, .drop').addClass("open");
	});
	 $(document).bind("click",function(e){
		 if($(e.target).closest(".button-group.open, .drop.open").length == 0){
			 $(".button-group, .drop").removeClass("open");
		 }
	});
	$checkplaceholder=function(){
		var input = document.createElement('input');
		return 'placeholder' in input;
	};
	if(!$checkplaceholder()){
		$("textarea[placeholder], input[placeholder]").each(function(index, element){
			var content=false;
			if($(this).val().length ===0 || $(this).val()==$(this).attr("placeholder")){content=true};
			if(content){
				$(element).val($(element).attr("placeholder"));
				$(element).css("color","rgb(169,169,169)");
				$(element).data("pintuerholder",$(element).css("color"));
				$(element).focus(function(){$hideplaceholder($(this));});
				$(element).blur(function(){$showplaceholder($(this));});
			}
		})
	};
	$showplaceholder=function(element){
		if( ($(element).val().length ===0 || $(element).val()==$(element).attr("placeholder")) && $(element).attr("type")!="password"){
			$(element).val($(element).attr("placeholder"));
			$(element).data("pintuerholder",$(element).css("color"));
			$(element).css("color","rgb(169,169,169)");
		}
	};
	var $hideplaceholder=function(element){
		if($(element).data("pintuerholder")){
			$(element).val("");
			$(element).css("color", $(element).data("pintuerholder"));		
			$(element).removeData("pintuerholder");
		}
	};
	$('textarea, input, select').blur(function(){
		var e=$(this);
		if(e.attr("data-validate")){
			e.closest('.field').find(".input-help").remove();
			var $checkdata=e.attr("data-validate").split(',');
			var $checkvalue=e.val();
			var $checkstate=true;
			var $checktext="";
			if(e.attr("placeholder")==$checkvalue){$checkvalue="";}
			if($checkvalue!="" || e.attr("data-validate").indexOf("required")>=0){
				for(var i=0;i<$checkdata.length;i++){
					var $checktype=$checkdata[i].split(':');
					if(! $pintuercheck(e,$checktype[0],$checkvalue)){
						$checkstate=false;
						$checktext=$checktext+"<li>"+$checktype[1]+"</li>";
					}
				}
			};
			if($checkstate){
				e.closest('.form-group').removeClass("check-error");
				e.parent().find(".input-help").remove();
				e.closest('.form-group').addClass("check-success");
			}else{
				e.closest('.form-group').removeClass("check-success");
				e.closest('.form-group').addClass("check-error");
				e.closest('.field').append('<div class="input-help"><ul>'+$checktext+'</ul></div>');
			}
		}
	});
	$pintuercheck=function(element,type,value){
		$pintu=value.replace(/(^\s*)|(\s*$)/g, "");
		switch(type){
			case "required":return /[^(^\s*)|(\s*$)]/.test($pintu);break;
			case "chinese":return /^[\u0391-\uFFE5]+$/.test($pintu);break;
			case "number":return /^\d+$/.test($pintu);break;
			case "integer":return /^[-\+]?\d+$/.test($pintu);break;
			case "plusinteger":return /^[+]?\d+$/.test($pintu);break;
			case "double":return /^[-\+]?\d+(\.\d+)?$/.test($pintu);break;
			case "plusdouble":return /^[+]?\d+(\.\d+)?$/.test($pintu);break;
			case "english":return /^[A-Za-z]+$/.test($pintu);break;
			case "username":return /^[a-z]\w{3,}$/i.test($pintu);break;
			case "mobile":return /^((\(\d{3}\))|(\d{3}\-))?13[0-9]\d{8}?$|15[89]\d{8}?$|170\d{8}?$|147\d{8}?$/.test($pintu);break;
			case "phone":return /^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$/.test($pintu);break;
			case "tel":return /^((\(\d{3}\))|(\d{3}\-))?13[0-9]\d{8}?$|15[89]\d{8}?$|170\d{8}?$|147\d{8}?$/.test($pintu) || /^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$/.test($pintu);break;
			case "email":return /^[^@]+@[^@]+\.[^@]+$/.test($pintu);break;
			case "url":return /^http:\/\/[A-Za-z0-9]+\.[A-Za-z0-9]+[\/=\?%\-&_~`@[\]\':+!]*([^<>\"\"])*$/.test($pintu);break;
			case "ip":return /^[\d\.]{7,15}$/.test($pintu);break;
			case "qq":return /^[1-9]\d{4,10}$/.test($pintu);break;
			case "currency":return /^\d+(\.\d+)?$/.test($pintu);break;
			case "zip":return /^[1-9]\d{5}$/.test($pintu);break;
			case "radio":
				var radio=element.closest('form').find('input[name="'+element.attr("name")+'"]:checked').length;
				return eval(radio==1);
				break;
			default:
				var $test=type.split('#');
				if($test.length>1){
					switch($test[0]){
						case "compare":
							return eval(Number($pintu)+$test[1]);
							break;
						case "regexp":
							return new RegExp($test[1],"gi").test($pintu);
							break;
						case "length":
							var $length;
							if(element.attr("type")=="checkbox"){
								$length=element.closest('form').find('input[name="'+element.attr("name")+'"]:checked').length;
							}else{
								$length=$pintu.replace(/[\u4e00-\u9fa5]/g,"***").length;
							}
							return eval($length+$test[1]);
							break;
						case "ajax":							
							var $getdata;
							var $url=$test[1]+$pintu;							
							$.ajaxSetup({async:false});
							$.getJSON($url,function(data){	
								//alert(data.getdata);							
								$getdata=data.getdata;								
							});
							if($getdata=="true"){return true;}
							break;
						case "repeat":
							return $pintu==jQuery('input[name="'+$test[1]+'"]').eq(0).val();
							break;
						default:return true;break;
					}
					break;
				}else{
					return true;
				}
		}
	};
	$('form').submit(function(){
		$(this).find('input[data-validate],textarea[data-validate],select[data-validate]').trigger("blur");
		$(this).find('input[placeholder],textarea[placeholder]').each(function(){$hideplaceholder($(this));});
		var numError = $(this).find('.check-error').length;
		if(numError){
			$(this).find('.check-error').first().find('input[data-validate],textarea[data-validate],select[data-validate]').first().focus().select();
			return false;
		}
	});
	$('.form-reset').click(function(){
		$(this).closest('form').find(".input-help").remove();
		$(this).closest('form').find('.form-submit').removeAttr('disabled');
		$(this).closest('form').find('.form-group').removeClass("check-error");
		$(this).closest('form').find('.form-group').removeClass("check-success");
	});
	$('.tab .tab-nav li').each(function(){
		var e=$(this);
		var trigger=e.closest('.tab').attr("data-toggle");
		if (trigger=="hover"){
			e.mouseover(function(){
				$showtabs(e);
			});
			e.click(function(){
				return false;
			});
		}else{
			e.click(function(){
				$showtabs(e);
				return false;
			});
		}
	});
	$showtabs=function(e){
		var detail=e.children("a").attr("href");
		e.closest('.tab .tab-nav').find("li").removeClass("active");
		e.closest('.tab').find(".tab-body .tab-panel").removeClass("active");
		e.addClass("active");
		$(detail).addClass("active");
	};
	$('.dialogs').each(function(){
		var e=$(this);
		var trigger=e.attr("data-toggle");
		if (trigger=="hover"){
			e.mouseover(function(){
				$showdialogs(e);
			});
		}else if(trigger=="click"){
			e.click(function(){
				$showdialogs(e);
			});
		}
	});
	$showdialogs=function(e){
		var trigger=e.attr("data-toggle");
		var getid=e.attr("data-target");
		var data=e.attr("data-url");
		var mask=e.attr("data-mask");
		var width=e.attr("data-width");
		var detail="";
		var masklayout=$('<div class="dialog-mask"></div>');
		if(width==null){width="80%";}
		
		if (mask=="1"){
			$("body").append(masklayout);
		}
		detail='<div class="dialog-win" style="position:fixed;width:'+width+';z-index:11;">';
		if(getid!=null){detail=detail+$(getid).html();}
		if(data!=null){detail=detail+$.ajax({url:data,async:false}).responseText;}
		//alert(detail);
		detail=detail+'</div>';
		
		var win=$(detail);
		win.find(".dialog").addClass("open");
		$("body").append(win);
		var x=parseInt($(window).width()-win.outerWidth())/2;
		var y=parseInt($(window).height()-win.outerHeight())/2;
		if (y<=10){y="10"}
		win.css({"left":x,"top":y});
		win.find(".dialog-close,.close").each(function(){
			$(this).click(function(){
				win.remove();
				$('.dialog-mask').remove();
			});
		});
		masklayout.click(function(){
			win.remove();
			$(this).remove();
		});
	};
	$('.tips').each(function(){
		var e=$(this);
		var title=e.attr("title");
		var trigger=e.attr("data-toggle");
		e.attr("title","");
		if (trigger=="" || trigger==null){trigger="hover";}
		if (trigger=="hover"){
			e.mouseover(function(){
				$showtips(e,title);
			});
		}else if(trigger=="click"){
			e.click(function(){
				$showtips(e,title);
			});
		}else if(trigger=="show"){
			e.ready(function(){
				$showtips(e,title);
			});
		}
	});
	$showtips=function(e,title){
		var trigger=e.attr("data-toggle");
		var place=e.attr("data-place");
		var width=e.attr("data-width");
		var css=e.attr("data-style");
		var image=e.attr("data-image");
		var content=e.attr("content");
		var getid=e.attr("data-target");
		var data=e.attr("data-url");
		var x=0;
		var y=0;
		var html="";
		var detail="";
		
		if(image!=null){detail=detail+'<img class="image" src="'+image+'" />';}
		if(content!=null){detail=detail+'<p class="tip-body">'+content+'</p>';}
		if(getid!=null){detail=detail+$(getid).html();}
		if(data!=null){detail=detail+$.ajax({url:data,async:false}).responseText;}
		if(title!=null && title!=""){
			if(detail!=null && detail!=""){detail='<p class="tip-title"><strong>'+title+'</strong></p>'+detail;}else{detail='<p class="tip-line">'+title+'</p>';}
		}
		detail='<div class="tip">'+detail+'</div>';
		html=$(detail);

		$("body").append( html );
		if(width!=null){
			html.css("width",width);
		}
		if(place=="" || place==null){place="top";}
		if(place=="left"){
			x=e.offset().left - html.outerWidth()-5;
			y=e.offset().top - html.outerHeight()/2 + e.outerHeight()/2;
		}else if(place=="top"){
			x=e.offset().left - html.outerWidth()/2 + e.outerWidth()/2;
			y=e.offset().top - html.outerHeight()-5;
		}else if(place=="right"){
			x=e.offset().left + e.outerWidth()+5;
			y=e.offset().top - html.outerHeight()/2 + e.outerHeight()/2;
		}else if(place=="bottom"){
			x=e.offset().left - html.outerWidth()/2 + e.outerWidth()/2;
			y=e.offset().top + e.outerHeight()+5;
		}
		if (css!=""){html.addClass(css);}
		html.css({"left":x+"px","top":y+"px","position":"absolute"});
		if (trigger=="hover" || trigger=="click" || trigger==null){
			e.mouseout(function(){html.remove();e.attr("title",title)});
		}
	};
	$('.alert .close').each(function(){
		$(this).click(function(){
			$(this).closest('.alert').remove();
		});
	});
	$('.radio label').each(function(){
		var e=$(this);
		e.click(function(){
			e.closest('.radio').find("label").removeClass("active");
			e.addClass("active");
		});
	});
	$('.checkbox label').each(function(){
		var e=$(this);
		e.click(function(){
			if(e.find('input').is(':checked')){
				e.addClass("active");
			}else{
				e.removeClass("active");
			};
		});
	});
	$('.collapse .panel-head').each(function(){
		var e=$(this);
		e.click(function(){
			e.closest('.collapse').find(".panel").removeClass("active");
			e.closest('.panel').addClass("active");
		});
	});
	$('.icon-navicon').each(function(){
		var e=$(this);
		var target=e.attr("data-target");
		e.click(function(){
			$(target).toggleClass("nav-navicon");
		});
	});
	$('.banner').each(function(){
		var e=$(this);
		var pointer=e.attr("data-pointer");
		var interval=e.attr("data-interval");
		var style=e.attr("data-style");
		var items=e.attr("data-item");
		var items_s=e.attr("data-small");
		var items_m=e.attr("data-middle");
		var items_b=e.attr("data-big");
		var num=e.find(".carousel .item").length;
		var win=$(window).width();
		var i=1;

		if(interval==null){interval=5};
		if(items==null || items<1){items=1};
		if(items_s!=null && win>760){items=items_s};
		if(items_m!=null && win>1000){items=items_m};
		if(items_b!=null && win>1200){items=items_b};

		var itemWidth=Math.ceil(e.outerWidth()/items);
		var page=Math.ceil(num/items);
		e.find(".carousel .item").css("width",itemWidth+ "px");
		e.find(".carousel").css("width",itemWidth*num + "px");
		
		var carousel=function(){
			i++;
			if(i>page){i=1;}
			$showbanner(e,i,items,num);
		};
		var play=setInterval(carousel,interval*600);
		
		e.mouseover(function(){clearInterval(play);});
		e.mouseout(function(){play=setInterval(carousel,interval*600);});
		
		if(pointer!=0 && page>1){
			var point='<ul class="pointer"><li value="1" class="active"></li>';
			for (var j=1;j<page;j++){
				point=point+' <li value="'+(j+1)+'"></li>';
			};
			point=point+'</ul>';
			var pager=$(point);
			if(style!=null){pager.addClass(style);};
			e.append(pager);
			pager.css("left",e.outerWidth()*0.5 - pager.outerWidth()*0.5+"px");
			pager.find("li").click(function(){
				$showbanner(e,$(this).val(),items,num);
			});
			var lefter=$('<div class="pager-prev icon-angle-left"></div>');
			var righter=$('<div class="pager-next icon-angle-right"></div>');
			if(style!=null){lefter.addClass(style);righter.addClass(style);};
			e.append(lefter);
			e.append(righter);
			
			lefter.click(function(){
				i--;
				if(i<1){i=page;}
				$showbanner(e,i,items,num);
			});
			righter.click(function(){
				i++;
				if(i>page){i=1;}
				$showbanner(e,i,items,num);
			});
		};
	});	
	$showbanner=function(e,i,items,num){
		var after=0,leftx=0;
		leftx = - Math.ceil(e.outerWidth()/items)*(items)*(i-1);
		if(i*items > num){after=i*items-num;leftx= - Math.ceil(e.outerWidth()/items)*(num-items);};
		e.find(".carousel").stop(true, true).animate({"left":leftx+"px"},800);
		e.find(".pointer li").removeClass("active");
		e.find(".pointer li").eq(i-1).addClass("active");
	};
	$(".spy a").each(function(){
		var e=$(this);
		var t=e.closest(".spy");
		var target=t.attr("data-target");
		var top=t.attr("data-offset-spy");
		var thistarget="";
		var thistop="";
		if(top==null){top=0;};
		if(target==null){thistarget=$(window);}else{thistarget=$(target);};
		
		thistarget.bind("scroll",function(){
			if(target==null){
				thistop=$(e.attr("href")).offset().top - $(window).scrollTop() - parseInt(top);	
			}else{
				thistop=$(e.attr("href")).offset().top - thistarget.offset().top - parseInt(top);
			};
	
			if(thistop<0){
				t.find('li').removeClass("active");
				e.parents('li').addClass("active");
			};

		});
	});
	$(".fixed").each(function(){
		var e=$(this);
		var style=e.attr("data-style");
		var top=e.attr("data-offset-fixed");
		if(top==null){top=e.offset().top;}else{top=e.offset().top - parseInt(top);};
		if(style==null){style="fixed-top";};
		
		$(window).bind("scroll",function(){
			var thistop=top - $(window).scrollTop();
			if(style=="fixed-top" && thistop<0){
				e.addClass("fixed-top");
			}else{
				e.removeClass("fixed-top");
			};
			
			var thisbottom=top - $(window).scrollTop()-$(window).height();
			if(style=="fixed-bottom" && thisbottom>0){
				e.addClass("fixed-bottom");
			}else{
				e.removeClass("fixed-bottom");
			};
		});

	});

})
function WeiXin(){
	//debugger;
	//清空二维码文本框
	$("#qrcode").html("");

	var title = $("#commentTitle").val();
	var url = window.location.href;
	var url2 = url.split("localhost:8080/");
	if (url2.length > 1){
		var url3 = url2[1];
		var url4 = "http://www.zhengquan51.com/" + url3;
	} else{
		//如果是在线上路径下
		url4 = url2;
	}
	var icno = $("#icno").val();
	if (icno == undefined || icno == null){
		icno = "";
	}

	//主要看这里就行了（作用是调用后台接口以及图片回显）
	$("#qrcode").attr("src", "/getCode/qrcode?content=" + url4);     //根据路径访问后台接口，生成二维码并通过src属性展示在容器中，url4为我需要生成二维码的页面链接内容

	$(".Index-Popup-Boxs").show();
	!function(t){var e,n,o,i,a,l='<svg><symbol id="icon-mima" viewBox="0 0 1024 1024"><path d="M827.472 394.408h-61.26v-75.602c0-144.915-116.398-258.325-257.296-258.325-140.903 0-251.173 113.41-251.173 258.325v75.602h-67.387c-24.506 0-36.756 18.902-36.756 37.802v466.244c0 25.202 18.377 44.103 36.756 44.103h637.116c24.505 0 42.883-18.901 42.883-44.103V432.21c-6.123-18.9-18.378-37.802-42.883-37.802z m-490.086-75.602c0-100.811 79.637-176.419 171.53-176.419 98.016 0 171.53 81.91 171.53 176.419v75.602h-343.06v-75.602z m447.203 541.84h-551.35V476.32h557.477v384.328h-6.127z" fill="#1AA5FF" ></path><path d="M208.823 446.789h607.458v441.776H208.823z" fill="#1AA5FF" ></path></symbol><symbol id="icon-zhanghao-xuanzhong" viewBox="0 0 1024 1024"><path d="M512 288m-224 0a224 224 0 1 0 448 0 224 224 0 1 0-448 0Z" fill="#026BFF" ></path><path d="M448 320h128a64 64 0 1 1-128 0z" fill="#80B5FF" ></path><path d="M96 576m192 0l448 0q192 0 192 192l0 0q0 192-192 192l-448 0q-192 0-192-192l0 0q0-192 192-192Z" fill="#026BFF" ></path></symbol><symbol id="icon-fanhui" viewBox="0 0 1024 1024"><path d="M624.788992 204.047974 585.205965 164.464026 219.560038 530.185011 585.205965 895.864013 624.788992 856.280986 298.663014 530.16105Z"  ></path></symbol><symbol id="icon-icon-" viewBox="0 0 1024 1024"><path d="M720 966.4a38.4 38.4 0 0 1-27.136-11.264l-416-416a38.464 38.464 0 0 1 0-54.336l416-416a38.464 38.464 0 0 1 54.336 54.336L358.336 512l388.864 388.864a38.464 38.464 0 0 1-27.2 65.536z"  ></path></symbol></svg>',c=(c=document.getElementsByTagName("script"))[c.length-1].getAttribute("data-injectcss"),d=function(t,e){e.parentNode.insertBefore(t,e)};if(c&&!t.__iconfont__svg__cssinject__){t.__iconfont__svg__cssinject__=!0;try{document.write("<style>.svgfont {display: inline-block;width: 1em;height: 1em;fill: currentColor;vertical-align: -0.1em;font-size:16px;}</style>")}catch(t){console&&console.log(t)}}function s(){a||(a=!0,o())}function h(){try{i.documentElement.doScroll("left")}catch(t){return void setTimeout(h,50)}s()}e=function(){var t,e;(e=document.createElement("div")).innerHTML=l,l=null,(t=e.getElementsByTagName("svg")[0])&&(t.setAttribute("aria-hidden","true"),t.style.position="absolute",t.style.width=0,t.style.height=0,t.style.overflow="hidden",e=t,(t=document.body).firstChild?d(e,t.firstChild):t.appendChild(e))},document.addEventListener?~["complete","loaded","interactive"].indexOf(document.readyState)?setTimeout(e,0):(n=function(){document.removeEventListener("DOMContentLoaded",n,!1),e()},document.addEventListener("DOMContentLoaded",n,!1)):document.attachEvent&&(o=e,i=t.document,a=!1,h(),i.onreadystatechange=function(){"complete"==i.readyState&&(i.onreadystatechange=null,s())})}(window);
}