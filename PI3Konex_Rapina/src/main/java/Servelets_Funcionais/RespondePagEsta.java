/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets_Funcionais;

import ClassesJavaBean.Pagamento_mensalidade;
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
@WebServlet(name = "RespondePagEsta", urlPatterns = {"/RespondePagEsta"})
public class RespondePagEsta extends HttpServlet {

    

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        //parametros
        String botao = request.getParameter("btn");
        String idEstaStr = request.getParameter("lineIDEsta");
        String nome = request.getParameter("lineUser");
        String data = request.getParameter("lineData");
        String valorStr = request.getParameter("lineValor");
        //Sessao
        HttpSession sessao = request.getSession();
        
        int id = 0;
        float valor = 0f;

        if (valorStr != null && valorStr.trim().length() > 0) {
            valor = Float.parseFloat(valorStr);
            if (idEstaStr != null && idEstaStr.trim().length() > 0) {
                 id = Integer.parseInt(idEstaStr);
                 if (botao.equals("notificaEsta")) {  

                            //constroe o objeto
                            Pagamento_mensalidade pagMes = new Pagamento_mensalidade(id,data,nome,valor);
                            request.setAttribute("pagMes", pagMes);
                            
                            //constroe a sessao
                            sessao.setAttribute("dadosPagMes", pagMes);
                            response.sendRedirect(request.getContextPath() + "/CriaTelaPagEsta");
                        }else{
                     
                 }
            }
               
        }
           
            
            
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
}
