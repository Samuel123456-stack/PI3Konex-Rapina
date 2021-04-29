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

    ArrayList<Estabelecimento> lista = new ArrayList<>();

    public EstabelecimentoDAO() {

    }

    public int consultaCNPJ(Estabelecimento dado) {
        //Consulta se o CNPJ informado já existe no bd
        ConexaoJDBC conexao = new ConexaoJDBC();
        int verifica = 0;
        try {
            Connection conn = conexao.obterConexaoBD();
            PreparedStatement stmt = conn.prepareStatement("Select*from estabelecimento where cnpj = ?");
            stmt.setString(1, dado.getCnpj());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                verifica = 1;
                return verifica;
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return verifica;
    }

    public int cadastraEst(Estabelecimento dado) throws SQLException {
        //Cadastra o Estabelecimento
        int cadastrado = 0;
        int verifica = consultaCNPJ(dado);
        if (verifica == 1) {
            cadastrado = -1;
            return cadastrado;
        } else if (verifica == 0) {
            //Elementos para a conexão e verificação
            ConexaoJDBC conexao = new ConexaoJDBC();

            //declarações do prepareStatement
            try (
                    Connection conn = conexao.obterConexaoBD();
                    PreparedStatement stmt = conn.prepareStatement("insert into"
                            + " estabelecimento(nome_esta,cnpj,email,senha,"
                            + "capacidade,endereco,cep,numero,horario_de_fun,"
                            + "disponibilidade,taxa_cancelamento,concordar,"
                            + "newslatter,def_aud,def_fis,tipo_usuario,id_planos)"
                            + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");) {
                //passa os parametros
                stmt.setString(1, dado.getNome_estabelecimento());
                stmt.setString(2, dado.getCnpj());
                stmt.setString(3, dado.getEmail());
                stmt.setString(4, dado.getSenha());
                stmt.setInt(5, dado.getCapacidade());
                stmt.setString(6, dado.getLogadouro_estabelecimento());
                stmt.setString(7, dado.getCep_estabelecimento());
                stmt.setInt(8, dado.getNumero());
                stmt.setString(9, dado.getHorario_funcionamento());
                stmt.setString(10, dado.getDisponibilidade());
                stmt.setFloat(11, dado.getTaxa_cancelamento());
                stmt.setString(12, dado.getConcorda());
                stmt.setString(13, dado.getConcorda_newstalleter());
                stmt.setString(14, dado.getAcessi_auditiva());
                stmt.setString(15, dado.getAcessi_fisico());
                stmt.setInt(16, dado.getTipo_user());
                stmt.setInt(17, dado.getId_planos());
                //Executa a Query
                cadastrado = stmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e);
            }

        }
        return cadastrado;
    }

    public void atualiazaEst(Estabelecimento dado) throws SQLException {
        //Atualiza o Estabelecimento 
        //Elementos para a conexão e verificação
        ConexaoJDBC conexao = new ConexaoJDBC();

        //declarações do prepareStatement
        try (
                Connection conn = conexao.obterConexaoBD();
                PreparedStatement stmt = conn.prepareStatement("update estabelecimento set"
                        + "nome_esta=?, cnpj=?, email=?, senha=?"
                        + ", capacidade=?, endereco=?, cep=?, "
                        + "numero=?, horario_de_fun=?, disponibilidade=?,"
                        + "taxa_cancelamento=?,concordar=?,newstalleter=?,def_aud=?, def_fis=?"
                        + ",id_planos=? where id_esta=?");) {
            //passa os parametros
            stmt.setString(1, dado.getNome_estabelecimento());
            stmt.setString(2, dado.getCnpj());
            stmt.setString(3, dado.getCep_estabelecimento());
            stmt.setString(4, dado.getLogadouro_estabelecimento());
            stmt.setInt(5, dado.getNumero());
            stmt.setString(6, dado.getAcessi_auditiva());
            stmt.setString(7, dado.getAcessi_fisico());
            stmt.setString(8, dado.getAcessi_nenhuma());
            stmt.setString(9, dado.getHorario_funcionamento());
            stmt.setInt(10, dado.getCapacidade());
            stmt.setFloat(11, dado.getTaxa_cancelamento());
            stmt.setString(12, dado.getEmail());
            stmt.setString(13, dado.getSenha());
            stmt.setString(14, dado.getConcorda());
            stmt.setString(15, dado.getConcorda_newstalleter());
            stmt.setString(16, dado.getDisponibilidade());
            stmt.setInt(17, dado.getId_planos());
            stmt.setInt(18, dado.getId_estabelecimento());
        }

    }

    public void remove(int valor) throws SQLException {
        //Remover o Estabelecimento por ID
        //Elementos para a conexão e verificação
        ConexaoJDBC conexao = new ConexaoJDBC();

        //declarações do preparedStatement
        try (
                Connection conn = conexao.obterConexaoBD();
                PreparedStatement stmt = conn.prepareStatement("delete from "
                        + "estabelecimento where id_esta= ?");) {
            //Executa a Query
            stmt.setInt(1, valor);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public List<Estabelecimento> listarTodos() throws SQLException {
        //Lista os Estabelecimento
        ConexaoJDBC conexao = new ConexaoJDBC();
        try {
            Connection conn = conexao.obterConexaoBD();
            PreparedStatement stmt = conn.prepareStatement("select*from estabelecimento;");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Estabelecimento esta = new Estabelecimento();
                esta.setId_estabelecimento(rs.getInt("id_esta"));
                esta.setNome_estabelecimento(rs.getString("nome_esta"));
                esta.setCnpj(rs.getString("cnpj"));
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
                esta.setConcorda(rs.getString("concordar"));
                esta.setConcorda_newstalleter(rs.getString("newslatter"));
                esta.setDisponibilidade(rs.getString("disponibilidade"));
                esta.setId_planos(rs.getInt("id_planos"));
                esta.setTipo_user(rs.getInt("tipo_usuario"));
                lista.add(esta);
            }

        } catch (SQLException erro) {
            System.out.println(erro);
        }
        return lista;
    }

    public Estabelecimento estaPorID(int estaID) throws SQLException {
        //Pega um Estabelecimento pelo ID
        Estabelecimento esta = new Estabelecimento();
        ConexaoJDBC conexao = new ConexaoJDBC();
        try {
            Connection conn = conexao.obterConexaoBD();
            PreparedStatement stmt = conn.prepareStatement("select * from estabelecimento where id_esta=?;");
            stmt.setInt(1, estaID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                esta.setId_estabelecimento(rs.getInt("id_esta"));
                esta.setNome_estabelecimento(rs.getString("nome_esta"));
                esta.setCnpj(rs.getString("cnpj"));
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
                esta.setConcorda(rs.getString("concordar"));
                esta.setConcorda_newstalleter(rs.getString("newslatter"));
                esta.setDisponibilidade(rs.getString("disponibilidade"));
                esta.setId_planos(rs.getInt("id_planos"));
                esta.setTipo_user(rs.getInt("tipo_usuario"));

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return esta;
    }
}

    /*Mais Metodos serão atribuidos nesta classe, apenas precisam serem mais 
    trabalhados e revisados*/

