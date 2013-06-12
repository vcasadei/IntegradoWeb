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
 * @author Ian
 */
public class InserirAuthor extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
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
            out.println("<title>Servlet InserirAuthor</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InserirAuthor at " + request.getContextPath() + "</h1>");
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
        //recebe o foreName do autor selecionado
        String foreName = request.getParameter("foreName");
        
        //recebe o lastName do autor selecionado
        String lastName = request.getParameter("lastName");
        
        //recebe as iniciais do autor selecionado
        String initials = request.getParameter("initials");
        
        //Inicializa a váriavel que conterá a página de retorno
        PrintWriter retorno = response.getWriter();
        
        ConexaoBD conexaoBD = new ConexaoBD();
        if(conexaoBD.inserirAuthor(foreName,lastName,initials)){
            retorno.print(this.constroiPaginaSucesso(foreName,lastName));
        }else{
            retorno.print(this.constroiPaginaErro(foreName,lastName));
        }

        //finaliza o retorno
        retorno.close();
    }
    
    //método auxiliar para a construção da página de inserção com sucesso
    private String constroiPaginaSucesso(String foreName, String lastName) {
        String pagina;
        pagina = "<!DOCTYPE html>\n"
                + "<html>\n"
                + "  <head>\n"
                + "    <title>Autor Inserido</title>\n"
                + "    <meta charset=\"UTF-8\">\n"
                + "  </head>\n"
                + "  <body>\n"
                + "     <p>Autor " + foreName + lastName + " foi inserido com sucesso</p>"
                + "  </body>\n"
                + "</html>\n";
        return pagina;
    }

    //método auxiliar para a construção de uma página de erro de inserção
    private String constroiPaginaErro(String foreName, String lastName) {
        String pagina;
        pagina = "<!DOCTYPE html>\n"
                + "<html>\n"
                + "  <head>\n"
                + "    <title>Erro de Inserção</title>\n"
                + "    <meta charset=\"UTF-8\">\n"
                + "  </head>\n"
                + "  <body>\n"
                + "     <p>O Autor " + foreName + lastName + " não pode ser inserido</p>"
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
