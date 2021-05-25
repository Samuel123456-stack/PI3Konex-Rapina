<%-- 
    Document   : TelaRespostaPag
    Created on : 24 de mai de 2021, 19:21:46
    Author     : gusta
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="${pageContext.request.contextPath}/NotificaPagamento" method="get">
            <p>Você deseja enviar a seguinte mensagem? <c:out value="${sessionScope.dadosPag.nomeUser}"/></p>
            
            <c:if test="${sessionScope.dadosPag.id_usuario!=null}">
                <p><c:out value="${sessionScope.dadosPag.id_usuario}"/></p>
            </c:if>
            <c:if test="${sessionScope.dadosPag.id_estabelecimento!=null}">
                <p><c:out value="${sessionScope.dadosPag.id_estabelecimento}"/></p>
            </c:if>
                
            <p>Tipo de Usuário:<c:out value="${sessionScope.dadosPag.tipo_user}"/></p>
            
            <textarea name="msg">Caro, <c:out value="${sessionScope.dadosPag.nomeUser}"/>, consta em nosso sistema
            um atraso referente a sua fatura no valor de: <c:out value="${sessionScope.dadosPag.valor_total}"/>
            ,que se encontra vencida desde: <c:out value="${sessionScope.dadosPag.data_cobranca}"/>.
            Ficamos no Aguardo da Regularização desta pendencia.
            Atenciosamente Grato,
            Rapina.
            </textarea>

            <input type="submit">
        </form>
    </body>
</html>