package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Bean.Article;

public final class AlterarArtigo_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<!--[if lt IE 7]>      <html class=\"no-js lt-ie9 lt-ie8 lt-ie7\"> <![endif]-->\n");
      out.write("<!--[if IE 7]>         <html class=\"no-js lt-ie9 lt-ie8\"> <![endif]-->\n");
      out.write("<!--[if IE 8]>         <html class=\"no-js lt-ie9\"> <![endif]-->\n");
      out.write("<!--[if gt IE 8]><!--> <html class=\"no-js\"> <!--<![endif]-->\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\n");
      out.write("        <title></title>\n");
      out.write("        <meta name=\"description\" content=\"\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width\">\n");
      out.write("\n");
      out.write("        <link href='http://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'>\n");
      out.write("        <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/normalize.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/main.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/cadastro_artigo.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/autocomplete.css\">\n");
      out.write("\n");
      out.write("        <script src=\"js/vendor/modernizr-2.6.2-respond-1.1.0.min.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <!--[if lt IE 7]>\n");
      out.write("            <p class=\"chromeframe\">You are using an <strong>outdated</strong> browser. Please <a href=\"http://browsehappy.com/\">upgrade your browser</a> or <a href=\"http://www.google.com/chromeframe/?redirect=true\">activate Google Chrome Frame</a> to improve your experience.</p>\n");
      out.write("        <![endif]-->\n");
      out.write("\n");
      out.write("        <div class=\"header-container\">\n");
      out.write("            <header class=\"wrapper clearfix\">\n");
      out.write("                <h1 class=\"title\"></h1>\n");
      out.write("                <nav>\n");
      out.write("                    <ul>\n");
      out.write("                        <li><a href=\"Index.html\">Início</a></li>\n");
      out.write("                        <li><a href=\"CadastroArtigo.html\">Cadastrar</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </nav>\n");
      out.write("            </header>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"main-container\">\n");
      out.write("            <div class=\"main wrapper clearfix\">\n");
      out.write("                <div class=\"cadastro-box\">\n");
      out.write("                    <h2>Alterar Artigo</h2>\n");
      out.write("\n");
      out.write("                    <form class=\"form-cadastro\" action=\"CadastrarArtigo\" method=\"POST\">\n");
      out.write("                        <div class=\"separator separator1\">Informações Gerais</div>\n");
      out.write("                        ");

                            Article objArticleBean = (Article) request.getAttribute("artigoBean");
                            if (objArticleBean != null) {
                                int cont, tam;

                        
      out.write("\n");
      out.write("                        <p class=\"line-field\">\n");
      out.write("                            <label class=\"label-s\" for=\"titulo\">Título: </label>\n");
      out.write("                            <input class=\"text-s\" type=\"text\" name=\"titulo\" value=\"");
      out.print( objArticleBean.getTitle());
      out.write("\"/>\n");
      out.write("                        </p>\n");
      out.write("                        <p class=\"side-fields\">\n");
      out.write("                            <label class=\"label-s\" for=\"articleId\">ID do Artigo: </label>\n");
      out.write("                            <input class=\"text-inline\" type=\"text\" name=\"articleId\" disabled value=\"");
      out.print( objArticleBean.getArticleID());
      out.write("\"/>\n");
      out.write("                            <label class=\"label-s label-right\" for=\"data\">Data de Publicação: </label>\n");
      out.write("\n");
      out.write("                            <input class=\"date-field text-right\" type=\"text\" name=\"data\" value=\"");
      out.print( objArticleBean.getArticleDate());
      out.write("\"/>\n");
      out.write("                        </p>\n");
      out.write("                        <p class=\"side-fields\">\n");
      out.write("                            <label class=\"label-s\" for=\"articleId\">Status da Publicação: </label>\n");
      out.write("                            <select class=\"status-combobox\">\n");
      out.write("                                ");

                                    String aux = objArticleBean.getPublicationStatus();
                                    if (aux == "ppublish") {

                                
      out.write("\n");
      out.write("                                <option value=\"apublish\" selected>ppublish</option>\n");
      out.write("                                <option value=\"epublish\">epublish</option>\n");
      out.write("                                <option value=\"aheadofprint\">aheadofprint</option>\n");
      out.write("                                ");
                                        } else {
                                    if (aux == "epublish") {
                                
      out.write("\n");
      out.write("                                <option value=\"apublish\">ppublish</option>\n");
      out.write("                                <option value=\"epublish\" selected>epublish</option>\n");
      out.write("                                <option value=\"aheadofprint\">aheadofprint</option>\n");
      out.write("                                ");
                                                } else {
                                
      out.write("\n");
      out.write("                                <option value=\"apublish\">ppublish</option>\n");
      out.write("                                <option value=\"epublish\">epublish</option>\n");
      out.write("                                <option value=\"aheadofprint\" selected>aheadofprint</option>\n");
      out.write("                                ");
                                                        }
                                    }
                                
      out.write("\n");
      out.write("\n");
      out.write("                            </select>\n");
      out.write("                            <label class=\"label-s label-right\" for=\"affiliation\">Afiliação: </label>\n");
      out.write("                            <input class=\"text-inline text-right\" type=\"text\" name=\"affiliation\" value=\"");
      out.print( objArticleBean.getAffiliation());
      out.write("\"/>\n");
      out.write("                        </p>\n");
      out.write("                        <p class=\"resumo-field\">\n");
      out.write("                            <label class=\"label-s\" for=\"resumo\">Resumo: </label>\n");
      out.write("                            <textarea class=\"resumo\" rows=\"6\" cols=\"90\" name=\"resumo\">");
      out.print( objArticleBean.getResumo());
      out.write("</textarea>\n");
      out.write("                        </p>\n");
      out.write("                        <div class=\"separator separator2\">Informações sobre a Revista</div>\n");
      out.write("                        <p class=\"side-fields\">\n");
      out.write("                            <label class=\"label-s\" for=\"nlmuniqueid\">NLM (ID único): </label>\n");
      out.write("                            <input class=\"text-inline nlm-edt\" type=\"text\" name=\"nlmuniqueid\" disabled ");
      out.print( objArticleBean.getJournal().getNlmUniqueID());
      out.write("/>\n");
      out.write("                            <label class=\"label-s label-right\" for=\"issn\">ISSN: </label>\n");
      out.write("                            <input class=\"text-right issn-edt\" type=\"text\" name=\"issn\" value=\"");
      out.print( objArticleBean.getJournal().getISSN());
      out.write("\" disabled />\n");
      out.write("                        </p>\n");
      out.write("                        <p class=\"line-field\">\n");
      out.write("                            <label class=\"label-s\" for=\"journalTitle\">Título da Revista: </label>\n");
      out.write("                            <input class=\"text-s journal\" type=\"text\" name=\"journalTitle\" value=\"");
      out.print( objArticleBean.getJournal().getTitle());
      out.write("\" disabled/>\n");
      out.write("                        </p>\n");
      out.write("                        <p class=\"side-fields\">\n");
      out.write("                            <label class=\"label-s\" for=\"pagination\">Paginação: </label>\n");
      out.write("                            <input class=\"text-inline\" type=\"text\" name=\"pagination\" size=\"10\" value=\"");
      out.print( objArticleBean.getPagination());
      out.write("\" disabled/>\n");
      out.write("                            <label class=\"label-s label-right\" for=\"volume\">Volume: </label>\n");
      out.write("                            <input class=\"text-inline\" type=\"text\" name=\"volume\" size=\"10\" disabled value=\"");
      out.print( objArticleBean.getVolume());
      out.write("\"/>\n");
      out.write("                            <label class=\"label-s label-right\" for=\"issue\">Issue: </label>\n");
      out.write("                            <input class=\"text-inline\" type=\"text\" name=\"issue\" size=\"10\" disabled value=\"");
      out.print( objArticleBean.getIssue());
      out.write("\"/>\n");
      out.write("                        </p>\n");
      out.write("                        <div class=\"separator separator2\">Autores</div>\n");
      out.write("                        <p class=\"line-field no-bottom-margin\">\n");
      out.write("                        <table class=\"autor-table\">\n");
      out.write("                            <tr class=\"tr-labels\">\n");
      out.write("                                <td></td>\n");
      out.write("                                <td>Nome</td>\n");
      out.write("                                <td>Sobrenome</td>\n");
      out.write("                                <td>Iniciais</td>\n");
      out.write("                                <td></td>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>\n");
      out.write("                                    <label class=\"label-s\" for=\"autor-busca\">Pesquise por Autores: </label>\n");
      out.write("                                </td>\n");
      out.write("                                <td>\n");
      out.write("                                    <input class=\"\" size=\"13\" data-provide=\"typeahead\" type=\"text\" name=\"autor-busca\" id=\"forename\"/>\n");
      out.write("                                </td>\n");
      out.write("                                <td>\n");
      out.write("                                    <input class=\"\" data-provide=\"typeahead\" type=\"text\" size=\"13\" name=\"autor-busca\" id=\"lastname\"/>    \n");
      out.write("                                </td>\n");
      out.write("                                <td>\n");
      out.write("                                    <input class=\"\" data-provide=\"typeahead\" type=\"text\" size=\"7\" name=\"autor-busca\" id=\"initialsname\"/>\n");
      out.write("                                </td>\n");
      out.write("                                <td>\n");
      out.write("                                    <input type=\"text\" class=\"noClickSubmit adicionar-autor\" />\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                        </table>\n");
      out.write("                        <div class=\"autor-box\">\n");
      out.write("                            <p class=\"no-bottom-margin autores-selecionados\">\n");
      out.write("                                <strong>*Autores Selecionados:</strong>\n");
      out.write("                            </p>\n");
      out.write("                            ");

                                if (objArticleBean.getAutores().isEmpty()) {
                            
      out.write("\n");
      out.write("                            <p class=\"no-top-margin autor-nenhum selecionado-nenhum\">\n");
      out.write("                                Nenhum Autor adicionado (Utilize os controles acima para adicionar autores)\n");
      out.write("                            </p>\n");
      out.write("                            ");
 
                                } else {
                            
      out.write("\n");
      out.write("                            <ul class=\"selecionados-list\">\n");
      out.write("                                ");

                                    cont = 0;
                                    tam = objArticleBean.getAutores().size();
                                    while (cont < tam) {

                                
      out.write("\n");
      out.write("                                <!--Coloca o código dos autores aqui-->\n");
      out.write("                                ");

                                        cont++;
                                    }
                                
      out.write("\n");
      out.write("                            </ul>\n");
      out.write("                            ");

                                }
                            
      out.write("\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"separator separator2\">Palavras-chave</div>\n");
      out.write("                        <div class=\"keyword-box\">\n");
      out.write("                            <p class=\"no-bottom-margin\">\n");
      out.write("                                <label class=\"label-s label-right\" for=\"keyword\">Palavra-chave: </label>\n");
      out.write("                            </p>\n");
      out.write("                            <p class=\"no-top-margin new-line-edt\">\n");
      out.write("                                <input class=\"text-inline keyword-edt\" type=\"text\" name=\"keyword\"/>\n");
      out.write("                                <input type=\"text\" class=\"noClickSubmit adicionar-keyword\"/>\n");
      out.write("                                <strong class='keyword-erro'></strong> \n");
      out.write("                            </p>\n");
      out.write("                            ");

                                if (objArticleBean.getKeyWord().isEmpty()) {
                            
      out.write("\n");
      out.write("                            <p class=\"keyword-nenhum\">\n");
      out.write("                                Nenhuma Palavra-chave adicionada (Utilize os controles acima para adicionar uma nova palavra-chave)\n");
      out.write("                            </p>\n");
      out.write("                            ");
 
                                } else {
                            
      out.write("\n");
      out.write("                            <ul class=\"keyword-list\">\n");
      out.write("                                ");

                                    cont = 0;
                                    tam = objArticleBean.getKeyWord().size();
                                    while (cont < tam) {

                                
      out.write("\n");
      out.write("                                <li class=\"keyword-item\">");
      out.print( objArticleBean.getKeyWord().get(cont));
      out.write("<strong class=\"keyword-remover\" onclick=\"removeKeyword(this)\">[remover]</strong></li>\n");
      out.write("                                    ");

                                            cont++;
                                        }
                                    
      out.write("\n");
      out.write("\n");
      out.write("                            </ul>\n");
      out.write("                            ");

                                }
                            
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"separator separator2\">Termos Mesh</div>\n");
      out.write("                        <div class=\"mesh-box\">\n");
      out.write("                            <p class=\"no-bottom-margin\">\n");
      out.write("                                <label class=\"label-s label-right\" for=\"mesh\">Termo Mesh: </label>\n");
      out.write("                            </p>\n");
      out.write("                            <p class=\"no-top-margin new-line-edt\">\n");
      out.write("                                <input class=\"text-inline mesh-edt\" type=\"text\" name=\"mesh\"/>\n");
      out.write("                                <input type=\"text\" class=\"noClickSubmit adicionar-mesh\"/>\n");
      out.write("                                <strong class='mesh-erro'></strong>\n");
      out.write("                            </p>\n");
      out.write("                            ");

                                if (objArticleBean.getMeshHeading().isEmpty()) {
                            
      out.write("\n");
      out.write("                            <p class=\"mesh-nenhum\">\n");
      out.write("                                Nenhum Termo Mesh adicionado (Utilize os controles acima para adicionar um novo termo mesh)\n");
      out.write("                            </p>\n");
      out.write("                            ");
                            } else {
                            
      out.write("\n");
      out.write("                            <ul class=\"mesh-list\">\n");
      out.write("                                ");

                                    cont = 0;
                                    tam = objArticleBean.getMeshHeading().size();
                                    while (cont < tam) {

                                
      out.write("\n");
      out.write("                                <li class=\"mesh-item\">");
      out.print( objArticleBean.getMeshHeading().get(cont));
      out.write("<strong class=\"mesh-remover\" onclick=\"removeMesh(this)\">[remover]</strong></li>\n");
      out.write("                                    ");

                                            cont++;
                                        }
                                    
      out.write("\n");
      out.write("                            </ul>\n");
      out.write("                            ");

                                }
                            
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"separator separator2\">Substâncias Químicas</div>\n");
      out.write("                        <div class=\"chemical-box\">\n");
      out.write("                            <p class=\"no-bottom-margin\">\n");
      out.write("                                <label class=\"label-s label-right\" for=\"chemical\">Substância Química: </label>\n");
      out.write("                            </p>\n");
      out.write("                            <p class=\"no-top-margin new-line-edt\">\n");
      out.write("                                <input class=\"text-inline chemical-edt\" type=\"text\" name=\"chemical\"/>\n");
      out.write("                                <input type=\"text\" class=\"noClickSubmit adicionar-chemical\"/>\n");
      out.write("                                <strong class='chemical-erro'></strong>\n");
      out.write("                            </p>\n");
      out.write("                            ");

                                if (objArticleBean.getChemical().isEmpty()) {
                            
      out.write("\n");
      out.write("                            <p class=\"chemical-nenhum\">\n");
      out.write("                                Nenhuma Substância Química adicionada (Utilize os controles acima para adicionar uma nova substância)\n");
      out.write("                            </p>\n");
      out.write("                            ");
                            } else {
                            
      out.write("\n");
      out.write("                            <ul class=\"chemical-list\">\n");
      out.write("                                ");

                                    cont = 0;
                                    tam = objArticleBean.getChemical().size();
                                    while (cont < tam) {

                                
      out.write("\n");
      out.write("                                <li class=\"mesh-item\">");
      out.print( objArticleBean.getMeshHeading().get(cont));
      out.write("<strong class=\"mesh-remover\" onclick=\"removeMesh(this)\">[remover]</strong></li>\n");
      out.write("                                    ");

                                            cont++;
                                        }
                                    
      out.write("\n");
      out.write("                            </ul>\n");
      out.write("                            ");

                                }
                            
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"separator separator2\">Tipo de Publicação</div>\n");
      out.write("                        <div class=\"pubtype-box\">\n");
      out.write("                            <p class=\"no-bottom-margin\">\n");
      out.write("                                <label class=\"label-s label-right\" for=\"pubtype\">Tipos de Publicação: </label>\n");
      out.write("                            </p>\n");
      out.write("                            <p class=\"no-top-margin new-line-edt\">\n");
      out.write("                                <input class=\"text-inline pubtype-edt\" type=\"text\" name=\"pubtype\"/>\n");
      out.write("                                <input type=\"text\" class=\"noClickSubmit adicionar-pubtype\"/>\n");
      out.write("                                <strong class='pubtype-erro'></strong>\n");
      out.write("                            </p>\n");
      out.write("                            ");

                                if (objArticleBean.getPublicationType().isEmpty()) {
                            
      out.write("\n");
      out.write("                            <p class=\"pubtype-nenhum\">\n");
      out.write("                                Nenhum Tipo de Publicação adicionado (Utilize os controles acima para adicionar um novo tipo)\n");
      out.write("                            </p>\n");
      out.write("                            ");
                            } else {
                            
      out.write("\n");
      out.write("                            <ul class=\"pubtype-list\">\n");
      out.write("                                ");

                                    cont = 0;
                                    tam = objArticleBean.getPublicationType().size();
                                    while (cont < tam) {

                                
      out.write("\n");
      out.write("                                <li class=\"pubtype-item\">");
      out.print( objArticleBean.getPublicationType().get(cont));
      out.write("<strong class=\"pubtype-remover\" onclick=\"removePubtype(this)\">[remover]</strong></li>\n");
      out.write("                                    ");

                                            cont++;
                                        }
                                    
      out.write("\n");
      out.write("                            </ul>\n");
      out.write("                            ");

                                }
                            
      out.write("\n");
      out.write("                            <div class=\"separator separator2\"></div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        ");

                            }
                        
      out.write("\n");
      out.write("\n");
      out.write("                        <div class=\"btn-cadastrar-box\">\n");
      out.write("                            <input type=\"submit\" class=\"btn-cadastrar\" value=\"Cadastrar\">\n");
      out.write("                        </div>\n");
      out.write("                        <!-- <div class=\"btn-cadastrar\">\n");
      out.write("                            Cadastrar\n");
      out.write("                        </div> -->\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"voltar-box\">\n");
      out.write("                    <a href=\"Index.html\" class=\"voltar-link\">\n");
      out.write("                        Voltar para a página de pesquisa\n");
      out.write("                    </a>\n");
      out.write("                </div>\n");
      out.write("            </div> <!-- #main -->\n");
      out.write("        </div> <!-- #main-container -->\n");
      out.write("\n");
      out.write("        <div class=\"footer-container\">\n");
      out.write("            <footer class=\"wrapper\">\n");
      out.write("                <h3>© 2013 forArticle - Forward your research!</h3>\n");
      out.write("            </footer>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <script src=\"./js/jquery-1.9.1.min.js\"></script>\n");
      out.write("        <script>window.jQuery || document.write('<script src=\"js/vendor/jquery-1.9.1.min.js\"><\\/script>')</script>\n");
      out.write("        \n");
      out.write("        <script src=\"js/main.js\"></script>\n");
      out.write("        <script src=\"js/add-properties.js\"></script>\n");
      out.write("        <script src=\"js/search-author.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"js/autocomplete.js\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
