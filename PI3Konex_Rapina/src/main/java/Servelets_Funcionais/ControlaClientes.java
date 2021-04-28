/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets_Funcionais;

import ClassesJavaBean.Cliente;
import ClassesDAO.ClienteDAO;
import java.io.IOException;
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
 * @author gusta
 */
@WebServlet(name = "ControlaClientes", urlPatterns = {"/ControlaClientes"})
public class ControlaClientes extends HttpServlet {

   

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpSession sessao1 = request.getSession();
        int tipoCli =0;
        if (sessao1.getAttribute("cli") != null) {
             Cliente cliente = (Cliente) sessao1.getAttribute("cli");
              sessao1.setAttribute("cli", cliente);
              tipoCli = cliente.getTipo_user();
              request.setAttribute("cli", cliente);
        }

        String nome = request.getParameter("nome");
        String genero = request.getParameter("genero");
        String cpf = request.getParameter("cpf");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String senhaRe = request.getParameter("senhaRepete");
        String dataNascStr = request.getParameter("dataNasc");
        String concordar = request.getParameter("concordar");
        String concordarNews = "Não";
        int tipoUsuarioStr = tipoCli;
        
        //Tratamento de Exceções
         boolean temErro = false;
        if (nome != null && nome.trim().length() > 0) {
            try {
                temErro = false;
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = true;
                //Declaração de Erro
                request.setAttribute("erroNome", "Nome é Obrigatorio");
            }

        }

        if (genero != null && genero.trim().length() > 0) {
            try {
                temErro = false;
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = true;
                //Declaração de Erro
                request.setAttribute("erroGenero", "Genero é Obrigatorio");
            }

        }
        if (cpf != null && cpf.trim().length() > 0) {
            try {
                temErro = false;
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = true;
                //Declaração de Erro
                request.setAttribute("erroCpf", "CPF é Obrigatorio");
            }

        }
        if (email != null && email.trim().length() > 0) {
            try {
                temErro = false;
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = true;
                //Declaração de Erro
                request.setAttribute("erroEmail", "Email é Obrigatorio");
            }

        
        }
        if (senha != null && senha.trim().length() > 0) {
            try {
               if(!senha.equals(senhaRe)){
                   temErro=true;
                   request.setAttribute("ErroSenhaRe", "Senha Repetida não é igual");
               }
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = true;
                //Declaração de Erro
               request.setAttribute("ErroSenhaObg", "Senha é Obrigatoria");
            }

        }
        if (dataNascStr != null && dataNascStr.trim().length() > 0) {
            try {
                temErro = false;
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = true;
                //Declaração de Erro
                request.setAttribute("erroDataNasc", "Data de Nascimento é Obrigatoria");
            }

        }
        if (concordar != null && concordar.trim().length() > 0) {
            try {
                temErro = false;
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = true;
                //Declaração de Erro
                request.setAttribute("erroConcorda", "Concordar é Obrigatiorio");
            }

        }
        //Instancia as Classes
        Cliente cliente = new Cliente(nome,cpf,email,genero
                ,dataNascStr,senha,concordar,concordarNews,tipoCli);
        ClienteDAO casCli = new ClienteDAO();
        request.setAttribute("cliente", cliente);
        
        try{
            int verificaCadastro = casCli.cadastra(cliente);
          
            if(verificaCadastro==1){

                temErro=false;
            }else if(verificaCadastro==0){
                temErro=true;
            }else{
                temErro=true;               
                request.setAttribute("erroCpf", temErro);
            }
        }catch(SQLException ex){
            System.out.println("Erro:"+ex);
        }
        //Verifica se tem Erro
        if(temErro){
            RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/TelaCadastroCli.jsp");
            dispatcher.forward(request, response);
        }else{
            try {
                request.setAttribute("clientes", casCli.listarTodos());
            } catch (SQLException ex) {
                Logger.getLogger(ControlaClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
            HttpSession sessao = request.getSession();
            sessao.setAttribute("cliente", cliente);
            response.sendRedirect(request.getContextPath() + "/TelaCartaoCli");
        }
    }

}
