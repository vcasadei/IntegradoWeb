// $(window).scroll(function() {
//     if (($(window).scrollTop() + $(window).height()) >= ($('body').height())) {
//         aux = document.getElementsByClassName('error-box')[0];
//         if (aux == null || aux == undefined) {
//             var loading = document.createElement('article');
//             loading.setAttribute('class', 'error-box');
//             loading.style.backgroundImage = "url('img/loading-bar.gif')";

//             var box = document.getElementById('main-result-box');
//             box.appendChild(loading);
//         }
//         ;
//     }
//     ;
// });
$(document).ready(function(){
    $( '.radios' ).on( "click", function() {
            if($("input:checked").val() == "Titulo"){
                $( "#caixa-pesquisa" ).attr("placeholder","Digite aqui o título do artigo");
                $('#pesquisa-avancada-txt').html("Busca Avançada");
            } else {
                $( "#caixa-pesquisa" ).attr("placeholder","Digite aqui uma keyword");
                $('#pesquisa-avancada-txt').html("");
            }

        });
});

$(window).ready(function() {
    $('.pesquisar-edt').focus();   
});

$('.noEnterSubmit').keypress(function(e) {
    if (e.which === 13) {
        pesquisaSimples('edt');
    }
    if (e.which === 13)
        e.preventDefault();
});

$('.noClickSubmit').click(function() {
    pesquisaSimples('btn');
});



function pesquisaSimples(origem) { //origem pode ser botao ou edt (enter)

    var pesquisa = $('.pesquisar-edt').val();
    $('.pesquisar-edt').val(pesquisa);

    //REALIZA PESQUISA
    var loading = document.getElementsByClassName('pesquisar-btn')[0];
    var edt = document.getElementsByClassName('pesquisar-edt')[0];

    $.ajax({
        type: "POST",
        url: "PesquisarSimples",
        dataType: "json",
        data: {search: $('.pesquisar-edt').val()},
        cache: false,
        beforeSend: function() {
            loading.style.backgroundImage = "url('img/loading.gif')";
            edt.disabled = true;
        }
    }).done(function(data) {
        loading.style.backgroundImage = "url('img/search-btn.png')";
        edt.disabled = false;
        aux = document.getElementsByClassName('error-box')[0];
        if (aux != null || aux != undefined) {
            aux.parentNode.removeChild(aux);
        }
        if (data.article.erro !== 'Nenhum resultado encontrado') {
            construirResultados(data);
        } else {
            construirErro(data.article.erro);
        }
        ;
    });
}

function construirErro(s_erro) {
    var erro = document.createElement('article');
    erro.setAttribute('class', 'error-box');
    erro.innerHTML = s_erro;

    var r_label = document.getElementById('results-label');
    r_label.style.display = 'none';

    var box = document.getElementById('main-result-box');
    var article_old = box.firstChild;
    if (article_old != null || article_old != undefined) {
        article_old.parentNode.removeChild(article_old);
    }
    ;
    box.appendChild(erro);

    var foot = document.getElementsByClassName('footer-container')[0];
    foot.style.position = 'absolute';

}

function construirResultados(json) {
    var len = json.article.length;
    var article_elem = document.createElement('article');
    article_elem.setAttribute('class', 'main-results');
    article_elem.style.visibility = 'hidden';

    for (var i = 0; i < len; i++) {
        var tit = document.createTextNode(json.article[i].titulo);
        var abs = document.createTextNode(json.article[i].resumo);
        var aid = document.createTextNode(json.article[i].articleID);
        var sec = document.createElement('section');
        var h = document.createElement('h3');
        var p = document.createElement('p');
        var p2 = document.createElement('p');
        p2.setAttribute('class','articleID');
        p2.style.display = 'none';
        p2.appendChild(aid);
        h.appendChild(tit);
        p.appendChild(abs);
        sec.appendChild(h);
        sec.appendChild(p);
        sec.appendChild(p2);
        sec.setAttribute('class','result');
        sec.setAttribute('onclick','resultClick(this)');

        article_elem.appendChild(sec);
    };

    var box = document.getElementById('main-result-box');
    var article_old = box.firstChild;
    if (article_old != null || article_old != undefined) {
        article_old.parentNode.removeChild(article_old);
    };
    mudarCssAposPesquisa();

    box.appendChild(article_elem);
    article_elem.style.visibility = 'visible';
}

function mudarCssAposPesquisa() {
    var foot = document.getElementsByClassName('footer-container')[0];
    var r_label = document.getElementById('results-label');
    var b_label = document.getElementById('busca-label');
    var busca_avanc = document.getElementsByClassName('pesquisa-avancada-box')[0];
    var margin = busca_avanc.style.marginTop.substring(0, 2);

    var pa_label = document.getElementsByClassName('pesquisa-avancada')[0];

    if (margin > 80) {
        busca_avanc.style.marginTop = (parseInt(margin) - 87) + 'px';
    }
    ;
    r_label.style.display = 'block';
    b_label.style.display = 'none';
    foot.style.position = 'relative';

}

$('#pesquisa-avancada-txt').click(function() {
    
    var pa_label = document.getElementsByClassName('pesquisa-avancada')[0];
    var busca = document.getElementsByClassName('pesquisar-edt')[0];
    // busca.disabled = true;
    var pesquisaBtn = document.getElementsByClassName('pesquisar-btn')[0];
    var pesquisaEdt = document.getElementsByClassName('pesquisar-edt')[0];

    if (pa_label.firstChild.innerHTML === 'Fechar') {
        busca.removeAttribute('disabled');
        $( '.radios' ).removeAttr('disabled')
        $('#fix-keyword').html("<br></br>")
        pesquisaEdt.style.borderRight = '0px';
        pesquisaEdt.style.width = '70%';
        pesquisaBtn.style.visibility = 'visible';
        // busca.disabled = false;
        pa_label.firstChild.innerHTML = 'Busca Avançada';
        var busca_avanc = document.getElementsByClassName('pesquisa-avancada-box')[0];
        busca_avanc.style.display = 'none';
    } else {
        $('#fix-keyword').html("")
        $( '.radios' ).attr('disabled', 'disabled')
        busca.setAttribute('disabled','disabled');
        pesquisaEdt.style.borderRight = '1px solid #777';
        pesquisaEdt.style.width = '76%';
        pesquisaBtn.style.visibility = 'hidden';
        // busca.disabled = true;
        pa_label.firstChild.innerHTML = 'Fechar';
        var busca_avanc = document.getElementsByClassName('pesquisa-avancada-box')[0];
        busca_avanc.style.display = 'block';

    }
    ;
});

function resultClick(e){
	a = e.getElementsByClassName('articleID')[0];
    window.location = 'artigo.html?id='+a.innerHTML;
};