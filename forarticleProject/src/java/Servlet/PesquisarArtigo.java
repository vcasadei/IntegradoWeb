/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import ClassesBanco.Article;
import ClassesBanco.ConexaoBD;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ian
 */
public class PesquisarArtigo extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PesquisarArtigo</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PesquisarArtigo at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //recebe o articleID do artigo selecionado
        response.setContentType("text/html;charset=UTF-8");
        String articleID = request.getParameter("articleID");
        System.out.println(articleID);

        //realiza a busca completa do artigo
        Article artigo;
        ConexaoBD conexaoBD = new ConexaoBD();
        artigo = conexaoBD.pesquisarArtigo(articleID);

        //Inicializa a váriavel que conterá a página de retorno
        PrintWriter retorno = response.getWriter();

        //monta a págica sem resultados encontrados
        retorno.print(this.constroiPagina(artigo));

        //finaliza o retorno
        retorno.close();
    }

    private String constroiPagina(Article artigo) {
        String pagina;
        pagina = "<!DOCTYPE html>\n"
                + "<html dir=\"ltr\" lang=\"en-US\"><head><!-- Created by Artisteer v4.1.0.59861 -->\n"
                + "        <meta charset=\"utf-8\">\n"
                + "        <title>Artigo</title>\n"
                + "        <meta name=\"viewport\" content=\"initial-scale = 1.0, maximum-scale = 1.0, user-scalable = no, width = device-width\">\n"
                + "\n"
                + "        <!--[if lt IE 9]><script src=\"https://html5shiv.googlecode.com/svn/trunk/html5.js\"></script><![endif]-->\n"
                + "        <link rel=\"stylesheet\" href=\"style.css\" media=\"screen\">\n"
                + "        <!--[if lte IE 7]><link rel=\"stylesheet\" href=\"../style.ie7.css\" media=\"screen\" /><![endif]-->\n"
                + "        <link rel=\"stylesheet\" href=\"style.responsive.css\" media=\"all\">\n"
                + "\n"
                + "\n"
                + "        <script src=\"jquery.js\"></script>\n"
                + "        <script src=\"script.js\"></script>\n"
                + "        <script src=\"script.responsive.js\"></script>\n"
                + "\n"
                + "\n"
                + "        <style>.pubmed-content .pubmed-postcontent-0 .layout-item-0 { padding-right: 10px;padding-left: 10px;  }\n"
                + "            .ie7 .pubmed-post .pubmed-layout-cell {border:none !important; padding:0 !important; }\n"
                + "            .ie6 .pubmed-post .pubmed-layout-cell {border:none !important; padding:0 !important; }\n"
                + "\n"
                + "        </style></head>\n"
                + "    <body>\n"
                + "        <div id=\"pubmed-main\">\n"
                + "            <nav class=\"pubmed-nav\">\n"
                + "                <div class=\"pubmed-nav-inner\">\n"
                + "                    <ul class=\"pubmed-hmenu\"><li><a href=\"index.html\" class=\"\">Home</a></li><li><a href=\"login.html\" class=\"\">Login</a></li><li><a href=\"contato.html\" class=\"\">Contato</a></li></ul> \n"
                + "                </div>\n"
                + "            </nav>\n"
                + "            <header class=\"pubmed-header\">\n"
                + "\n"
                + "\n"
                + "                <div class=\"pubmed-shapes\">\n"
                + "\n"
                + "                </div>\n"
                + "                <h1 class=\"pubmed-headline\" data-left=\"1.93%\">\n"
                + "                    <a href=\"#\">PubMed</a>\n"
                + "                </h1>\n"
                + "\n"
                + "\n"
                + "\n"
                + "\n"
                + "\n"
                + "\n"
                + "            </header>\n"
                + "            <div class=\"pubmed-sheet clearfix\">\n"
                + "                <div class=\"pubmed-layout-wrapper\">\n"
                + "                    <div class=\"pubmed-content-layout\">\n"
                + "                        <div class=\"pubmed-content-layout-row\">\n"
                + "                            <div class=\"pubmed-layout-cell pubmed-content\"><article class=\"pubmed-post pubmed-article\">\n"
                + "                                    <div class=\"pubmed-postmetadataheader\">\n"
                + "                                        <h2 class=\"pubmed-postheader\">Informações do Artigo</h2>\n"
                + "                                    </div>\n"
                + "\n"
                + "                                    <div class=\"pubmed-postcontent pubmed-postcontent-0 clearfix\"><div class=\"pubmed-content-layout\">\n"
                + "                                            <div class=\"pubmed-content-layout-row\">\n"
                + "                                                <div class=\"pubmed-layout-cell layout-item-0\" style=\"width: 25%\" >\n"
                + "                                                    <p style=\"padding-left: 80px;\">Título do Artigo:    <label >" + artigo.getTitle() + "</label></p>\n"
                + "                                                    <p style=\"line-height: 200%; padding-left: 80px;\"><span style=\"font-family: Verdana;\">ID do Artigo:   <label >" + artigo.getArticleID() + "</label></span></p>\n"
                + "                                                    <p style=\"line-height: 200%; padding-left: 80px;\"><span style=\"font-family: Verdana;\">Data do Artigo:     <label> ";
        if (artigo.getArticleDate() != null) {
            pagina += artigo.getArticleDate();
        } else {
            pagina += "Não Informada";
        }
        pagina += " </label></span></p>\n"
                + "\n"
                + "                                                    <p style=\"line-height: 200%; padding-left: 80px;\"><span style=\"font-family: Verdana;\">Status da Publicação:     <label>";
        if (artigo.getPublicationStatus() != null) {
            pagina += artigo.getPublicationStatus();
        } else {
            pagina += "Não Informado";
        }
        pagina += "</label> </span></p>\n"
                + "                                                    <p style=\"line-height: 200%; padding-left: 80px;\"><span style=\"font-family: Verdana;\">Afiliação: <label>";
        if (artigo.getAffiliation() != null) {
            pagina += artigo.getAffiliation();
        } else {
            pagina += "Não Informado";
        }
        pagina += "</label></span></p>\n"
                + "\n"
                + "                                                    <p style=\"line-height: 200%; padding-left: 80px;\"><span style=\"font-family: Verdana;\">Tipos de Publicação:   <label>";
        if (artigo.getPublicationType().isEmpty()) {
            pagina += "Não Informado";
        } else {
            for (int i = 0; i < artigo.getPublicationType().size(); i++) {
                if (i != artigo.getPublicationType().size() - 1) {
                    pagina += artigo.getPublicationType().get(i).getTypeName() + "   -   ";
                } else {
                    pagina += artigo.getPublicationType().get(i).getTypeName();
                }
            }
        }
        pagina += "</label><br></span></p>\n"
                + "          <p style=\"line-height: 200%; padding-left: 80px;\"><span style=\"font-family: Verdana;\">Chemical(s):     <label>";
        if (artigo.getChemical().isEmpty()) {
            pagina += "Não Informado";
        } else {
            for (int i = 0; i < artigo.getChemical().size(); i++) {
                if (i != artigo.getChemical().size() - 1) {
                    pagina += artigo.getChemical().get(i).getChemicalName() + "   -   ";
                } else {
                    pagina += artigo.getChemical().get(i).getChemicalName();
                }
            }
        }
        pagina += "</label></span></p>\n"
                + "                                                    <p style=\"line-height: 200%; padding-left: 80px;\"><span style=\"font-family: Verdana;\">Keyword(s):      <label>";
        if (artigo.getKeyWord().isEmpty()) {
            pagina += "Não Informada";
        } else {
            for (int i = 0; i < artigo.getKeyWord().size(); i++) {
                if (i != artigo.getKeyWord().size() - 1) {
                    pagina += artigo.getKeyWord().get(i).getKeyWord() + "   -   ";
                } else {
                    pagina += artigo.getKeyWord().get(i).getKeyWord();
                }
            }
        }
        pagina += "</label></span></p>\n"
                + "          <p style=\"line-height: 200%; padding-left: 80px;\"><span style=\"font-family: Verdana;\">MeshTerm(s):      <label>";
        if (artigo.getMeshHeading().isEmpty()) {
            pagina += "Não Informado";
        } else {
            for (int i = 0; i < artigo.getMeshHeading().size(); i++) {
                if (i != artigo.getMeshHeading().size() - 1) {
                    pagina += artigo.getMeshHeading().get(i).getDescriptionName() + "   -   ";
                } else {
                    pagina += artigo.getMeshHeading().get(i).getDescriptionName();
                }
            }
        }
        pagina += "</label></span></p>\n"
                + "                                                    <p style=\"line-height: 200%; padding-left: 80px;\"><span style=\"font-family: Verdana;\">Autor(es):      <label>";
        if (artigo.getAutores().isEmpty()) {
            pagina += "Não Informado";
        } else {
            for (int i = 0; i < artigo.getAutores().size(); i++) {
                if (i != artigo.getAutores().size() - 1) {
                    pagina += artigo.getAutores().get(i).getLastName() + ", " + artigo.getAutores().get(i).getForeName() + " (" + artigo.getAutores().get(i).getInitials() + ")   -   ";
                } else {
                    pagina += artigo.getAutores().get(i).getLastName() + ", " + artigo.getAutores().get(i).getForeName() + " (" + artigo.getAutores().get(i).getInitials() + ")";
                }
            }
        }
        pagina += "</label></span></p>\n"
                + "                                                    <p style=\"line-height: 200%; padding-left: 80px;\"><span style=\"font-family: Verdana;\">Título do Journal:    <label>";
        if (artigo.getJournal().getTitle() != null) {
            pagina += artigo.getJournal().getTitle();
        } else {
            pagina += "Não informado";
        }
        pagina += "</label></span></p>\n"
                + "                                                    <p style=\"line-height: 200%; padding-left: 80px;\"><span style=\"font-family: Verdana;\">ISSN do Journal:      <label>";
        if (artigo.getJournal().getISSN() != null) {
            pagina += artigo.getJournal().getISSN();
        } else {
            pagina += "Não informado";
        }
        pagina += "</label></span></p>\n"
                + "                                                    <p style=\"line-height: 200%; padding-left: 80px;\"><span style=\"font-family: Verdana;\">Paginação:      <label>";
        if (artigo.getPagination() != null) {
            pagina += artigo.getPagination();
        } else {
            pagina += "Não informada";
        }
        pagina += "</label><br></span></p>\n"
                + "                                                    <p style=\"line-height: 200%; padding-left: 80px;\"><span style=\"font-family: Verdana;\">Volume:      <label>";
        if (artigo.getVolume() != null) {
            pagina += artigo.getVolume();
        } else {
            pagina += "Não informado";
        }
        pagina += "</label><br></span></p>\n"
                + "                                                    <p style=\"line-height: 200%; padding-left: 80px;\"><span style=\"font-family: Verdana;\">Issue:      <label>";
        if (artigo.getIssue() != null) {
            pagina += artigo.getIssue();
        } else {
            pagina += "Não informada";
        }
        pagina += "</label></span></p><br>\n"
                + "                                                </div>\n"
                + "                                                \n"
                + "                                            </div>\n"
                + "                                        </div>\n"
                + "                                        <div class=\"pubmed-content-layout\">\n"
                + "                                            <div class=\"pubmed-content-layout-row\">\n"
                + "                                                <div class=\"pubmed-layout-cell layout-item-0\" style=\"width: 33%\" >\n"
                + "                                                    \n"
                + "                                                </div>\n"
                + "                                                <div class=\"pubmed-layout-cell layout-item-0\" style=\"width: 23%\" >\n"
                + "                                                    \n"
                + "                                                    \n"
                + "                                                </div>\n"
                + "                                            </div>\n"
                + "                                        </div>\n"
                + "                                        <div class=\"pubmed-content-layout\">\n"
                + "                                            <div class=\"pubmed-content-layout-row\">\n"
                + "                                                <div class=\"pubmed-layout-cell layout-item-0\" style=\"width: 100%\" >\n"
                + "<p style=\"text-align:center;\"><table style=\"align:center;\"><tr><td><form style=\"text-align: center;\" method=\"post\" action=\"AlterarArtigo\"><a href=\"#\" target=\"_self\" title=\"Alterar Artigo!\" accesskey=\"Enter\" class=\"pubmed-button\" onclick=\"javascript:jQuery(this).parents('form').submit();\">Alterar</a>&nbsp;<a style=\"padding-left: 100px\"></a>"
                + "</form></td><td>"
                + "<form method=\"post\" action=\"ExcluirArtigo\" ><input id=\"articleID\" type=\"hidden\" name=\"articleID\" value=\"" + artigo.getArticleID() + "\" ><a href=\"#\" title=\"Excluir Artigo!\" onclick=\"javascript:jQuery(this).parents('form').submit();\" class=\"pubmed-button\" id=\"buttonExcluir\">Excluir</a>"
                + "</form></td></tr></table></p><br>     \n"
                + "                                                </div>\n"
                + "                                            </div>\n"
                + "                                        </div>\n"
                + "                                    </div>\n"
                + "\n"
                + "\n"
                + "                                </article></div>\n"
                + "                        </div>\n"
                + "                    </div>\n"
                + "                </div>\n"
                + "            </div>\n"
                + "            <footer class=\"pubmed-footer\">\n"
                + "                <div class=\"pubmed-footer-inner\">\n"
                + "                    <div class=\"pubmed-content-layout\">\n"
                + "                        <div class=\"pubmed-content-layout-row\">\n"
                + "                            <div class=\"pubmed-layout-cell layout-item-0\" style=\"width: 50%\">\n"
                + "                                <p style=\"float:left;\"><a href=\"#\"></a><a href=\"#\"><img width=\"32\" height=\"32\" alt=\"\" src=\"images/rss_32-2.png\"></a><img width=\"32\" height=\"32\" alt=\"\" src=\"images/facebook_32-2.png\" class=\"\"><a href=\"#\"></a><a href=\"#\"><img width=\"32\" height=\"32\" alt=\"\" src=\"images/twitter_32-2.png\" class=\"\"></a></p>\n"
                + "                            </div><div class=\"pubmed-layout-cell layout-item-0\" style=\"width: 50%\">\n"
                + "                                <p style=\"float: right; text-align: left;\">Copyright © 2011 All Rights Reserved</p>\n"
                + "                            </div>\n"
                + "                        </div>\n"
                + "                    </div>\n"
                + "\n"
                + "                </div>\n"
                + "            </footer>\n"
                + "\n"
                + "        </div>\n"
                + "\n"
                + "\n"
                + "    </body></html>";
        return pagina;
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
