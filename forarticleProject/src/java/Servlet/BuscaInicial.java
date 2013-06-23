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
        
        try {
            Usuario user = new Usuario(/*request.getParameter("user"), request.getParameter("senha")*/"","");
            
            //recebe o valor buscado na operação de busca avançada
            String titJournal = request.getParameter("journal-title-edt");
            String issnJournal = request.getParameter("journal-issn-edt");
            String dataIni = request.getParameter("data-inicial-edt");
            String dataFim = request.getParameter("data-final-edt");
            String pagina = request.getParameter("pagina");       
            String tipo = request.getParameter("tipo");
            int qtde_paginas = Integer.parseInt(request.getParameter("qtdePaginas"));
            
            int n_pagina = Integer.parseInt(pagina);
            
            
            //Lista de artigos encontrados
            List <Article> artigos;        
            BuscaArtigosDAO arDAO = new BuscaArtigosDAO(user);
            
            artigos = arDAO.buscaAvancadaArtigo(issnJournal, titJournal, dataFim, dataIni, n_pagina);
            
            if(qtde_paginas == 0){
                BuscaArtigosDAO numarDAO = new BuscaArtigosDAO(user);
                //qtde_paginas = numarDAO.buscaQuantidadeDeArtigos(valorBusca);
                if (qtde_paginas % 10 == 0){
                    qtde_paginas = qtde_paginas / 10;
                } else {
                    qtde_paginas = (qtde_paginas / 10) + 1;
                }
            }
                
            //Inicializa a váriavel que conterá a página de retorno
            PrintWriter retorno = response.getWriter();
            
            request.setAttribute("listaArtigos", artigos);
            request.setAttribute("paginaAtual", n_pagina);
            //request.setAttribute("search", valorBusca);            
            request.setAttribute("tipo", tipo);
            request.setAttribute("qtdePaginas", qtde_paginas);

            RequestDispatcher rd = null;
            rd = request.getRequestDispatcher("/resultados.jsp");
            rd.forward(request, response);
            
        } catch (PubMedDAOException ex) {
            Logger.getLogger(BuscaInicial.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BuscaInicial.class.getName()).log(Level.SEVERE, null, ex);
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
        
        try {
            Usuario user = new Usuario(/*request.getParameter("user"), request.getParameter("senha")*/"","");
            //recebe o valor buscado na operação de busca simples
            String valorBusca = request.getParameter("search");
            String pagina = request.getParameter("pagina");            
            String tipo = request.getParameter("tipo");
            int qtde_paginas = Integer.parseInt(request.getParameter("qtdePaginas"));
            
            int n_pagina = Integer.parseInt(pagina);
            
            
            //Lista de artigos encontrados
            List <Article> artigos;        
            BuscaArtigosDAO arDAO = new BuscaArtigosDAO(user);
            
            artigos = arDAO.buscaArtigoTitulo(valorBusca, n_pagina);
            
            if(qtde_paginas == 0){
                BuscaArtigosDAO numarDAO = new BuscaArtigosDAO(user);
                qtde_paginas = numarDAO.buscaQuantidadeDeArtigos(valorBusca);
                if (qtde_paginas % 10 == 0){
                    qtde_paginas = qtde_paginas / 10;
                } else {
                    qtde_paginas = (qtde_paginas / 10) + 1;
                }
            }
                
            //Inicializa a váriavel que conterá a página de retorno
            PrintWriter retorno = response.getWriter();
            
            request.setAttribute("listaArtigos", artigos);
            request.setAttribute("paginaAtual", n_pagina);
            request.setAttribute("search", valorBusca);            
            request.setAttribute("tipo", tipo);
            request.setAttribute("qtdePaginas", qtde_paginas);

            RequestDispatcher rd = null;
            rd = request.getRequestDispatcher("/resultados.jsp");
            rd.forward(request, response);
            
        } catch (PubMedDAOException ex) {
            Logger.getLogger(BuscaInicial.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BuscaInicial.class.getName()).log(Level.SEVERE, null, ex);
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
