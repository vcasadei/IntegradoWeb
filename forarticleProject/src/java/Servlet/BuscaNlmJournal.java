/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Bean.Usuario;
import Banco.BuscaPropriedadesDAO;
import Banco.PubMedDAOException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Caah
 */
public class BuscaNlmJournal extends HttpServlet {

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
            out.println("<title>Servlet BuscaNlmJournal</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BuscaNlmJournal at " + request.getContextPath() + "</h1>");
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

        try {
            List<String> listaNlmUniqueID;
            String nlmUniqueID;
            int cont = 0;
            BuscaPropriedadesDAO busca = new BuscaPropriedadesDAO(new Usuario("labbd05", "bananassaoazuis"), "nlmJournal");

            nlmUniqueID = request.getParameter("nlm");
            listaNlmUniqueID = busca.buscaAtributosAutoComplete(nlmUniqueID);

            /*Campos HTML*/
            nlmUniqueID = "[";
            for (String nlm : listaNlmUniqueID) {
                nlmUniqueID += "\"" + nlm + "\"";
                if (cont != 0) {
                    nlmUniqueID += ", ";
                }
                cont++;
            }
            nlmUniqueID += "]";

            PrintWriter write = response.getWriter();
            write.print(nlmUniqueID);
            write.close();

        } catch (PubMedDAOException ex) {
            Logger.getLogger(BuscaNlmJournal.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServletException(ex.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(BuscaNlmJournal.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServletException(ex.getMessage());
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
