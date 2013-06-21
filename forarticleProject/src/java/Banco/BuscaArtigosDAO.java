/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

import Bean.Article;
import Bean.Author;
import Bean.Journal;
import Bean.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Caah
 */
public class BuscaArtigosDAO {

    /*Atributo da conexão*/
    private Connection conn;

    public BuscaArtigosDAO(Usuario usuario) throws PubMedDAOException {
        /*Estabele conexão com o banco*/
        this.conn = ConnectionPubMed.getConnection(usuario.getLogin(), usuario.getSenha());
    }

    /*Faz a busca simples por título*/
    public List<Article> buscaArtigoTitulo(String titulo) throws SQLException, PubMedDAOException {

        List<Article> listaTitulos = new ArrayList<Article>();
        PreparedStatement ps;

        String SQL = "SELECT articleID, resumo, title FROM Article WHERE title LIKE '%" + titulo + "%'";

        ps = conn.prepareStatement(SQL);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Article art = new Article(rs.getString("articleID"), rs.getString("resumo"), rs.getString("title"));
            listaTitulos.add(art);
        }

        ConnectionPubMed.close(conn, ps, rs);
        return listaTitulos;
    }
    
    /*Busca os dados do artigo de acordo com uma keyword*/
    public List<Article> buscaArtigoKeyWord(String keyword) throws SQLException, PubMedDAOException{
        
        Statement ps;
        List<Article> retorno = new ArrayList();
       
        String SQL = "SELECT article.articleID, title, resumo FROM article, "
                + "articleKeywordList as ak WHERE article.articleID = ak.articleID"
                + "AND ak.keyword LIKE '" + keyword + "';";
        
        ps = conn.createStatement();
        ResultSet rs = ps.executeQuery(SQL);
        
        while (rs.next()) {
            Article artigo = new Article(rs.getString("articleID"), rs.getString("title"), rs.getString("resumo"));
            retorno.add(artigo);
        }
        
        ConnectionPubMed.close(conn, ps, rs);
        return retorno;
   }

    /*Chama a procedure que faz a busca avançada com os parâmetros necessários*/
    public List<Article> buscaAvancadaArtigo(String issn, String titulo, String dataFinal, String dataInicial)
            throws SQLException, PubMedDAOException {

        List<Article> listaTitulos = new ArrayList<Article>();
        Statement ps;

        String SQL = "exec buscaAvancada @tit = " + titulo + " @issn = " + issn + " @dataInic = " + dataInicial
                + " @dataFinal = " + dataFinal;

        ps = conn.createStatement();

        ResultSet rs = ps.executeQuery(SQL);

        while (rs.next()) {
            Article art = new Article(rs.getString("articleID"), rs.getString("resumo"), rs.getString("title"));
            listaTitulos.add(art);
        }

        ConnectionPubMed.close(conn, ps, rs);
        return listaTitulos;
    }
    
    /*Busca todos os dados pra um artigo*/
    public Article buscaDadosArtigo(String articleID, String titulo, String resumo) throws SQLException{
        
        Article dados = new Article();
        Statement ps = conn.createStatement();
        
        String SQL = "Select journal, pagination, volume, issue, articleDate, publicationStatus"
                + "afiliation, loginUser, journal.title, abreviation, issn from Article, Journal where articleID"
                + "like '" + articleID + "' and NlmUniqueID = journal";
        
        ResultSet rs = ps.executeQuery(SQL);
        
        /*Coloca os dados do artigo e do journal no objeto artigo*/
        if (rs.next()){
            dados.setArticleID(articleID);
            dados.setTitle(titulo);
            dados.setResumo(resumo);
            dados.setJournal(new Journal(rs.getString("issn"), rs.getString("journal.title"),
                    rs.getString("abrevition"), rs.getString("journal")));
            dados.setPagination(rs.getString("pagination"));
            dados.setVolume(rs.getString("volume"));
            dados.setIssue(rs.getString("issue"));
            dados.setArticleDate(rs.getString("articleDate"));
            dados.setPublicationStatus(rs.getString("publicationStatus"));
            dados.setAffiliation(rs.getString("afiliation"));
            dados.setUsername(rs.getString("loginUser"));
        }
        
        /*Pega os chemicals*/
        SQL = "Select chemicalName from ArticleChemicalList where articleID like '" + articleID + "'";
        rs = ps.executeQuery(SQL);
        while (rs.next()){
            dados.addChemical(rs.getString("chemicalName"));
        }
        
        /*Pega os Keywords*/
        SQL = "Select keyWord from ArticleKeywordList where articleID like '" + articleID + "'";
        rs = ps.executeQuery(SQL);
        while (rs.next()){
            dados.addKeyWord(rs.getString("keyWord"));
        }
        
        /*Pega os Mesh Terms*/
        SQL = "Select meshHeading from ArticleMeshHeadingList where articleID like '" + articleID + "'";
        rs = ps.executeQuery(SQL);
        while (rs.next()){
            dados.addMeshHeading(rs.getString("meshHeading"));
        }
        
        /*Pega os publications type*/
        SQL = "Select publicationTypeName from ArticlePublicationType where articleID like '" + articleID + "'";
        rs = ps.executeQuery(SQL);
        while (rs.next()){
            dados.addPublicationType(rs.getString("publicationTypeName"));
        }
        
        /*Pega os autores*/
        SQL = "Select foreName, lastName, initials from authorArticle where articleID like '"
                + articleID + "'";
        rs = ps.executeQuery(SQL);
        while (rs.next()){
            dados.addAuthor(new Author(rs.getString("foreName"), rs.getString("lastName"), rs.getString("initials")));
        }
        
        return dados;
    }
}