/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesJavaBean;

/**
 *
 * @author Gabriel
 */
public class Doacao {
    public int id_doacao;
    public String nome;
    public float valor;
    private int id_user;
    private int id_estabelecimento;
    
    //metodo construtor
    public Doacao(String nome, float valor, int id_user, int id_estabelecimento) {
        this.nome = nome;
        this.valor = valor;
        this.id_user = id_user;
        this.id_estabelecimento = id_estabelecimento;
    }
    
    
    //Getters e setters
    public int getId_doacao() {
        return id_doacao;
    }

    public void setId_doacao(int id_doacao) {
        this.id_doacao = id_doacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_estabelecimento() {
        return id_estabelecimento;
    }

    public void setId_estabelecimento(int id_estabelecimento) {
        this.id_estabelecimento = id_estabelecimento;
    }
    
    
    
}
