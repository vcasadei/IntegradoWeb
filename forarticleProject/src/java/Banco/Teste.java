/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author Caah
 */
public class Teste {
 
    public static void main(String args[]) throws PubMedDAOException{
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            String conexao = "jdbc:sqlserver://localhost;databaseName=Proje;";
            String usuario = "labbd05", senha= "bananassaoazuis";
            Connection conn = DriverManager.getConnection(conexao);
            
            String SQL = "CREATE LOGIN Teste WITH PASSWORD = 'teste'";
            
            PreparedStatement ps = conn.prepareCall(SQL);
            ps.execute();
            
        } catch (Exception e) {
            throw new PubMedDAOException(e.getMessage());
        }
    }
}
