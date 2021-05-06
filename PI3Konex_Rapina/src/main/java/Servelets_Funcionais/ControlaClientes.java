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
        
        //session
        HttpSession sessao = request.getSession();
        int tipoCli = 0;
        
        if (sessao.getAttribute("cli") != null) {
            Cliente cliente = (Cliente) sessao.getAttribute("cli");
            sessao.setAttribute("cli", cliente);
            
            tipoCli = cliente.getTipo_user();
            request.setAttribute("cli", cliente);
            
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/TelaCadastroCli.jsp");
            dispatcher.forward(request, response);
        }

        String idStr = request.getParameter("idCliente");
        String nome = request.getParameter("nome");
        String genero = request.getParameter("genero");
        String cpf = request.getParameter("cpf");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String telefone = request.getParameter("celular");
        String senhaRe = request.getParameter("senhaRepete");
        String dataNascStr = request.getParameter("dataNasc");
        String concordar = request.getParameter("concordar");
        String concordarNews = "Não";

        //Tratamento de Exceções
        boolean temErro = false;
        
        if (nome != null && nome.trim().length() > 0) {
            try {
                temErro = true;
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = false;
                //Declaração de Erro
                request.setAttribute("erroNome", " ");
            }
        }else{
            temErro=true;
            request.setAttribute("erroNome", " ");
        }

        if (genero != null && genero.trim().length() > 0) {
            try {
                temErro = true;
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = false;
                //Declaração de Erro
                request.setAttribute("erroGenero", " ");
            }

        }
        if (cpf != null && cpf.trim().length() > 0) {
            try {
                temErro = false;
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = true;
                //Declaração de Erro
                request.setAttribute("erroCpf", " ");
            }
        }else{
            temErro=true;
            request.setAttribute("erroCpf", " ");
        }
        
        if (email != null && email.trim().length() > 0) {
            try {
                temErro = true;
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = false;
                //Declaração de Erro
                request.setAttribute("erroEmail", " ");
            }

        }else{
            temErro=true;
            request.setAttribute("erroEmail", " ");
        }
        
        if (senha != null && senha.trim().length() > 0) {
            try {
                if (!senha.equals(senhaRe)) {
                    temErro = true;
                    senha = null;
                    request.setAttribute("ErroSenhaRe", " ");
                } else {
                    temErro = false;
                }
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = false;
                //Declaração de Erro
                request.setAttribute("ErroSenhaRe", " ");
            }
        }else{
            temErro=true;
            request.setAttribute("ErroSenhaRe", " ");
        }
        
        if (dataNascStr != null && dataNascStr.trim().length() > 0) {
            try {
                temErro = true;
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = false;
                //Declaração de Erro
                request.setAttribute("erroDataNasc", " ");
            }
        }else{
            temErro=true;
            request.setAttribute("erroDataNasc", " ");
        }
        
        
        if (concordar != null && concordar.trim().length() > 0) {
            try {
                temErro = true;
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = false;
                //Declaração de Erro
                request.setAttribute("erroConcorda", " ");
            }

        }
        //Instancia as Classes
        Cliente cliente = new Cliente(nome, cpf, email, genero,
                dataNascStr, senha,concordar, concordarNews, tipoCli);
        ClienteDAO casCli = new ClienteDAO();
        request.setAttribute("cliente", cliente);

        try {
            int verificaCadastro = casCli.cadastra(cliente);

            if (verificaCadastro == 1) {

                temErro = false;
            } else if (verificaCadastro == 0) {
                temErro = true;
            } else {
                temErro = true;
                request.setAttribute("erroCpf", temErro);
                request.setAttribute("ErroSenhaRe", temErro);
            }
        } catch (SQLException ex) {
            System.out.println("Erro:" + ex);
        }
        
        //Verifica se tem Erro
        if (temErro) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/TelaCadastroCli.jsp");
            dispatcher.forward(request, response);
        } else {
            HttpSession sessao2 = request.getSession();
            sessao2.setAttribute("cli", cliente);
            response.sendRedirect(request.getContextPath() + "/TelaCartaoCli");
        }
    }
}