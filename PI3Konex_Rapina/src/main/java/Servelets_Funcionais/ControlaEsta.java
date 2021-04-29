/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets_Funcionais;

import ClassesDAO.EstabelecimentoDAO;
import ClassesJavaBean.Estabelecimento;
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
 * @author gusta
 */
@WebServlet(name = "ControlaEsta", urlPatterns = {"/ControlaEsta"})
public class ControlaEsta extends HttpServlet {



  @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        //Sessao
        HttpSession sessao1 = request.getSession();
        int tipoEsta = 0;
        
        if (sessao1.getAttribute("esta") != null) {
            Estabelecimento esta = (Estabelecimento) sessao1.getAttribute("esta");
            sessao1.setAttribute("esta", esta);
            tipoEsta = esta.getTipo_user();
            request.setAttribute("esta", esta);
        }else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/TelaCadastroEsta.jsp");
            dispatcher.forward(request, response);
        }

        String nomeEst = request.getParameter("nome");
        String cnpj = request.getParameter("cnpj");
        String cep = request.getParameter("cep");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String senhaRe = request.getParameter("senhaRe");
        String endereco = request.getParameter("endereco");
        String numeroStr = request.getParameter("numero");
        String horario = request.getParameter("horario_de_fun");
        String capacidadeStr = request.getParameter("capacidade");
        String taxaStr = request.getParameter("valCancela");
        String concordar = request.getParameter("concordar");
        String concordarNews = request.getParameter("concordarNews");
        String defAud = request.getParameter("defAud");
        String defFis = request.getParameter("defFis");
        String disponibilidade = "Sim";
        int tipoUsuario = tipoEsta;
        String idPlanosStr = "1";

        //Tratamento de Erros
        boolean temErro = false;
        if (nomeEst != null && nomeEst.trim().length() > 0) {
            try {
                temErro = false;
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = true;
                //Declaração de Erro
                request.setAttribute("erroNomeEst", "Nome é Obrigatorio");
            }

        }

        if (cnpj != null && cnpj.trim().length() > 0) {
            try {
                temErro = false;
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = true;
                //Declaração de Erro
                request.setAttribute("erroCnpj", "CNPJ é Obrigatorio");
            }

        }
        if (cep != null && cep.trim().length() > 0) {
            try {
                temErro = false;
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = true;
                //Declaração de Erro
                request.setAttribute("erroCep", "CEP é Obrigatorio");
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
                if (!senha.equals(senhaRe)) {
                    temErro = true;
                    senha = null;
                    request.setAttribute("ErroSenhaRe", "Senha Repetida não é igual");
                } else {
                    temErro = false;
                }
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = true;
                //Declaração de Erro
                request.setAttribute("ErroSenhaObg", "Senha é Obrigatoria");
            }

        }
        if (endereco != null && endereco.trim().length() > 0) {
            try {
                temErro = false;
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = true;
                //Declaração de Erro
                request.setAttribute("erroEndereco", "Endereço é Obrigatorio");
            }

        }
        if (numeroStr != null && numeroStr.trim().length() > 0) {
            try {
                temErro = false;
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = true;
                //Declaração de Erro
                request.setAttribute("erroNumero", "Numero é Obrigatorio");
            }

        }
        if (horario != null && horario.trim().length() > 0) {
            try {
                temErro = false;
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = true;
                //Declaração de Erro
                request.setAttribute("erroHorario", "Horario é Obrigatorio");
            }

        }
        if (capacidadeStr != null && capacidadeStr.trim().length() > 0) {
            try {
                temErro = false;
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = true;
                //Declaração de Erro
                request.setAttribute("erroCap", "Capacidade é Obrigatoria");
            }

        }
        if (taxaStr != null && taxaStr.trim().length() > 0) {
            try {
                if (taxaStr == "20.00") {
                    temErro = true;
                    request.setAttribute("ErroTaxaValor", "O valor maximo da taxa deve ser de até R$19.99");
                } else {
                    temErro = false;
                }
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = true;
                //Declaração de Erro
                request.setAttribute("erroTaxaCancela", "Taxa de Cancelamento não informada");
            }

        }
        if (concordar != null && concordar.trim().length() > 0) {
            try {
                temErro = false;
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = true;
                //Declaração de Erro
                request.setAttribute("erroConcorda", "Concordar é Obrigatorio");
            }

        }
        //Condição caso não tenha Assistencia auditiva e fisica
        if (defAud == null && defFis == null) {
            defAud = "Não";
            defFis = "Não";
        } else if (defAud != null || defFis != null) {
            defAud = "Sim";
            defFis = "Sim";
        }

        //Conversao
        int numeroEst = Integer.parseInt(numeroStr);
        int capEst = Integer.parseInt(capacidadeStr);
        float taxaCancela = Float.parseFloat(taxaStr);
        int idPlanos = Integer.parseInt(idPlanosStr);
        //Condição da Taxa
        if (taxaCancela > 20.00) {//Erro
            temErro = true;
            request.setAttribute("ErroTaxaValor", "O valor maximo da taxa deve ser de até R$19.99");
        } else {
            temErro = false;
        }

        //Instancia as Classes
        Estabelecimento esta = new Estabelecimento(nomeEst, cnpj, cep, endereco,
                 numeroEst, defAud, defFis, horario, capEst, taxaCancela, email, senha,
                 concordar, concordarNews, disponibilidade, idPlanos, tipoUsuario);
        EstabelecimentoDAO casEsta = new EstabelecimentoDAO();
        request.setAttribute("estabelecimento", esta);

        try {
            int verificaCadastro = casEsta.cadastraEst(esta);
            if (verificaCadastro == 1) {
                temErro = false;
            } else if (verificaCadastro == 0) {
                temErro = true;
            } else {
                temErro = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ControlaEsta.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Verifica se tem Erro
        if (temErro) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/TelaCadastroEsta.jsp");
            dispatcher.forward(request, response);
        } else {
            HttpSession sessao = request.getSession();
            sessao.setAttribute("estabelecimento", esta);
            response.sendRedirect(request.getContextPath() + "/TelaCartaoCli");
        }
    }
  
}
