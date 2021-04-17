
package ClassesJavaBean;

/**
 *
 * @author Gabriel Felipe
 */
public class Cartao {
    //atributos do cartão
    public int num_cartao;
    private String validade;
    private int cvv;
    private String bandeira;
    private String titular;
    
    //metodo construtor
    public Cartao() {
    }
    
    //metodos getters e setters

    public int getNum_cartao() {
        return num_cartao;
    }

    public void setNum_cartao(int num_cartao) {
        this.num_cartao = num_cartao;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }
    
}
