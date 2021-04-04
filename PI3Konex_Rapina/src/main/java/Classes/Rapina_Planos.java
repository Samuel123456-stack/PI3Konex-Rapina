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
public class Rapina_Planos{
    //Atributos plano rapina
    public int id_planos;
    public String nome_plano;
    private float valor_plano;
    public String benefícios;

    //metodo construtor
    public Rapina_Planos(String nome_plano) {   
        //condição dos planos 
        if(null != this.nome_plano)switch (this.nome_plano) {
            case "Serrana":
                this.valor_plano=(float) 19.9;
                break;
            case "Rarpy":
                this.valor_plano=(float) 49.9;
                break;
            case "Açor":
                this.valor_plano=(float) 29.9;
                break;
            default:
                break;
        }
        
    }

    //Metodos que serão utilizados
    public void alteraPlano() {
    }

    public void listarQtdSerra() {
    }

    public void listarQtdRarpy() {
    }

    public void listarQtdAçor() {
    }

    //metodo getters e setters

    public int getId_planos() {
        return id_planos;
    }

    public void setId_planos(int id_planos) {
        this.id_planos = id_planos;
    }

    public String getNome_plano() {
        return nome_plano;
    }

    public void setNome_plano(String nome_plano) {
        this.nome_plano = nome_plano;
    }

    public float getValor_plano() {
        return valor_plano;
    }

    public void setValor_plano(float valor_plano) {
        this.valor_plano = valor_plano;
    }

    public String getBenefícios() {
        return benefícios;
    }

    public void setBenefícios(String benefícios) {
        this.benefícios = benefícios;
    }
    
}
