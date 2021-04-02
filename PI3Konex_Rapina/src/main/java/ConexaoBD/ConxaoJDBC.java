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
public class ConxaoJDBC {
    public Connection obterConexaoBD() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            throw new SQLException("Driver do MySQL não encontrado", ex);
        }
        // o "exemplojdbc" é um exemplo de banco devemos muda-lo quando o db estiver pronto
        Connection conexao = DriverManager.getConnection("jdbc:mysql://local"
                + "host:3306/exemplojdbc?useUnicode=yes&"
                + "characterEncoding=UTF-8&useTimezone=America/Sao_Paulo", "root", "");
        return conexao;

    }
}
