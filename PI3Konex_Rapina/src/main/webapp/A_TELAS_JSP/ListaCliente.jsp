<%-- 
    Document   : ListaCliente
    Created on : 29 de abr de 2021, 01:26:03
    Author     : gusta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista Cliente</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>ID Cliente</th>
                    <th>Nome Cliente</th>
                    <th>Genero Cliente</th>
                    <th>CPF Cliente</th>
                    <th>Email Cliente</th>
                    <th>Senha Cliente</th>
                    <th>Nascimento</th>
                    <th>Concorda</th>
                    <th>Concorda News</th>
                    <th>ID Cartao</th>
                   <th colspan="2">Ações</th>
                </tr>
            </thead>
                        <tbody>
                <c:forEach items="${clientes}" var="cli">
                    <tr>
                <td><c:out value="${cli.id_usuario}"/></td>
                <td><c:out value="${cli.nome}"/></td>
                <td><c:out value="${cli.genero}"/></td>
                <td><c:out value="${cli.cpf}"/></td>
                <td><c:out value="${cli.email}"/></td>
                <td><c:out value="${cli.senha}"/></td>
                <td><c:out value="${cli.data_nascimento}"/></td>
                <td><c:out value="${cli.concorda}"/></td>
                <td><c:out value="${cli.concorda_newstalleter}"/></td>
                <td><c:out value="${cli.num_cartao}"/></td>
                <td><a href="ControlaCartao?action=editar&id_usuario=<c:out value="${cli.id_usuario}"/>">Editar</a></td>
                <td><a href="ControlaCartao?action=deletar&id_usuario=<c:out value="${cli.id_usuario}"/>">Excluir</a></td>
               
                        </tr>
                </c:forEach>
                      
            </tbody>
        </table>

    </body>
</html>
