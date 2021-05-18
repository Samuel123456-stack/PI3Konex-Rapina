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
            PreparedStatement stmt = conn.prepareStatement("Select*from reserva where num_reserva = ?");
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

    public void remove(int valor) throws SQLException {
        //Elementos para a conexão e verificação
        ConexaoJDBC conexao = new ConexaoJDBC();

        //declarações do preparedStatement
        try (
                 Connection conn = conexao.obterConexaoBD();  PreparedStatement stmt = conn.prepareStatement("delete from "
                + "reserva where num_resrva= ?");) {
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
}
