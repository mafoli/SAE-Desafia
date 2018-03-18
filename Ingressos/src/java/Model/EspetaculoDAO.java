/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Matheus
 */
public class EspetaculoDAO {
    private String stmtInsert = "insert into espetaculo(nome,data,direcao,local,poltrona) values(?,?,?,?,?);";
    private String stmtUpdate = "update espetaculo set nome=?, data=?, direcao=?, local=?, poltrona=?  where id=?";
    private String stmtSelect = "select * from espetaculo";
    private String stmtSelectById = "select * from espetaculo where id =?";
    private String stmtDelete = "delete from espetaculo where id = ?";
    
    
    public void insert(Espetaculo espetaculo) {
        Connection con = null;
        PreparedStatement stmt = null;
        int idObjeto = 0;
        
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtInsert, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, espetaculo.getNome());
            stmt.setDate(2, (java.sql.Date) (Date) espetaculo.getData());
            stmt.setString(3, espetaculo.getDirecao());
            stmt.setString(4, espetaculo.getLocal());
            stmt.setInt(5, espetaculo.getPoltrona());
            
            
            stmt.execute();
            //Seta o id 
            ResultSet rs = stmt.getGeneratedKeys();
            while (rs.next()) {
                idObjeto = rs.getInt(1);
            }

            espetaculo.setId(idObjeto);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                stmt.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar stmt. Ex=" + ex.getMessage());
            };
            try {
                con.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar conexão. Ex=" + ex.getMessage());
            };
        }
    }

    public void update(Espetaculo espetaculo) {
        com.mysql.jdbc.Connection con = null;
        PreparedStatement stmt = null;
        try {

            con = (com.mysql.jdbc.Connection) ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtUpdate);
             stmt.setString(1, espetaculo.getNome());
            stmt.setDate(2, (java.sql.Date) (Date) espetaculo.getData());
            stmt.setString(3, espetaculo.getDirecao());
            stmt.setString(4, espetaculo.getLocal());
            stmt.setInt(5, espetaculo.getPoltrona());
            
           
            stmt.setInt(6, espetaculo.getId());
            
            
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                stmt.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar stmt. Ex=" + ex.getMessage());
            };
            try {
                con.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar conexão. Ex=" + ex.getMessage());
            };
        }
    }

   

    public Espetaculo getById(int id) throws ClassNotFoundException {
        Espetaculo Espetaculo = new Espetaculo();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtSelectById, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Espetaculo.setId(rs.getInt("id"));
                Espetaculo.setNome(rs.getString("nome"));
                Espetaculo.setData(rs.getDate("data"));
                Espetaculo.setDirecao(rs.getString("direcao"));
                Espetaculo.setLocal(rs.getString("local"));
                Espetaculo.setPoltrona(rs.getInt("poltrona"));
            }
            return Espetaculo;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                stmt.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar stmt. Ex=" + ex.getMessage());
            };
            try {
                con.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar conexão. Ex=" + ex.getMessage());
            };
        }

    }
    
    public void delete(int id) {
        com.mysql.jdbc.Connection con = null;
        PreparedStatement stmt = null;
        try {

            con = (com.mysql.jdbc.Connection) ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtDelete);
            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                stmt.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar stmt. Ex=" + ex.getMessage());
            };
            try {
                con.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar conexão. Ex=" + ex.getMessage());
            };
        }
    }
    
    public List<Espetaculo> getLista() throws SQLException {
        com.mysql.jdbc.Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = (com.mysql.jdbc.Connection) ConnectionFactory.getConnection();
            
            stmt = con.prepareStatement(stmtSelect);
            rs = stmt.executeQuery();
            List<Espetaculo> lstEspetaculo = new ArrayList();

            while (rs.next()) {
                // criando o objeto Usuario
                Espetaculo Espetaculo = new Espetaculo();
                Espetaculo.setId(rs.getInt("id"));
                Espetaculo.setNome(rs.getString("nome"));
                Espetaculo.setData(rs.getDate("data"));
                Espetaculo.setDirecao(rs.getString("direcao"));
                Espetaculo.setLocal(rs.getString("local"));
                Espetaculo.setPoltrona(rs.getInt("poltrona"));
               

                lstEspetaculo.add(Espetaculo);
            }
            return lstEspetaculo;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                rs.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar result set. Ex=" + ex.getMessage());
            };
            try {
                stmt.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar stmt. Ex=" + ex.getMessage());
            };
            try {
                con.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar conexão. Ex=" + ex.getMessage());
            };
        }

    }
    
    


    
}
