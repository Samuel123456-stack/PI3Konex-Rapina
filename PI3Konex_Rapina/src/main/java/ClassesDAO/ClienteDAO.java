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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
*
* @author gusta
*/

public class ClienteDAO {
ArrayList<Cliente> listaCli = new ArrayList<>();
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
    public void atualiza(Cliente dado) throws SQLException {
        //Elementos para a conexão e verificação
        ConexaoJDBC conexao = new ConexaoJDBC();

        //declarações do preparedStatement
        try (
                Connection conn = conexao.obterConexaoBD();
                PreparedStatement stmt = conn.prepareStatement("update usuario "
                        + "set nome=?,genero=?,cpf=?,nascimento=?,concordar=?,"
                        + "newslatter=?,id_cartao=?,id_favorito=?,tipo_usuario=? "
                        + "where id_usuario=?");) {
            //Executa a Query
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
            stmt.setInt(12, dado.getId_usuario());
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void remove(int valor) throws SQLException {
        //Elementos para a conexão e verificação
        ConexaoJDBC conexao = new ConexaoJDBC();

        //declarações do preparedStatement
        try (
                Connection conn = conexao.obterConexaoBD();
                PreparedStatement stmt = conn.prepareStatement("delete from "
                        + "usuario where id_usuario= ?");) {
            //Executa a Query
            stmt.setInt(1,valor);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public List<Cliente> listarTodos() throws SQLException {

        ConexaoJDBC conexao = new ConexaoJDBC();
        
        try {
            Connection conn = conexao.obterConexaoBD();
            PreparedStatement stmt = conn.prepareStatement("select*from usuario;");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId_usuario(rs.getInt("id_usuario"));
                cliente.setNome(rs.getString("nome"));
                cliente.setGenero(rs.getString("genero"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setEmail(rs.getString("email"));
                cliente.setSenha(rs.getString("senha"));
                cliente.setData_nascimento(rs.getString("nascimento"));
                cliente.setConcorda(rs.getString("concordar"));
                cliente.setConcorda_newstalleter(rs.getString("newslatter"));
                cliente.setNum_cartao(rs.getInt("id_cartao"));
                cliente.setId_favoritado(rs.getInt("id_favorito"));
                cliente.setTipo_user(rs.getInt("tipo_usuario"));
                listaCli.add(cliente);
            }

        } catch (SQLException erro) {
            System.out.println(erro);
        }
        return listaCli;
    }

    public Cliente cliPorID(int cliID) throws SQLException {
        Cliente cli = new Cliente();
        ConexaoJDBC conexao = new ConexaoJDBC();
        
        try {
            Connection conn = conexao.obterConexaoBD();
            PreparedStatement stmt = conn.prepareStatement("select * from usuario where id_usuario=?;");
            stmt.setInt(1, cliID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                cli.setId_usuario(rs.getInt("id_usuario"));
                cli.setNome(rs.getString("nome"));
                cli.setGenero(rs.getString("genero"));
                cli.setCpf(rs.getString("cpf"));
                cli.setEmail(rs.getString("email"));
                cli.setSenha(rs.getString("senha"));
                cli.setData_nascimento(rs.getString("nascimento"));
                cli.setConcorda(rs.getString("concordar"));
                cli.setConcorda_newstalleter(rs.getString("newslatter"));
                cli.setNum_cartao(rs.getInt("id_cartao"));
                cli.setId_favoritado(rs.getInt("id_favorito"));
                cli.setTipo_user(rs.getInt("tipo_usuario"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return cli;
    }
}
/*Mais Metodos serao atribuidos nesta classe, apenas precisam 
ser mais trabalhados e revisados*/
