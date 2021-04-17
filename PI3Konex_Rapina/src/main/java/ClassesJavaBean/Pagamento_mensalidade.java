
package ClassesJavaBean;

/**
 *
 * @author Gabriel Felipe
 */
public class Pagamento_mensalidade {

    //Atributos pagamento mensalidade
    public int id_pag_mensalidade;
    public int id_estabelecimento;
    private String data_cobranca;
    private float valor;

    //metodo construtor

    public Pagamento_mensalidade() {
    }
    
    
    //Metodos especiais
    public void consultarMensalidade() {
    }

    public void pagarMensalidade() {
    }  
    
    //metodos getters e setters

    public int getId_pag_mensalidade() {
        return id_pag_mensalidade;
    }

    public void setId_pag_mensalidade(int id_pag_mensalidade) {
        this.id_pag_mensalidade = id_pag_mensalidade;
    }

    public int getId_estabelecimento() {
        return id_estabelecimento;
    }

    public void setId_estabelecimento(int id_estabelecimento) {
        this.id_estabelecimento = id_estabelecimento;
    }

    public String getData_cobranca() {
        return data_cobranca;
    }

    public void setData_cobranca(String data_cobranca) {
        this.data_cobranca = data_cobranca;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    
}
