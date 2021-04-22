
package ClassesJavaBean;

/**
 *
 * @author Gabriel Felipe
 */
public class Estabelecimento {
    //Atributos do Estabelecimento
    public int id_estabelecimento;
    public String nome_estabelecimento;
    private int cpnj;
    private String email;
    private String senha;
    public int capacidade;
    public int cep_estabelecimento;
    public String logadouro_estabelecimento;
    public int numero;
    public String horario_funcionamento;
    public boolean disponibilidade;
    public String acessi_auditiva ;
    public String acessi_fisico ;
    public float taxa_cancelamento;
    private int celular;
    private String concorda;
    public String concorda_newstalleter;
    public int tipo_user;
    private int id_planos;
    private int id_pagamento_taxa;  
    
    
    //metodo construtor 
    public Estabelecimento() {
    }
    
    //metodos especiais(funcionalidades)
    public void cadastro() {
    }

    public void login() {
    }

    public void atualizarDados() {
    }

    public void atualziarDispositivo() {
    }

    public void renovarMensalidade() {
    }

    public void alterarPlanoContrado() {
    }
    
    //metodos getters e setters
    public int getId_estabelecimento() {
        return id_estabelecimento;
    }

    public void setId_estabelecimento(int id_estabelecimento) {
        this.id_estabelecimento = id_estabelecimento;
    }

    public String getNome_estabelecimento() {
        return nome_estabelecimento;
    }

    public void setNome_estabelecimento(String nome_estabelecimento) {
        this.nome_estabelecimento = nome_estabelecimento;
    }

    public int getCpnj() {
        return cpnj;
    }

    public void setCpnj(int cpnj) {
        this.cpnj = cpnj;
    }

    public int getCep_estabelecimento() {
        return cep_estabelecimento;
    }

    public void setCep_estabelecimento(int cep_estabelecimento) {
        this.cep_estabelecimento = cep_estabelecimento;
    }

    public String getLogadouro_estabelecimento() {
        return logadouro_estabelecimento;
    }

    public void setLogadouro_estabelecimento(String logadouro_estabelecimento) {
        this.logadouro_estabelecimento = logadouro_estabelecimento;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getAcessi_auditiva() {
        return acessi_auditiva;
    }

    public void setAcessi_auditiva(String acessi_auditiva) {
        this.acessi_auditiva = acessi_auditiva;
    }

    public String getAcessi_fisico() {
        return acessi_fisico;
    }

    public void setAcessi_fisico(String acessi_fisico) {
        this.acessi_fisico = acessi_fisico;
    }

    public String getHorario_funcionamento() {
        return horario_funcionamento;
    }

    public void setHorario_funcionamento(String horario_funcionamento) {
        this.horario_funcionamento = horario_funcionamento;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public float getTaxa_cancelamento() {
        return taxa_cancelamento;
    }

    public void setTaxa_cancelamento(float taxa_cancelamento) {
        this.taxa_cancelamento = taxa_cancelamento;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
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

    public String getConcorda() {
        return concorda;
    }

    public void setConcorda(String concorda) {
        this.concorda = concorda;
    }

    public String getConcorda_newstalleter() {
        return concorda_newstalleter;
    }

    public void setConcorda_newstalleter(String concorda_newstalleter) {
        this.concorda_newstalleter = concorda_newstalleter;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public int getId_planos() {
        return id_planos;
    }

    public void setId_planos(int id_planos) {
        this.id_planos = id_planos;
    }

    public int getId_pagamento_taxa() {
        return id_pagamento_taxa;
    }

    public void setId_pagamento_taxa(int id_pagamento_taxa) {
        this.id_pagamento_taxa = id_pagamento_taxa;
    }

    public int getTipo_user() {
        return tipo_user;
    }

    public void setTipo_user(int tipo_user) {
        this.tipo_user = tipo_user;
    }
    
}
