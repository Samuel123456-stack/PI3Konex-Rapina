<%-- 
    Document   : TelaInicial
    Created on : 2 de mai de 2021, 16:28:40
    Author     : Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Bem vindo(a) a Rapina</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords" content="HTML, CSS, JAVASCRIPT">
        <meta name="description" content="Crowd Control">
        <meta name="author" content="konex-group">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/TelaIndex.css">
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/icons/logotipo.png">
        <link href="https://fonts.googleapis.com/css2?family=Ubuntu:wght@300;400;500;700&display=swap" rel="stylesheet">
    </head>
    <body>
        <div id="container-landing">
            <section class="menu-bar">
                <div>
                    <img src="${pageContext.request.contextPath}/images/icons/logotipo.png" alt="logo-image" class="logo-icon" />
                </div>
            </section>
            
            <div class="main-container">
                <h1>
                    Seja bem vindo(a), você quer voar com Rapina?
                </h1>
                <p class="first-paragraph">
                    Com a rapina você pode voar mais alto e com liberdade.
                </p>
                
                <footer>
                    <a href="${pageContext.request.contextPath}/Pre_Cadastro"><button type="button">Cadastrar</button></a>
                    <a href="${pageContext.request.contextPath}/LogEmail"><button type="button">Entrar</button></a>
                </footer>
            </div>
        </div>
    </body>
</html>
