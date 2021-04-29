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
    private static String ListaCli = "/A_TELAS_JSP/ListaCliente.jsp";
    private static String editar = "/A_TELAS_JSP/TelaCadastroCli.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        String action = request.getParameter("action");
        String forward="";//Prossegue para a proxima tela com ação
        ClienteDAO cliDao = new ClienteDAO();
        Cliente cli = new Cliente();
        //ações
        //Deleta o Cliente por ID
        if(action.equalsIgnoreCase("deletar")){
           int idCli = Integer.parseInt(request.getParameter("id_usuario"));
            try {
                cliDao.remove(idCli);
            } catch (SQLException ex) {
                Logger.getLogger(ControlaClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
            forward = ListaCli;
            try {
                request.setAttribute("clientes", cliDao.listarTodos());
            } catch (SQLException ex) {
                Logger.getLogger(ControlaClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
            //Edita o Usuario por ID
        }else if(action.equalsIgnoreCase("editar")){
            forward=editar;
            int idCli = Integer.parseInt(request.getParameter("id_usuario"));
            try {
                cli= cliDao.cliPorID(idCli);
                cliDao.atualiza(cli);
                request.setAttribute("cli", cli);
            } catch (SQLException ex) {
                Logger.getLogger(ControlaClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
            //Listagem de Clientes
        }else if(action.equalsIgnoreCase("listaCli")){
            forward=ListaCli;
            try {
                request.setAttribute("clientes", cliDao.listarTodos());
            } catch (SQLException ex) {
                Logger.getLogger(ControlaClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(forward);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        //pega os dados do Cadastro
        HttpSession sessao = request.getSession();
        Cliente cliente = new Cliente();
        int idCli = 0;//id do cliente da sessão
        if (sessao.getAttribute("cliente") != null) {
             cliente = (Cliente) sessao.getAttribute("cliente");
            sessao.setAttribute("cliente", cliente);
            idCli = cliente.getId_usuario();

            request.setAttribute("cliente", cliente);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/Telas/TelaCartaoCli.jsp");
            dispatcher.forward(request, response);
        }

        //Vincular idCartao com o Cliente
        String numCartaoStr = request.getParameter("numCartao");
        String validade = request.getParameter("val");
        String cvvStr = request.getParameter("cvv");
        String bandeira = request.getParameter("bandeira");
        String titular = request.getParameter("titular");

        //Declarções de Erro
        boolean temErro = false;
        long numCartao=0L;
        if (numCartaoStr != null && numCartaoStr.trim().length() > 0) {
            
            try {
                numCartao = Long.parseLong(numCartaoStr);
                if(numCartaoStr.trim().length()>17){
                    //Numero tem mais de 17 numeros       
                    temErro = true;
                    request.setAttribute("ErroNumero", "O Número de Cartao tem 17 numeros");
                }else{
                    temErro = false;
                }
                
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = true;
                //Declaração de Erro
                request.setAttribute("erroNumCartao", "Erro NumCartao");
            }

        }else{
            temErro=true;
        }

        if (validade != null && validade.trim().length() > 0) {
            try {
                temErro = false;
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = true;
                //Declaração de Erro
                request.setAttribute("erroValidade", "Validade é Obrigatoria");
            }

        }else{
            temErro=true;
        }
        int cvv=0;
        if (cvvStr != null && cvvStr.trim().length() > 0) {
            try {
                cvv = Integer.parseInt(cvvStr);
                temErro = false;
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = true;
                //Declaração de Erro
                request.setAttribute("erroCVV", "CVV é Obrigatorio");
            }

        }else{
            temErro=true;
        }
        if (bandeira != null && bandeira.trim().length() > 0) {
            try {
                temErro = false;
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = true;
                //Declaração de Erro
                request.setAttribute("erroBandeira", "Bandeira é Obrigatoria");
            }

        }else{
            temErro=true;
        }
        if (titular != null && titular.trim().length() > 0) {
            try {
                temErro = false;
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = true;
                //Declaração de Erro
                request.setAttribute("erroTitular", "Titular é Obrigatorio");
            }

        }else{
            temErro=true;
        }
        //Instancia as Classes
        Cartao cartao = new Cartao(numCartao, validade, cvv, bandeira, titular);
        ClienteDAO cliCartao = new ClienteDAO();
        request.setAttribute("cartao", cartao);

        try {
            int verificaCadastro = cliCartao.cadastraCartao(cartao);
            
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
            RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/Telas/TelaCartaoCli.jsp");
            dispatcher.forward(request, response);
        } else {
            //Logica caso não tenha Erro
           request.getSession();
           sessao.setAttribute("clientes", cliente);
           sessao.setAttribute("cartao", cartao);
           response.sendRedirect(request.getContextPath()+"/ListaCliente");
        }
    }
}