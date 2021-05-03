<%-- 
    Document   : TelaPosAtuliza
    Created on : 30 de abr de 2021, 19:30:44
    Author     : Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel='stylesheet' type='text/css' href="${pageContext.request.contextPath}/CSS/confAttDados.css">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/icons/logotipo.png">
    <title>Sucesso</title>
</head>
<body>
    <div class="todo">
        <br>
        <img src="${pageContext.request.contextPath}/images/icons/logotipo.png" alt="">
        <h1>Confirmação feita com sucesso</h1>
        <p>Selecione uma das opções</p>
        <br><br>
        <div class="floatleft">
            <a href="${pageContext.request.contextPath}/MenuCliente" id="btnVol"><button>Voltar</button></a>
        </div>
        <div class="floatleft">
            <a href="${pageContext.request.contextPath}/TelaSaida" action="${pageContext.request.contextPath}/ExitSession" method="get" id="btnSair"><button >Sair</button></a>    
        </div>
        
    </div>  
</body>
</html>
