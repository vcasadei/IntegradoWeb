/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

import Bean.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Caah
 */
public class CadastrarUsuarioDAO {
    
    private Connection conn;
    
    public CadastrarUsuarioDAO() throws PubMedDAOException{
        
        this.conn = ConnectionPubMed.getConnection(new Usuario("labbd05", "bananassaoazuis"));
    }
    
    public void cadastrarComum(Usuario usuario) throws SQLException, PubMedDAOException{
        
        String SQL;
        PreparedStatement ps;
        
        SQL = "EXEC criarLoginComum '" + usuario.getLogin() + "', '" + usuario.getSenha() + "';";
        
        ps = conn.prepareCall(SQL);
        ps.execute();   
        
    }
    
    public void cadastrarAdim(Usuario usuario) throws SQLException, PubMedDAOException{
     
        String SQL;
        PreparedStatement ps;
        
        SQL = "EXEC criarLoginAdmin '" + usuario.getLogin() + "', '" + usuario.getSenha() + "';";
        
        ps = conn.prepareCall(SQL);
        ps.execute(); 
    }
}
