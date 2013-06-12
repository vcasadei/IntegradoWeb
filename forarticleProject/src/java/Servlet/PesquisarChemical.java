/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import ClassesBanco.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ian
 */
public class PesquisarChemical extends HttpServlet {

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
            out.println("<title>Servlet PesquisarChemical</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PesquisarChemical at " + request.getContextPath() + "</h1>");
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
        //recebe o chemicalName buscado na operação de busca pelo Chemical
        String chemicalName = request.getParameter("chemicalName");
        
        //Lista de chemical encontrados
        ArrayList <Chemical> chemical;        
        ConexaoBD conexaoBD = new ConexaoBD();
        chemical = conexaoBD.pesquisarChemical(chemicalName);
              
        //Inicializa a váriavel que conterá a página de retorno
        PrintWriter retorno = response.getWriter();
        
        if(chemical.isEmpty()){
            //monta a págica sem resultados encontrados
            retorno.print(this.constroiPaginaSemResult());
        } else {
            //monta a página com os resultados encontrados
            retorno.print(this.constroiPaginaResultados(chemical));
        }
         
        //finaliza o retorno
        retorno.close();
    }

    //método auxiliar para a construção da página sem resultados encontrados
    private String constroiPaginaSemResult() {
        String pagina;
        pagina = "<!DOCTYPE html>\n"
                + "<html>\n"
                + "  <head>\n"
                + "    <title>Resultados não encontrados</title>\n"
                + "    <meta charset=\"UTF-8\">\n"
                + "  </head>\n"
                + "  <body>\n"
                + "     <p>Nenhum resultado foi encontrado</p>"
                + "  </body>\n"
                + "</html>\n";
        return pagina;
    }

    //método auxiliar para a pagina de exibição dos resultados encontrados
    private String constroiPaginaResultados(ArrayList<Chemical> chemical){
        String pagina;
        pagina = "<!DOCTYPE html>\n"
                + "<html>\n"
                + "  <head>\n"
                + "    <title>Resultados Encontrados</title>\n"
                + "    <meta charset=\"UTF-8\">\n"
                + "  </head>\n"
                + "  <body>\n"
                + "     <p>Foram encontrados : " + chemical.size() + " resultados</p>"
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
