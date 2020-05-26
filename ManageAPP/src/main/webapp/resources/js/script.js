$(function(){
    $('.js-modal-close').on('click',function(){
        $('.js-modal').fadeOut();
        return false;
    });
});

function clickBtn(url){
	location.href = url + "/add	";
}

function init(remindList){
	if(remindList.length > 2){
		$('.js-modal').fadeIn();
	}
}

