/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Junior
 */
public class Usuario {
    private int id;
    private String nomeUsuario;
    private String login;
    private String senha;


    public int getId(){
       return this.id;
    }
    
    public String getNomeUsuario(){
       return this.nomeUsuario;
    }
    
    public String getLogin(){
       return this.login;
    }
    
    public String getSenha(){
       return this.senha;
    }
    
    public void setId(int id){
       this.id = id;
    }
    
    public void setNomeUsuario(String nomeUsuario){
       this.nomeUsuario = nomeUsuario;
    }
    
    public void setLogin(String login){
       this.login = login;
    }
    
    public void setSenha(String senha){
       this.senha = senha;
    }
}
