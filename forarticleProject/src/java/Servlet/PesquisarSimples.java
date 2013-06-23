/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Banco.BuscaArtigosDAO;
import Banco.PubMedDAOException;
import Bean.ArticleResult;
import Bean.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import org.json.*;

//Pacotes das classes e conexão do banco
import ClassesBanco.*;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author Ian
 */
public class PesquisarSimples extends HttpServlet {

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
            out.println("<title>Servlet PesquisaSimples</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PesquisaSimples at " + request.getContextPath() + "</h1>");
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
//        try {
//            Usuario user = new Usuario(/*request.getParameter("user"), request.getParameter("senha")*/"labbd05","bananassaoazuis");
//            //recebe o valor buscado na operação de busca simples
//            String valorBusca = request.getParameter("search");
//            
//            //Lista de artigos encontrados
//            List <ArticleResult> artigos;        
//            BuscaArtigosDAO arDAO = new BuscaArtigosDAO(user);
//            artigos = arDAO.buscaArtigoTitulo(valorBusca);
//            
//            //Inicializa a váriavel que conterá a página de retorno
//            PrintWriter retorno = response.getWriter();
//            
//            request.setAttribute("listaArtigos", artigos);
//            RequestDispatcher rd = null;
//            rd = request.getRequestDispatcher("/resultados.jsp");
//            rd.forward(request, response);
//            
//        } catch (PubMedDAOException ex) {
//            Logger.getLogger(PesquisarSimples.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(PesquisarSimples.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
