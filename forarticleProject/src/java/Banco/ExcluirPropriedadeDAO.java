/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

import Bean.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Ian
 */
public class ExcluirPropriedadeDAO {
    private Connection conn;

    public ExcluirPropriedadeDAO(Usuario user) throws PubMedDAOException {
        this.conn = ConnectionPubMed.getConnection(user);
    }

    public void excluirMeshHeading() throws SQLException, PubMedDAOException {
        PreparedStatement ps;
        String SQL = "DELETE FROM meshHeading WHERE descriptionName NOT IN "
                + "(SELECT distinct(meshHeading) FROM ArticleMeshHeadingList";
        ps = conn.prepareStatement(SQL);
        ResultSet rs = ps.executeQuery();
        ConnectionPubMed.close(conn, ps, rs);
    }
    
    public void excluirChemical() throws SQLException, PubMedDAOException {
        PreparedStatement ps;
        String SQL = "DELETE FROM chemical WHERE chemicalName NOT IN "
                + "(SELECT distinct(chemicalName) FROM ArticleChemicalList)";
        ps = conn.prepareStatement(SQL);
        ResultSet rs = ps.executeQuery();
        ConnectionPubMed.close(conn, ps, rs);
    }
    
    public void excluirKeyword() throws SQLException, PubMedDAOException {
        PreparedStatement ps;
        String SQL = "DELETE FROM Keyword WHERE keyWordName NOT IN "
                + "(SELECT distinct(keyword) FROM ArticleKeywordList)";
        ps = conn.prepareStatement(SQL);
        ResultSet rs = ps.executeQuery();
        ConnectionPubMed.close(conn, ps, rs);
    }
    
    public void excluirPublication() throws SQLException, PubMedDAOException {
        PreparedStatement ps;
        String SQL = "DELETE FROM PublicationType WHERE typeName NOT IN "
                + "(SELECT distinct(PublicationTypeName) FROM ArticlePublicationType)";
        ps = conn.prepareStatement(SQL);
        ResultSet rs = ps.executeQuery();
        ConnectionPubMed.close(conn, ps, rs);
    }       
            
}