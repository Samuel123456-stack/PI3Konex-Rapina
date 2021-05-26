package ClassesDAO;

import ClassesJavaBean.Login;
import ConexaoBD.ConexaoJDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

    private String email;
    private String senha;

    public LoginDAO() {
    }

    public LoginDAO(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public int validaEmail(Login dadoRecebido) throws SQLException {
        //Var auxliadora
        int tipoUser = 0;

        //Crio a conexao com o bd
        ConexaoJDBC conexao = new ConexaoJDBC();

        try (
                Connection conn = conexao.obterConexaoBD();
                PreparedStatement stmt = conn.prepareStatement("Select * from login where email = ?");) {

            //passa o parametro recebido para o STMT usando o dado.get(atributo)
            stmt.setString(1, dadoRecebido.getEmail());

            //Executa a Query
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    tipoUser = rs.getInt("tipo_usuario");
                    dadoRecebido.setTipo_usuario(tipoUser);
                    return tipoUser;
                }
            }
        }
        return tipoUser;
    }

    public int validaSenha() throws SQLException {
        //Var auxliadora
        int liberaAcesso = 0;

        //Crio a conexao com o bd
        ConexaoJDBC conexao = new ConexaoJDBC();

        try (
                Connection conn = conexao.obterConexaoBD();
                PreparedStatement stmt = conn.prepareStatement("Select * from login where email =?");) {

            //passa o parametro recebido para o STMT usando o dado.get(atributo)
            stmt.setString(1, getEmail());

            //Executa a Query
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    //verifico se a senha digitada é igual da coluna do BD
                    String senhaBd = rs.getString("senha");

                    //condição
                    if (senhaBd.equals(getSenha())) {
                        liberaAcesso = 1;
                    } else {
                        liberaAcesso = 0;
                    }
                }
            }
        }
        return liberaAcesso;
    }
    
    public int retornaIDEsta(String email) throws SQLException{
        //Var auxliadora
        int retorna = 0;

        //Crio a conexao com o bd
        ConexaoJDBC conexao = new ConexaoJDBC();

        try (
                Connection conn = conexao.obterConexaoBD();
                PreparedStatement stmt = conn.prepareStatement("Select * from login where email =?");) {

            //passa o parametro recebido para o STMT usando o dado.get(atributo)
            stmt.setString(1, getEmail());

            //Executa a Query
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    //verifico se a senha digitada é igual da coluna do BD
                    int idEsta = rs.getInt("id_esta");
                    
                    retorna = idEsta; 
                }
            }
        }
        return retorna;
    }
    public String retornaNome(String id) throws SQLException{
        //Var auxliadora
        String retorna = null;

        //Crio a conexao com o bd
        ConexaoJDBC conexao = new ConexaoJDBC();

        try (
                Connection conn = conexao.obterConexaoBD();
                PreparedStatement stmt = conn.prepareStatement("Select * from login where email =?");) {

            //passa o parametro recebido para o STMT usando o dado.get(atributo)
            stmt.setString(1, getEmail());

            //Executa a Query
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    //verifico se a senha digitada é igual da coluna do BD
                    String nome = rs.getString("nome");
                    
                    retorna = nome; 
                }
            }
        }
        return retorna;
    }
    
    public int retornaIDCli(String email) throws SQLException{
        //Var auxliadora
        int retorna = 0;

        //Crio a conexao com o bd
        ConexaoJDBC conexao = new ConexaoJDBC();

        try (
                Connection conn = conexao.obterConexaoBD();
                PreparedStatement stmt = conn.prepareStatement("Select * from login where email =?");) {

            //passa o parametro recebido para o STMT usando o dado.get(atributo)
            stmt.setString(1, getEmail());

            //Executa a Query
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    //verifico se a senha digitada é igual da coluna do BD
                    int idEsta = rs.getInt("id_usuario");
                    
                    retorna = idEsta; 
                }
            }
        }
        return retorna;
    }
    public String retornaNomeCli(String id) throws SQLException{
        //Var auxliadora
        String retorna = null;

        //Crio a conexao com o bd
        ConexaoJDBC conexao = new ConexaoJDBC();

        try (
                Connection conn = conexao.obterConexaoBD();
                PreparedStatement stmt = conn.prepareStatement("Select * from login where email =?");) {

            //passa o parametro recebido para o STMT usando o dado.get(atributo)
            stmt.setString(1, getEmail());

            //Executa a Query
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    //verifico se a senha digitada é igual da coluna do BD
                    String nome = rs.getString("nome");
                    
                    retorna = nome; 
                }
            }
        }
        return retorna;
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

}
