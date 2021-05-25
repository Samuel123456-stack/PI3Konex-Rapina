/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets_Funcionais;

import ClassesJavaBean.Pagamento_taxa;
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
 * @author gusta
 */
@WebServlet(name = "BuscaPagamentos", urlPatterns = {"/BuscaPagamentos"})
public class BuscaPagamentos extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String botao = request.getParameter("btn");
        String idStr = request.getParameter("lineID");
        String idEstaStr = request.getParameter("lineIDEsta");
        String nome = request.getParameter("lineUser");
        String data = request.getParameter("lineData");
        String valorStr = request.getParameter("lineValor");
        int id=0;
        float valor = 0f;

        if (valorStr != null && valorStr.trim().length() > 0) {

            valor = Float.parseFloat(valorStr);
             if (idStr != null && idStr.trim().length() > 0) {
                id = Integer.parseInt(idStr); 
                //id = Integer.parseInt(idEstaStr);
                
            if (botao.equals("notifica")) {
                Pagamento_taxa pagTaxa = new Pagamento_taxa(id,nome,data,valor);
                request.setAttribute("pag", pagTaxa);
                //buscar ID do usuario pelo nome
                RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/TelaRespostaPag.jsp");
                dispatcher.forward(request, response);
            }else if(botao.equals("bloquea")){
                //Alterar Status do Estabelecimento para 'Inativo'
            }
             }

            
        }
    }


    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
}
