$(document).ready(function() {
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
        $('#pag_atual').attr('value','1');
        $('#qtde_pag').attr('value','0');
        $('#pesquisa-s').submit();

    });

    $('.pag_goto').on( 'click', function() {
        $('#pag_atual').attr('value',$(this).text())
        $('#pesquisa-s').submit();
    });

    $('.anterior').on( 'click', function() {
        var a = parseInt($('#pag_atual').attr('value'))-1;
        $('#pag_atual').attr('value',a);
        $('#pesquisa-s').submit();
    });

    $('.proximo').on( 'click', function() {
        var a = $('#pag_atual').attr('value')
        $('#pag_atual').attr('value',parseInt(a)+1);
        $('#pesquisa-s').submit();
    });
});
