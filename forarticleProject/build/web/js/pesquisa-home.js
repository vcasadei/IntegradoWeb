$(window).scroll(function () { 
    if(($(window).scrollTop() + $(window).height()) >= ($('body').height()) ){
        aux = document.getElementsByClassName('loading-box')[0];
        if(aux == null || aux == undefined){
	        var loading = document.createElement('article');
                loading.setAttribute('class','loading-box');
                loading.style.backgroundImage = "url('img/loading-bar.gif')";

                var box = document.getElementById('main-result-box');
                box.appendChild(loading);
	};
    };
});

$('.noEnterSubmit').keypress(function(e){
   	if ( e.which === 13 ) {
   		pesquisaSimples('edt');
   	}
    if ( e.which === 13 ) e.preventDefault(); 
});

$('.noClickSubmit').click(function(){
   	pesquisaSimples('btn');
});

function pesquisaSimples(origem){ //origem pode ser botao ou edt (enter)

    var pesquisa = $('.pesquisar-edt').val();
	$('.pesquisar-edt').val(pesquisa);
	
	//REALIZA PESQUISA
	var loading = document.getElementsByClassName('pesquisar-btn')[0];
	var edt = document.getElementsByClassName('pesquisar-edt')[0];

        $.ajax({
		type: "POST",
		url: "PesquisarSimples",
		dataType: "json",
    		data: {search: $('.pesquisar-edt').val() },
                cache: false,
                beforeSend: function(){
                    loading.style.backgroundImage = "url('img/loading.gif')";
                    edt.disabled = true;
                }
        }).done ( function(data){
            loading.style.backgroundImage = "url('img/search-btn.png')";
            edt.disabled = false;
            aux = document.getElementsByClassName('loading-box')[0];
            if(aux != null || aux != undefined){
                aux.parentNode.removeChild(aux);
            }
            if (data.article.erro !== 'Nenhum resultado encontrado') {
                construirResultados(data);
            } else {
                construirErro(data.article.erro);
            };
	});	

	// json_resultado = {
	// 	"article" : [ 
	//         { "titulo": "Titulo1", "resumo":"Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quidem, saepe, molestiae repudiandae debitis omnis sint laudantium mollitia exercitationem nihil obcaecati esse neque assumenda numquam odit suscipit dolorum possimus modi est!" },
	//         { "titulo": "Titulo2", "resumo":"Lorem ipsum dolor sit amet, consectetur adipisicing elit. Laudantium, culpa magni animi dolore voluptate consectetur veniam quod placeat at molestias earum repellendus minima eum eaque a adipisci dolorum inventore tempore." },
	//         { "titulo": "Titulo3", "resumo":"Lorem ipsum dolor sit amet, consectetur adipisicing elit. Laudantium, culpa magni animi dolore voluptate consectetur veniam quod placeat at molestias earum repellendus minima eum eaque a adipisci dolorum inventore tempore." },
	//         { "titulo": "Titulo4", "resumo":"Lorem ipsum dolor sit amet, consectetur adipisicing elit. Laudantium, culpa magni animi dolore voluptate consectetur veniam quod placeat at molestias earum repellendus minima eum eaque a adipisci dolorum inventore tempore." },
	//         { "titulo": "Titulo5", "resumo":"Lorem ipsum dolor sit amet, consectetur adipisicing elit. Laudantium, culpa magni animi dolore voluptate consectetur veniam quod placeat at molestias earum repellendus minima eum eaque a adipisci dolorum inventore tempore." },
	//         { "titulo": "Titulo6", "resumo":"Lorem ipsum dolor sit amet, consectetur adipisicing elit. Laudantium, culpa magni animi dolore voluptate consectetur veniam quod placeat at molestias earum repellendus minima eum eaque a adipisci dolorum inventore tempore." },
	//         { "titulo": "Titulo7", "resumo":"Lorem ipsum dolor sit amet, consectetur adipisicing elit. Laudantium, culpa magni animi dolore voluptate consectetur veniam quod placeat at molestias earum repellendus minima eum eaque a adipisci dolorum inventore tempore." },
	//         { "titulo": "Titulo8", "resumo":"Lorem ipsum dolor sit amet, consectetur adipisicing elit. Laudantium, culpa magni animi dolore voluptate consectetur veniam quod placeat at molestias earum repellendus minima eum eaque a adipisci dolorum inventore tempore." },
	//         { "titulo": "Titulo9", "resumo":"Lorem ipsum dolor sit amet, consectetur adipisicing elit. Laudantium, culpa magni animi dolore voluptate consectetur veniam quod placeat at molestias earum repellendus minima eum eaque a adipisci dolorum inventore tempore." },
	//         { "titulo": "Titulo10", "resumo":"Lorem ipsum dolor sit amet, consectetur adipisicing elit. Porro, ducimus, adipisci, est consequatur blanditiis nostrum in quod iusto consectetur commodi hic fugiat voluptate atque eveniet doloribus reprehenderit labore eius officia!" } 
 //    	]
 //    };
}

