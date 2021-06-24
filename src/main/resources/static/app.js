$(function(){
        $("#title").on('keydown keyup change', function() {
	
                var count = $(this).val().length;
                $("#count").text(count);
                if(count > 60) {
                    $("#count").css({color: 'red', fontWeight: 'bold'});
                }else{
                    $("#count").css({color: '#333', fontWeight: 'normal'});
                }
        });
});
