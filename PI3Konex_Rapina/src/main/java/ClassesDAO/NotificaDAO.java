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

    public List<Notification> listarTodos() throws SQLException {
        //Lista as Notificacao
        ConexaoJDBC conexao = new ConexaoJDBC();
        try {
            Connection conn = conexao.obterConexaoBD();
            PreparedStatement stmt = conn.prepareStatement("select * from notificacao inner join usuario on notificacao.id_usuario = usuario.id_usuario");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Notification not = new Notification();
                not.setNome_noti(rs.getString("nome"));
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
