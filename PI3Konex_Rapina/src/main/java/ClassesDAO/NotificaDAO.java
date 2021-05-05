/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesDAO;

import ClassesJavaBean.Notification;
import ConexaoBD.ConexaoJDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gabriel
 */
public class NotificaDAO {

    ArrayList<Notification> lista = new ArrayList<>();

    public int solicitaExclusao(Notification dados) throws SQLException {
        //var de retorno
        int deuCerto = 0;

        //Crio a conexao com o bd
        ConexaoJDBC conexao = new ConexaoJDBC();

        try (
                Connection conn = conexao.obterConexaoBD();
                PreparedStatement stmt = conn.prepareStatement("INSERT INTO  notificacao (mensagem, data_noti, id_usuario) values (?,?,?)");) {

            //passa o parametro recebido para o STMT usando o dado.get(atributo)
            stmt.setString(1, dados.getMensagem());
            stmt.setString(2, dados.getData());
            stmt.setInt(3, dados.getId_user());
            stmt.executeUpdate();
            deuCerto = 1;
        }
        return deuCerto;
    }

    public int solicitaExclusaoEsta(Notification dados) throws SQLException {
        //var de retorno
        int deuCerto = 0;

        //Crio a conexao com o bd
        ConexaoJDBC conexao = new ConexaoJDBC();

        try (
                Connection conn = conexao.obterConexaoBD();
                PreparedStatement stmt = conn.prepareStatement("INSERT INTO  notificacao (mensagem, data_noti, id_esta) values (?,?,?)");) {

            //passa o parametro recebido para o STMT usando o dado.get(atributo)
            stmt.setString(1, dados.getMensagem());
            stmt.setString(2, dados.getData());
            stmt.setInt(3, dados.getId_estabelecimento());
            stmt.executeUpdate();
            deuCerto = 1;
        }
        return deuCerto;
    }

    public void removeNoti(int valor) throws SQLException {
        //Elementos para a conexão e verificação
        ConexaoJDBC conexao = new ConexaoJDBC();

        //declarações do preparedStatement
        try (
                Connection conn = conexao.obterConexaoBD();
                PreparedStatement stmt = conn.prepareStatement("delete from "
                        + "notificacao where id_noti= ?");) {
            //Executa a Query
            stmt.setInt(1, valor);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public ArrayList<Notification> listarCli() throws SQLException {
        //Lista as Notificacaoes
        ConexaoJDBC conexao = new ConexaoJDBC();
        try {
            Connection conn = conexao.obterConexaoBD();
            PreparedStatement stmt = conn.prepareStatement("select n.id_noti, n.id_usuario, n.mensagem, n.data_noti, l.nome from notificacao as n join login as l on n.id_usuario=l.id_usuario");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Notification not = new Notification();
                not.setId_notification(rs.getInt("id_noti"));
                not.setNome_noti(rs.getString("nome"));
                not.setId_user(rs.getInt("id_usuario"));
                not.setMensagem(rs.getString("mensagem"));
                not.setData(rs.getString("data_noti"));
                lista.add(not);
            }

        } catch (SQLException erro) {
            System.out.println(erro);
        }
        return lista;
    }

    public ArrayList<Notification> listarCliPorID(int valor) throws SQLException {
        //Lista a Notificação do Usuario por ID
        ConexaoJDBC conexao = new ConexaoJDBC();
        try {
            Connection conn = conexao.obterConexaoBD();
            PreparedStatement stmt = conn.prepareStatement("select n.id_noti, n.id_usuario, n.mensagem, n.data_noti, l.nome from notificacao as n join login as l on n.id_usuario=l.id_usuario where id_noti=?");
            stmt.setInt(1, valor);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Notification not = new Notification();
                not.setId_notification(rs.getInt("id_noti"));
                not.setNome_noti(rs.getString("nome"));
                not.setId_user(rs.getInt("id_usuario"));
                not.setMensagem(rs.getString("mensagem"));
                not.setData(rs.getString("data_noti"));
                lista.add(not);
            }

        } catch (SQLException erro) {
            System.out.println(erro);
        }
        return lista;
    }

    public ArrayList<Notification> listarEstaPorID(int valor) throws SQLException {
        //Lista a Notificação do Cliente por ID
        ConexaoJDBC conexao = new ConexaoJDBC();
        try {
            Connection conn = conexao.obterConexaoBD();
            PreparedStatement stmt = conn.prepareStatement("select n.id_noti, n.id_esta, n.mensagem, n.data_noti, l.nome from notificacao as n join login as l on n.id_esta=l.id_esta where id_noti=?");
            stmt.setInt(1, valor);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Notification not = new Notification();
                not.setId_notification(rs.getInt("id_noti"));
                not.setNome_noti(rs.getString("nome"));
                not.setId_estabelecimento(rs.getInt("id_esta"));
                not.setMensagem(rs.getString("mensagem"));
                not.setData(rs.getString("data_noti"));
                lista.add(not);
            }

        } catch (SQLException erro) {
            System.out.println(erro);
        }
        return lista;
    }

    public ArrayList<Notification> listarEsta() throws SQLException {
        //Lista as Notificacaoes
        ConexaoJDBC conexao = new ConexaoJDBC();
        try {
            Connection conn = conexao.obterConexaoBD();
            PreparedStatement stmt = conn.prepareStatement("select n.id_noti, n.id_esta, n.mensagem, n.data_noti, l.nome from notificacao as n join login as l on n.id_esta=l.id_esta");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Notification not = new Notification();
                not.setId_notification(rs.getInt("id_noti"));
                not.setNome_noti(rs.getString("nome"));
                not.setId_estabelecimento(rs.getInt("id_esta"));
                not.setMensagem(rs.getString("mensagem"));
                not.setData(rs.getString("data_noti"));
                lista.add(not);
            }

        } catch (SQLException erro) {
            System.out.println(erro);
        }
        return lista;
    }
}