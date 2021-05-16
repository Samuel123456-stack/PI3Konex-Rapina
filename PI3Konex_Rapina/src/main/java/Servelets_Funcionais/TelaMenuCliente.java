/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets_Funcionais;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gabriel
 */
@WebServlet(name = "TelaMenuCliente", urlPatterns = {"/Menu"})
public class TelaMenuCliente extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //boas praticas
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        //Pegar o parametro
        String botao = request.getParameter("btn");

        //condição
        if (botao != null) {
            //condição
            if (botao.equals("att card")) {
                response.sendRedirect(request.getContextPath() + "/TelaAltCard");
            } else if (botao.equals("att dados")) {
                response.sendRedirect(request.getContextPath() + "/TelaAlteraDados");
            } else if (botao.equals("sub exclusao")) {
                response.sendRedirect(request.getContextPath() + "/TelaSolicitaExclusao");
            } else if(botao.equals("envia doacao")){
                response.sendRedirect(request.getContextPath() + "/TelaDoacao");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
