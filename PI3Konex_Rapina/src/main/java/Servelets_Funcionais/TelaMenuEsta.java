/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets_Funcionais;

import ClassesDAO.PlanosDAO;
import ClassesJavaBean.Planos;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gusta
 */
@WebServlet(name = "TelaMenuEsta", urlPatterns = {"/MenuEstabelecimento"})
public class TelaMenuEsta extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //boas praticas
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        Calendar c = Calendar.getInstance();
        int PegaMes = c.get(Calendar.MONTH);
        int aux = 0;
        int[] meses = {1,2,3,4,5,6,7,8,9,10,11,12};
        
        for(int i =0; i<meses.length; i++){
            if(meses[i] == PegaMes){
                aux=meses[i+1];
            } else {
            }
        }

        //Pegar o parametro
        String botao = request.getParameter("btn");

        //condição
        if (botao != null) {
            //condição
            if (botao.equals("att card")) {
                response.sendRedirect(request.getContextPath() + "/TelaAltCard");
            } else if (botao.equals("att dados")) {
                response.sendRedirect(request.getContextPath() + "/AlteraDadosEsta");

            } else if (botao.equals("sub exclusao")) {
                response.sendRedirect(request.getContextPath() + "/TelaSolicitaExclusao");
            } else if (botao.equals("alterar plano")) {
                int id_esta = 3;
                PlanosDAO dao = new PlanosDAO();
                try {
                    List<Planos> listaDados;
                    listaDados = dao.planosPorID(id_esta);
                    request.setAttribute("ListaPlano", listaDados);
                    request.setAttribute("mes_vencimento", aux);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/TelaAltPlano.jsp");
                    dispatcher.forward(request, response);

                } catch (SQLException ex) {
                    Logger.getLogger(TelaAltPlano.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}