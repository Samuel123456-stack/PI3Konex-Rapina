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

/**
 *
 * @author Gabriel
 */
public class NotificaDAO {
    public int solicitaExclusao(Notification dados) throws SQLException{
        //var de retorno
        int deuCerto=0;
        
        //Crio a conexao com o bd
        ConexaoJDBC conexao = new ConexaoJDBC();
        
        try (
            Connection conn = conexao.obterConexaoBD();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO  notificacao (mensagem, data_noti, id_usuario, id_esta) values (?,?,?,?)");) {
            
            //passa o parametro recebido para o STMT usando o dado.get(atributo)
            stmt.setString(1, dados.getMensagem());
            stmt.setString(2, dados.getData());
            stmt.setInt(3, dados.getId_user());
            stmt.setInt(4, dados.getId_estabelecimento());
            stmt.executeUpdate();
            deuCerto=1;
        }
        return deuCerto;
    }
}