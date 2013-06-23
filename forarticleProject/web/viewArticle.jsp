<%@page import="Bean.Usuario"%>
<%@page import="Bean.Article"%>
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

        <link href='http://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>

        <link rel="stylesheet" href="css/normalize.min.css">
        <link rel="stylesheet" href="css/main.css">
        <link rel="stylesheet" href="css/article-view.css">

        <script src="js/vendor/modernizr-2.6.2-respond-1.1.0.min.js"></script>
    </head>
    <body>
        <!--[if lt IE 7]>
            <p class="chromeframe">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> or <a href="http://www.google.com/chromeframe/?redirect=true">activate Google Chrome Frame</a> to improve your experience.</p>
        <![endif]-->

        <div class="header-container">
            <header class="wrapper clearfix">
                <h1 class="title"></h1>
                <nav>
                    <ul>
                        <% 
                            Usuario objUsuarioBean = (Usuario)request.getAttribute("usuarioBean");
                            if (objUsuarioBean != null){
                                if(objUsuarioBean.getTipo().equals("adm")){ //Menu Admin
                          %>
                        <li><a href="#.jsp" class="active">AutorizaÃ§Ã£o de usuÃ¡rio</a></li>
                        <li><a href="#.jsp">Cadastro de Rotas</a></li>
                        <%
                             } else if(objUsuarioBean.getTipo().equals("user")){ //Menu User
                                        %>
                        <li><a href="#.jsp" class="active">AutorizaÃ§Ã£o de usuÃ¡rio</a></li>
                        <li><a href="#.jsp">Cadastro de Rotas</a></li>
                        <%
                               }
                            } //ver o que vai fazer caso dê um pau no banco e não consiga encontrar o usuário
                        %>
                    </ul>
                </nav>
            </header>
        </div>

        <div class="main-container">
            <div class="main wrapper clearfix">
                <div id="article-container">
                    <%
                            Article objArticleBean = (Article)request.getAttribute("artigo");
                            if (objArticleBean != null){
                            %>
                    <div id="title-box">
                        
                        <h2 id="title"><%= objArticleBean.getTitle() %></h2>
                        
                        <p id="journal">
                            <b>Revista: </b><%= objArticleBean.getJournal().getTitle() %>
                            
                            (Abreviação: <%= objArticleBean.getJournal().getAbreviation() %>).
                            ISSN: <%= objArticleBean.getJournal().getISSN() %>. 
                            Vol <%= objArticleBean.getVolume() %>. 
                            Páginas: <%= objArticleBean.getPagination() %>. 
                            Issue: <%= objArticleBean.getIssue() %> 
                            Afiliação: <%= objArticleBean.getAffiliation() %></p>
                    </div>
                    <div id="author-box">
                        Autores: 
                        <%
                                int cont = 0, tam = objArticleBean.getAutores().size();
                                while(cont < tam){
                                    %>
                                    <h6><%= objArticleBean.getAutores().get(cont).getLastName() %>.
                                     <%= objArticleBean.getAutores().get(cont).getForeName()%> 
                                    <%= objArticleBean.getAutores().get(cont).getInitials() %></h6><h5>, </h5>
                                    <%
                                    cont++;
                                }
                                %>

                    </div>
                    <div id="abstract-box">
                        <h3 class="label">Resumo:</h3>
                        <p id="abstract"><%= objArticleBean.getResumo() %></p>
                    </div>
                    <div id="mesh-box">
                        <h3 class="label">Termos Mesh: </h3>
                        
                        <%
                                cont = 0;
                                tam = objArticleBean.getMeshHeading().size();
                                while(cont < tam){
                                    %>
                                    <h6 class="property-name"><%= objArticleBean.getMeshHeading().get(cont) %></h6><h5>, </h5>
                                    <%
                                    cont++;
                                }
                                %>
                        
                        
                    </div>
                    <div id="keyword-box">
                        <h3 class="label">Palavras-chave: </h3>
                        <%
                                cont = 0;
                                tam = objArticleBean.getKeyWord().size();
                                while(cont < tam){
                                    %>
                                    <h6 class="property-name"><%= objArticleBean.getKeyWord().get(cont) %></h6><h5>, </h5>
                                    <%
                                    cont++;
                                }
                                %>
                        
                    </div>
                    <div id="chemical-box">
                        <h3 class="label">Substâncias químicas: </h3>
                        <%
                                cont = 0;
                                tam = objArticleBean.getChemical().size();
                                while(cont < tam){
                                    %>
                                    <h6 class="property-name"><%= objArticleBean.getChemical().get(cont) %></h6><h5>, </h5>
                                    <%
                                    cont++;
                                }
                                %>
                        
                    </div>
                    <div id="publication-box">
                        <h3 class="label">Tipos de publicação: </h3>
                        <%
                                cont = 0;
                                tam = objArticleBean.getPublicationType().size();
                                while(cont < tam){
                                    %>
                                    <h6 class="property-name"><%= objArticleBean.getPublicationType().get(cont) %></h6><h5>, </h5>
                                    <%
                                    cont++;
                                }
                                %>
                        
                    </div>
                            <%
                            } else {
                                %>
                                <h2>Não foi possível recuperar o Artigo</h1>
                                <%
                            }
                                %>
                </div>
                <div class="voltar-box">
                    <a href="index.html" class="voltar-link">
                        Voltar para a página de pesquisa
                    </a>
                </div>
            </div> <!-- #main -->
        </div> <!-- #main-container -->

        <div class="footer-container">
            <footer class="wrapper">
                <h3>Â© 2013 forArticle - Forward your research!</h3>
            </footer>
        </div>

        <script src="./js/jquery-1.9.1.min.js"></script>
        <script src="./js/article-view.js"></script>
        <script>window.jQuery || document.write('<script src="js/vendor/jquery-1.9.1.min.js"><\/script>')</script>

        <script src="js/main.js"></script>


    </body>
</html>
