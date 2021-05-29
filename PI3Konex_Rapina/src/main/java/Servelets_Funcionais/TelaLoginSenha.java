/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets_Funcionais;

import ClassesDAO.ClienteDAO;
import ClassesDAO.ContagemDAO;
import ClassesDAO.DoacaoDAO;
import ClassesDAO.EstabelecimentoDAO;
import ClassesDAO.FavoritoDAO;
import ClassesDAO.LoginDAO;
import ClassesDAO.PagamentoDAO;
import ClassesDAO.ReservaDAO;
import ClassesJavaBean.Cartao;
import ClassesJavaBean.Cliente;
import ClassesJavaBean.Doacao;
import ClassesJavaBean.Estabelecimento;
import ClassesJavaBean.Favoritos;
import ClassesJavaBean.Login;
import ClassesJavaBean.Pagamento_mensalidade;
import ClassesJavaBean.Pagamento_taxa;
import ClassesJavaBean.Reserva;
import java.io.IOException;
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
 * @author Gabriel
 */
@WebServlet(name = "TelaLoginSenha", urlPatterns = {"/LogSenha"})
public class TelaLoginSenha extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //boas praticas de uso
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        //VAR que serão utilizada
        Login logUser = new Login();
        boolean temErro = false;
        String email = null;
        int userTipo = 0;
        int id=0;
        int idEsta = 0;
        int idCartao=0;
        String nome = null;

        //Pegando a Sessao da tela anterior
        HttpSession sessaoUser = request.getSession();

        //verificamos se a session tem algum dado para ser obtido
        if (sessaoUser.getAttribute("dadosAcesso") != null) {
            //trasfiro os dados da session anterio pra o novo objeto
            logUser = (Login) sessaoUser.getAttribute("dadosAcesso");

            //setando os valaores para as variaveis que utilizaremos
            email = logUser.getEmail();
            userTipo = logUser.getTipo_usuario();
            id = logUser.getId_usuario();
              
            //Setando o objeto para parametro
            request.setAttribute("logUser", logUser);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/TelaLogSenha.jsp");
            dispatcher.forward(request, response);
        }

        //pego o atributo da JSP
        String senhaInf = request.getParameter("senha");

        //verifico a senha
        if (senhaInf != null && senhaInf.trim().length() > 0) {
            temErro = false;
        }

        //Objetos que serão utilizados
        Login loginUser = new Login(email);
        LoginDAO acesso = new LoginDAO(email, senhaInf);

        loginUser.setSenha(senhaInf);

        //Requests
        request.setAttribute("userLogado", loginUser);

        try {
            //verifica a senha
            int x = acesso.validaSenha();

            if (x == 1) {
                //não tem erro
                temErro = false;
            } else {
                temErro = true;
            }
            request.setAttribute("rtSenha", x);
        } catch (SQLException ex) {
            Logger.getLogger(TelaLoginSenha.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        //verifica se há erros
        if (temErro) {
            //não deixa prosseguir
            RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/TelaLogSenha.jsp");
            dispatcher.forward(request, response);

        } else {
            //prossegue de acordo  tipo de usuario
            if (userTipo == 1) {//Se o tipo de usuario for 1 é um ADM
                sessaoUser.setAttribute("logUser", userTipo);
                
                //Faz os carregamentos dos dados
                ContagemDAO conta = new ContagemDAO();
                try {
                    int qtdSerra=conta.contaPlanoA();
                    int qtdRarpy=conta.contaPlanoB();
                    int qtdAcor=conta.contaPlanoC();
                    sessaoUser.setAttribute("dadosPlano", qtdSerra);
                    sessaoUser.setAttribute("dadosPlanoB", qtdRarpy);
                    sessaoUser.setAttribute("dadosPlanoC", qtdAcor);
                    
                    //verifica qual é mais contratado
                    int maiorPlano = verificaMaiorPlano(qtdSerra, qtdRarpy, qtdAcor);
                    if (maiorPlano > 0) {
                        sessaoUser.setAttribute("maior", maiorPlano);
                    }

                    //CARREGA DADOS INFORMATIVOS
                    int qtdReservaAtivas= conta.contaReservas();
                    sessaoUser.setAttribute("DadosReserva", qtdReservaAtivas);
                    
                    int qtdDoacoes= conta.contaDoacoes();
                    sessaoUser.setAttribute("dadosDoacoes", qtdDoacoes);
                    
                    int qtdPagam= conta.contaPagamentos();
                    sessaoUser.setAttribute("dadosPagamentos", qtdPagam);
                    
                    int qtdUsers= conta.contaUsers();
                    sessaoUser.setAttribute("dadosUsers", qtdUsers);
                    
                    response.sendRedirect(request.getContextPath() + "/MenuADM");

                } catch (SQLException ex) {
                    Logger.getLogger(TelaLoginSenha.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else if (userTipo == 2) {//Se o tipo de usuario for 1 é um Cliente
                sessaoUser.setAttribute("logUser", userTipo);

                //buscar id e nome do usuario e setar esses valores
                email = logUser.getEmail();
                String name = "";
                int idUser = 0;

                try {
                    name = acesso.retornaNomeCli(email);
                    idUser = acesso.retornaIDCli(email);
                    logUser.setNome(name);
                    logUser.setId_usuario(idUser);

                    sessaoUser.setAttribute("dadoName", logUser.getNome());
                    sessaoUser.setAttribute("dadoId", logUser.getId_usuario());

                    //Faz os carregamentos dos dados
                    ContagemDAO conta = new ContagemDAO();

                    //carregar dados gerais: Reservas, doações e qtd de pagamentos
                    int qtdReservasFeitas = conta.contaReservaCli(idUser);
                    sessaoUser.setAttribute("dadosReserCli", qtdReservasFeitas);

                    int qtdDoaçõesFeitas = conta.contaDoeCli(idUser);
                    sessaoUser.setAttribute("dadosDoeCli", qtdDoaçõesFeitas);

                    int qtdPagamentosFeitos = conta.contaPagCli(idUser);
                    sessaoUser.setAttribute("dadosPagCli", qtdPagamentosFeitos);

                    //Carrega a lista de favoritos
                    //constroe o objeto DAO
                    FavoritoDAO actionDAO = new FavoritoDAO();

                    //chama o metodo que retorna uma lista de favoritos
                    List<Favoritos> listaD;
                    listaD = actionDAO.listarDadosFavoritos(idUser);
                    sessaoUser.setAttribute("listaFavCli", listaD);
                    
                    //Chama o metodo que retorna uma lista de pagamentos
                    //constroe o objeto DAO
                    PagamentoDAO actionPag = new PagamentoDAO();
                    
                    //Chama o metodo que retorna uma lista de pagamentos
                    List<Pagamento_taxa> listaE;
                    listaE = actionPag.listarPagamentoCli(idUser);
                    sessaoUser.setAttribute("listaPagamCli", listaE);
                    
                    
                    //Chama o metodo que retorna uma lista de Doações feitas pelo usuario
                    //constroe o objeto DAO
                    DoacaoDAO actionDoa = new DoacaoDAO();
                    
                    //Chama o metodo que retorna uma lista de pagamentos
                    List<Doacao> listaF;
                    listaF = actionDoa.listaDoacoesClie(idUser);
                    sessaoUser.setAttribute("listaDoacoesCli", listaF);
                    
                    //Chama o metodo que retorna lista de Reservas e Dados do Estabelecimento
                    ReservaDAO actionRes = new ReservaDAO();
                    
                    List<Reserva> listaRes;
                    listaRes= actionRes.listarReservaCli(idUser);
                    sessaoUser.setAttribute("listaReservasCli", listaRes);

                    
                    
                    
                } catch (SQLException ex) {
                    Logger.getLogger(TelaLoginSenha.class.getName()).log(Level.SEVERE, null, ex);
                }

                response.sendRedirect(request.getContextPath() + "/MenuCliente");

            } else if (userTipo == 3) {//Se o tipo de usuario for 3 é um Estabelecimento
                sessaoUser.setAttribute("logUser", userTipo);
                Estabelecimento esta = new Estabelecimento();
                Cartao cartao = new Cartao();
                 email = logUser.getEmail();
                 
                try {
                    idEsta = acesso.retornaIDEsta(email);
                    nome = acesso.retornaNome(email);
                    esta = acesso.pegaDadosEsta(idEsta);
                    cartao = acesso.pegaDadosCartao(idEsta);
                    idCartao = acesso.retornaIDCartaoEsta(email);
                    cartao.setId_card(idCartao);
                    esta.setId_estabelecimento(idEsta);
                } catch (SQLException ex) {
                    Logger.getLogger(TelaLoginSenha.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                //Faz os carregamentos dos dados
                ContagemDAO contaDAO = new ContagemDAO();
                EstabelecimentoDAO estaDAO = new EstabelecimentoDAO();
                List<Reserva> listaReserva;
                List<Pagamento_mensalidade> listaMensalidade;
                List<Doacao> listaDoacao;
                
                try {
                    //Carrega a Lista;
                    listaReserva = estaDAO.listarDadosRes(idEsta);
                    listaMensalidade = estaDAO.listaPagMensal(idEsta);
                    listaDoacao = estaDAO.listaDadosDoa(idEsta);
                    sessaoUser.setAttribute("dadosListaRes", listaReserva);
                    sessaoUser.setAttribute("dadosListaMensal", listaMensalidade);
                    sessaoUser.setAttribute("dadosListaDoacao", listaDoacao);
                    //CARREGA DADOS INFORMATIVOS
                    int qtdResVal = contaDAO.contaResValidada(idEsta);
                    sessaoUser.setAttribute("dadosResVal", qtdResVal);

                    int qtdContaDoa = contaDAO.contaDoaRecebidas(idEsta);
                    sessaoUser.setAttribute("dadosDoacao", qtdContaDoa);
                    
                    int qtdContaFav = contaDAO.contaFavoritos(idEsta);
                    sessaoUser.setAttribute("dadosFav", qtdContaFav);
                    
                    int qtdContaRec = contaDAO.contaRecebidos(idEsta);
                    sessaoUser.setAttribute("dadosRec", qtdContaRec);
                    sessaoUser.setAttribute("nomeEsta", nome);
                    sessaoUser.setAttribute("idEsta", idEsta);
                    sessaoUser.setAttribute("cartao", cartao);
                    sessaoUser.setAttribute("esta", esta);

                } catch (SQLException ex) {
                    Logger.getLogger(TelaLoginSenha.class.getName()).log(Level.SEVERE, null, ex);
                }

                response.sendRedirect(request.getContextPath() + "/MenuEsta");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    public static int verificaMaiorPlano(int qtdSerra, int qtdRarpy, int qtdAcor){
        int maior = 0;
        
        //condições
        if (qtdSerra > qtdRarpy) {
            maior = 2;
        } else {
            maior = 1;
        }
        if (qtdRarpy > qtdAcor) {
            maior = 1;
        }else{
            maior = 3;
        }
        if (qtdAcor > qtdSerra) {
            maior = 3;
        }else{
            maior = 2;
        }

        return maior;
    }
    
}
