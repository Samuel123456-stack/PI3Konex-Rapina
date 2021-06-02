<%-- 
    Document   : ConfirmaMensagem
    Created on : 2 de jun de 2021, 16:58:53
    Author     : gusta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Confirmação da mensagem</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords" content="HTML, CSS, JAVASCRIPT">
        <meta name="description" content="Crowd Control">
        <meta name="author" content="konex-group">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/messageConfirm.css">
        <link href="https://fonts.googleapis.com/css2?family=Ubuntu:wght@300;400;500;700&display=swap" rel="stylesheet">
    </head>
    <body>
        <div id="container-landing">
            <div class="message-container">
                <div class="message-content">
                    <img src="${pageContext.request.contextPath}/images/icons/check.png" alt="check-icons" />
                    <section class="compose">
                        <h3>
                            A mensagem foi enviada com sucesso!
                        </h3>
                        <button name="btn"><a style="text-decoration: none;" href="${pageContext.request.contextPath}/MenuEsta">Voltar</a></button>
                    </section>
                </div>
            </div>
        </div>
    </body>
</html>

