/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets_Funcionais;

import ClassesDAO.NotificaDAO;
import ClassesJavaBean.Notification;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gusta
 */
@WebServlet(name = "ControlaResposta", urlPatterns = {"/ControlaResposta"})
public class ControlaResposta extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Boas Praticas
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //Pegando os Parametros
        String idStr = request.getParameter("idUser");
        String mensagem = request.getParameter("assunto");
        //var conversao
        int idUser = 0;

        //Tratamento de Erros
        boolean temErro = false;
        if (idStr != null && idStr.trim().length() > 0) {
            try {
                temErro = false;
                idUser = Integer.parseInt(idStr);
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = true;
                //Declaração de Erro
                idStr = null;
                request.setAttribute("ErroID", " ");
            }
        } else {
            temErro = true;
            request.setAttribute("ErroID", " ");
        }
        if (mensagem != null && mensagem.trim().length() > 0) {
            try {
                temErro = false;

            } catch (StringIndexOutOfBoundsException ex) {
                temErro = true;
                //Declaração de Erro
                mensagem = null;
                request.setAttribute("ErroMensagem", " ");
            }
        } else {
            temErro = true;
            request.setAttribute("ErroMensagem", " ");
        }

        //declaro a data e horario da solicitação
        Date dataAtual = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String data = formatter.format(dataAtual);

        //Instancio os Objetos
        Notification noti = new Notification(idUser, mensagem, data);
        NotificaDAO notiDao = new NotificaDAO();
        
        //var que retorna a reposta
        int verificaResposta = notiDao.criaResposta(noti);
        
        //retorno da verificação
        if (verificaResposta == 1) {
            temErro = false;
        } else if (verificaResposta == 0) {
            temErro = true;
        } else {
            temErro = true;
        }
        if (temErro) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/TelaResposta.jsp");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/TelaNotificacoes.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
