package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Bean.Journal;

public final class alterarJournal_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        \n");
      out.write("        <link rel=\"stylesheet\" href=\"css/normalize.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/main.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/cadastro_artigo.css\">\n");
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
      out.write("                        <li><a href=\"index.html\">Início</a></li>\n");
      out.write("                        <li><a href=\"login.html\">Login</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </nav>\n");
      out.write("            </header>\n");
      out.write("        </div> \n");
      out.write("\n");
      out.write("        <div class=\"main-container\">\n");
      out.write("            ");

                                 Journal objJournalBean = (Journal)request.getAttribute("journalBean");
                                    if (true){
                                        
                                    
                                
      out.write("\n");
      out.write("            <div class=\"main wrapper clearfix\">\n");
      out.write("                <div class=\"cadastro-box\">\n");
      out.write("                    <h2>Alterar Revista</h2>\n");
      out.write("                    <form class=\"form-cadastro\" action=\"AlterarJournal\" method=\"POST\" name=\"form\">\n");
      out.write("                        <div class=\"separator separator2\">Informações sobre a Revista</div>\n");
      out.write("                        \n");
      out.write("                        <p class=\"side-fields\">\n");
      out.write("                            \n");
      out.write("                                \n");
      out.write("                            <label class=\"label-s\" for=\"nlmuniqueid\">NLM (ID único): </label>\n");
      out.write("                            <input class=\"text-inline nlm-edt\" type=\"text\" disabled name=\"nlmuniqueid\" value=\"");
      out.print( objJournalBean.getNlmUniqueID());
      out.write("\" />\n");
      out.write("                            \n");
      out.write("                            <label class=\"label-s label-right\" for=\"issn\">ISSN: </label>\n");
      out.write("                                <input class=\"text-right issn-edt\" disabled type=\"text\" name=\"issn\" value=\"");
      out.print( objJournalBean.getISSN());
      out.write("\" />\n");
      out.write("                            \n");
      out.write("                        </p>\n");
      out.write("                        <p class=\"line-field\">\n");
      out.write("                            <label class=\"label-s\" for=\"journalTitle\">Título da Revista: </label>\n");
      out.write("                                <input class=\"text-s journal\" type=\"text\" name=\"journalTitle\" value=\"");
      out.print( objJournalBean.getTitle() );
      out.write("\"/>\n");
      out.write("                        </p>\n");
      out.write("                        <p class=\"line-field\">\n");
      out.write("                            <label class=\"label-s\" for=\"abreviatioln\">Abreviação: </label>\n");
      out.write("                                <input class=\"text-s journal\" type=\"text\" name=\"abreviation\" value=\"");
      out.print( objJournalBean.getAbreviation());
      out.write("\"/>\n");
      out.write("                        </p>\n");
      out.write("                        \n");
      out.write("                        ");

                                    }
                                    
      out.write("\n");
      out.write("                        \n");
      out.write("                        \n");
      out.write("                        <div class=\"btn-cadastrar-box\">\n");
      out.write("                            <input type=\"submit\" class=\"btn-cadastrar\" value=\"Alterar\">\n");
      out.write("                        </div>\n");
      out.write("                    </form>\n");
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
      out.write("                <h3>© 2013 forArticle - Forward your research!</h3>\n");
      out.write("            </footer>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <script src=\"./js/jquery-1.9.1.min.js\"></script>\n");
      out.write("        <script>window.jQuery || document.write('<script src=\"js/vendor/jquery-1.9.1.min.js\"><\\/script>')</script>\n");
      out.write("\n");
      out.write("        <script src=\"js/main.js\"></script>\n");
      out.write("        <script src=\"js/add-properties.js\"></script>\n");
      out.write("        <script src=\"js/search-author.js\"></script>\n");
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
