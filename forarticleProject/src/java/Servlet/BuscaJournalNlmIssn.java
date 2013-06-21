/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Bean.Journal;
import Bean.Usuario;
import Banco.BuscaDadosJournalDAO;
import Banco.PubMedDAOException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ian
 */
public class BuscaJournalNlmIssn extends HttpServlet {

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
            out.println("<title>Servlet buscarJournal</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet buscarJournal at " + request.getContextPath() + "</h1>");
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
    /*Busca um journal pelo seu NlmUniqueID*/
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            String nlmID = request.getParameter("nlmuniqueid");
            Usuario user = new Usuario(/*request.getParameter("user"), request.getParameter("senha")*/"labbd05","bananassaoazuis");
            Journal journal;
            BuscaDadosJournalDAO cadArtigo = new BuscaDadosJournalDAO(user);
            journal = cadArtigo.buscaJournalNlmID(nlmID);
              
            request.setAttribute("journal", journal);
            
            //RequestDispatcher rd;
            //rd = request.getRequestDispatcher("/resultados.jsp");
            //rd.forward(request, response);
            
            
        }catch(PubMedDAOException e){
            Logger.getLogger(BuscaJournalNlmIssn.class.getName()).log(Level.SEVERE, null, e);
            throw new ServletException(e.getMessage());
        }catch(SQLException e){
            Logger.getLogger(BuscaJournalNlmIssn.class.getName()).log(Level.SEVERE, null, e);
            throw new ServletException(e.getMessage());
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
    /*Busca um journal pelo seu issn*/
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            String issn = request.getParameter("issn");
            Usuario user = new Usuario(/*request.getParameter("user"), request.getParameter("senha")*/"labbd05","bananassaoazuis");
            Journal journal;
            BuscaDadosJournalDAO cadArtigo = new BuscaDadosJournalDAO(user);
            journal = cadArtigo.buscaJournalIssn(issn);
              
            request.setAttribute("journal", journal);
            
            //RequestDispatcher rd;
            //rd = request.getRequestDispatcher("/resultados.jsp");
            //rd.forward(request, response);
            
            
        }catch(PubMedDAOException e){
            Logger.getLogger(BuscaJournalNlmIssn.class.getName()).log(Level.SEVERE, null, e);
            throw new ServletException(e.getMessage());
        }catch(SQLException e){
            Logger.getLogger(BuscaJournalNlmIssn.class.getName()).log(Level.SEVERE, null, e);
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
