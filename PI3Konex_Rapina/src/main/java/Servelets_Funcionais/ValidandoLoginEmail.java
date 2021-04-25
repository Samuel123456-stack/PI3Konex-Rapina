/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets_Funcionais;

import ClassesDAO.LoginDAO;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "ValidandoLoginEmail", urlPatterns = {"/verificaEmail"})
public class ValidandoLoginEmail extends HttpServlet {

    //METODO DO GET
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //boas praticas de uso
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");   
        
        //Pegando o atributo da JSP
        String emailDigitado=request.getParameter("email");
        
        //Variável verificadoa
        boolean temErro=false;
        
        //condição de obrigatoriedade
        if (emailDigitado != null && emailDigitado.trim().length() > 0) {
            try {
                //status do verificador
                temErro = false;

            } catch (StringIndexOutOfBoundsException ex) {
                temErro = true;

                //declaração de erro
                request.setAttribute("erroEmail", temErro);
            }
        }
        
        //Instanciando um objeto
        
        //Objeto da classeDAO é declarado para utilizar o verificador
        LoginDAO logando=new LoginDAO();
        
        //VERIFICA SE O EMAIL É EXISTENTE AO BANCO DE DADOS
        
        
        //Verifica se tem
            if(temErro){
                //Se há erro, ele impede o usuário de avançar
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Telas/TelaLoginEmail.jsp");
                dispatcher.forward(request, response);
            }else{
                //RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Telas/TelaLoginSenha.jsp");
                //dispatcher.forward(request, response);
                
                //**** GET-REDIRECT-POST
                HttpSession sessao = request.getSession();
                //sessao.setAttribute("dadoRecebido", users);
                response.sendRedirect(request.getContextPath() + "/TelaLoginSenha");
            }
        
        
    }
    //METODO DO POST
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
}