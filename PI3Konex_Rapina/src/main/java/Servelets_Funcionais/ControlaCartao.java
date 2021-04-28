/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets_Funcionais;

import ClassesJavaBean.Cartao;
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
@WebServlet(name = "ControlaCartao", urlPatterns = {"/ControlaCartao"})
public class ControlaCartao extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        //pega os dados do Cadastro
        HttpSession sessao = request.getSession();

        //id do cliente da sessão
        int idCli = 0;
        if (sessao.getAttribute("cli") != null) {
            Cliente cli = (Cliente) sessao.getAttribute("cliente");

            sessao.removeAttribute("cli");
            idCli = cli.getId_usuario();
            request.setAttribute("cli", cli);

            //RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/MenuCliente.jsp");
            //dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/TelaCartaoCli.jsp");
            dispatcher.forward(request, response);
        }

        String numCartaoStr = request.getParameter("numCartao");
        String validade = request.getParameter("val");
        String cvvStr = request.getParameter("cvv");
        String titular = request.getParameter("titular");
        String bandeira = "Visa";

        //Declarções de Erros
        boolean temErro = false;
        if (numCartaoStr != null && numCartaoStr.trim().length() > 0) {
            try {
                temErro = false;
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = true;
                //Declaração de Erro
                request.setAttribute("erroNumCartao", "Erro NumCartao");
            }

        }

        if (validade != null && validade.trim().length() > 0) {
            try {
                temErro = false;
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = true;
                //Declaração de Erro
                request.setAttribute("erroValidade", "Validade é Obrigatoria");
            }

        }
        if (cvvStr != null && cvvStr.trim().length() > 0) {
            try {
                temErro = false;
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = true;
                //Declaração de Erro
                request.setAttribute("erroCVV", "CVV é Obrigatorio");
            }

        }

        if (titular != null && titular.trim().length() > 0) {
            try {
                temErro = false;
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = true;
                //Declaração de Erro
                request.setAttribute("erroTitular", "Titular é Obrigatorio");
            }

        }

        //Conversao
        long numCartao = Long.parseLong(numCartaoStr);
        int cvv = Integer.parseInt(cvvStr);

        //Instancia as Classes
        Cartao cartao = new Cartao(numCartao, validade, cvv, bandeira, titular);
        ClienteDAO cliCartao = new ClienteDAO();

        request.setAttribute("cartao", cartao);

        try {
            int verificaCadastro = cliCartao.cadastraCartao(cartao);
            //faz a verificação
            switch (verificaCadastro) {
                case 1:
                    temErro = false;
                    cliCartao.vinculaCartao(cartao, idCli);
                    break;
                case 0:
                    temErro = true;
                    break;
                default:
                    temErro = true;
                    break;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ControlaCartao.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Verifica se tem Erro
        if (temErro) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/TelaCartaoCli.jsp");
            dispatcher.forward(request, response);
        } else {
            //Logica caso tenha Erro
            HttpSession sessao1 = request.getSession();
            sessao1.setAttribute("cartao", cartao);
            response.sendRedirect(request.getContextPath() + "/MenuCliente");
        }

    }
}
