<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Entre com Email</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords" content="HTML, CSS, JAVASCRIPT">
        <meta name="description" content="Crowd Control">
        <meta name="author" content="konex-group">

        <link rel="stylesheet" href="../CSS/formEmail.css">
        <script src="https://kit.fontawesome.com/194a95388c.js" crossorigin="anonymous"></script>
        <link rel="shortcut icon" href="../images/icons/logotipo.png">
        <link href="https://fonts.googleapis.com/css2?family=Ubuntu:wght@300;400;500;700&display=swap" rel="stylesheet">
    </head>
    <body>
        <div id="container-landing">
            <section class="menu-bar">
                <div>
                    <img src="../images/icons/logotipo.png" alt="logo-image" class="logo-icon" />
                </div>
            </section>


            <div class="main-page">
                <section>
                    <img src="../images/cloud.png" alt="cloud-image" />

                </section>
                <main class="form-container">
                    <h3>Login entrar com email</h3>
                    
                    <!--FORMULÁRIO DE ENTRADA- LOGIN EMAIL-->
                    <form action="" method="get">
                        <div class="input-field">
                            
                            <!--INPUT EMAIL-->
                            <input type="email" name="verificaEmail" placeholder="Email" maxlength="28"
                                   value="${users.email}" class="${not empty erroEmail ? 'msg-erro' : ''}" />
                            <span>
                                <img src="../images/icons/Vector-email.png" alt="email-icon" />
                            </span>
                            <div class="underline"></div>
                        </div>
                        <div class="submit-block">
                            <input type="submit" name="button-submit" value="Continuar" />
                        </div>
                    </form>
                </main>

                <article>
                    <img src="../images/lock.png" alt="lock-image" />
                </article>
            </div>
        </div>
    </div>
</body>
</html>
