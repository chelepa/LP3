$(document).ready(function(){
	$(".dropdown-trigger").dropdown();
	
    var $campo = $("#cep");
    $campo.mask('00000-000', {reverse: true});
    
    var $campo = $("#CPFCli");
    $campo.mask('000.000.000-00', {reverse: true});
    
    var $campo = $("#CPFFunc");
    $campo.mask('000.000.000-00', {reverse: true});
    
    var $campo = $("#DataNCli");
    $campo.mask('0000-00-00', {reverse: true});
    
    var $campo = $("#DataFabricProd");
    $campo.mask('0000-00-00', {reverse: true});
    
    var $campo = $("#DataNFunc");
    $campo.mask('0000-00-00', {reverse: true});
    
    $("#CNPJFor").mask("99.999.999/9999-99");
    
    $("#SalarioFunc").maskMoney();
    
    $("#PrecoUnitProd").maskMoney();
    
    $('select').formSelect();
    
    $('.datepicker').datepicker({ dateFormat: 'yyyy-mm-dd' });
});
