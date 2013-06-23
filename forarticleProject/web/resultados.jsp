<%@page import="Bean.Article"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title></title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width">

        <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
        
        <link rel="stylesheet" href="css/normalize.min.css">
        <link rel="stylesheet" href="css/main.css">
        <link rel="stylesheet" href="css/menu.css">
        <link rel="stylesheet" href="css/busca_form.css">
        <link rel="stylesheet" href="css/resultados.css">

        <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
        <script src="js/vendor/modernizr-2.6.2-respond-1.1.0.min.js"></script>
        
        
    </head>
    <body>
        <!--[if lt IE 7]>
            <p class="chromeframe">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> or <a href="http://www.google.com/chromeframe/?redirect=true">activate Google Chrome Frame</a> to improve your experience.</p>
        <![endif]-->

        <%
            List<Article> resultList = (List<Article>) request.getAttribute("listaArtigos");
            int num_paginas = (Integer) request.getAttribute("qtdePaginas");
            if (num_paginas > 15) num_paginas = 15;
            int pagina_atual = (Integer) request.getAttribute("paginaAtual");
            String busca = (String) request.getAttribute("search");
            String tipo = (String) request.getAttribute("tipo");
        %>
        
        <div class="header-container">
            <header class="wrapper clearfix">
                <a class="title" href="index.jsp"></a>
                <nav>
                    <ul>
                        <li><a href="index.jsp">Início</a></li>
                        <li><a href="login.html">Login</a></li>
                    </ul>
                </nav>
            </header>
        </div>

        <div class="main-container">
            <div class="main wrapper clearfix">
                <div class="form-box">
                    <form method="POST" action="BuscaInicial" class="form-pesquisa" id="pesquisa-s">
                       <p id="radio">
                           <input class="radios" type="radio" name="tipo" value="titulo" <% if(tipo.equals("titulo")) { %> checked <% }%>/>Título
                           <input class="radios" type="radio" name="tipo" value="keyword" <% if(tipo.equals("keyword")) { %> checked <% }%>/>Palavra-chave
                       </p>
                       <input type="text" name="search" id="caixa-pesquisa" class="search-edt" value="<%= busca%>" autocomplete="off"/>
                       <input id="pag_atual" type="hidden" name="pagina" value="<%= pagina_atual%>"/>
                       <input id="qtde_pag" type="hidden" name="qtdePaginas" value="<%= num_paginas%>"/>
                       <input type="text" class="search-btn" id="btn-pesquisa"/>
                   </form>
                   <form method="POST" action="BuscaInicial" class="form-pesquisa" id="pesquisa-a">
                       <div id="form-pesquisa-avancada">
                            <p class="form-separator">Informações do Journal:</p>
                            <label for="journal-title-edt">Titulo </label>
                            <input type="text" name="journal-title-edt" class="journal-title-edt noEnterSubmit" placeholder=""/>
                            <label for="journal-issn-edt">ISSN </label>
                            <input type="text" name="journal-issn-edt" class="journal-issn-edt noEnterSubmit" placeholder="XXXX-XXXX"/>
                            <p class="form-separator">Intervalo de Data:</p>
                            <label for="data-inicial-edt">Inicial </label>
                            <input type="date" name="data-inicial-edt" class="data-edt data-inicial-edt noEnterSubmit" />
                            <label for="data-final-edt">Final </label>
                            <input type="date" name="data-final-edt" class="data-edt data-final-edt noEnterSubmit"/>
                            <div class="btn-pesquisar-box">
                                <input type="submit" class="btn-pesquisar" value="Pesquisar">
                            </div>
                       </div>
                    </form>
                   <div class="avancada-box"><strong id="avancada">Busca Avançada</strong></div>
                   <div class="avancada-box"><strong id="simples">Busca Simples</strong></div>

                </div>
                <div class="main-result-box">
                    <%
                        if (resultList.isEmpty()){
                            %> <h3>Nenhum Resultado Encontrado </h3><%
                        } else {
                            %> <h3 id="results-label">Resultados Encontrados (página <%= pagina_atual%> de <%= num_paginas%>)</h3> <%
                            %> <div class="pagination">
                                <%if (pagina_atual == 1){%>
                                <strong class="pag_atual">< Anterior</strong>
                                <%} else {%>
                                <strong class="anterior pag_item">< Anterior</strong>
                                <% } %>
                                <% for(int i = 0; i < num_paginas; i++) {
                                    if (i+1 == pagina_atual) {
                                    %> <strong class="pag_atual"><%= i+1 %></strong> <%    
                                    } else {
                                    %> <strong class="pag_item pag_goto"><%= i+1 %></strong> <%
                                    }
                                }%>
                                <%if (pagina_atual == num_paginas){%>
                                <strong class="pag_atual">Próximo ></strong>
                                <%} else {%>
                                <strong class="proximo pag_item">Próximo ></strong>
                                <% } %>
                            </div> <%
                            
                            %> <article class="main-results"> <%
                            for(int i = 0; i < resultList.size(); i++){
                                %><section class="result" onclick="resultClick(this)">
                                    <h3> <%= resultList.get(i).getTitle()%> </h3>
                                    <p> <%= resultList.get(i).getResumo()%> </p>
                                    <p class="articleID"> <%= resultList.get(i).getArticleID()%> </p>
                                </section><%
                            }
                            %></article><%
                            %> <div class="pagination">
                                <%if (pagina_atual == 1){%>
                                <strong class="pag_atual">< Anterior</strong>
                                <%} else {%>
                                <strong class="anterior pag_item">< Anterior</strong>
                                <% } %>
                                <% for(int i = 0; i < num_paginas; i++) {
                                    if (i+1 == pagina_atual) {
                                    %> <strong class="pag_atual"><%= i+1 %></strong> <%    
                                    } else {
                                    %> <strong class="pag_item pag_goto"><%= i+1 %></strong> <%
                                    }
                                }%>
                                <%if (pagina_atual == num_paginas){%>
                                <strong class="pag_atual">Próximo ></strong>
                                <%} else {%>
                                <strong class="proximo pag_item">Próximo ></strong>
                                <% } %>
                            </div> <%
                        }
                    %>
                </div>
            </div> <!-- #main -->
        </div> <!-- #main-container -->

        <div class="footer-container">
            <footer class="wrapper">
                <h3>© 2013 forArticle - Forward your research!</h3>
            </footer>
        </div>

        <script src="./js/jquery-1.9.1.min.js"></script>
        <script charset="utf-8" src="./js/pesquisa-resultados.js"></script>
        <script>window.jQuery || document.write('<script src="js/vendor/jquery-1.9.1.min.js"><\/script>')</script>

        <script src="js/main.js"></script>
    </body>
</html>
