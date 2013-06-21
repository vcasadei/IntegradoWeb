/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Bean.Article;
import Bean.Usuario;
import Banco.BuscaArtigosDAO;
import Banco.PubMedDAOException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ian
 */
public class BuscaInicial extends HttpServlet {

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
            out.println("<title>Servlet PesquisarInicial</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PesquisarInicial at " + request.getContextPath() + "</h1>");
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
    /*Faz a busca simples*/
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try{
            //String radio = request.getParameter("opcao");
            String parametro = request.getParameter("pesquisar-edt");
            Usuario user = new Usuario("labbd05", "bananassaoazuis");
            BuscaArtigosDAO inicial = new BuscaArtigosDAO(user);
            List<Article> artigos;
            
            //if(radio.equals("titulo")){
                artigos = inicial.buscaArtigoTitulo(parametro);
            //}else{
            //    artigos = inicial.buscaArtigoKeyWord(parametro);
            //}
            
            request.setAttribute("articleBean", artigos);
            
            //RequestDispatcher rd;
            //rd = request.getRequestDispatcher("/resultados.jsp");
            //rd.forward(request, response);
            
            
        } catch (PubMedDAOException ex) {
            Logger.getLogger(BuscaInicial.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServletException(ex.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(BuscaInicial.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServletException(ex.getMessage());
        }
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
    /*Busca Avancada*/
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       try{
            String tituloJournal = request.getParameter("journal-title-edt");
            String issnJournal = request.getParameter("journal-issn-edt");
            String dataInicial = request.getParameter("data-inicial-edt");
            String dataFinal = request.getParameter("data-final-edt");
            
            Usuario user = new Usuario("labbd05", "bananassaoazuis");
            BuscaArtigosDAO inicial = new BuscaArtigosDAO(user);
           
            List<Article> artigos;
            artigos = inicial.buscaAvancadaArtigo(tituloJournal, issnJournal, dataInicial, dataFinal);
           
            request.setAttribute("articleBean", artigos);
            
            //RequestDispatcher rd;
            //rd = request.getRequestDispatcher("/resultados.jsp");
            //rd.forward(request, response);
            
            
        }catch(PubMedDAOException e){
            Logger.getLogger(BuscaInicial.class.getName()).log(Level.SEVERE, null, e);
            throw new ServletException(e.getMessage());
        }catch(SQLException e){
            Logger.getLogger(BuscaInicial.class.getName()).log(Level.SEVERE, null, e);
            throw new ServletException(e.getMessage());
        }
        
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
