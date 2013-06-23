package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!DOCTYPE html>\r\n");
      out.write("<!--[if lt IE 7]>      <html class=\"no-js lt-ie9 lt-ie8 lt-ie7\"> <![endif]-->\r\n");
      out.write("<!--[if IE 7]>         <html class=\"no-js lt-ie9 lt-ie8\"> <![endif]-->\r\n");
      out.write("<!--[if IE 8]>         <html class=\"no-js lt-ie9\"> <![endif]-->\r\n");
      out.write("<!--[if gt IE 8]><!--> <html class=\"no-js\"> <!--<![endif]-->\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"utf-8\">\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\">\r\n");
      out.write("        <title></title>\r\n");
      out.write("        <meta name=\"description\" content=\"\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width\">\r\n");
      out.write("\r\n");
      out.write("        <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>\r\n");
      out.write("        \r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/normalize.min.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/main.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/busca_form.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/menu.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/autocomplete.css\">\r\n");
      out.write("\r\n");
      out.write("        <script src=\"http://code.jquery.com/jquery-1.9.1.js\"></script>\r\n");
      out.write("        <script src=\"js/vendor/modernizr-2.6.2-respond-1.1.0.min.js\"></script>\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <!--[if lt IE 7]>\r\n");
      out.write("            <p class=\"chromeframe\">You are using an <strong>outdated</strong> browser. Please <a href=\"http://browsehappy.com/\">upgrade your browser</a> or <a href=\"http://www.google.com/chromeframe/?redirect=true\">activate Google Chrome Frame</a> to improve your experience.</p>\r\n");
      out.write("        <![endif]-->\r\n");
      out.write("\r\n");
      out.write("        <div class=\"header-container\">\r\n");
      out.write("            <header class=\"wrapper clearfix\">\r\n");
      out.write("                <a class=\"title\" href=\"index.jsp\"></a>\r\n");
      out.write("                <nav>\r\n");
      out.write("                    <ul>\r\n");
      out.write("                        <li><a class=\"menu-item\" href=\"index.jsp\">Início</a></li>\r\n");
      out.write("                        <li><a href=\"login.html\">Login</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </nav>\r\n");
      out.write("            </header>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"main-container\">\r\n");
      out.write("            <div class=\"main wrapper clearfix\">\r\n");
      out.write("                <div class=\"form-box\">\r\n");
      out.write("                    <h2 class=\"busca-lbl\">Busque por artigos:</h2>\r\n");
      out.write("                    <form method=\"POST\" action=\"BuscaInicial\" class=\"form-pesquisa\" id=\"pesquisa-s\">\r\n");
      out.write("                       <p id=\"radio\">\r\n");
      out.write("                           <input class=\"radios\" type=\"radio\" name=\"tipo\" value=\"titulo\" checked/>Título\r\n");
      out.write("                           <input class=\"radios\" type=\"radio\" name=\"tipo\" value=\"keyword\"/>Palavra-chave\r\n");
      out.write("                       </p>\r\n");
      out.write("                       <input type=\"text\" data-provide=\"typeahead\" name=\"search\" id=\"caixa-pesquisa\" class=\"search-edt\" autocomplete=\"off\" placeholder=\"Digite aqui parte do título de um artigo\"/>\r\n");
      out.write("                       <input type=\"hidden\" name=\"pagina\" value=\"1\"/>\r\n");
      out.write("                       <input type=\"hidden\" name=\"qtdePaginas\" value=\"0\"/>\r\n");
      out.write("                       <input type=\"text\" class=\"search-btn\" id=\"btn-pesquisa\"/>\r\n");
      out.write("                   </form>\r\n");
      out.write("                   <form method=\"POST\" action=\"BuscaInicial\" class=\"form-pesquisa\" id=\"pesquisa-a\">\r\n");
      out.write("                       <div id=\"form-pesquisa-avancada\">\r\n");
      out.write("                            <p class=\"form-separator\">Informações do Journal:</p>\r\n");
      out.write("                            <label for=\"journal-title-edt\">Titulo </label>\r\n");
      out.write("                            <input type=\"text\" name=\"journal-title-edt\" class=\"journal-title-edt noEnterSubmit\" placeholder=\"\"/>\r\n");
      out.write("                            <label for=\"journal-issn-edt\">ISSN </label>\r\n");
      out.write("                            <input type=\"text\" name=\"journal-issn-edt\" class=\"journal-issn-edt noEnterSubmit\" placeholder=\"XXXX-XXXX\"/>\r\n");
      out.write("                            <p class=\"form-separator\">Intervalo de Data:</p>\r\n");
      out.write("                            <label for=\"data-inicial-edt\">Inicial </label>\r\n");
      out.write("                            <input type=\"date\" name=\"data-inicial-edt\" class=\"data-edt data-inicial-edt noEnterSubmit\" />\r\n");
      out.write("                            <label for=\"data-final-edt\">Final </label>\r\n");
      out.write("                            <input type=\"date\" name=\"data-final-edt\" class=\"data-edt data-final-edt noEnterSubmit\"/>\r\n");
      out.write("                            <div class=\"btn-pesquisar-box\">\r\n");
      out.write("                                <input type=\"submit\" class=\"btn-pesquisar\" value=\"Pesquisar\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                       </div>\r\n");
      out.write("                    </form>\r\n");
      out.write("                   <div class=\"avancada-box\"><strong id=\"avancada\">Busca Avançada</strong></div>\r\n");
      out.write("                   <div class=\"avancada-box\"><strong id=\"simples\">Busca Simples</strong></div>\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- <div id=\"fix-keyword\"><br/><br/></div>  -->\r\n");
      out.write("            </div> <!-- #main -->\r\n");
      out.write("        </div> <!-- #main-container -->\r\n");
      out.write("\r\n");
      out.write("        <div class=\"footer-container\">\r\n");
      out.write("            <footer class=\"wrapper\">\r\n");
      out.write("                <h3>© 2013 forArticle - Forward your research!</h3>\r\n");
      out.write("            </footer>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <script src=\"./js/jquery-1.9.1.min.js\"></script>\r\n");
      out.write("        <script charset=\"utf-8\" src=\"./js/pesquisa-home.js\"></script>\r\n");
      out.write("        <script>window.jQuery || document.write('<script src=\"js/vendor/jquery-1.9.1.min.js\"><\\/script>')</script>\r\n");
      out.write("\r\n");
      out.write("        <script src=\"js/bootstrap.js\"></script>\r\n");
      out.write("        <script src=\"js/autocomplete.js\"></script>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
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
