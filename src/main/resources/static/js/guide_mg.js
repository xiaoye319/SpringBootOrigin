$(function(){
	var guideTemp = '<div class="guide-popup mg">'+
	'<div class="cover"></div>'+
		'<div class="ship" onclick="closeGuide()"></div>'+
		'<div class="g-page g1 show">'+
			'<div class="g-menu"></div>'+
			'<div class="g-btn" onclick="nextGuide(2)"></div>'+
		'</div>'+
		'<div class="g-page g2 ">'+
			'<div class="g-menu"></div>'+
			'<div class="g-btn" onclick="nextGuide(3)"></div>'+
		'</div>'+
		'<div class="g-page g3">'+
			'<div class="g-menu"></div>'+
			'<div class="g-btn final" onclick="closeGuide()"></div>'+
		'</div>'+
		'<div class="guide-type" onclick="checkType(this)"></div>'+
	'</div>';

	var data = document.getElementById("guide_mg").getAttribute("data-id");
	if(data == '0' || data == null || data == 'unified'){
		setTimeout(function(){
			$('body').append(guideTemp);
		},500)
	}

});

	// 页面引导相关
	var fxzGuide = false,
			checkTypes = 0;
	var url = $("#guide_mg").attr("data-url");
	function closeGuide() {
		$.ajax({
			url:url,
			data:{isGuide:checkTypes},
			type:"post",
			dataType:"text",
			async:false,
			success:function(data){
			}
		})
		$('.guide-popup').remove();
	}
	function checkType(that) {
		if($(that).hasClass('checked')){
			$(that).removeClass('checked');
			checkTypes = 0;
		}else{
			 $(that).addClass('checked');
			 checkTypes = 1;
		}
	}
	function nextGuide(index) {
		$('.guide-popup').find('.g'+index).addClass('show').siblings('.g-page').removeClass('show')
	}
