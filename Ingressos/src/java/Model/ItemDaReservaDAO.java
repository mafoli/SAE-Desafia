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
import java.util.List;

/**
 *
 * @author Junior
 */
public class ItemDaReservaDAO {

    private String stmtSelect = "select * from reserva where id_espetaculo = ?;";
    private String stmtSelectudo = "select * from reserva";
    private String stmtInsert = "insert into reserva(id_espetaculo, id_cliente, qtdade,valor) values(?, ?, ?,?);";
    private String stmtDeleteAll = "delete from reserva where id_espetaculo = ?";
    private String stmtDelete = "delete from reserva where id_espetaculo = ? and id_cliente = ?";
    private String stmtSoma = "select id_pedido, id_produto, SUM(qtdade*valor) as 'total' from pedido_has_produto where id_pedido = ?;";
   

    public List<ItemDaReserva> getLista(int idEspetaculo) throws SQLException, ClassNotFoundException {
        com.mysql.jdbc.Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = (com.mysql.jdbc.Connection) ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtSelect, Statement.RETURN_GENERATED_KEYS);
            
            stmt.setInt(1, idEspetaculo);
             
            rs = stmt.executeQuery();
           
            
            List<ItemDaReserva> lstItemDaReserva = new ArrayList();

            while (rs.next()) {
                // criando o objeto Usuario
                ItemDaReserva ItemDaReserva = new ItemDaReserva();
                ItemDaReserva.setId_espetaculo(rs.getInt("id_espetaculo"));
                ItemDaReserva.setQtdade(rs.getInt("qtdade"));
                ItemDaReserva.setPrecovenda(rs.getDouble("valor"));
                
                ClienteDAO ClienteDAO = new ClienteDAO();
                ItemDaReserva.setCliente(ClienteDAO.getById(rs.getInt("id_cliente")));

                lstItemDaReserva.add(ItemDaReserva);
            }
            return lstItemDaReserva;

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
    public List<ItemDaReserva> getListaTotal() throws SQLException, ClassNotFoundException {
        com.mysql.jdbc.Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = (com.mysql.jdbc.Connection) ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtSelectudo, Statement.RETURN_GENERATED_KEYS);
            
            
             
            rs = stmt.executeQuery();
           
            
            List<ItemDaReserva> lstItemDaReserva = new ArrayList();

            while (rs.next()) {
                // criando o objeto 
                ItemDaReserva ItemDaReserva = new ItemDaReserva();
                ItemDaReserva.setId_espetaculo(rs.getInt("id_espetaculo"));
                ItemDaReserva.setQtdade(rs.getInt("qtdade"));
                ItemDaReserva.setPrecovenda(rs.getDouble("valor"));
                
                ClienteDAO ClienteDAO = new ClienteDAO();
                ItemDaReserva.setCliente(ClienteDAO.getById(rs.getInt("id_cliente")));

                lstItemDaReserva.add(ItemDaReserva);
            }
            return lstItemDaReserva;

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

    public void insert(Espetaculo espetaculo) throws RuntimeException {
        Connection con = null;
        PreparedStatement stmt = null;
        int idEspetaculo = espetaculo.getId();
        List<ItemDaReserva> lstItemDaReserva = new ArrayList();
        lstItemDaReserva = espetaculo.getLstItemReserva();
        try {
            for (ItemDaReserva ItemDaReserva : lstItemDaReserva) {
                stmt = null;
                con = ConnectionFactory.getConnection();
                stmt = con.prepareStatement(stmtInsert, Statement.RETURN_GENERATED_KEYS);
                
                
                
                stmt.setInt(1, idEspetaculo);
                stmt.setInt(2, ItemDaReserva.getCliente().getId());
                stmt.setInt(3, ItemDaReserva.getQtdade());
                stmt.setDouble(4, ItemDaReserva.getPrecovenda());
                

                stmt.execute();
                //Seta o id 
                ResultSet rs = stmt.getGeneratedKeys();
                while (rs.next()) {
                }
            }
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

    public void deleteAll(int idEspetaculo) {
        com.mysql.jdbc.Connection con = null;
        PreparedStatement stmt = null;
        try {

            con = (com.mysql.jdbc.Connection) ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtDeleteAll);
            stmt.setInt(1, idEspetaculo);
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
    
    public void delete(int idEspetaculo, int idCliente) {
        com.mysql.jdbc.Connection con = null;
        PreparedStatement stmt = null;
        try {

            con = (com.mysql.jdbc.Connection) ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtDelete);
            stmt.setInt(1, idEspetaculo);
            stmt.setInt(2, idCliente);
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
   
   

}
