
package ClassesJavaBean;

/**
 *
 * @author Gabriel Felipe
 */
public class Pagamento_taxa {
    //atributos pagamento taxa
    private int id_pagamento_taxa;
    public int id_usuário;
    public String describe_taxa;
    public String data_cobranca;
    private float valor_rapina_adm;
    private float valor_estabelecimento;
    private int id_adm;
    public int id_estabelecimento;

    //metodo construtor

    public Pagamento_taxa() {
    }
    
    //Metodos especiais
    public void consultarTaxa() {
    }

    public void pagarTaxa() {
    }
    
    //metodos especiais

    public int getId_pagamento_taxa() {
        return id_pagamento_taxa;
    }

    public void setId_pagamento_taxa(int id_pagamento_taxa) {
        this.id_pagamento_taxa = id_pagamento_taxa;
    }

    public int getId_usuário() {
        return id_usuário;
    }

    public void setId_usuário(int id_usuário) {
        this.id_usuário = id_usuário;
    }

    public String getDescribe_taxa() {
        return describe_taxa;
    }

    public void setDescribe_taxa(String describe_taxa) {
        this.describe_taxa = describe_taxa;
    }

    public String getData_cobranca() {
        return data_cobranca;
    }

    public void setData_cobranca(String data_cobranca) {
        this.data_cobranca = data_cobranca;
    }

    public float getValor_rapina_adm() {
        return valor_rapina_adm;
    }

    public void setValor_rapina_adm(float valor_rapina_adm) {
        this.valor_rapina_adm = valor_rapina_adm;
    }

    public float getValor_estabelecimento() {
        return valor_estabelecimento;
    }

    public void setValor_estabelecimento(float valor_estabelecimento) {
        this.valor_estabelecimento = valor_estabelecimento;
    }

    public int getId_adm() {
        return id_adm;
    }

    public void setId_adm(int id_adm) {
        this.id_adm = id_adm;
    }

    public int getId_estabelecimento() {
        return id_estabelecimento;
    }

    public void setId_estabelecimento(int id_estabelecimento) {
        this.id_estabelecimento = id_estabelecimento;
    }
    
}
