/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import ClassesBanco.Article;
import ClassesBanco.ConexaoBD;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Ian
 */
public class PesquisarArtigo extends HttpServlet {

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
            out.println("<title>Servlet PesquisarArtigo</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PesquisarArtigo at " + request.getContextPath() + "</h1>");
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

        JSONObject json = new JSONObject();
        JSONObject journal = new JSONObject();
        JSONArray chemicalList = new JSONArray();
        JSONArray meshList = new JSONArray();
        JSONArray pubtypeList = new JSONArray();
        JSONArray autorList = new JSONArray();
        JSONArray keywordList = new JSONArray();
            
        //recebe o articleID do artigo selecionado
        response.setContentType("text/html;charset=UTF-8");
        String articleID = request.getParameter("articleID");

        //realiza a busca completa do artigo
        Article artigo;
        ConexaoBD conexaoBD = new ConexaoBD();
        artigo = conexaoBD.pesquisarArtigo(articleID);
        
        //Inicializa a váriavel que conterá a página de retorno
        PrintWriter retorno = response.getWriter();
        
        try {
            journal.put("issn", artigo.getJournal().getISSN());
            journal.put("abbreviation", artigo.getJournal().getAbreviation());
            journal.put("nlmUniqueId", artigo.getJournal().getNlmUniqueID());
            journal.put("title", artigo.getJournal().getTitle());
        } catch (JSONException e) {
               System.err.println(e);
               retorno.print("erro");
         }
        
        for (int i = 0; i < artigo.getAutores().size(); i++) 
        {
            JSONObject autor = new JSONObject();
            try {
                autor.put("foreName", artigo.getAutores().get(i).getForeName());
                autor.put("lastName", artigo.getAutores().get(i).getLastName());
                autor.put("initials", artigo.getAutores().get(i).getInitials());
                autorList.put(autor);
            } catch (JSONException e) {
                System.err.println(e);
                retorno.print("erro");
            }
        }
        
        for (int i = 0; i < artigo.getMeshHeading().size(); i++) 
        {
            JSONObject mesh = new JSONObject();
            try {
                mesh.put("meshDescriptor", artigo.getMeshHeading().get(i).getDescriptionName());
                meshList.put(mesh);
            } catch (JSONException e) {
                System.err.println(e);
                retorno.print("erro");
            }
        }
        
        for (int i = 0; i < artigo.getChemical().size(); i++) 
        {
            JSONObject chemical = new JSONObject();
            try {
                chemical.put("chemicalName", artigo.getChemical().get(i).getChemicalName());
                chemicalList.put(chemical);
            } catch (JSONException e) {
                System.err.println(e);
                retorno.print("erro");
            }
        }
        
        for (int i = 0; i < artigo.getPublicationType().size(); i++) 
        {
            JSONObject pub = new JSONObject();
            try {
                pub.put("publicationType", artigo.getPublicationType().get(i).getTypeName());
                pubtypeList.put(pub);
            } catch (JSONException e) {
                System.err.println(e);
                retorno.print("erro");
            }
        }
        
        for (int i = 0; i < artigo.getKeyWord().size(); i++) 
        {
            JSONObject keyword = new JSONObject();
            try {
                keyword.put("keywordName", artigo.getKeyWord().get(i).getKeyWord());
                keywordList.put(keyword);
            } catch (JSONException e) {
                System.err.println(e);
                retorno.print("erro");
            }
        }
        try {
            json.put("title", artigo.getTitle());
            json.put("articleID", artigo.getArticleID());
            json.put("issue", artigo.getIssue());
            json.put("resumo", artigo.getResumo());
            if(artigo.getArticleDate() == null){
                json.put("pubDate", "");
            } else {
                json.put("pubDate", artigo.getArticleDate());
            }
            json.put("affiliation", artigo.getAffiliation());
            json.put("pagination", artigo.getPagination());
            json.put("publicationStatus", artigo.getPublicationStatus());
            json.put("username", artigo.getUsername());
            json.put("volume", artigo.getVolume());
            json.put("journal", journal);
            json.put("chemicalList", chemicalList);
            json.put("meshList", meshList);
            json.put("publicationTypeList", pubtypeList);
            json.put("keywordList", keywordList);
            json.put("authorList", autorList);
        } catch (JSONException e) {
            System.err.println(e);
            retorno.print("erro");
        }
        
        retorno.print(json);
        
        //finaliza o retorno
        retorno.close();
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
