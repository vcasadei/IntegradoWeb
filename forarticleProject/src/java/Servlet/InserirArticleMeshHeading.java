/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import ClassesBanco.ConexaoBD;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author andre
 */
public class InserirArticleMeshHeading extends HttpServlet {

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
            out.println("<title>Servlet InserirArticleMeshHeading</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InserirArticleMeshHeading at " + request.getContextPath() + "</h1>");
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
        String articleID = request.getParameter("articleID");
        String mesh = request.getParameter("mesh-name");

        
        //Inicializa a váriavel que conterá a página de retorno
        PrintWriter retorno = response.getWriter();
        
        ConexaoBD conexaoBD = new ConexaoBD();
        if(conexaoBD.inserirArticleMeshHeading(articleID, mesh)){
            retorno.print(this.constroiPaginaSucesso(articleID, mesh));
        }else{
            retorno.print(this.constroiPaginaErro(articleID, mesh));
        }

        //finaliza o retorno
        retorno.close();
    }
    
    //método auxiliar para a construção da página de associação com sucesso
    private String constroiPaginaSucesso(String articleID, String mesh) {
        String pagina;
        pagina = "<!DOCTYPE html>\n"
                + "<html>\n"
                + "  <head>\n"
                + "    <title>Mesh Associado</title>\n"
                + "    <meta charset=\"UTF-8\">\n"
                + "  </head>\n"
                + "  <body>\n"
                + "     <p>Mesh "+ mesh +" adicionado ao artigo " + articleID + " com sucesso</p>"
                + "  </body>\n"
                + "</html>\n";
        return pagina;
    }

    //método auxiliar para a construção de uma página de erro de associação
    private String constroiPaginaErro(String articleID, String mesh) {
        String pagina;
        pagina = "<!DOCTYPE html>\n"
                + "<html>\n"
                + "  <head>\n"
                + "    <title>Erro de Associação</title>\n"
                + "    <meta charset=\"UTF-8\">\n"
                + "  </head>\n"
                + "  <body>\n"
                + "     <p>O mesh "+mesh+" não pode ser associado ao artigo " + articleID +"\n"
                + "  </body>\n"
                + "</html>\n";
        return pagina;
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
