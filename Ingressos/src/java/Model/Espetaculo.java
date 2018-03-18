/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Junior
 */
public class Espetaculo implements Serializable{
    private int id;
    private String nome;
    private Date data;
    private String direcao;
    private String local;
    private int poltrona;
    
    private int total;
     private List<ItemDaReserva> lstItemReserva;

    public List<ItemDaReserva> getLstItemReserva() {
        return lstItemReserva;
    }

    public void setLstItemReserva(List<ItemDaReserva> lstItemReserva) {
        this.lstItemReserva = lstItemReserva;
    }

   
  
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDirecao() {
        return direcao;
    }

    public void setDirecao(String direcao) {
        this.direcao = direcao;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getPoltrona() {
        return poltrona;
    }

    public void setPoltrona(int poltrona) {
        this.poltrona = poltrona;
    }

   

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
      
    
    
}
