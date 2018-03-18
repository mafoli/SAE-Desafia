/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Junior
 */
public class UsuarioDAO {   
    private String stmtGetBy = "select * from usuario where senha =? and login=?;";
       
    public Usuario verificaLogin(String login, String senha) throws ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        Usuario Usuario = new Usuario();
       Connection con = null;
        PreparedStatement stmt = null;
        
        ResultSet rs = null;
        try {
            con =(Connection) ConnectionFactory.getConnection();
            
            stmt = con.prepareStatement(stmtGetBy, Statement.RETURN_GENERATED_KEYS);
            
            stmt.setString(1, login);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Usuario.setId(rs.getInt("id"));
                Usuario.setSenha(rs.getString("senha"));
                Usuario.setLogin(rs.getString("login"));
                
                
            }
            
            return Usuario;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally{
            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());};
            try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexão. Ex="+ex.getMessage());};
        }  
    }
}
