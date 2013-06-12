/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

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
import java.util.logging.Level;
import java.util.logging.Logger;

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
            throws ServletException, IOException{
        
        //recebe o valor buscado na operação de busca simples
        String valorBusca = request.getParameter("search");
        
        //Lista de artigos encontrados
        ArrayList <Article> artigos;        
        ConexaoBD conexaoBD = new ConexaoBD();
        artigos = conexaoBD.pesquisarSimples(valorBusca);
        
        //Inicializa a váriavel que conterá a página de retorno
        PrintWriter retorno = response.getWriter();
        
        if(artigos.isEmpty()){
            //monta a págica sem resultados encontrados
            JSONObject json1 = new JSONObject();
            JSONObject json2 = new JSONObject();
            try {
                json2.put("erro","Nenhum resultado encontrado");
                json1.put("article",json2);
                retorno.print(json1);
            } catch (JSONException ex) {
                System.err.println(ex);
            }
        } else {
            //monta a página com os resultados encontrados
            JSONObject json = new JSONObject();
            JSONArray articleList = new JSONArray();
            
            for (int i = 0; i < artigos.size(); i++) {
                try {
                    JSONObject article = new JSONObject();
                    article.put("titulo",artigos.get(i).getTitle());
                    article.put("resumo",artigos.get(i).getResumo());
                    article.put("id",artigos.get(i).getArticleID());
                    articleList.put(article);
                } catch (JSONException e){
                    System.err.println(e);
                    retorno.print("erro");
                }
//                json += "{ \"titulo\":\""
//                        +artigos.get(i).getTitle().replace(match1, repla1).replace(match2, repla2)+"\", \"resumo\":\""
//                        +artigos.get(i).getResumo().replace(match1, repla1).replace(match2, repla2)+"\", \"id\":\"";
//                        if (i == artigos.size()-1)
//                            json += artigos.get(i).getArticleID()+ "\"}\n"; //se for o ultimo n adiciona virgula
//                        else
//                            json += artigos.get(i).getArticleID()+ "\"},\n";
            }
            try {
                json.put("article", articleList);
            } catch (JSONException ex) {
                System.err.println(ex);
            }
            
            retorno.print(json);
        }
         
        //finaliza o retorno
        retorno.close();
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
