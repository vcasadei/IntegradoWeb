package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class viewArticle_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

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
      out.write("        <link rel=\"stylesheet\" href=\"css/article-view.css\">\n");
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
      out.write("                        ");
 
                            Usuario objUsuarioBean = (Usuario)request.getAttribute("usuarioBean");
                            if (objUsuarioBean!=null){
                                if(objUsuarioBean.getUsuario().equals("adm")){ //Menu Admin
                          
      out.write("\n");
      out.write("                        <li><a href=\"#.jsp\" class=\"active\">AutorizaÃ§Ã£o de usuÃ¡rio</a></li>\n");
      out.write("                        <li><a href=\"#.jsp\">Cadastro de Rotas</a></li>\n");
      out.write("                        ");

                             } else {
                                    if(objUsuarioBean.getUsuario().equals("user")){ //Menu User
                                        
      out.write("\n");
      out.write("                        <li><a href=\"#.jsp\" class=\"active\">AutorizaÃ§Ã£o de usuÃ¡rio</a></li>\n");
      out.write("                        <li><a href=\"#.jsp\">Cadastro de Rotas</a></li>\n");
      out.write("                        ");

                                    } else { //Menu Visitante
                                      
      out.write("\n");
      out.write("                        <li><a href=\"index.html\">InÃ­cio</a></li>\n");
      out.write("                        <li><a href=\"login.html\">Login</a></li>\n");
      out.write("                        ");
  
                                    }
                                    
                                    
                                }
                            }
                        
      out.write("\n");
      out.write("                    </ul>\n");
      out.write("                </nav>\n");
      out.write("            </header>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"main-container\">\n");
      out.write("            <div class=\"main wrapper clearfix\">\n");
      out.write("                <div id=\"article-container\">\n");
      out.write("                    ");

                            Article objArticleBean = (Article)request.getAttribute("artigo");
                            if (objArticleBean){
                            
      out.write("\n");
      out.write("                    <div id=\"title-box\">\n");
      out.write("                        \n");
      out.write("                        <h2 id=\"title\">");
      out.print( objArticleBean.getArticleTitle() );
      out.write("</h2>\n");
      out.write("                        \n");
      out.write("                        <p id=\"journal\">\n");
      out.write("                            <b>Revista: </b>");
      out.print( objArticleBean.getPublicationTitle() );
      out.write("\n");
      out.write("                            \n");
      out.write("                            (Abreviação: ");
      out.print( objArticleBean.getAbreviation() );
      out.write(").\n");
      out.write("                            ISSN: ");
      out.print( objArticleBean.getISSN() );
      out.write(". \n");
      out.write("                            Vol ");
      out.print( objArticleBean.getVolume() );
      out.write(". \n");
      out.write("                            Páginas: ");
      out.print( objArticleBean.getPagination() );
      out.write(". \n");
      out.write("                            Issue: ");
      out.print( objArticleBean.getIssue() );
      out.write(" \n");
      out.write("                            Afiliação: ");
      out.print( objArticleBean.getAffiliation() );
      out.write("</p>\n");
      out.write("                    </div>\n");
      out.write("                    <div id=\"author-box\">\n");
      out.write("                        Autores: \n");
      out.write("                        ");

                                while(objArticleBean.getAuthor() != 0){
                                    
      out.write("\n");
      out.write("                                    <h6>");
      out.print( objArticleBean.getAuthor() );
      out.write("</h6><h5>, </h5>\n");
      out.write("                                    ");

                                }
                                
      out.write("\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <div id=\"abstract-box\">\n");
      out.write("                        <h3 class=\"label\">Resumo:</h3>\n");
      out.write("                        <p id=\"abstract\">");
      out.print( objArticleBean.getAbstract() );
      out.write("</p>\n");
      out.write("                    </div>\n");
      out.write("                    <div id=\"mesh-box\">\n");
      out.write("                        <h3 class=\"label\">Termos Mesh: </h3>\n");
      out.write("                        \n");
      out.write("                        ");

                                while(objArticleBean.getMesh() != 0){
                                    
      out.write("\n");
      out.write("                                    <h6 class=\"property-name\">");
      out.print( objArticleBean.getMesh() );
      out.write("</h6><h5>, </h5>\n");
      out.write("                                    ");

                                }
                                
      out.write("\n");
      out.write("                        \n");
      out.write("                        \n");
      out.write("                    </div>\n");
      out.write("                    <div id=\"keyword-box\">\n");
      out.write("                        <h3 class=\"label\">Palavras-chave: </h3>\n");
      out.write("                        ");

                                while(objArticleBean.getKeyword() != 0){
                                    
      out.write("\n");
      out.write("                                    <h6 class=\"property-name\">");
      out.print( objArticleBean.getKeyword() );
      out.write("</h6><h5>, </h5>\n");
      out.write("                                    ");

                                }
                                
      out.write("\n");
      out.write("                        \n");
      out.write("                    </div>\n");
      out.write("                    <div id=\"chemical-box\">\n");
      out.write("                        <h3 class=\"label\">Substâncias químicas: </h3>\n");
      out.write("                        ");

                                while(objArticleBean.getChemical() != 0){
                                    
      out.write("\n");
      out.write("                                    <h6 class=\"property-name\">");
      out.print( objArticleBean.getChemical() );
      out.write("</h6><h5>, </h5>\n");
      out.write("                                    ");

                                }
                                
      out.write("\n");
      out.write("                        \n");
      out.write("                    </div>\n");
      out.write("                    <div id=\"publication-box\">\n");
      out.write("                        <h3 class=\"label\">Tipos de publicação: </h3>\n");
      out.write("                        ");

                                while(objArticleBean.getPublicationType() != 0){
                                    
      out.write("\n");
      out.write("                                    <h6 class=\"property-name\">");
      out.print( objArticleBean.getPublicationType() );
      out.write("</h6><h5>, </h5>\n");
      out.write("                                    ");

                                }
                                
      out.write("\n");
      out.write("                        \n");
      out.write("                    </div>\n");
      out.write("                            ");

                            } else {
                                
      out.write("\n");
      out.write("                                <h2>Não foi possível recuperar o Artigo</h1>\n");
      out.write("                                ");

                            }
                                
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <div class=\"voltar-box\">\n");
      out.write("                    <a href=\"index.html\" class=\"voltar-link\">\n");
      out.write("                        Voltar para a página de pesquisa\n");
      out.write("                    </a>\n");
      out.write("                </div>\n");
      out.write("            </div> <!-- #main -->\n");
      out.write("        </div> <!-- #main-container -->\n");
      out.write("\n");
      out.write("        <div class=\"footer-container\">\n");
      out.write("            <footer class=\"wrapper\">\n");
      out.write("                <h3>Â© 2013 forArticle - Forward your research!</h3>\n");
      out.write("            </footer>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <script src=\"./js/jquery-1.9.1.min.js\"></script>\n");
      out.write("        <script src=\"./js/article-view.js\"></script>\n");
      out.write("        <script>window.jQuery || document.write('<script src=\"js/vendor/jquery-1.9.1.min.js\"><\\/script>')</script>\n");
      out.write("\n");
      out.write("        <script src=\"js/main.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
