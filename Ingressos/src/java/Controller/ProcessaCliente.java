package Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Model.Cliente;
import Model.ClienteDAO;
import Model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Junior
 */
@WebServlet(urlPatterns = {"/ProcessaCliente"})
public class ProcessaCliente extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
         
         Usuario Usuario = (Usuario) session.getAttribute("Usuario");
         

        ClienteDAO ClienteDAO = new ClienteDAO();

        String tipoServlet = request.getParameter("tipoServlet");

        if (tipoServlet == null) {

            List<Cliente> lista = new ArrayList();

            try {
                lista = ClienteDAO.getLista2("");
            } catch (SQLException ex) {
                Logger.getLogger(ProcessaCliente.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ProcessaCliente.class.getName()).log(Level.SEVERE, null, ex);
            }

            request.setAttribute("dados", lista);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/Cliente.jsp");
            rd.forward(request, response);
        }

        if (("getform").equals(tipoServlet)) {
            int id = Integer.parseInt(request.getParameter("id"));

            Cliente cliente = new Cliente();

            try {
                cliente = ClienteDAO.getById(id);
                request.setAttribute("cliente", cliente);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/FormCliente.jsp");
                rd.forward(request, response);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ProcessaCliente.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        if (("insert").equals(tipoServlet)) {
            int id = Integer.parseInt(request.getParameter("id"));

            Cliente cliente = new Cliente();

            String cpf = request.getParameter("cpf");
            String nome = request.getParameter("nome");
            String sobreNome = request.getParameter("sobreNome");
            String endereco = request.getParameter("endereco");
            int numero = Integer.parseInt(request.getParameter("numero"));
            String complemento = request.getParameter("complemento");
            String cep = request.getParameter("cep");
            String uf = request.getParameter("uf");
            String cidade = request.getParameter("cidade");
            String bairro = request.getParameter("bairro");
            String telefone = request.getParameter("telefone");
            String celular = request.getParameter("celular");
            
            
            

            cliente.setId(id);
            cliente.setCpf(cpf);
            cliente.setNome(nome);
            cliente.setSobreNome(sobreNome);
            cliente.setEndereco(endereco);
            cliente.setNumero(numero);
            cliente.setComplemento(complemento);
            cliente.setCep(cep);
            cliente.setUf(uf);
            cliente.setCidade(cidade);
            cliente.setBairro(bairro);
            cliente.setTelefone(telefone);
            cliente.setCelular(celular);
            String mensagem;
            if (cliente.getId() != 0) {

                ClienteDAO.update(cliente);
                mensagem = "Cadastro alterado com sucesso.";

            } else {
                //insert
                ClienteDAO.insert(cliente);
                mensagem = "Cadastro realizado com sucesso.";
            }
            request.setAttribute("mensagem", mensagem);
            request.setAttribute("voltar", "ProcessaCliente");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/Mensagem.jsp");
            rd.forward(request, response);

        }

        if (("delete").equals(tipoServlet)) {
            int id = Integer.parseInt(request.getParameter("id"));
            String mensagem = "";
            
            try{
                ClienteDAO.delete(id);
            }catch(RuntimeException e){
                mensagem = "Não é possivel excluir pois o cliente possui pedidos.";
            
                request.setAttribute("mensagem", mensagem);
                request.setAttribute("voltar", "ProcessaCliente");
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/Mensagem.jsp");
                rd.forward(request, response);
            }

            
            mensagem = "Cliente excluido com sucesso.";
            
            request.setAttribute("mensagem", mensagem);
            request.setAttribute("voltar", "ProcessaCliente");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/Mensagem.jsp");
            rd.forward(request, response);
        }
        
        if (("busca").equals(tipoServlet)) {
            String cpf = request.getParameter("filtroCpf");
            List<Cliente> lista = new ArrayList();

            try {
                lista = ClienteDAO.getLista2(cpf);
            } catch (SQLException ex) {
                Logger.getLogger(ProcessaCliente.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ProcessaCliente.class.getName()).log(Level.SEVERE, null, ex);
            }

            request.setAttribute("dados", lista);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/Cliente.jsp");
            rd.forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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