$(function(){
    $('.js-modal-close').on('click',function(){
        $('.js-modal').fadeOut();
        return false;
    });

    $("#dateSearch").click(function() {
        $.ajax({
            type        : "GET",
            url         : "ajax_data",
            dataType    : "json",
            success     : function(data) {
            				$("#model_show").css("display", "none");
            				$("#ajax_show").empty();
            				var table = $('<table border="1" style="width: 100%;margin-top: 20px;">');
            				var tr = $('<tr></tr>').appendTo(table);
			                $("<th></th>").text("名前").width("10%").css("color","blue").appendTo(tr);
			                $("<th></th>").text("現場場所").width("25%").css("color","blue").appendTo(tr);
			                $("<th></th>").text("プロジェクト名").width("15%").css("color","blue").appendTo(tr);
			                $("<th></th>").text("前回面談日付").width("15%").css("color","blue").appendTo(tr);
			                $("<th></th>").text("今回面談日付").width("15%").css("color","blue").appendTo(tr);
			                $("<th></th>").text("備考").width("15%").css("color","blue").appendTo(tr);
			                for (var cnt = 0; cnt < data.length; cnt++) {
			                	table.append($("<tr></tr>")
			                	        .append($("<td></td>").text(data[cnt].name))
			                	        .append($("<td></td>").text(data[cnt].work_place + "　" + data[cnt].customer))
			                	        .append($("<td></td>").text(data[cnt].project))
			                	        .append($("<td></td>").text(data[cnt].pre_interview))
			                	        .append($("<td></td>").text(data[cnt].post_interview))
			                	        .append($("<td></td>").text(data[cnt].bikou))
			                	);
			                }
			                $("#ajax_show").append(table);
                        },
            error       : function(XMLHttpRequest, textStatus, errorThrown) {
		            	 	alert("error:" + XMLHttpRequest);
		            	    alert("status:" + textStatus);
		            	    alert("errorThrown:" + errorThrown);
                        }
        });
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

function check(){
	if(!$("#id").val() && !$("#name").val() && !$("#date").val()){
		if(!window.confirm("条件を入力せずに検索すると、すべての情報を取り出します。よろしいでしょうか？")){
			return false;
		}
	}
}
