package ClassesDAO;

import ConexaoBD.ConexaoJDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
    //construtor vazio
    public LoginDAO(){
    
    }
    
    //metoodo que recebe a Classe bean
    public int VerificaEmail(/*Login dado*/) throws SQLException {
        int a=0;
        //Elementos para a conexão e verificação
        ConexaoJDBC conexao = new ConexaoJDBC();

        //declarações do prepareStatement
        try (
            Connection conn = conexao.obterConexaoBD();
            PreparedStatement stmt = conn.prepareStatement("Select * from login where email = ?");) {

            //passa o parametro recebido para o STMT usando o dado.get(atributo)
            //stmt.setString(1, dado.getEmail());

            //Executa a Query
            try ( ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    
                    //busco o tipo de usuário que ele é
                    //a= dado.getTipoUser();
                }
            }
        }
        return a;
    }
    public int VerificaSenha(/*login dado*/) throws SQLException {
        //Declaração de retorno da verificação
        int verificadorSenha = 0;

        //Elementos para a conexão e verificação
        ConexaoJDBC conexao = new ConexaoJDBC();

        //declarações do prepareStatement
        try (
            Connection conn = conexao.obterConexaoBD();  
            PreparedStatement stmt = conn.prepareStatement("Select * from login where email = ? and senha = ? ");  
            ) {

            //passa o parametro recebido para o STMT recebe dado e pega o email e senha
            //stmt.setString(1, dado.getEmail());
            //stmt.setString(2, dado.getSenha());

            //Executa a Query
            try ( ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    verificadorSenha = 1;
                }else{
                    verificadorSenha=0;
                }
            }
        }
        return verificadorSenha;
    }
}