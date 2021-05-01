/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets_Funcionais;

import ClassesJavaBean.Cartao;
import ClassesJavaBean.Cliente;
import ClassesDAO.ClienteDAO;
import ClassesDAO.EstabelecimentoDAO;
import ClassesJavaBean.Estabelecimento;
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

        //pega os dados do Cadastro do Cliente
        HttpSession sessao = request.getSession();
        
        //OBJETOS DA SESSOES
        Cliente cliente = new Cliente();
        Estabelecimento esta = new Estabelecimento();
        
        //VAR DAS SESSOES
        int idCli = 0;
        int tipoUsuario = 0;
        int idEsta = 0;
        
        //VERIFICA QUAL USER ESTÁ NA SESSAO
        if (sessao.getAttribute("cli") != null && sessao.getAttribute("estabelecimento") == null) {
            cliente = (Cliente) sessao.getAttribute("cli");
            
            //pega o id do Cliente
            idCli = cliente.getId_usuario();
            tipoUsuario = cliente.getTipo_user();
            
            //Request
            request.setAttribute("cli", cliente);
            
        } else if (sessao.getAttribute("cli") == null && sessao.getAttribute("estabelecimento") != null) {
            esta = (Estabelecimento) sessao.getAttribute("estabelecimento");
            
            //pega o Id do Estabelecimento e o tipo do usuário
            idEsta = esta.getId_estabelecimento();
            tipoUsuario = esta.getTipo_user();
            
            //Request do objeto
            request.setAttribute("estabelecimento", esta);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/TelaCartaoCli.jsp");
            dispatcher.forward(request, response);
        }

        //PEGANDO  OS ARIBUTOS DA JSP
        String numCartaoStr = request.getParameter("numCartao");
        String validade = request.getParameter("val");
        String cvvStr = request.getParameter("cvv");
        String titular = request.getParameter("titular");

        //Declarções de Erro
        boolean temErro = false;
        
        //VAR DE CONVERSAO
        long numCartao = 0L;
        int cvv = 0;
        
        //VERIFICA NUM CARTAO
        if (numCartaoStr != null && numCartaoStr.trim().length() > 0) {
            try {
                numCartao = Long.parseLong(numCartaoStr);
                if (numCartaoStr.trim().length() > 16) {
                    temErro = true;
                    request.setAttribute("erro", " ");
                } else {
                    temErro = false;
                }

            } catch (StringIndexOutOfBoundsException ex) {
                temErro = true;
                //Declaração de Erro
                request.setAttribute("erro", " ");
            }

        } else {
            temErro = true;
            request.setAttribute("erro", " ");
        }

        //VERIFICA VALIDADE
        if (validade != null && validade.trim().length() > 0) {
            try {
                temErro = false;
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = true;
                //Declaração de Erro
                request.setAttribute("erro", " ");
            }
        } else {
            temErro = true;
            request.setAttribute("erro", " ");
        }

        //VERIFICA CVV
        if (cvvStr != null && cvvStr.trim().length() > 0) {
            try {
                cvv = Integer.parseInt(cvvStr);
                temErro = false;
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = true;
                //Declaração de Erro
                request.setAttribute("erro", " ");
            }
        } else {
            temErro = true;
            request.setAttribute("erro", " ");
        }

        //VERIFICA TITULAR
        if (titular != null && titular.trim().length() > 0) {
            try {
                temErro = false;
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = true;
                //Declaração de Erro
                request.setAttribute("erroTitular", "Titular é Obrigatorio");
            }

        } else {
            temErro = true;
            request.setAttribute("erro", " ");
        }

        //INSTANCIAMENTO DE CLASSES
        Cartao cartao = new Cartao(numCartao, validade, cvv, titular);
        ClienteDAO cliCartao = new ClienteDAO();
        EstabelecimentoDAO estaCartao = new EstabelecimentoDAO();

        //Request do bjeto cartao
        request.setAttribute("cartao", cartao);

        //verificações
        try {
            if (tipoUsuario == 2) {
                int verificaCadastroCli = cliCartao.cadastraCartao(cartao);
                switch (verificaCadastroCli) {
                    case 1:
                        temErro = false;
                        cliCartao.vinculaCartao(cartao, idCli);
                        idCli = -1;//id ser -1 para nao dar erro
                        break;
                    case 0:
                        temErro = true;
                        break;
                    default:
                        temErro = true;
                        break;
                }
            } else if (tipoUsuario == 3) {
                int verificaCadastroEsta = estaCartao.cadastraCartaoEsta(cartao);
                switch (verificaCadastroEsta) {
                    case 1:
                        temErro = false;
                        estaCartao.vinculaCartaoEsta(cartao, idEsta);
                        idEsta = -1;//id ser -1 para nao dar erro
                        break;
                    case 0:
                        temErro = true;
                        break;
                    default:
                        temErro = true;
                        break;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlaCartao.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Verifica se tem Erro
        if (temErro) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/TelaCartaoCli.jsp");
            dispatcher.forward(request, response);
        } else {
            sessao.setAttribute("cartao", cartao);
            response.sendRedirect(request.getContextPath() + "/MenuCliente");
        }
    }
}
