/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets_Funcionais;

import ClassesDAO.EstabelecimentoDAO;
import ClassesJavaBean.Estabelecimento;
import java.io.IOException;
import java.io.PrintWriter;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Gabriel
 */
@WebServlet(name = "ListaRestaurantesBuscados", urlPatterns = {"/ListaRestaurantesBuscados"})
public class ListaRestaurantesBuscados extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //boas praticas de uso
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        //pega o parametro do botao
        String botao = request.getParameter("selectionRestaurante");
        
        
        if(botao.equals("selectionRestaurante")){
                //despacha a tela de seleção 
                response.sendRedirect(request.getContextPath() + "/Selection");
            }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }


}
