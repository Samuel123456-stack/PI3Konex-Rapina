<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <title>Menu Rapinante</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords" content="HTML, CSS, JAVASCRIPT">
        <meta name="description" content="Crowd Control">
        <meta name="author" content="konex-group">

        <link rel='stylesheet' type='text/css' href="${pageContext.request.contextPath}/CSS/altCard.css">
        <link href="https://fonts.googleapis.com/css2?family=Ubuntu:wght@300;400;500;700&display=swap" rel="stylesheet">
        
    </head>
    <body>
        <br>
        <div id="only-screen">
            <section class="menu-bar">
                <div>
                    <img src="${pageContext.request.contextPath}/images/icons/logotipo.png" alt="logo-image" class="logo-icon" />
                </div>
            </section>
            
            <div class="outline-color">
                <div class="query-select">
                    <h2>Obrigado por se cadastrar. Em breve você
                    poderá utilizar o melhor da Rapina.</h2>
                    <p>
                        Estamos em fase de construção, por isso estamos
                        com funcionalidades limitadas.
                    </p>
                </div>
                <footer class="option">
                    <form action="${pageContext.request.contextPath}/Menu" method="get">
                        <button type="submit" name="btn" value="att card">Alterar cartão</button>
                        <button type="submit" name="btn" value="att dados">Alterar dados</button>
                        <button type="submit" name="btn" value="sub exclusao">Solicitar exclusão da conta</button>
                    </form>
                </footer>
            </div>
        </div>
    </body>
</html>
