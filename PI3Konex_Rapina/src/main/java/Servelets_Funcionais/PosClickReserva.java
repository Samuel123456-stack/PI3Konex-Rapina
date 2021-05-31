/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets_Funcionais;

import ClassesDAO.ClienteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gabriel
 */
@WebServlet(name = "PosClickReserva", urlPatterns = {"/PosClickReserva"})
public class PosClickReserva extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //boas praticas
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        //pega os parametros
        String botao= request.getParameter("btn");
        
        //var
        int id=0;
        
        
        if(botao.equals("cadastrar")){
        
        }else if(botao.equals("logar")){
            //verificar se a data do cadastro é igual a data atual
            //ou seja saber se é a primeira vez que vai logar
            //se for a true a passamos essa parametro como sessao 
            //para utilizar na tela LOG senha onde fazemos a chamada da CONFIRMAÇÃO DA RESERVA
            ClienteDAO actionCli = new ClienteDAO();
            int retornaDataCadastro =actionCli.verificaUser(id);
            
            if(retornaDataCadastro == 1){
                //a data do cadastro é a mesma que atual
            }else{
                //chama o login 
            }
        }
        
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
}