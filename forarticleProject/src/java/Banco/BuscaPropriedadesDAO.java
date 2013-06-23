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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Caah
 */
public class BuscaPropriedadesDAO {

    private String propriedade;
    private Connection conn;
    
    
    public BuscaPropriedadesDAO(Usuario usuario, String propriedade) throws PubMedDAOException{
        this.conn = ConnectionPubMed.getConnection(usuario);
        this.propriedade = propriedade;
    }
    
    /*Busca uma propriedade através de busca relativa (precisa ver como pegar só 5 pra poder mostrar)*/
    public List<String> buscaAtributosAutoComplete(String valor) throws SQLException, PubMedDAOException{
        
        List<String> parametros = new ArrayList<String>();
        PreparedStatement ps;
        String SQL = "";
        
        /*Verifica qual a propriedade a ser buscada e monta a busca*/
        if (propriedade.equals("keyWord")){
            SQL = "Select distinct top(5) keyWordName from KeyWord where keyWordName like '%" + valor + "%'";
        } else if (propriedade.equals("chemical")){
            SQL = "SELECT distinct top(5) chemicalName from Chemical where chemicalName like '%" + valor + "%'";
        } else if (propriedade.equals("mesh")){
            SQL = "SELECT distinct top(5) descriptionName from MeshHeading where descriptionName like '%" + valor + "%'";
        } else if (propriedade.equals("publicationType")){
            SQL = "SELECT distinct top(5) typeName from PublicationType where typeName like '%" + valor + "%'";
        } else if (propriedade.equals("authorForeName")){
            SQL = "SELECT distinct top(5) foreName from Author where ForeName like '%" + valor + "%'";
        } else if (propriedade.equals("authorLastName")){
            SQL = "SELECT distinct top(5) LastName from Author where LastName like '%" + valor + "%'";
        } else if (propriedade.equals("authorInitials")){
            SQL = "SELECT distinct top(5) Initials from Author where Initials like '%" + valor + "%'";
        } else if (propriedade.equals("tituloJournal")){
            SQL = "SELECT top(5) title from Journal where title like '%" + valor + "%'";
        } else if (propriedade.equals("issnJournal")){
            SQL = "SELECT distinct top(5) issn from Journal where issn like '" + valor + "%'";
        } else if (propriedade.equals("nlmJournal")){
            SQL = "SELECT distinct top(5) nlmUniqueID from Journal where nlmUniqueID like '" + valor + "%'";
        }
        
        ps = conn.prepareStatement(SQL);
        
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()){
            parametros.add(rs.getString(1));
        }
        
        ConnectionPubMed.close(conn, ps, rs);
        return parametros;
    }
}