function construirErro(s_erro){
    var erro = document.createElement('article');
    erro.setAttribute('class','loading-box');
    erro.innerHTML = s_erro;

    var box = document.getElementById('main-result-box');
    var article_old = box.firstChild;
    if (article_old != null || article_old != undefined){
        article_old.parentNode.removeChild(article_old);    
    };
    box.appendChild(erro);
    
    var foot = document.getElementsByClassName('footer-container')[0];
    foot.style.position = 'absolute';
	
}

function construirResultados(json){
	var len = json.article.length;
	var article_elem = document.createElement('article');
 	article_elem.setAttribute('class','main-results');
 	article_elem.style.visibility = 'hidden';

 	for (var i = 0; i < len; i++) {
		var tit = document.createTextNode(json.article[i].titulo);
		var abs = document.createTextNode(json.article[i].resumo);
		var sec = document.createElement('section');
		var h = document.createElement('h3');
		var p = document.createElement('p');
		h.appendChild(tit);
		p.appendChild(abs);
		sec.appendChild(h);
		sec.appendChild(p);

		article_elem.appendChild(sec);
	};

	var box = document.getElementById('main-result-box');
	var article_old = box.firstChild;
        if (article_old != null || article_old != undefined){
            article_old.parentNode.removeChild(article_old);    
        };
	mudarCssAposPesquisa();

	box.appendChild(article_elem);
 	article_elem.style.visibility = 'visible';
}

function mudarCssAposPesquisa(){
	var foot = document.getElementsByClassName('footer-container')[0];
	var r_label = document.getElementById('results-label');
	var b_label = document.getElementById('busca-label');
	var busca_avanc = document.getElementsByClassName('pesquisa-avancada-box')[0];
	var margin = busca_avanc.style.marginTop.substring(0,2);

	var pa_label = document.getElementsByClassName('pesquisa-avancada')[0];

	if (margin > 80) {
		busca_avanc.style.marginTop = (parseInt(margin) - 87) + 'px';
	};
	r_label.style.display = 'block';
	b_label.style.display = 'none';
	foot.style.position = 'relative';

}

$('#pesquisa-avancada-txt').click(function (){
	var pa_label = document.getElementsByClassName('pesquisa-avancada')[0];

	if (pa_label.firstChild.innerHTML === 'Fechar') {
		pa_label.firstChild.innerHTML = 'Busca Avançada';
		var busca_avanc = document.getElementsByClassName('pesquisa-avancada-box')[0];
		busca_avanc.style.display = 'none';
	} else {
		pa_label.firstChild.innerHTML = 'Fechar';
		var busca_avanc = document.getElementsByClassName('pesquisa-avancada-box')[0];
		busca_avanc.style.display = 'block';
	};
});
