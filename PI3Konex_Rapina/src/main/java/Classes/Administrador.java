/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Gabriel
 */
public class Administrador {
     //Atributos do administrador(donos da rapina)
    private int id_adm;
    private String email;
    private String senha;
    public String nome_adm;
    
    //metodo construtor
    
    //metodos especiais (metodos de funcionalidades)
    public void excluirUsuario() {
    }

    public void consultarCliente(){
    }
    public void consultarEstabelecimento(){
    }
    public void bloquearEstabelecimento(){
    }
    public void debloquearEstabelecimento(){
    }
    
    
    
    //metodos getters e setters
    public int getId_adm() {
        return id_adm;
    }

    public void setId_adm(int id_adm) {
        this.id_adm = id_adm;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome_adm() {
        return nome_adm;
    }

    public void setNome_adm(String nome_adm) {
        this.nome_adm = nome_adm;
    }
    
}
