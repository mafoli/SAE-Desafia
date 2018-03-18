/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author Junior
 */
public class ItemDaReserva implements Serializable{
    private int id_espetaculo;
    private Cliente cliente;
    private int qtdade;
    private double precovenda;
    private int total; 

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotal() {
        return total;
    }

    public void setPrecovenda(double precovenda) {
        this.precovenda = precovenda;
    }

    public double getPrecovenda() {
        return precovenda;
    }

    public int getId_espetaculo() {
        return id_espetaculo;
    }

    public void setId_espetaculo(int id_espetaculo) {
        this.id_espetaculo = id_espetaculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }



    public int getQtdade() {
        return qtdade;
    }

  

    public void setQtdade(int qtdade) {
        this.qtdade = qtdade;
    }

    

  
    
}
