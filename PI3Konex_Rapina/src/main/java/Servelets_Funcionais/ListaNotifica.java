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
@WebServlet(name = "ListaNotifica", urlPatterns = {"/ListaNotifica"})
public class ListaNotifica extends HttpServlet {
   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String valor = request.getParameter("btn");
        String abre = request.getParameter("abre");
        int tipoUsuario = Integer.parseInt(valor);
        NotificaDAO notiDao = new NotificaDAO();
        ArrayList<Notification> lista = new ArrayList<>();
        if(valor.equals("2")){
            try {
            lista = notiDao.listarCli();
            request.setAttribute("listaNoti",lista);
            //Rever estas questoes
            //RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/JSP/Lista.jsp");
            //dispatcher.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ListaNotifica.class.getName()).log(Level.SEVERE, null, ex);
        }
        }else if(valor.equals("3")){
            try {
            lista = notiDao.listarEsta();
            request.setAttribute("listaNoti",lista);
            //Rever estas Questoes
            //RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/JSP/Lista.jsp");
            //dispatcher.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ListaNotifica.class.getName()).log(Level.SEVERE, null, ex);
        }
        }

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }


}
