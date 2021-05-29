/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesDAO;

import ClassesJavaBean.Reserva;
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
public class ReservaDAO {
    
    ArrayList<Reserva> lista = new ArrayList<>();

    public int ConsultaReserva(int dado) {
        //Consulta se o CPF é igual
        ConexaoJDBC conexao = new ConexaoJDBC();
        int verifica = 0;
        try {
            Connection conn = conexao.obterConexaoBD();
            PreparedStatement stmt = conn.prepareStatement("Select*from reserva where num_reserva = ? and reserva_status='Ativa'" );
            stmt.setInt(1, dado);
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

    public void atualizaStatus(int valor) throws SQLException {
        //Elementos para a conexão e verificação
        ConexaoJDBC conexao = new ConexaoJDBC();

        //declarações do preparedStatement
        try (
                 Connection conn = conexao.obterConexaoBD();  PreparedStatement stmt = conn.prepareStatement("update reserva set reserva_status='Validada' where num_reserva=?");) {
            //Executa a Query
            stmt.setInt(1, valor);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public List<Reserva> listarDadosReserva(int id) throws SQLException {
        //Lista as Reservas
        ConexaoJDBC conexao = new ConexaoJDBC();
        try {
            Connection conn = conexao.obterConexaoBD();
            PreparedStatement stmt = conn.prepareStatement("select r.reserva_status, r.quant_pessoas, r.data_reserva, r.hora_reserva, l.nome from reserva as r join login as l on r.id_usuario=l.id_usuario where num_reserva=?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Reserva res = new Reserva();

                //Status
                res.setReserva_status(rs.getString("reserva_status"));
                //Nome
                res.setNome_reservado(rs.getString("nome"));
                //Pessoas
                res.setQtd_acompanhantes(rs.getInt("quant_pessoas"));
                //Data reservada
                res.setData_reservada(rs.getString("data_reserva"));
                //Horario reservado
                res.setHorario_reservado(rs.getString("hora_reserva"));

                lista.add(res);
            }

        } catch (SQLException erro) {
            System.out.println(erro);
        }
        return lista;
    }
    
    public List<Reserva> listarReservaCli(int id) throws SQLException {
        //Lista as Reservas
        ConexaoJDBC conexao = new ConexaoJDBC();
        try {
            Connection conn = conexao.obterConexaoBD();
            PreparedStatement stmt = conn.prepareStatement("select r.num_reserva, r.quant_pessoas, r.id_esta, r.data_reserva, r.hora_reserva, l.nome_esta, l.endereco, l.cep, l.numero, l.celular, l.taxa_cancelamento from reserva as r join estabelecimento as l on r.id_esta=l.id_esta where r.id_usuario=? && r.reserva_status='ativa' order by r.data_reserva desc;");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Reserva res = new Reserva();

                //num reserva
                res.setNum_reserva(rs.getInt("num_reserva"));
                
                //qtd de acompanhates
                res.setQtd_acompanhantes(rs.getInt("quant_pessoas"));
                
                //id do estabelecimento
                res.setId_estabelecimento(rs.getInt("id_esta"));
                
                //data reservada
                res.setData_reservada(rs.getString("data_reserva"));
                
                //horario reservado
                res.setHorario_reservado(rs.getString("hora_reserva"));
                
                //nome do estabelecimento
                res.setNome_Restaurante(rs.getString("nome_esta"));
                
                //endereço
                res.setEndereco(rs.getString("nome_esta"));
                
                //cep
                res.setCep(rs.getString("cep"));
                
                //numero
                res.setNumero(rs.getInt("numero"));
                
                //celular estabelecimento
                res.setContato_Rest(rs.getString("celular"));
                
                //valor da taxa
                res.setValor_taxa(rs.getFloat("taxa_cancelamento"));
                
                lista.add(res);
            }

        } catch (SQLException erro) {
            System.out.println(erro);
        }
        return lista;
    }
    public void cancelaReserva(int valor) throws SQLException {
        //Elementos para a conexão e verificação
        ConexaoJDBC conexao = new ConexaoJDBC();

        //declarações do preparedStatement
        try (
            Connection conn = conexao.obterConexaoBD();
            PreparedStatement stmt = conn.prepareStatement("UPDATE reserva SET reserva_status = 'Cancelada' WHERE num_reserva =?");) {
            
            //Executa a Query
            stmt.setInt(1, valor);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }      
}
