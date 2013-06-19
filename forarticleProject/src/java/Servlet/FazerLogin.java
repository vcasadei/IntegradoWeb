/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Bean.Usuario;
import banco.BuscaPropriedadesDAO;
import banco.ConnectionPubMed;
import banco.PubMedDAOException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Caah
 */
public class FazerLogin extends HttpServlet {

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
            out.println("<title>Servlet FazerLogin</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FazerLogin at " + request.getContextPath() + "</h1>");
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
        
        try{         
            Connection conn;
            conn = ConnectionPubMed.getConnection(request.getParameter("username-edt"), request.getParameter("password-edt"));
            
            /*Presida, você tem que fazer o bang dos cookies aqui, antes de fechar a conexão*/
            String name = request.getParameter("username-edt");
            String password = request.getParameter("password-edt");
            HttpSession session = request.getSession();
            session.setAttribute( "username", name );
            session.setAttribute( "password", password );
            
            /*
             * Para recuperar no JSP, basta fazer
             * <%= session.getAttribute( "username" ) %>
             * <%= session.getAttribute( "password" ) %>
             * No JSP não precisa declarar o Session
             * 
             * No Servlet, basta fazer
             * HttpSession session = request.getSession();
             * String name = session.getAttribute( "username" );
             * String password = session.getAttribute( "password" );
             */
            
            /*
             * Se não estiver conectado, os valores retornados pelo getAttribute é NULL
             */

            ConnectionPubMed.close(conn, null, null);
            
        } catch (PubMedDAOException ex) {
            Logger.getLogger(FazerLogin.class.getName()).log(Level.SEVERE, null, ex);
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
