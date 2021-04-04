
package Classes;

/**
 *
 * @author Gabriel Felipe
 */
public class Cliente {

    //Atributos do usuário 
    public int id_usuario;
    public String nome;
    private int cpf;
    private String email;
    private String genero;
    private String data_nascimento;
    private String senha;
    private String concorda;
    public String concorda_newstalleter;
    public int num_cartao;
    public int id_favoritado;

    //metodo construtor
    public Cliente() {
    }

    //metodos especiais(funcionalidades)
    public void cadastro() {
    }

    public void login() {
    }

    public void atualizarPerfil() {
    }

    public void buscarFavoritos() {
    }

    //metodos getters e setters
    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
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

    public int getNum_cartao() {
        return num_cartao;
    }

    public void setNum_cartao(int num_cartao) {
        this.num_cartao = num_cartao;
    }

    public int getId_favoritado() {
        return id_favoritado;
    }

    public void setId_favoritado(int id_favoritado) {
        this.id_favoritado = id_favoritado;
    }

}
