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
import java.sql.SQLException;

/**
 *
 * @author gusta
 */
public class EstabelecimentoDAO {
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
    /*Mais Metodos serão atribuidos nesta classe, apenas precisam serem mais 
    trabalhados e revisados*/
}
