<%-- 
    Document   : TelaPagamentoEsta
    Created on : 25 de mai de 2021, 18:23:14
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
        <form action="${pageContext.request.contextPath}/RespondePagEsta" method="get">
            <p>Você deseja enviar a seguinte mensagem? <c:out value="${sessionScope.dadosPagMes.nome}"/></p>
<textarea name="msg">Este Pagamento ja foi Debitado, porque estou sendo cobrado?
            </textarea>

            <input type="submit">
        </form>
    </body>
</html>
