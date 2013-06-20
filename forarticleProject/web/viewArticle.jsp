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
                            if (objUsuarioBean!=null){
                                if(objUsuarioBean.getUsuario().equals("adm")){ //Menu Admin
                          %>
                        <li><a href="#.jsp" class="active">Autorização de usuário</a></li>
                        <li><a href="#.jsp">Cadastro de Rotas</a></li>
                        <%
                             } else {
                                    if(objUsuarioBean.getUsuario().equals("user")){ //Menu User
                                        %>
                        <li><a href="#.jsp" class="active">Autorização de usuário</a></li>
                        <li><a href="#.jsp">Cadastro de Rotas</a></li>
                        <%
                                    } else { //Menu Visitante
                                      %>
                        <li><a href="index.html">Início</a></li>
                        <li><a href="login.html">Login</a></li>
                        <%  
                                    }
                                    
                                    
                                }
                            }
                        %>
                    </ul>
                </nav>
            </header>
        </div>

        <div class="main-container">
            <div class="main wrapper clearfix">
                <div id="article-container">
                     <div class="separator separator3"><a href="index.html">Inicio</a> -> <a href="">Visualizar Artigo</a></div>
                     
                    <%
                            Article objArticleBean = (Article)request.getAttribute("artigo");
                            if (objArticleBean){
                            %>
                    <div id="title-box">
                        
                        <h2 id="title"><%= objArticleBean.getArticleTitle() %></h2>
                        
                        <p id="journal">
                            <b>Revista: </b><%= objArticleBean.getPublicationTitle() %>
                            
                            (Abrevia��o: <%= objArticleBean.getAbreviation() %>).
                            ISSN: <%= objArticleBean.getISSN() %>. 
                            Vol <%= objArticleBean.getVolume() %>. 
                            P�ginas: <%= objArticleBean.getPagination() %>. 
                            Issue: <%= objArticleBean.getIssue() %> 
                            Afilia��o: <%= objArticleBean.getAffiliation() %></p>
                    </div>
                    <div id="author-box">
                        Autores: 
                        <%
                                while(objArticleBean.getAuthor() != 0){
                                    %>
                                    <h6><%= objArticleBean.getAuthor() %></h6><h5>, </h5>
                                    <%
                                }
                                %>

                    </div>
                    <div id="abstract-box">
                        <h3 class="label">Resumo:</h3>
                        <p id="abstract"><%= objArticleBean.getAbstract() %></p>
                    </div>
                    <div id="mesh-box">
                        <h3 class="label">Termos Mesh: </h3>
                        
                        <%
                                while(objArticleBean.getMesh() != 0){
                                    %>
                                    <h6 class="property-name"><%= objArticleBean.getMesh() %></h6><h5>, </h5>
                                    <%
                                }
                                %>
                        
                        
                    </div>
                    <div id="keyword-box">
                        <h3 class="label">Palavras-chave: </h3>
                        <%
                                while(objArticleBean.getKeyword() != 0){
                                    %>
                                    <h6 class="property-name"><%= objArticleBean.getKeyword() %></h6><h5>, </h5>
                                    <%
                                }
                                %>
                        
                    </div>
                    <div id="chemical-box">
                        <h3 class="label">Subst�ncias qu�micas: </h3>
                        <%
                                while(objArticleBean.getChemical() != 0){
                                    %>
                                    <h6 class="property-name"><%= objArticleBean.getChemical() %></h6><h5>, </h5>
                                    <%
                                }
                                %>
                        
                    </div>
                    <div id="publication-box">
                        <h3 class="label">Tipos de publica��o: </h3>
                        <%
                                while(objArticleBean.getPublicationType() != 0){
                                    %>
                                    <h6 class="property-name"><%= objArticleBean.getPublicationType() %></h6><h5>, </h5>
                                    <%
                                }
                                %>
                        
                    </div>
                            <%
                            } else {
                                %>
                                <h2>N�o foi poss�vel recuperar o Artigo</h1>
                                <%
                            }
                                %>
                </div>
                <div class="voltar-box">
                    <a href="index.html" class="voltar-link">
                        Voltar para a p�gina de pesquisa
                    </a>
                </div>
            </div> <!-- #main -->
        </div> <!-- #main-container -->

        <div class="footer-container">
            <footer class="wrapper">
                <h3>© 2013 forArticle - Forward your research!</h3>
            </footer>
        </div>

        <script src="./js/jquery-1.9.1.min.js"></script>
        <script src="./js/article-view.js"></script>
        <script>window.jQuery || document.write('<script src="js/vendor/jquery-1.9.1.min.js"><\/script>')</script>

        <script src="js/main.js"></script>


    </body>
</html>
