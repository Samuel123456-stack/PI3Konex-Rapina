package ClassesDAO;

import ClassesJavaBean.Login;
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
    public int VerificaEmail(Login dado) throws SQLException {
        int a=0;
        //Elementos para a conexão e verificação
        ConexaoJDBC conexao = new ConexaoJDBC();

        //declarações do prepareStatement
        try (
                Connection conn = conexao.obterConexaoBD();
                PreparedStatement stmt1 = conn.prepareStatement("Select * from login where email = ? tipo_usuario ='1'");
                PreparedStatement stmt2 = conn.prepareStatement("Select * from login where email = ? tipo_usuario ='2'");
                PreparedStatement stmt3 = conn.prepareStatement("Select * from login where email = ? tipo_usuario ='3'");) {

            stmt1.setString(1, dado.getEmail());
            stmt2.setString(1, dado.getEmail());
            stmt3.setString(1, dado.getEmail());

            try (ResultSet rs = stmt1.executeQuery()) {
                if (rs.next()) {
                    a = 1;
                } else {
                    ResultSet rs2 = stmt2.executeQuery();
                    if (rs2.next()) {
                        a = 2;
                    } else {
                        ResultSet rs3 = stmt3.executeQuery();
                        if (rs3.next()) {
                            a = 3;
                        } else {
                            a = 4;
                        }
                    }
                }
            }
        }
        return a;
    }
    public int VerificaSenha(Login dado) throws SQLException {
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
            stmt.setString(1, dado.getEmail());
            stmt.setString(2, dado.getSenha());

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