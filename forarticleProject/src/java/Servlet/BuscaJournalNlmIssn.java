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
        try {
            String nlmID = request.getParameter("nlm");
            Usuario user = new Usuario(/*request.getParameter("user"), request.getParameter("senha")*/"labbd05", "bananassaoazuis");
            Journal journal;
            BuscaDadosJournalDAO cadArtigo = new BuscaDadosJournalDAO(user);
            journal = cadArtigo.buscaJournalNlmID(nlmID);


            String dados = "<div class=\"separator separator1\">Informações sobre a Revista</div>"
                    + "<p class=\"side-fields\">"
                    + "<label class=\"label-s\" for=\"nlmuniqueid\">NLM (ID único): </label>"
                    + "<input class=\"text-inline nlm-edt\" type=\"text\" data-provide=\"typeahead\""
                    + " name=\"nlmuniqueid\" id=\"nlmuniqueid\" placeholder=\"Busque pelo ID\" value=\""
                    + journal.getNlmUniqueID() + "\" readonly/>"
                    + "<label class=\"label-s label-right\" for=\"issn\">ISSN: </label>"
                    + "<input class=\"text-right issn-edt\" data-provide=\"typeahead\" type=\"text\""
                    + " name=\"issn\" id=\"issn\" value=\"" + journal.getISSN() + "\" readonly />"
                    + "</p>"
                    + "<p class=\"line-field\">"
                    + "<label class=\"label-s\" for=\"journalTitle\">Título da Revista: </label>"
                    + "<input class=\"text-s journal\" type=\"text\" data-provide=\"typeahead\""
                    + " name=\"journalTitle\" id=\"journalTitle\" value=\"" + journal.getTitle() + "\"/>"
                    + "</p>"
                    + "<p class=\"side-fields\">"
                    + "<label class=\"label-s\" for=\"aberviation\">Abreviação: </label>"
                    + "<input class=\"text-inline abreviation-title-edt\" type=\"text\" name=\"abreviation\""
                    + " value=\"" + journal.getAbreviation() + "\"/>"
                    + "</p>"
                    + "<div class=\"btn-alterar-box\">"
                    + "<input type=\"submit\" class=\"btn-alterar\" value=\"Alterar\">"
                    + "</div>";

            response.setContentType("text/html;charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(dados);
            writer.close();


        } catch (PubMedDAOException e) {
            Logger.getLogger(BuscaJournalNlmIssn.class.getName()).log(Level.SEVERE, null, e);
            throw new ServletException(e.getMessage());
        } catch (SQLException e) {
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
        try {
            String issn = request.getParameter("issn");
            Usuario user = new Usuario(/*request.getParameter("user"), request.getParameter("senha")*/"labbd05", "bananassaoazuis");
            Journal journal;
            BuscaDadosJournalDAO cadArtigo = new BuscaDadosJournalDAO(user);
            journal = cadArtigo.buscaJournalIssn(issn);

            String dados = "<div class=\"separator separator1\">Informações sobre a Revista</div>"
                    + "<p class=\"side-fields\">"
                    + "<label class=\"label-s\" for=\"nlmuniqueid\">NLM (ID único): </label>"
                    + "<input class=\"text-inline nlm-edt\" type=\"text\" data-provide=\"typeahead\""
                    + " name=\"nlmuniqueid\" id=\"nlmuniqueid\" placeholder=\"Busque pelo ID\" value=\""
                    + journal.getNlmUniqueID() + "\" readonly/>"
                    + "<label class=\"label-s label-right\" for=\"issn\">ISSN: </label>"
                    + "<input class=\"text-right issn-edt\" data-provide=\"typeahead\" type=\"text\""
                    + " name=\"issn\" id=\"issn\" value=\"" + journal.getISSN() + "\" readonly />"
                    + "</p>"
                    + "<p class=\"line-field\">"
                    + "<label class=\"label-s\" for=\"journalTitle\">Título da Revista: </label>"
                    + "<input class=\"text-s journal\" type=\"text\" data-provide=\"typeahead\""
                    + " name=\"journalTitle\" id=\"journalTitle\" value=\"" + journal.getTitle() + "\"/>"
                    + "</p>"
                    + "<p class=\"side-fields\">"
                    + "<label class=\"label-s\" for=\"aberviation\">Abreviação: </label>"
                    + "<input class=\"text-inline abreviation-title-edt\" type=\"text\" name=\"abreviation\""
                    + " value=\"" + journal.getAbreviation() + "\"/>"
                    + "</p>"
                    + "<div class=\"btn-alterar-box\">"
                    + "<input type=\"submit\" class=\"btn-alterar\" value=\"Alterar\">"
                    + "</div>";

            response.setContentType("text/html;charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.print(dados);
            writer.close();


        } catch (PubMedDAOException e) {
            Logger.getLogger(BuscaJournalNlmIssn.class.getName()).log(Level.SEVERE, null, e);
            throw new ServletException(e.getMessage());
        } catch (SQLException e) {
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
