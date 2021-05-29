/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets_Funcionais;

import ClassesJavaBean.Cartao;
import ClassesJavaBean.Estabelecimento;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "SubMenusEsta", urlPatterns = {"/SubMenusEsta"})
public class SubMenusEsta extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Estabelecimento esta = new Estabelecimento();
        Cartao cartao = new Cartao();
        HttpSession session = request.getSession();
        
        if (session.getAttribute("esta") != null && session.getAttribute("cartao")!= null) {
              esta = (Estabelecimento) session.getAttribute("esta");
              cartao = (Cartao) session.getAttribute("cartao");

              
        }
        String botao = request.getParameter("btn");
        if (botao != null) {
            if(botao.equals("alteraCartao")){
                request.setAttribute("cartao", cartao);
                session.setAttribute("cartao", cartao);
                response.sendRedirect(request.getContextPath()+"/TelaAltCard");
                
            }else if(botao.equals("alteraDadosEsta")){
                request.setAttribute("esta", esta);
                session.setAttribute("esta", esta);
                response.sendRedirect(request.getContextPath()+"/AlteraDadosEsta");
                
            }else if(botao.equals("validaReserva")){
                response.sendRedirect(request.getContextPath()+"");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }



}
