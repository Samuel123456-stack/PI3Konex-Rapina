/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesDAO;


import ClassesJavaBean.Cartao;
import ClassesJavaBean.Estabelecimento;
import ConexaoBD.ConexaoJDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
                    PreparedStatement stmt = conn.prepareStatement("insert into estabelecimento(nome_esta,cnpj,email,senha,capacidade,endereco,cep,numero,celular,horario_de_fun,disponibilidade,taxa_cancelamento,concordar,newslatter,def_aud,def_fis,tipo_usuario) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);) {
                //passa os parametros
                stmt.setString(1, dado.getNome_estabelecimento());
                stmt.setString(2, dado.getCnpj());
                stmt.setString(3, dado.getEmail());
                stmt.setString(4, dado.getSenha());
                stmt.setInt(5, dado.getCapacidade());
                stmt.setString(6, dado.getLogadouro_estabelecimento());
                stmt.setString(7, dado.getCep_estabelecimento());
                stmt.setInt(8, dado.getNumero());
                stmt.setString(9, dado.getCelular());
                stmt.setString(10, dado.getHorario_funcionamento());
                stmt.setString(11, dado.getDisponibilidade());
                stmt.setFloat(12, dado.getTaxa_cancelamento());
                stmt.setString(13, dado.getConcorda());
                stmt.setString(14, dado.getConcorda_newstalleter());
                stmt.setString(15, dado.getAcessi_auditiva());
                stmt.setString(16, dado.getAcessi_fisico());
                stmt.setInt(17, dado.getTipo_user());
                //Executa a Query
                cadastrado = stmt.executeUpdate();
                //Pega o id inserido no bd da tabela estabelecimento
                ResultSet rs = stmt.getGeneratedKeys();
                int id = 0;
                if (rs.next()) {
                    id = rs.getInt(1);
                }
                dado.setId_estabelecimento(id);
                cadastrado = 1;
                return cadastrado;
            } catch (SQLException e) {
                System.out.println(e);
            }

        }
        return cadastrado;
    }

    public int atualiazaEst(Estabelecimento dado) throws SQLException {
        //Atualiza o Estabelecimento 
        //Elementos para a conexão e verificação
        ConexaoJDBC conexao = new ConexaoJDBC();
        //var verificadora
        int atualiza = 0;
        //declarações do prepareStatement
        try (
                Connection conn = conexao.obterConexaoBD();
                PreparedStatement stmt = conn.prepareStatement("update estabelecimento set nome_esta=?,email=?, senha=?, capacidade=?, endereco=?, cep=?, numero=?, celular=?, horario_de_fun=?,taxa_cancelamento=?,concordar=?,def_aud=?, def_fis=? where id_esta=?");) {
            //passa os parametros
            stmt.setString(1, dado.getNome_estabelecimento());
            stmt.setString(2, dado.getEmail());
            stmt.setString(3, dado.getSenha());
            stmt.setInt(4, dado.getCapacidade());
            stmt.setString(5, dado.getLogadouro_estabelecimento());
            stmt.setString(6, dado.getCep_estabelecimento());
            stmt.setInt(7, dado.getNumero());
            stmt.setString(8, dado.getCelular());
            stmt.setString(9, dado.getHorario_funcionamento());
            stmt.setFloat(10, dado.getTaxa_cancelamento());
            stmt.setString(11, dado.getConcorda());
            stmt.setString(12, dado.getAcessi_auditiva());
            stmt.setString(13, dado.getAcessi_fisico());
            stmt.setInt(14, dado.getId_estabelecimento());
            stmt.executeUpdate();
            
            atualiza= 1;
        }catch(SQLException e){
            System.out.println(e);
        }
        return atualiza;

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
    public int cadastraCartaoEsta(Cartao dadoCartao) throws SQLException {
        //Cadastra o Cartao do Estabelecimento
        //Elementos para a conexão e verificação
        ConexaoJDBC conexao = new ConexaoJDBC();
        Estabelecimento esta = new Estabelecimento();
        int a = 0;
        try (
                Connection conn = conexao.obterConexaoBD();
                PreparedStatement stmt = conn.prepareStatement("insert into cartao(num_cartao,validade"
                        + ",cvv,titular) values(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);) {

            //passa os parametros do cartao
            stmt.setLong(1, dadoCartao.getNum_cartao());
            stmt.setString(2, dadoCartao.getValidade());
            stmt.setLong(3, dadoCartao.getCvv());
            stmt.setString(4, dadoCartao.getTitular());

            //Executa a Query
            stmt.executeUpdate();
            //Pega o ultimo id do cartao
            ResultSet rs = stmt.getGeneratedKeys();
            int idCartaoEsta = 0;
            if (rs.next()) {
                idCartaoEsta = rs.getInt(1);

            }
            dadoCartao.setId_card(idCartaoEsta);
            esta.setId_cartao(idCartaoEsta);
            a = 1;
            return a;
        } catch (SQLException e) {
            System.out.println(e);

        }
        return a;
    }
    public void vinculaCartaoEsta(Cartao dado, int esta) throws SQLException {
        //Vincula cartão com o ultimo estabelecimento
        //Elementos para a conexão e verificação
        ConexaoJDBC conexao = new ConexaoJDBC();
        String sql = "update estabelecimento set id_cartao= (?) where id_esta= (?)";
        try (
                Connection conn = conexao.obterConexaoBD();
                PreparedStatement stmt2 = conn.prepareStatement(sql)) {

            //Setando Parametros
            stmt2.setInt(1, dado.getId_card());
            stmt2.setInt(2, esta);
            stmt2.executeUpdate();
        }
    }
    public void atualizaCartaoEsta(Cartao dado) throws SQLException {
        //Elementos para a conexão e verificação
        ConexaoJDBC conexao = new ConexaoJDBC();
        
        //var verificador

        //declarações do preparedStatement
        try (
                Connection conn = conexao.obterConexaoBD();
                PreparedStatement stmt = conn.prepareStatement("update cartao "
                        + "set num_cartao= ?, validade= ?, cvv= ?, titular= ? where id_cartao= ?");) {
            
            //Executa a Query
            stmt.setLong(1, dado.getNum_cartao());
            stmt.setString(2, dado.getValidade());
            stmt.setLong(3, dado.getCvv());
            stmt.setString(4, dado.getTitular());
            stmt.setInt(5, dado.getId_card());
            
            //executa
            stmt.executeUpdate();
            
            //novo valor de A

        } catch (SQLException e) {
            System.out.println(e);

        }
    }
    
    public int verificaSenha(Estabelecimento dado){
        int verifica = 0;
       
        //Elementos para a conexão e verificação
        ConexaoJDBC conexao = new ConexaoJDBC();
        
        //verifica a senha
        try {
            Connection conn = conexao.obterConexaoBD();
            PreparedStatement stmt = conn.prepareStatement("select * from estabelecimento where id_esta = ?");
            
            stmt.setInt(1, dado.getId_estabelecimento());
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                String senha = rs.getString("senha");
                
                if(senha.equals(dado.getSenha())){
                    verifica = 1;
                   
                }else{
                    verifica = -1;
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return verifica;        
    }
}

    /*Mais Metodos serão atribuidos nesta classe, apenas precisam serem mais 
    trabalhados e revisados*/

