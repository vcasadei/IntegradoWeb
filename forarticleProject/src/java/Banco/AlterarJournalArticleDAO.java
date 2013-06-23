/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

import Bean.Article;
import Bean.Journal;
import Bean.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.el.util.ConcurrentCache;

/**
 *
 * @author Caah
 */
public class AlterarJournalArticleDAO {
    
    private Connection conn;
    
    public AlterarJournalArticleDAO(Usuario user) throws PubMedDAOException{
        this.conn = ConnectionPubMed.getConnection(user);
    }
    
    public void alterarJournal(Journal journal) throws SQLException, PubMedDAOException{
        
        Statement ps;
        String SQL;
        
        SQL = "UPDATE Journal set title = '" + journal.getTitle() + "', abreviation = '" + journal.getAbreviation()
                + "' WHERE NlmUniqueID like '" + journal.getNlmUniqueID() + "';";
        
        ps = conn.createStatement();
        
        ps.execute(SQL);
        
        ConnectionPubMed.close(conn, ps, null);
    }
    
    public void alterarArticle(Article article){
        
    }
    
}
