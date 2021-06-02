/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets_Funcionais;

import ClassesDAO.LoginDAO;
import ClassesDAO.NotificaDAO;
import ClassesJavaBean.Estabelecimento;
import ClassesJavaBean.Login;
import ClassesJavaBean.Notification;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
 * @author gusta
 */
@WebServlet(name = "EnviaPerguntaEsta", urlPatterns = {"/EnviaPerguntaEsta"})
public class EnviaPerguntaEsta extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        //pega o id do usuario  atraves da sessao
        //recupera a sessao
        Login logUser = new Login();
        int id = 0;

        //Pegando a Sessao da tela anterior
        HttpSession sessaoUser = request.getSession();

        //verificamos se a session tem algum dado para ser obtido
        if (sessaoUser.getAttribute("dadosAcesso") != null) {
            //trasfiro os dados da session anterio pra o novo objeto
            logUser = (Login) sessaoUser.getAttribute("dadosAcesso");
            
            //setando os valaores para as variaveis que utilizaremos
            id = logUser.getId_esta();

            
            //Setando o objeto para parametro
            request.setAttribute("logUser", logUser);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/TelaLogSenha.jsp");
            dispatcher.forward(request, response);
        }
        
        //parametros
        String mensagem= request.getParameter("mensagem");
        
        //var de data
        Date dataAtual = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String data = formatter.format(dataAtual);
        
        //objeto DAO
        NotificaDAO help= new NotificaDAO();
        Notification dadosNotifica = new Notification();
        
        //passsa os dados que serão enviados
        dadosNotifica.setMensagem(mensagem);
        dadosNotifica.setId_estabelecimento(id);
        dadosNotifica.setData(data);
        
        //metodo que cria a resposta
        int envia= help.criaPerguntaEsta(dadosNotifica);
        if(envia==1){
            //despacha a tela
            RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/ConfirmaMensagem.jsp");
            dispatcher.forward(request, response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    

}
