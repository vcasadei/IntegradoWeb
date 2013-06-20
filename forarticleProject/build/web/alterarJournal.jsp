<%-- 
    Document   : alterarJournal
    Created on : Jun 18, 2013, 4:05:57 PM
    Author     : Vitor Casadei
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <link rel="stylesheet" href="css/cadastro_artigo.css">

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
                        <li><a href="index.html">Início</a></li>
                        <li><a href="login.html">Login</a></li>
                    </ul>
                </nav>
            </header>
        </div> 

        <div class="main-container">
            <div class="main wrapper clearfix">
                <div class="cadastro-box">
                    <div class="separator separator3"><a href="index.html">Inicio</a> -> <a href="alterarJournal.jsp">Alterar Revista</a></div>
                    <h2>Alterar Revista</h2>
                    <p> * - Obrigatório </p>
                    <form class="form-cadastro" action="AlterarJournal" method="POST">
                        <div class="separator separator2">Informações sobre a Revista</div>
                        <p class="side-fields">
                            <%
                                 Journal objJournalBean = (Journal)request.getAttribute("journalBean");
                                    if (objJournalBean != null){
                                        
                                    
                                %>
                                
                            <label class="label-s" for="nlmuniqueid">NLM (ID único): </label>
                            <input class="text-inline nlm-edt" type="text" disabled name="nlmuniqueid" value="<%= objJournalBean.getNlm() %>" />
                            
                            <label class="label-s label-right" for="issn">ISSN: </label>
                                <input class="text-right issn-edt" disabled type="text" name="issn" value="<%= objJournalBean.getIssn() %>" />
                            
                        </p>
                        <p class="line-field">
                            <label class="label-s" for="journalTitle">Título da Revista: </label>
                                <input class="text-s journal" type="text" name="journalTitle" value="<%= objJournalBean.getTitle() %>"/>
                        </p>
                        <p class="side-fields">
                            <label class="label-s" for="aberviation">Abreviação: </label>
                                <input class="text-inline" type="text" name="abreviation" size="10" value="<%= objJournalBean.getAbreviation() %>"/>/>
                            
                            <label class="label-s label-right" for="pagination">Paginação: </label>
                                <input class="text-inline" disabled type="text" name="pagination" size="10" value="<%= objJournalBean.getPagination() %>"/>
                            <label class="label-s label-right" for="volume">Volume: </label>
                                <input class="text-inline" disabled type="text" name="volume" size="10" value="<%= objJournalBean.getVolume() %>"/>
                            <label class="label-s label-right" for="issue">Issue: </label>
                                <input class="text-inline" disabled type="text" name="issue" size="10" value="<%= objJournalBean.getIssue() %>"/>
                        </p>
                        
                        <%
                                    }
                                    %>
                        
                        
                        <div class="btn-cadastrar-box">
                            <input type="submit" class="btn-cadastrar" value="Alterar">
                        </div>
                    </form>
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
                <h3>© 2013 forArticle - Forward your research!</h3>
            </footer>
        </div>

        <script src="./js/jquery-1.9.1.min.js"></script>
        <script>window.jQuery || document.write('<script src="js/vendor/jquery-1.9.1.min.js"><\/script>')</script>

        <script src="js/main.js"></script>
        <script src="js/add-properties.js"></script>
        <script src="js/search-author.js"></script>
    </body>
</html>

