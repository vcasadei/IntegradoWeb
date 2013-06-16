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

        <script src="js/vendor/modernizr-2.6.2-respond-1.1.0.min.js"></script>
    </head>
    <body>
        <!--[if lt IE 7]>
            <p class="chromeframe">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> or <a href="http://www.google.com/chromeframe/?redirect=true">activate Google Chrome Frame</a> to improve your experience.</p>
        <![endif]-->

        <div class="header-container">
            <header class="wrapper clearfix">
                <h1 class="title">
                    <a class="logo" href="#">
                        <img class="asterisco" src="<%= request.getScheme() + "://" + request.getServerName() + 
> ":" + request.getServerPort() %>/web/img/img2.png" alt="ForArticle" />
                        <img class="texto" src="<%= request.getScheme() + "://" + request.getServerName() + 
> ":" + request.getServerPort() %>/web/img/img1.png" alt="ForArticle" />
                    </a>
                    
                </h1>
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
                <form method="GET" action="#" class="pesquisar-form">
                    <p id="busca-label">Busque por artigos:</p>
                    <input type="text" name="pesquisar-edt" class="pesquisar-edt noEnterSubmit" placeholder="Digite aqui o título do artigo"/>
                    <!-- <input type="image" alt="Submit" name="pesquisar-btn" class="pesquisar-btn" src="./img/search-btn.png"> -->
                    <input type="button" value="" class="noClickSubmit pesquisar-btn"/>
                </form>
                <div class="pesquisa-avancada-box" style="margin-top:82px;">
                    <form id="pesquisa-avancada-form">
                        <p class="form-separator">Informações do Journal:</p>
                        <label for="journal-title-edt">Titulo </label>
                        <input type="text" name="journal-title-edt" class="journal-title-edt noEnterSubmit" placeholder=""/>
                        <label for="journal-issn-edt">ISSN </label>
                        <input type="text" name="journal-issn-edt" class="journal-issn-edt noEnterSubmit" placeholder="XXXX-XXXX"/>
                        <p class="form-separator">Intervalo de Data:</p>
                        <label for="data-inicial-edt">Inicial </label>
                        <input type="text" name="data-inicial-edt" class="data-edt data-inicial-edt noEnterSubmit" />
                        <label for="data-final-edt">Final </label>
                        <input type="text" name="data-final-edt" class="data-edt data-final-edt noEnterSubmit"/>

                    </form>
                </div>
                <div class="pesquisa-avancada"><a id="pesquisa-avancada-txt">Busca Avançada</a>
                </div>
                <p id='results-label'>Resultados Encontrados:</p>
                <div id="main-result-box">
                </div>
            </div> <!-- #main -->
        </div> <!-- #main-container -->

        <div class="footer-container">
            <footer class="wrapper">
                <h3>© 2013 forArticle - Forward your research!</h3>
            </footer>
        </div>

        <script src="./js/jquery-1.9.1.min.js"></script>
        <script src="./js/pesquisa-home.js"></script>
        <script>window.jQuery || document.write('<script src="js/vendor/jquery-1.9.1.min.js"><\/script>')</script>

        <script src="js/main.js"></script>
    </body>
</html>
