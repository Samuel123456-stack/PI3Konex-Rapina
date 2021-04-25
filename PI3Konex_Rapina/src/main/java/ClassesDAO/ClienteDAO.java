/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesDAO;

import ClassesJavaBean.Cliente;
import ConexaoBD.ConexaoJDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
*
* @author gusta
*/

public class ClienteDAO {

    public ClienteDAO() {

    }

    public int cadastra(Cliente dado) throws SQLException {
        //Elementos para a conexão e verificação
        ConexaoJDBC conexao = new ConexaoJDBC();
        int status = 0;

        //declarações do preparedStatement
        try (
                Connection conn = conexao.obterConexaoBD();
                PreparedStatement stmt = conn.prepareStatement("insert into usuario(nome,genero,cpf,"
                        + "email,senha,nascimento,concordar,newslatter,id_cartao,id_favorito,tipo_usuario)"
                        + " values(?,?,?,?,?,?,?,?,?,?,?);");) {
            //passa os parametros
            stmt.setString(1, dado.getNome());
            stmt.setString(2, dado.getGenero());
            stmt.setString(3, dado.getCpf());
            stmt.setString(4, dado.getEmail());
            stmt.setString(5, dado.getSenha());
            stmt.setString(6, dado.getData_nascimento());
            stmt.setString(7, dado.getConcorda());
            stmt.setString(8, dado.getConcorda_newstalleter());
            stmt.setInt(9, dado.getNum_cartao());
            stmt.setInt(10, dado.getId_favoritado());
            stmt.setInt(11, dado.getTipo_user());
            //Executa a Query
            
            status = stmt.executeUpdate();            
        }catch(SQLException e){
            System.out.println(e);
        }
        return status;       
    }
}
/*Mais Metodos serao atribuidos nesta classe, apenas precisam 
ser mais trabalhados e revisados*/
