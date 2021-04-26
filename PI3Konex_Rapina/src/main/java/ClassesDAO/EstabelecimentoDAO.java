/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesDAO;

import ClassesJavaBean.Estabelecimento;
import ConexaoBD.ConexaoJDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gusta
 */
public class EstabelecimentoDAO {
    ArrayList<Estabelecimento> listaEsta = new ArrayList<>();
     public EstabelecimentoDAO(){
        
    }
    
    public int cadastraEst(Estabelecimento dado) throws SQLException{
        //Elementos para a conexão e verificação
        ConexaoJDBC conexao = new ConexaoJDBC();
        int cadastrado = 0;

        //declarações do prepareStatement
        try (
                Connection conn = conexao.obterConexaoBD();
                PreparedStatement stmt = conn.prepareStatement("insert into"
                        + " estabelecimento(nome_esta,cnpj,email,senha,"
                        + "capacidade,endereco,cep,numero,horario_de_fun,"
                        + "disponibilidade,taxa_cancelamento,concordar,"
                        + "newslatter,def_aud,def_fis,tipo_usuario,id_planos)"
                        + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");) {
            //passa os parametros
            stmt.setString(1, dado.getNome_estabelecimento());
            stmt.setString(2, dado.getCpnj());
            stmt.setString(3, dado.getEmail());
            stmt.setString(4, dado.getSenha());
            stmt.setInt(5, dado.getCapacidade());
            stmt.setString(6, dado.getLogadouro_estabelecimento());
            stmt.setString(7, dado.getCep_estabelecimento());
            stmt.setInt(8, dado.getNumero());
            stmt.setString(9, dado.getHorario_funcionamento());
            stmt.setBoolean(10, dado.isDisponibilidade());
            stmt.setFloat(11,dado.getTaxa_cancelamento());
            stmt.setString(12, dado.getConcorda());
            stmt.setString(13, dado.getConcorda_newstalleter());
            stmt.setString(14, dado.getAcessi_auditiva());
            stmt.setString(15, dado.getAcessi_fisico());
            stmt.setInt(16, dado.getTipo_user());
            stmt.setInt(17, dado.getId_planos());
            //Executa a Query
            cadastrado = stmt.executeUpdate();
            }catch(SQLException e){
                System.out.println(e);
        }
        return cadastrado;
    }
    public void atualiazaEst(Estabelecimento dado) throws SQLException{
        //Elementos para a conexão e verificação
        ConexaoJDBC conexao = new ConexaoJDBC();

        //declarações do prepareStatement
        try (
                Connection conn = conexao.obterConexaoBD();
                PreparedStatement stmt = conn.prepareStatement("update estabelecimento set"
                        + "nome_estabelecimento=?, cpnj=?, email=?, senha=?"
                        + ", capacidade=?, endereco=?, cep=?, "
                        + "numero=?, horario_de_fun=?, disponibilidade=?,"
                        + "taxa_cancelamento=?,concorda=?,newstalleter=?,def_aud=?, def_fis=?"
                        + "tipo_usuario=?,id_planos=? where id_esta=?");) {
            //passa os parametros
            stmt.setString(1, dado.getNome_estabelecimento());
            stmt.setString(2, dado.getCpnj());
            stmt.setString(3, dado.getCep_estabelecimento());
            stmt.setString(4, dado.getLogadouro_estabelecimento());
            stmt.setInt(5, dado.getNumero());
            stmt.setString(6, dado.getAcessi_auditiva());
            stmt.setString(7, dado.getAcessi_fisico());
            stmt.setString(8, dado.getHorario_funcionamento());
            stmt.setInt(9, dado.getCapacidade());
            stmt.setFloat(10,dado.getTaxa_cancelamento());
            stmt.setString(11, dado.getEmail());
            stmt.setString(12, dado.getSenha());
            stmt.setString(13, dado.getConcorda());
            stmt.setString(14, dado.getConcorda_newstalleter());
            stmt.setBoolean(15, dado.isDisponibilidade());
            stmt.setInt(16, dado.getId_planos());
            stmt.setInt(17, dado.getId_estabelecimento());
    }
    
}
    public void remove(int valor) throws SQLException {
        //Elementos para a conexão e verificação
        ConexaoJDBC conexao = new ConexaoJDBC();

        //declarações do preparedStatement
        try (
                Connection conn = conexao.obterConexaoBD();
                PreparedStatement stmt = conn.prepareStatement("delete from "
                        + "estabelecimento where id_esta= ?");) {
            //Executa a Query
            stmt.setInt(1,valor);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public List<Estabelecimento> listarTodos() throws SQLException {

        ConexaoJDBC conexao = new ConexaoJDBC();
        
        try {
            Connection conn = conexao.obterConexaoBD();
            PreparedStatement stmt = conn.prepareStatement("select*from estabelecimento;");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Estabelecimento esta = new Estabelecimento();
                esta.setId_estabelecimento(rs.getInt("id_esta"));
                esta.setNome_estabelecimento(rs.getString("nome"));
                esta.setCpnj(rs.getString("cnpj"));
                esta.setCep_estabelecimento(rs.getString("cep"));
                esta.setLogadouro_estabelecimento(rs.getString("endereco"));
                esta.setNumero(rs.getInt("numero"));
                esta.setAcessi_auditiva(rs.getString("def_aud"));
                esta.setAcessi_fisico(rs.getString("def_fis"));
                esta.setHorario_funcionamento(rs.getString("horario_de_fun"));
                esta.setCapacidade(rs.getInt("capacidade"));
                esta.setTaxa_cancelamento(rs.getFloat("taxa_cancelamento"));
                esta.setEmail(rs.getString("email"));
                esta.setSenha(rs.getString("senha"));
                esta.setConcorda(rs.getString("concorda"));
                esta.setConcorda_newstalleter(rs.getString("newstalleter"));
                esta.setTipo_user(rs.getInt("tipo_usuario"));
                esta.setId_planos(rs.getInt("id_planos"));
                listaEsta.add(esta);
            }

        } catch (SQLException erro) {
            System.out.println(erro);
        }
        return listaEsta;
    }

    public Estabelecimento estaPorID(int estaID) throws SQLException {
        Estabelecimento esta = new Estabelecimento();
        ConexaoJDBC conexao = new ConexaoJDBC();
        
        try {
            Connection conn = conexao.obterConexaoBD();
            PreparedStatement stmt = conn.prepareStatement("select * from usuario where id_usuario=?;");
            stmt.setInt(1, estaID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                esta.setId_estabelecimento(rs.getInt("id_esta"));
                esta.setNome_estabelecimento(rs.getString("nome"));
                esta.setCpnj(rs.getString("cnpj"));
                esta.setCep_estabelecimento(rs.getString("cep"));
                esta.setLogadouro_estabelecimento(rs.getString("endereco"));
                esta.setNumero(rs.getInt("numero"));
                esta.setAcessi_auditiva(rs.getString("def_aud"));
                esta.setAcessi_fisico(rs.getString("def_fis"));
                esta.setHorario_funcionamento(rs.getString("horario_de_fun"));
                esta.setCapacidade(rs.getInt("capacidade"));
                esta.setTaxa_cancelamento(rs.getFloat("taxa_cancelamento"));
                esta.setEmail(rs.getString("email"));
                esta.setSenha(rs.getString("senha"));
                esta.setConcorda(rs.getString("concorda"));
                esta.setConcorda_newstalleter(rs.getString("newstalleter"));
                esta.setTipo_user(rs.getInt("tipo_usuario"));
                esta.setId_planos(rs.getInt("id_planos"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return esta;
    }
    /*Mais Metodos serão atribuidos nesta classe, apenas precisam serem mais 
    trabalhados e revisados*/
}
