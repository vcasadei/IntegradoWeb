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
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            String conexao = "jdbc:sqlserver://localhost;DatabaseName=LABBD;integratedSecurity=true;";
////            String usuario = "Admin", senha= "admin";
//            Connection conn = DriverManager.getConnection(conexao);
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = "jdbc:sqlserver://localhost;DatabaseName=LABBD;integratedSecurity=true;";
            Connection conn = DriverManager.getConnection(connectionUrl);
//            stmt = con.createStatement();
            
            System.out.println("ok");
//            String SQL = "CREATE LOGIN Teste WITH PASSWORD = 'teste'";;
//            
//            PreparedStatement ps = conn.prepareCall(SQL);
//            ps.execute();
            
        } catch (Exception e) {
            throw new PubMedDAOException(e.getMessage());
        }
    }
}
