$(document).ready(function(){
	$(".dropdown-trigger").dropdown();
	
    var $campo = $("#cep");
    $campo.mask('00000-000', {reverse: true});
    
    var $campo = $("#CPFCli");
    $campo.mask('000.000.000-00', {reverse: true});
    
    var $campo = $("#DataNCli");
    $campo.mask('0000-00-00', {reverse: true});
    
    $('select').formSelect();
    
    $('.datepicker').datepicker({ dateFormat: 'yyyy-mm-dd' });
});
