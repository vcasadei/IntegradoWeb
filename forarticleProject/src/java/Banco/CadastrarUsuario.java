/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

import Bean.Usuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Caah
 */
public class CadastrarUsuario {
    
    private Connection conn;
    
    public CadastrarUsuario(Usuario usuario) throws PubMedDAOException{
        this.conn = ConnectionPubMed.getConnection(usuario.getLogin(), usuario.getSenha());
    }
    
    public void cadastrarComum(String login, String senha) throws SQLException, PubMedDAOException{
        
    }
    
    public void cadastrarAdim(String login, String senha){
        
    }
}
