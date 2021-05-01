
package ClassesJavaBean;

/**
 *
 * @author Gabriel Felipe
 */
public class Cartao {
    //atributos do cartão
    public int id_card;
    public long num_cartao;
    private String validade;
    private long cvv;
    private String titular;
    
    //metodo construtor
    public Cartao() {
    }
    public Cartao(long num_cartao, String validade, long cvv,String titular) {
        this.num_cartao = num_cartao;
        this.validade = validade;
        this.cvv = cvv;
        this.titular = titular;
    }
    //metodos getters e setters

    public long getNum_cartao() {
        return num_cartao;
    }

    public void setNum_cartao(long num_cartao) {
        this.num_cartao = num_cartao;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public long getCvv() {
        return cvv;
    }

    public void setCvv(long cvv) {
        this.cvv = cvv;
    }


    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }
    public int getId_card() {
        return id_card;
    }

    public void setId_card(int id_card) {
        this.id_card = id_card;
    }

}
