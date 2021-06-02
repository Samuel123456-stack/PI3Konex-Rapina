/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets_Funcionais;

import ClassesDAO.ReservaDAO;
import ClassesJavaBean.Reserva;
import java.io.IOException;
import java.sql.SQLException;
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
@WebServlet(name = "ValidaReserva", urlPatterns = {"/ValidaReserva"})
public class ValidaReserva extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String numSTR = request.getParameter("numReserva");
        String botao = request.getParameter("btn");
        int numReserva = 0;
        boolean temErroValida = false;
        boolean temErro = false;
        if (numSTR != null && numSTR.trim().length() > 0) {
            try {
                numReserva = Integer.parseInt(numSTR);
                temErro = false;
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = true;
                //Declaração de Erro
                numSTR = null;
            }
        } else {
            temErro = true;
            numSTR = null;
        }
        if (temErro) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/TelaValidaReserva.jsp");
            dispatcher.forward(request, response);
        } else {
            //verificar se o botao foi pressionado
            if (botao.equals("confirmaReserva")) {
                //constroe o objeto DAO
                ReservaDAO resDAO = new ReservaDAO();

                //chama o metodo que retorna uma lista de reservas 
                List<Reserva> listaDados;
                int verifica = 0;
                try {
                    verifica = resDAO.ConsultaReserva(numReserva);
                    if (verifica == 1) {//se verifica for 1, atualizo o status das Reservas "Ativas"
                        resDAO.atualizaStatus(numReserva);
                        
                        //Chama o metodo que aumenta a lotação
                        
                        
                        listaDados = resDAO.listarDadosReserva(numReserva);//listo os dados da Reserva
                        request.setAttribute("lista", listaDados);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/TelaValidaReserva.jsp");
                        dispatcher.forward(request, response);
                    } else if (verifica == 0) {
                        temErroValida = true;
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(ValidaReserva.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (temErroValida) {
                    request.setAttribute("erroValida", "A reserva não foi identificada");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/TelaValidaReserva.jsp");
                    dispatcher.forward(request, response);
                }
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
