/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;



import Model.Espetaculo;
import Model.EspetaculoDAO;
import Model.Format;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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
@WebServlet(name = "ProcessaEspetaculo", urlPatterns = {"/ProcessaEspetaculo"})
public class ProcessaEspetaculo extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        EspetaculoDAO EspetaculoDAO = new EspetaculoDAO();

        String tipoServlet = request.getParameter("tipoServlet");

        if (tipoServlet == null) {

            List<Espetaculo> lista = new ArrayList();

            try {
                lista = EspetaculoDAO.getLista();
            } catch (SQLException ex) {
                Logger.getLogger(ProcessaCliente.class.getName()).log(Level.SEVERE, null, ex);
            }

            request.setAttribute("dados", lista);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/Espetaculo.jsp");
            rd.forward(request, response);
        }

        if (("getform").equals(tipoServlet)) {
            int id = Integer.parseInt(request.getParameter("id"));

            Espetaculo espetaculo = new Espetaculo();
            
            
            try {
                              
                 espetaculo = EspetaculoDAO.getById(id);
                 
                
             
                request.setAttribute("espetaculo", espetaculo);
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/FormEspetaculo.jsp");
                rd.forward(request, response);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ProcessaCliente.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        if (("insert").equals(tipoServlet)) {
            int id = Integer.parseInt(request.getParameter("id"));

            Espetaculo espetaculo = new Espetaculo();

            String nome = request.getParameter("nome");
            Date data = Format.toDate(request.getParameter("data"));
            String direcao = request.getParameter("direcao");
            String local = request.getParameter("local");
            int poltrona = Integer.parseInt(request.getParameter("poltrona"));
          
           

            espetaculo.setId(id);
            espetaculo.setNome(nome);
            espetaculo.setData(data);
            espetaculo.setDirecao(direcao);
            espetaculo.setLocal(local);
            espetaculo.setPoltrona(poltrona);
            
            String mensagem;
            if (espetaculo.getId() != 0) {

                EspetaculoDAO.update(espetaculo);
                mensagem = "Cadastro alterado com sucesso.";

            } else {

                EspetaculoDAO.insert(espetaculo);
                mensagem = "Cadastro realizado com sucesso.";
            }
            request.setAttribute("mensagem", mensagem);
            request.setAttribute("voltar", "ProcessaEspetaculo");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/Mensagem.jsp");
            rd.forward(request, response);

        }
        
        

        if (("delete").equals(tipoServlet)) {
            int id = Integer.parseInt(request.getParameter("id"));
            String mensagem = "";

            try {
                EspetaculoDAO.delete(id);
            } catch (RuntimeException e) {
                String msg = "Espetaculo não pode ser removido pois está em uso.";
                request.setAttribute("mensagem", msg);
                request.setAttribute("voltar", "ProcessaEspetaculo");
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/Mensagem.jsp");
                rd.forward(request, response);
            }


            mensagem = "Espetaculo excluso com sucesso.";

            request.setAttribute("mensagem", mensagem);
            request.setAttribute("voltar", "ProcessaEspetaculo");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/Mensagem.jsp");
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ProcessaEspetaculo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProcessaEspetaculo.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ProcessaEspetaculo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProcessaEspetaculo.class.getName()).log(Level.SEVERE, null, ex);
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
