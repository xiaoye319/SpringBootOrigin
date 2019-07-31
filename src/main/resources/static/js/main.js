$(function(){

		$('#side-menu .menu-item > a').click(function(event){
			event.preventDefault(); //勿删
			$('.switching-boot').removeClass('show');
			var that = $(this)
			if($('.extend-menu').hasClass('shrink')){
				extendMenu()
				return 
			}
			if(that.siblings('ul').length > 0) {
				if(that.parent().hasClass('extend')) {
					that.parent().attr('class','menu-item')
				}else{
					that.parent().attr('class','menu-item extend')
				}
				
			}else{
				that.parent().attr('class','menu-item active')
				$('#content').attr('src', that.prop('href'));

			}

			$('#side-menu .actived').removeClass('actived')
			that.parent().siblings('.menu-item').attr('class','menu-item');

		});



		$('.menu-item ul a').click(function(event){
			event.preventDefault(); //勿删
			var that = $(this)

			that.parent().addClass('actived').siblings().removeClass('actived')
			var $link = $(this).prop('href');
			$('#content').attr('src',$link);
		
		});



		// 头像跳转个人中心
		$('.users').click(function(event) {
			event.preventDefault(); //勿删
			var $link = $(this).prop('href');
			$('#content').attr('src',$link);
		});

		// 展开、收起菜单
		$('.extend-menu').click(function(){
			if($(this).hasClass('shrink')){
				extendMenu()
			}else{
				miniMenu()
			}
		})
		
}); 

function miniMenu() {
	$('.extend-menu').addClass('shrink')
	$('.side-menu').addClass('mini-menu')
	$('.main').addClass('mini-menu')
}

function extendMenu(){
	$('.extend-menu').removeClass('shrink')
	$('.side-menu').removeClass('mini-menu')
	$('.main').removeClass('mini-menu')
}

// 查看图片方法
var mySwiper ;
function closeGallery() {
	$('#gallery').removeClass('isShow').find('.swiper-wrapper').empty();
	mySwiper.destroy(false);
	mySwiper = {};
}
function startGallery(html,index) {
	$('#gallery .swiper-wrapper').append(html);
	mySwiper = new Swiper('.swiper-container', {
      navigation: {
        nextEl: '.swiper-button-next',
        prevEl: '.swiper-button-prev',
      },
    });
	mySwiper.slideTo(index, 10, false);
	$('#gallery').addClass('isShow');
}