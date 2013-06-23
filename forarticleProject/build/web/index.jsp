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
        <link rel="stylesheet" href="css/busca_form.css">
        <link rel="stylesheet" href="css/menu.css">
        <link rel="stylesheet" href="css/autocomplete.css">

        <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
        <script src="js/vendor/modernizr-2.6.2-respond-1.1.0.min.js"></script>
        
        
    </head>
    <body>
        <!--[if lt IE 7]>
            <p class="chromeframe">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> or <a href="http://www.google.com/chromeframe/?redirect=true">activate Google Chrome Frame</a> to improve your experience.</p>
        <![endif]-->

        <div class="header-container">
            <header class="wrapper clearfix">
                <a class="title" href="index.jsp"></a>
                <nav>
                    <ul>
                        <li><a class="menu-item" href="index.jsp">Início</a></li>
                        <li><a href="login.html">Login</a></li>
                    </ul>
                </nav>
            </header>
        </div>

        <div class="main-container">
            <div class="main wrapper clearfix">
                <div class="form-box">
                    <h2 class="busca-lbl">Busque por artigos:</h2>
                    <form method="POST" action="BuscaInicial" class="form-pesquisa" id="pesquisa-s">
                       <p id="radio">
                           <input class="radios" type="radio" name="tipo" value="titulo" checked/>Título
                           <input class="radios" type="radio" name="tipo" value="keyword"/>Palavra-chave
                       </p>
                       <input type="text" data-provide="typeahead" name="search" id="caixa-pesquisa" class="search-edt" autocomplete="off" placeholder="Digite aqui parte do título de um artigo"/>
                       <input type="hidden" name="pagina" value="1"/>
                       <input type="hidden" name="qtdePaginas" value="0"/>
                       <input type="text" class="search-btn" id="btn-pesquisa"/>
                   </form>
                   <form method="GET" action="BuscaInicial" class="form-pesquisa" id="pesquisa-a">
                       <div id="form-pesquisa-avancada">
                            <p class="form-separator">Informações do Journal:</p>
                            <label for="journal-title-edt">Titulo </label>
                            <input type="text" autocomplete="off" data-provide="typeahead" name="journal-title-edt" id="journalTitle" class="journal-title-edt noEnterSubmit" placeholder=""/>
                            <label for="journal-issn-edt">ISSN </label>
                            <input type="text" autocomplete="off" data-provide="typeahead" name="journal-issn-edt" id="issn" class="journal-issn-edt noEnterSubmit" placeholder="XXXX-XXXX"/>
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
                <!-- <div id="fix-keyword"><br/><br/></div>  -->
            </div> <!-- #main -->
        </div> <!-- #main-container -->

        <div class="footer-container">
            <footer class="wrapper">
                <h3>© 2013 forArticle - Forward your research!</h3>
            </footer>
        </div>

        <script src="./js/jquery-1.9.1.min.js"></script>
        <script charset="utf-8" src="./js/pesquisa-home.js"></script>
        <script>window.jQuery || document.write('<script src="js/vendor/jquery-1.9.1.min.js"><\/script>')</script>

        <script src="js/bootstrap.js"></script>
        <script src="js/autocomplete.js"></script>
    </body>
</html>
