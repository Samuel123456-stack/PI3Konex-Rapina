/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets_Funcionais;

import ClassesJavaBean.Cliente;
import ClassesJavaBean.Estabelecimento;
import java.io.IOException;
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
@WebServlet(name = "IniciaSessao", urlPatterns = {"/IniciaCadastro"})
public class IniciaSessao extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String botao = request.getParameter("button");

        Cliente cli = new Cliente();
        Estabelecimento esta = new Estabelecimento();
        int tipoUsuario = 0;
        
        HttpSession sessao = request.getSession();
        
        if (botao != null) {
            if (botao.equals("Cadastro Cliente")) {
                tipoUsuario = 2;
                
                cli.setTipo_user(tipoUsuario);
                sessao.setAttribute("cli", cli);
                response.sendRedirect(request.getContextPath() + "/TelaCadastroCli");
                
            } else if (botao.equals("Cadastro Estabelecimento")) {
                tipoUsuario = 3;
                
                esta.setTipo_user(tipoUsuario);
                sessao.setAttribute("esta", esta);
                response.sendRedirect(request.getContextPath() + "/TelaCadastroEsta");
            }
        }

    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }



}
