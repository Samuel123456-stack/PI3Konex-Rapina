/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexaoBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author gusta
 */
public class ConexaoJDBC {
    public Connection obterConexaoBD() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            throw new SQLException("Driver do MySQL não encontrado", ex);
        }
        // o "bd_test_rapina" será usado para testes, mudar o nome após todos os testes feitos
        Connection conexao = DriverManager.getConnection("jdbc:mysql://local"
                + "host:3306/bd_test_rapina?useUnicode=yes&"
                + "characterEncoding=UTF-8&useTimezone=America/Sao_Paulo", "root", "");
        return conexao;

    }
}
