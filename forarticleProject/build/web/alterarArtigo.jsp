<%-- 
    Document   : alterarArtigo
    Created on : Jun 18, 2013, 4:17:43 PM
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
                    <h2>Alterar Artigo</h2>

                    <form class="form-cadastro" action="CadastrarArtigo" method="POST">
                        <div class="separator separator1">Informações Gerais</div>
                        <%
                                 Article objArticleBean = (Article)request.getAttribute("artigoBean");
                                    if (objArticleBean != null){
                                        
                                    
                                %>
                        <p class="line-field">
                            <label class="label-s" for="titulo">Título: </label>
                                <input class="text-s" type="text" name="titulo" value="<%= objArticleBean.getTitle() %>"/>
                        </p>
                        <p class="side-fields">
                            <label class="label-s" for="articleId">ID do Artigo: </label>
                            <input class="text-inline" type="text" name="articleId" disabled value="<%= objArticleBean.getArticleID() %>"/>
                            <label class="label-s label-right" for="data">Data de Publicação: </label>
                                <input class="date-field text-right" type="date" name="data" value="<%= objArticleBean.getPublicationDate() %>"/>
                        </p>
                        <p class="side-fields">
                            <label class="label-s" for="articleId">Status da Publicação: </label>
                                <select class="status-combobox">
                                    <%
                                        String aux = objArticleBean.getPublicarionStatus();
                                        if(aux == "ppublish"){
                                            
                                        %>
                                    <option value="apublish" selected>ppublish</option>
                                    <option value="epublish">epublish</option>
                                    <option value="aheadofprint">aheadofprint</option>
                                        <%
                                        } else {
                                            if(aux == "epublish"){
                                                %>
                                    <option value="apublish">ppublish</option>
                                    <option value="epublish" selected>epublish</option>
                                    <option value="aheadofprint">aheadofprint</option>
                                                <%
                                                
                                                
                                            } else {
                                                %>
                                    <option value="apublish">ppublish</option>
                                    <option value="epublish">epublish</option>
                                    <option value="aheadofprint" selected>aheadofprint</option>
                                                <%
                                            }
                                        }
                                        %>
                                    
                                </select>
                            <label class="label-s label-right" for="affiliation">Afiliação: </label>
                                <input class="text-inline text-right" type="text" name="affiliation" value="<%= objArticleBean.getAfiliation() %>"/>
                        </p>
                        <p class="resumo-field">
                            <label class="label-s" for="resumo">Resumo: </label>
                            <textarea class="resumo" rows="6" cols="90" name="resumo"><%= objArticleBean.getAbstract() %></textarea>
                        </p>
                        <div class="separator separator2">Informações sobre a Revista</div>
                        <p class="side-fields">
                            <label class="label-s" for="nlmuniqueid">NLM (ID único): </label>
                                <input class="text-inline nlm-edt" type="text" name="nlmuniqueid" disabled <%= objArticleBean.getNlm() %>/>
                            <label class="label-s label-right" for="issn">ISSN: </label>
                            <input class="text-right issn-edt" type="text" name="issn" value="<%= objArticleBean.getIssn() %>" disabled />
                        </p>
                        <p class="line-field">
                            <label class="label-s" for="journalTitle">Título da Revista: </label>
                                <input class="text-s journal" type="text" name="journalTitle" value="<%= objArticleBean.getJournalTitle() %>" disabled/>
                        </p>
                        <p class="side-fields">
                            <label class="label-s" for="aberviation">Abreviação: </label>
                                <input class="text-inline" type="text" name="abreviation" disabled size="10" value="<%= objJournalBean.getAbreviation() %>"/>/>
                            
                            <label class="label-s label-right" for="pagination">Paginação: </label>
                                <input class="text-inline" disabled type="text" name="pagination" disabled size="10" value="<%= objJournalBean.getPagination() %>"/>
                            <label class="label-s label-right" for="volume">Volume: </label>
                                <input class="text-inline" type="text" name="volume" size="10" disabled value="<%= objArticleBean.getVolume() %>"/>
                            <label class="label-s label-right" for="issue">Issue: </label>
                                <input class="text-inline" type="text" name="issue" size="10" disabled value="<%= objArticleBean.getIssue() %>"/>
                        </p>
                        <div class="separator separator2">Autores</div>
                        <p class="line-field no-bottom-margin">
                            <label class="label-s" for="autor-busca">Pesquise por Autores: </label>
                                <input class="text-s autor-busca " type="text" name="autor-busca" placeholder="nome; sobrenome; iniciais"/>
                            <input type="text" class="noClickSubmit pesquisar-autor"/>
                            <strong class="open-help-autor">[exibir ajuda]</strong>
                        </p>
                        <p class="no-top-margin hint-autor">
                            Formato: nome; sobrenome; iniciais
                        </p>
                        <p class="help-text-autor no-bottom-margin">Utilize a ferramenta acima para pesquisar autores cadastrados. Você deve informar o nome, o sobrenome e as iniciais do autor (Ex.: João; Souza; JS). Abaixo serão exibidos os cinco primeiros autores encontrados. Para adicionar autores ao artigo, clique em [adicionar] ao lado dos resultados encontrados. Se você não encontrou o autor desejado, será exibida uma mensagem de cadastro, onde você poderá cadastrar um novo autor e adicioná-lo como autor de um artigo.
                        <strong class="close-help-autor">[fechar ajuda]</strong>
                        </p>
                        <div class="autor-box">
                            
                            <p class="no-bottom-margin autores-encontrados">
                                <strong>Autores Encontrados:</strong>
                            </p>
                            <p class="no-top-margin autor-nenhum encontrado-nenhum">
                                Utilize a ferramenta de busca acima para buscar autores.
                            </p>
                            <ul class="encontrados-list">
                            </ul>
                            <p class="no-bottom-margin autores-selecionados">
                                <strong>*Autores Selecionados:</strong>
                            </p>
                            <p class="no-top-margin autor-nenhum selecionado-nenhum">
                                Nenhum Autor adicionado (Utilize os controles acima para adicionar autores)
                            </p>
                            <ul class="selecionados-list">
                            </ul>
                            
                        </div>
                        <div class="separator separator2">Palavras-chave</div>
                        <div class="keyword-box">
                            <p class="no-bottom-margin">
                                <label class="label-s label-right" for="keyword">Palavra-chave: </label>
                            </p>
                            <p class="no-top-margin new-line-edt">
                                <input class="text-inline keyword-edt" type="text" name="keyword"/>
                                <input type="text" class="noClickSubmit adicionar-keyword"/>
                                <strong class='keyword-erro'></strong> 
                            </p>
                            <p class="keyword-nenhum">
                                Nenhuma Palavra-chave adicionada (Utilize os controles acima para adicionar uma nova palavra-chave)
                            </p>
                            <ul class="keyword-list">
                                <% 
                                        while(objArticleBean.getKeywords() != null){
                                            
                                            %>
                                            <li class="keyword-item"><%= objArticleBean.getKeyword() %><strong class="keyword-remover" onclick="removeKeyword(this)">[remover]</strong></li>
                                            <%
                                        }
                                        %>

                            </ul>
                        </div>
                        <div class="separator separator2">Termos Mesh</div>
                        <div class="mesh-box">
                            <p class="no-bottom-margin">
                                <label class="label-s label-right" for="mesh">Termo Mesh: </label>
                            </p>
                            <p class="no-top-margin new-line-edt">
                                <input class="text-inline mesh-edt" type="text" name="mesh"/>
                                <input type="text" class="noClickSubmit adicionar-mesh"/>
                                <strong class='mesh-erro'></strong>
                            </p>
                            <p class="mesh-nenhum">
                                Nenhum Termo Mesh adicionado (Utilize os controles acima para adicionar um novo termo mesh)
                            </p>
                            <ul class="mesh-list">
                                <% 
                                        while(objArticleBean.getMeshList() != null){
                                            
                                            %>
                                            <li class="mesh-item"><%= objArticleBean.getMesh() %><strong class="mesh-remover" onclick="removeMesh(this)">[remover]</strong></li>
                                            <%
                                        }
                                        %>
                            </ul>
                        </div>
                        <div class="separator separator2">Substâncias Químicas</div>
                        <div class="chemical-box">
                            <p class="no-bottom-margin">
                                <label class="label-s label-right" for="chemical">Substância Química: </label>
                            </p>
                            <p class="no-top-margin new-line-edt">
                                <input class="text-inline chemical-edt" type="text" name="chemical"/>
                                <input type="text" class="noClickSubmit adicionar-chemical"/>
                                <strong class='chemical-erro'></strong>
                            </p>
                            <p class="chemical-nenhum">
                                Nenhuma Substância Química adicionada (Utilize os controles acima para adicionar uma nova substância)
                            </p>
                            <ul class="chemical-list">
                                <% 
                                        while(objArticleBean.getChemicals() != null){
                                            
                                            %>
                                            <li class="chemical-item"><%= objArticleBean.getChemical() %><strong class="chemical-remover" onclick="removeChemical(this)">[remover]</strong></li>
                                            <%
                                        }
                                        %>
                            </ul>
                        </div>
                        <div class="separator separator2">Tipo de Publicação</div>
                        <div class="pubtype-box">
                            <p class="no-bottom-margin">
                                <label class="label-s label-right" for="pubtype">Tipos de Publicação: </label>
                            </p>
                            <p class="no-top-margin new-line-edt">
                                <input class="text-inline pubtype-edt" type="text" name="pubtype"/>
                                <input type="text" class="noClickSubmit adicionar-pubtype"/>
                                <strong class='pubtype-erro'></strong>
                            </p>    
                            <p class="pubtype-nenhum">
                                Nenhum Tipo de Publicação adicionado (Utilize os controles acima para adicionar um novo tipo)
                            </p>
                            <ul class="pubtype-list">
                                <% 
                                        while(objArticleBean.getPublicationType() != null){
                                            
                                            %>
                                            <li class="pubtype-item"><%= objArticleBean.getPublicationType() %><strong class="pubtype-remover" onclick="removePubtype(this)">[remover]</strong></li>
                                            <%
                                        }
                                        %>
                            </ul>
                        <div class="separator separator2"></div>
                        </div>
                        
                        <%
                                    }
                                        %>
                                        
                        <div class="btn-cadastrar-box">
                            <input type="submit" class="btn-cadastrar" value="Cadastrar">
                        </div>
                        <!-- <div class="btn-cadastrar">
                            Cadastrar
                        </div> -->
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

