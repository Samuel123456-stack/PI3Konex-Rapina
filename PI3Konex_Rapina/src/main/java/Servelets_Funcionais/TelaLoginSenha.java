/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets_Funcionais;

import ClassesDAO.LoginDAO;
import ClassesJavaBean.Login;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Gabriel
 */
@WebServlet(name = "TelaLoginSenha", urlPatterns = {"/LogSenha"})
public class TelaLoginSenha extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //boas praticas de uso
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        //VAR que serão utilizadas
        boolean temErro = false;
        String email = null;
        int userTipo = 0;

        //Pegando a Sessao da tela anterior
        HttpSession sessaoUser = request.getSession();

        //verificamos se a session tem algum dado para ser obtido
        if (sessaoUser.getAttribute("dadosAcesso") != null) {
            //trasfiro os dados da session anterio pra o novo objeto
            Login logUser = (Login) sessaoUser.getAttribute("dadosAcesso");

            //setando os valaores para as variaveis que utilizaremos
            email = logUser.getEmail();
            userTipo = logUser.getTipo_usuario();

            //Setando o objeto para parametro
            request.setAttribute("logUser", logUser);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/TelaLogSenha.jsp");
            dispatcher.forward(request, response);
        }

        //pego o atributo da JSP
        String senhaInf = request.getParameter("senha");
        
        //verifico a senha
        if (senhaInf != null && senhaInf.trim().length() > 0) {
            temErro=false;
        }
        
        //Objetos que serão utilizados
        Login loginUser = new Login(email);
        LoginDAO acesso = new LoginDAO(email,senhaInf);

        loginUser.setSenha(senhaInf);
        
        //Requests
        request.setAttribute("userLogado", loginUser);
        
        try {
            //verifica
            int x = acesso.validaSenha();
            
            if( x == 1){
                //não tem erro
                temErro=false;
            }else{
                temErro=true;
            }
            request.setAttribute("rtSenha", x);
        } catch (SQLException ex) {
            Logger.getLogger(TelaLoginSenha.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //verifica se há erros
        if(temErro){
            //não deixa prosseguir
            RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/TelaLogSenha.jsp");
            dispatcher.forward(request, response);
            
        }else{
            //prossegue de acordo  tipo de usuario
            if(userTipo == 1){
                //É um adm
                RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/TelaResultado.jsp");
                dispatcher.forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
