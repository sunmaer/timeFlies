/**
 * 动态交互文件
 * 孙梦海
 */
$(function(){
	//关于我 定位
	newTop=$("video").height();
	$(".nav").css("marginBottom",newTop)
	$(window).resize(function(){
		newTop=$("video").height();
		$(".nav").css("marginBottom",newTop)
	});
    // 滚动条滚动时导航栏增加背景色
    $(window).scroll(function() {
    	if ($(document).scrollTop() > 10) {
			$('#mynavbar').removeClass('mynavbar').addClass('mynavbar1');
		}
		else {
			$('#mynavbar').removeClass('mynavbar1').addClass('mynavbar');
		}
    });
	
    $(window).scroll(function() {
    	// 回到顶部效果
    	if ($(document).scrollTop() > 250) {
			$('.button').show();
			$('.button').animate({
				bottom: 40
			},
			10);
		}
		else {
			$('.button').hide();
			$('.button').animate({
				bottom: -40
			},
			0);
		}
    	
    	//导航栏下划线的移动
    	$height = $("video").height();//初始高度
    	$scrollTop = $(document).scrollTop();
    	$liWidth = $(document).width()/10;
    	if ($scrollTop >= 0 && $scrollTop < 50) {
    		$('#mynavbar hr').stop().animate({
    			left: ($liWidth-34)/2,
    			width: 34
    		},
    		500);
	    			
    	}else if($scrollTop >= $height && $scrollTop < ($height+50)) {
    		$('#mynavbar hr').stop().animate({
    			left: $liWidth+($liWidth-50)/2,
    			width: 50
    		},
    		500);
	    			
    	}else if($scrollTop >= ($height+671) && $scrollTop < ($height+721)) {
    		$('#mynavbar hr').stop().animate({
    			left: $liWidth*2+($liWidth-66)/2,
    			width: 66
    		},
    		500);
	    			
    	}else if($scrollTop >= ($height+1426) && $scrollTop < ($height+1476)) {
    		$('#mynavbar hr').stop().animate({
    			left: $liWidth*3+($liWidth-66)/2,
    			width: 66
    		},
    		500);
	    			
    	}else if($scrollTop >= ($height+2711) && $scrollTop < ($height+2761)) {
    		$('#mynavbar hr').stop().animate({
    			left: $liWidth*4+($liWidth-66)/2,
    			width: 66
    		},
    		500);
	    			
    	}else if($scrollTop >= ($height+3456) && $scrollTop < ($height+3496)) {
    		$('#mynavbar hr').stop().animate({
    			left: $liWidth*5+($liWidth-66)/2,
    			width: 66
    		},
    		500);
	    			
    	}
    	$(window).resize(function(){
    		//导航栏下划线的移动
        	$height = $("video").height();//初始高度
        	$scrollTop = $(document).scrollTop();
        	$liWidth = $(document).width()/10;
        	if ($scrollTop >= 0 && $scrollTop < 50) {
        		$('#mynavbar hr').stop().animate({
        			left: ($liWidth-34)/2,
        			width: 34
        		},
        		500);
    	    			
        	}else if($scrollTop >= $height && $scrollTop < ($height+50)) {
        		$('#mynavbar hr').stop().animate({
        			left: $liWidth+($liWidth-50)/2,
        			width: 50
        		},
        		500);
    	    			
        	}else if($scrollTop >= ($height+671) && $scrollTop < ($height+721)) {
        		$('#mynavbar hr').stop().animate({
        			left: $liWidth*2+($liWidth-66)/2,
        			width: 66
        		},
        		500);
    	    			
        	}else if($scrollTop >= ($height+1426) && $scrollTop < ($height+1476)) {
        		$('#mynavbar hr').stop().animate({
        			left: $liWidth*3+($liWidth-66)/2,
        			width: 66
        		},
        		500);
    	    			
        	}else if($scrollTop >= ($height+2711) && $scrollTop < ($height+2761)) {
        		$('#mynavbar hr').stop().animate({
        			left: $liWidth*4+($liWidth-66)/2,
        			width: 66
        		},
        		500);
    	    			
        	}else if($scrollTop >= ($height+3456) && $scrollTop < ($height+3496)) {
        		$('#mynavbar hr').stop().animate({
        			left: $liWidth*5+($liWidth-66)/2,
        			width: 66
        		},
        		500);
    	    			
        	}
    	});
    });
    $('.button').on('click',function(){
    	$('html,body').animate({
    	  	 	scrollTop: 0
    	 },
    	 400);
    });
	// 锚点的平滑过渡
  	$('a[href*="#"],area[href*="#"]').click(function() {
    	if (location.pathname.replace(/^\//, '') == this.pathname.replace(/^\//, '') && location.hostname == this.hostname) {
     	 	var $target = $(this.hash);    	 	
      		$target = $target.length && $target || $('[name=' + this.hash.slice(1) + ']');
//      		alert($target.offset().top);
        if ($target.length) {
        	var targetOffset = $target.offset().top;
       		 $('html,body').animate({
         	 scrollTop: targetOffset
        },
        600);
        return false;
      }
    }
   }); 
	//浏览器刷新页面回到顶部      
	$('html,body').animate({
    	 scrollTop: 0
   },
   600);
	
})
