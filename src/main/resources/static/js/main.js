$(document).ready(function(){
	$(".dropdown-trigger").dropdown();
	
    var $campo = $("#cep");
    $campo.mask('00000-000', {reverse: true});
    
	$('#remove').click(function(){
		var id = $(this).parent().parent().find("td").attr("id")
		alert(id);
		console.log(id);
		return false;
	});
});
