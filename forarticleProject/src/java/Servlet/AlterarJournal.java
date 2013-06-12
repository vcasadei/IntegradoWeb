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
public class AlterarJournal extends HttpServlet {

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
            out.println("<title>Servlet AlterarJournal2</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AlterarJournal2 at " + request.getContextPath() + "</h1>");
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
        
        //recebe o nlmUniqueID do journal selecionado
        String nlmUniqueID = request.getParameter("nlmUniqueID");
        
        //recebe o ISSN do journal selecionado
        String ISSN = request.getParameter("ISSN");
        
        //recebe o title do journal selecionado
        String title = request.getParameter("title");
        
        //recebe o abreviation do journal selecionado
        String abreviation = request.getParameter("abreviation");
        
        //Inicializa a váriavel que conterá a página de retorno
        PrintWriter retorno = response.getWriter();
        
        ConexaoBD conexaoBD = new ConexaoBD();
        if(conexaoBD.alterarJournal(ISSN, title, abreviation, nlmUniqueID)){
            retorno.print(this.constroiPaginaSucesso(nlmUniqueID));
        }else{
            retorno.print(this.constroiPaginaErro(nlmUniqueID));
        }

        //finaliza o retorno
        retorno.close();
    }
    
    //método auxiliar para a construção da página de inserção com sucesso
    private String constroiPaginaSucesso(String nlmUniqueID) {
        String pagina;
        pagina = "<!DOCTYPE html>\n"
                + "<html>\n"
                + "  <head>\n"
                + "    <title>Journal Alterado</title>\n"
                + "    <meta charset=\"UTF-8\">\n"
                + "  </head>\n"
                + "  <body>\n"
                + "     <p>Journal " + nlmUniqueID + " foi alterado com sucesso</p>"
                + "  </body>\n"
                + "</html>\n";
        return pagina;
    }

    //método auxiliar para a construção de uma página de erro de inserção
    private String constroiPaginaErro(String nlmUniqueID) {
        String pagina;
        pagina = "<!DOCTYPE html>\n"
                + "<html>\n"
                + "  <head>\n"
                + "    <title>Erro de Ateracao</title>\n"
                + "    <meta charset=\"UTF-8\">\n"
                + "  </head>\n"
                + "  <body>\n"
                + "     <p>O Journal " + nlmUniqueID + " não pode ser alterado</p>"
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
