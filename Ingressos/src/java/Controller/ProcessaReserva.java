/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Cliente;
import Model.ClienteDAO;
import Model.Format;
import Model.ItemDaReserva;
import Model.ItemDaReservaDAO;

import Model.Espetaculo;
import Model.EspetaculoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Junior
 */
@WebServlet(name = "ProcessaReserva", urlPatterns = {"/ProcessaReserva"})
public class ProcessaReserva extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        ClienteDAO ClienteDAO = new ClienteDAO();
        Cliente cliente = new Cliente();
        String tipoServlet = request.getParameter("tipoServlet");

      
        if (("getform").equals(tipoServlet)) {
           
            int id = Integer.parseInt(request.getParameter("id"));
            List<ItemDaReserva> lista = new ArrayList();
            List<Cliente> listaCliente = new ArrayList();
            
            double total =  0;
            int totalreserva =0;
            try {
                EspetaculoDAO EspetaculoDAO = new EspetaculoDAO();
                ItemDaReservaDAO itemDaReservaDAO = new ItemDaReservaDAO();
                Espetaculo espetaculo = new Espetaculo();
                espetaculo = EspetaculoDAO.getById(id);
                lista = itemDaReservaDAO.getLista(id);
                
                

                ClienteDAO clienteDAO = new ClienteDAO();
                listaCliente = clienteDAO.getLista();

               if (lista != null){
                    for (ItemDaReserva i : lista) {
                    
                    total += i.getPrecovenda() * i.getQtdade();
                                                         
                }
                     for (ItemDaReserva i : lista) {
                    
                    totalreserva +=  i.getQtdade();
                                                         
                }
               
               } 
               
                
                request.setAttribute("dados", lista);
                request.setAttribute("dadoscliente", listaCliente);
                request.setAttribute("espetaculo", espetaculo);
                request.setAttribute("totalreserva", totalreserva);
                request.setAttribute("total", total);


                RequestDispatcher rd = getServletContext().getRequestDispatcher("/FormReserva.jsp");
                rd.forward(request, response);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ProcessaCliente.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ProcessaReserva.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        
        

        if (("insertreserva").equals(tipoServlet)) {
           int idEspetaculo = Integer.parseInt(request.getParameter("id"));
            
            EspetaculoDAO EspetaculoDAO = new EspetaculoDAO();
            Espetaculo espetaculo = new Espetaculo();
            
            ClienteDAO clienteDAO = new ClienteDAO();

            List<ItemDaReserva> lstItemDaReserva = new ArrayList();
            ItemDaReserva ItemDaReserva = new ItemDaReserva();
            ItemDaReservaDAO ItemDaReservaDAO= new ItemDaReservaDAO();

            
            int idCliente = Integer.parseInt(request.getParameter("idCliente"));
            int qtdade = Integer.parseInt(request.getParameter("qtdade"));
            double precovenda = Double.parseDouble(request.getParameter("precovenda"));
            

            try {
                cliente = clienteDAO.getById(idCliente);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ProcessaReserva.class.getName()).log(Level.SEVERE, null, ex);
            }

            ItemDaReserva.setCliente(cliente);
            ItemDaReserva.setQtdade(qtdade);
            ItemDaReserva.setPrecovenda(precovenda);
            espetaculo.setId(idEspetaculo);
            lstItemDaReserva.add(ItemDaReserva);
            espetaculo.setLstItemReserva(lstItemDaReserva);
          
                ItemDaReservaDAO itemDAO = new ItemDaReservaDAO();
                espetaculo.setId(idEspetaculo);
                try {
                    
                    itemDAO.insert(espetaculo);
                    
                    
                } catch (RuntimeException e) {
                    String mensagem = "Este item já está na lista.";
                    request.setAttribute("mensagem", mensagem);
                   
                    RequestDispatcher rd = getServletContext().getRequestDispatcher("/Mensagem.jsp");
                    rd.forward(request, response);
                }
            

            //RECARREGAR LISTA
            
            
              int id = Integer.parseInt(request.getParameter("id"));
            List<ItemDaReserva> lista = new ArrayList();
            List<Cliente> listaCliente = new ArrayList();
            
            double total =  0;
            int totalreserva = 0;
            try {
                
                ItemDaReservaDAO itemDaReservaDAO = new ItemDaReservaDAO();
                
                espetaculo = EspetaculoDAO.getById(id);
                lista = itemDaReservaDAO.getLista(id);
                
                

              
                listaCliente = clienteDAO.getLista();

               
               for (ItemDaReserva i : lista) {
                    
                    total += i.getPrecovenda() * i.getQtdade();
                    
                                       
                }
               
               for (ItemDaReserva i : lista) {
                    
                    totalreserva +=  i.getQtdade();
                                                         
                }
                
                request.setAttribute("dados", lista);
                request.setAttribute("dadoscliente", listaCliente);
                request.setAttribute("espetaculo", espetaculo);
                request.setAttribute("totalreserva", totalreserva);
                request.setAttribute("total", total);


                RequestDispatcher rd = getServletContext().getRequestDispatcher("/FormReserva.jsp");
                rd.forward(request, response);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ProcessaCliente.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ProcessaReserva.class.getName()).log(Level.SEVERE, null, ex);
            }


        }

         if (("deleteitem").equals(tipoServlet)) {
            int idEspetaculo = Integer.parseInt(request.getParameter("idEspetaculo"));
            
            
            int idCliente = Integer.parseInt(request.getParameter("idCliente"));
            
            Espetaculo espetaculo = new Espetaculo();
            
            EspetaculoDAO EspetaculoDAO = new EspetaculoDAO();
            
     
            try {
                cliente = ClienteDAO.getById(idCliente);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ProcessaReserva.class.getName()).log(Level.SEVERE, null, ex);
            }
            ItemDaReservaDAO itemDAO = new ItemDaReservaDAO();
            List<ItemDaReserva> lista = new ArrayList();
            List<Cliente> listaCliente = new ArrayList();
          int saldo = 0;
         try {
                espetaculo = EspetaculoDAO.getById(idEspetaculo);
                lista = itemDAO.getLista(idEspetaculo);
                cliente = ClienteDAO.getById(idCliente);               
                
              

             
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ProcessaReserva.class.getName()).log(Level.SEVERE, null, ex);
            }
            
           
           
            itemDAO.delete(idEspetaculo, idCliente);
            

            //RECARREGAR LISTA
          
             double total =  0;
             int totalreserva = 0;
            try {
                
                ItemDaReservaDAO itemDaReservaDAO = new ItemDaReservaDAO();
                
                espetaculo = EspetaculoDAO.getById(idEspetaculo);
                lista = itemDaReservaDAO.getLista(idEspetaculo);
                
                

              
                listaCliente = ClienteDAO.getLista();

               
               for (ItemDaReserva i : lista) {
                    
                    total += i.getPrecovenda() * i.getQtdade();
                    
                                       
                }
               for (ItemDaReserva i : lista) {
                    
                    totalreserva +=  i.getQtdade();
                                                         
                }
                
                request.setAttribute("dados", lista);
                request.setAttribute("dadoscliente", listaCliente);
                request.setAttribute("espetaculo", espetaculo);
                request.setAttribute("totalreserva", totalreserva);
                request.setAttribute("total", total);


                RequestDispatcher rd = getServletContext().getRequestDispatcher("/FormReserva.jsp");
                rd.forward(request, response);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ProcessaCliente.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ProcessaReserva.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ProcessaReserva.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ProcessaReserva.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

   

}
