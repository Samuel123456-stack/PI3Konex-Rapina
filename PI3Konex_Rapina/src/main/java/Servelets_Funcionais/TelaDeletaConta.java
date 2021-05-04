/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets_Funcionais;

import ClassesDAO.NotificaDAO;
import ClassesJavaBean.Cliente;
import ClassesJavaBean.Notification;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@WebServlet(name = "TelaDeletaConta", urlPatterns = {"/DeletaConta"})
public class TelaDeletaConta extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //boas praticas
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        //para deletar a conta será necessário ter o ID do User da Sessão
        HttpSession session = request.getSession();
        
        int idCliente = 0;
        
        if (session.getAttribute("cli") != null) {
            Cliente cliente = (Cliente) session.getAttribute("cli");
            
            idCliente = cliente.getId_usuario();
            request.setAttribute("cli", cliente);
            
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/TelaAlteraCard.jsp");
            dispatcher.forward(request, response);
        }
        
        //Pega os paramentros das JSP
        String btn = request.getParameter("btn");
        
        //verifica qual botão foi acionado
        if(btn != null){
            if( btn.equals("Sim")){
                //Faz a confirmação da solicitação e despacha para tela PosAtualiza
                //1º Crio um objeto 
                Notification solicita = new Notification();
                
                //3ºSetar o id do usuário
                solicita.setId_user(idCliente);
                
                //4º Crio a Mensagem da solicitação
                String msg="Olá Rapina Masters, quero que vocês façam a exclusão da minha conta.";
                solicita.setMensagem(msg);
                
                //5º declaro a data e horario da solicitação
                Date dataAtual = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String data= formatter.format(dataAtual);
                solicita.setData(data);
                
                //6ºCriar o objeto DAO 
                NotificaDAO notification = new NotificaDAO();
                
                try {
                    //7º Executa o metodo
                    int x= notification.solicitaExclusao(solicita);
                    
                    if( x == 1){
                        //prossegue com a tela pos atualiza
                        RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/TelaPosAtualiza.jsp");
                        dispatcher.forward(request, response);
                        
                    }else{
                        //Não prossegue e emite msg
                        request.setAttribute("erroSolicita", "No momento você não pode solicitar a exclusão");
                        RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/TelaSolicitaExclusao.jsp");
                        dispatcher.forward(request, response);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(TelaDeletaConta.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }else if (btn.equals("Não")){
                //despacha a tela de MENU
                RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/MenuCliente.jsp");
                dispatcher.forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}
