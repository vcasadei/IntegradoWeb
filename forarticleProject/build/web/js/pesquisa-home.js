$(document).ready(function(){
    $('#caixa-pesquisa').focus();   
    $('#avancada').css('display','block');

    $( '.radios' ).on( 'click', function() {
            if($('input:checked').val() === 'titulo'){
                $('#caixa-pesquisa').attr('placeholder','Digite aqui parte do título de um artigo');
            } else {
                $("#caixa-pesquisa").attr("placeholder","Digite aqui uma palavra-chave");
            }

    });

    $('#avancada').on( 'click', function() {
        $('#pesquisa-s').css('display','none');
        $('#pesquisa-a').css('display','block');
        $('#simples').css('display','block');
        $('#avancada').css('display','none');
    });

    $('#simples').on( 'click', function() {
        $('#pesquisa-a').css('display','none');
        $('#pesquisa-s').css('display','block');
        $('#avancada').css('display','block');
        $('#simples').css('display','none');
    });

    $('#btn-pesquisa').on( 'focus', function() {
        $('#caixa-pesquisa').focus();   
    });

    $('#btn-pesquisa').on( 'click', function() {
        $('#caixa-pesquisa').focus();
        $('#pesquisa-s').submit();

    });

});

