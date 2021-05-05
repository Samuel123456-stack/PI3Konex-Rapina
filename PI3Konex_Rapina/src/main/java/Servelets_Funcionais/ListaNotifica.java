/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets_Funcionais;

import ClassesDAO.NotificaDAO;
import ClassesJavaBean.Notification;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "ListaNotifica", urlPatterns = {"/FazListagem"})
public class ListaNotifica extends HttpServlet {
   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String botao = request.getParameter("btn");
        String identifica = request.getParameter("id");
        String action = request.getParameter("action");
        NotificaDAO notiDao = new NotificaDAO();
        ArrayList<Notification> lista = new ArrayList<>();
        int valor = 0;
        int valorID = 0;
        boolean temErro = false;
        if (botao != null && botao.trim().length() > 0) {
            try {
                valor = Integer.parseInt(botao);
                temErro = false;
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = true;
                //Declaração de Erro
                botao = null;
            }
        } else {
            temErro = true;
            botao = null;
        }
        if (identifica != null && identifica.trim().length() > 0) {
            try {
                valorID = Integer.parseInt(identifica);
                temErro = false;
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = true;
                //Declaração de Erro
                identifica = null;
            }
        } else {
            temErro = true;
            identifica = null;
        }
        //Lista os Cli
        if (valor == 2) {
            try {
                lista = notiDao.listarCli();
                request.setAttribute("listaNoti", lista);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/TelaNotificacoes.jsp");
                dispatcher.forward(request, response);

            } catch (SQLException ex) {
                Logger.getLogger(ListaNotifica.class.getName()).log(Level.SEVERE, null, ex);
            }
            //Lista os Esta
        } else if (valor == 3) {
            try {
                lista = notiDao.listarEsta();
                request.setAttribute("listaNoti", lista);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/TelaNotificacoes.jsp");
                dispatcher.forward(request, response);

            } catch (SQLException ex) {
                Logger.getLogger(ListaNotifica.class.getName()).log(Level.SEVERE, null, ex);
            }
            valor = 0;
        }
        //Procura ID Mensagem do Cli
        if (valorID > 0) {
            try {
                lista = notiDao.listarCliPorID(valorID);
                request.setAttribute("listaNoti", lista);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/TelaNotificacoes.jsp");
                dispatcher.forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(ListaNotifica.class.getName()).log(Level.SEVERE, null, ex);
            }
            //procura ID do Esta
        } else if (valor == 3 && valorID > 0) {
            try {
                lista = notiDao.listarEstaPorID(valorID);
                request.setAttribute("listaNoti", lista);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/TelaNotificacoes.jsp");
                dispatcher.forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(ListaNotifica.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (action.equalsIgnoreCase("deletar")) {
            int idNoti = Integer.parseInt(request.getParameter("id_notification"));
            try {
                notiDao.removeNoti(idNoti);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/TelaNotificacoes.jsp");
                dispatcher.forward(request, response);

            } catch (SQLException ex) {
                Logger.getLogger(ListaNotifica.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        if (temErro) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/TelaNotificacoes.jsp");
            request.setAttribute("listaNoti", lista);
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/TelaNotificacoes.jsp");
            request.setAttribute("listaNoti", lista);
            dispatcher.forward(request, response);
        }


    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }


}
