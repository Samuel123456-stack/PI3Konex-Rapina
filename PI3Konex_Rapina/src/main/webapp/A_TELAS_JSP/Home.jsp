<%-- 
    Document   : Home
    Created on : 21 de mai de 2021, 19:19:43
    Author     : Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Home</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords" content="HTML, CSS, JAVASCRIPT">
        <meta name="description" content="Crowd Control">
        <meta name="author" content="konex-group">


        <link rel='stylesheet' type='text/css' href="${pageContext.request.contextPath}/CSS/home.css">
        <script src="https://kit.fontawesome.com/194a95388c.js" crossorigin="anonymous"></script>
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/icons/logotipo.png">
        <link href="https://fonts.googleapis.com/css2?family=Ubuntu:wght@300;400;500;700&display=swap" rel="stylesheet">

        
    </head>
    <body>
        <div id="container-landing">
            <div class="container-page">
                <div class="background-image">
                    <section class="menu-bar">
                        <div>
                            <a href="${pageContext.request.contextPath}/Home"><img src="${pageContext.request.contextPath}/images/icons/logotipo.png" alt="logo-image" class="logo-icon" /></a>
                        </div>
                        <div>
                    
                            <div class="dropdown">
                                <button class="dropbtn">
                                    <svg width="40" height="31" viewBox="0 0 40 31" fill="none" xmlns="http://www.w3.org/2000/svg">
                                        <rect width="40" height="3" fill="#4361EE"/>
                                        <rect y="28" width="40" height="3" fill="#4361EE"/>
                                        <rect y="14" width="40" height="3" fill="#4361EE"/>
                                    </svg> 
                                </button>
                                <div class="dropdown-content">
                                    <a href="${pageContext.request.contextPath}/Pre_Cadastro">Voe Com a Rapina</a>
                                    <a href="${pageContext.request.contextPath}/LogEmail">Login</a>
                                    <a href="${pageContext.request.contextPath}/TelaDoacao">Doa????es</a>
                                    <a href="${pageContext.request.contextPath}/Home">Site Institucional</a>
                                </div>
                              </div>
                        </div>
                    </section>

                    <main>
                        <h1>Liberdade com seguran??a</h1>
                        <p>Encontre estabelecimentos proximos de voc?? e reserve</p>
                        <div class="form-container">
                            <form action="" name="searching">
                                <div class="input-block">
                                    <a href="${pageContext.request.contextPath}/BuscaPorCep">
                                    <input 
                                        type="text" 
                                        id="block-search" 
                                        maxlength="40" 
                                        name="text-name" 
                                        data-toggle="modal"
                                        data-target="#windowModal"
                                        />
                                    <button type="button">
                                        <img src="${pageContext.request.contextPath}/images/icons/search-icon.png" alt="search-image" />
                                    </button>
                                    </a>
                                </div>
                                <div class="input-submit">
                                    <input type="submit" value="Buscar" />
                                </div>
                            </form>
                        </div>
                    </main>  
                </div>
            </div>

            <main class="outline-container-situation">
                <div class="landing-section">
                    <div class="first-content">
                        <img src="${pageContext.request.contextPath}/images/freeReser.png" alt="image" />
                    </div>
                    <div class="second-content">
                        <img src="${pageContext.request.contextPath}/images/dream-liberty.png" alt="image" />
                    </div>
                    <div class="third-content">
                        <img src="${pageContext.request.contextPath}/images/search-secure.png" alt="image" />
                    </div>
                </div>

                <section class="selection-content">
                    <header>
                        <h4>Os melhores da Rapina</h4>
                    </header>
                    <div class="options-select">
                        <div class="first-option">
                            <img src="${pageContext.request.contextPath}/images/mcDonald.png" alt="donald-image" />
                        </div>
                        <div class="second-option">
                            <img src="${pageContext.request.contextPath}/images/grill.png" alt="grill-image" />
                        </div>
                        <div class="third-option">
                            <img src="${pageContext.request.contextPath}/images/yakisoba.png" alt="yakisoba-image" />
                        </div>
                        <div class="forth-option">
                            <img src="${pageContext.request.contextPath}/images/burger.png" alt="burger-image" />
                        </div>
                    </div>
                </section>

                <div class="grid-container">
                    <div class="grid-subject">
                        <main>
                            <img src="${pageContext.request.contextPath}/images/business.png" alt="image-business" />
                        </main>
                        <article>
                            <h2>Voe com a gente</h2>
                            <p>
                                Venha fazer parte do maior grupo de busca por restaurantes,
                                bares e lanchonetes. Nesse momento da pandemia voc?? pode
                                ter liberdade com seguran??a.
                            </p>
                            <a href="">
                                <p>Saiba mais</p>
                            </a>
                        </article>
                    </div>
                </div>

                <footer class="footer-image">
                    <img src="${pageContext.request.contextPath}/images/footer-image.png" alt="image-footer" />
                </footer>
            </main>

            <div class="rodape">
                <div class="rodapeprin">
                    <div class="grupos">
                        <div class="top10">
                            <h3>A Rapina</h3>
                            <a href="${pageContext.request.contextPath}/Sobre" style="text-decoration: none;">Site Institucional</a>
                            <br><br>
                            <a href="${pageContext.request.contextPath}/Contato" style="text-decoration: none;">Fale conosco</a>
                            <br><br>
                            <a href="${pageContext.request.contextPath}/TelaTermos" style="text-decoration: none;">Termos de uso</a>
                            <br><br>
                            <a href="${pageContext.request.contextPath}/Privacidade" style="text-decoration: none;">Pol??tica de Privacidade</a>
                        </div>
                        <div class="top10">
                            <h3>Voe com a Rapina</h3>
                            <a href="${pageContext.request.contextPath}/Pre_Cadastro" style="text-decoration: none;">Cadastre seu estabelecimento</a>
                            <br><br>
                            <a href="${pageContext.request.contextPath}/TelaPlanos" style="text-decoration: none;">Rapina Planos</a>
                            <br><br>
                            <a href="${pageContext.request.contextPath}/Campanha" style="text-decoration: none;">Campanha Rapinantes</a>
                            <br><br>
                            <a href="${pageContext.request.contextPath}/LogEmail" style="text-decoration: none;">J?? sou uma loja parceira</a>
                        </div>
                        <div class="top10">
                            <div class="social">
                                <h3>Social</h3>
                                <a href="" title="Facebook"><svg class="icon" xmlns="http://www.w3.org/2000/svg" width="11" height="24" viewBox="0 0 11 24"><path d="M10.7 4L8.8 4C7.2 4 6.9 4.9 6.9 6L6.9 8.6 10.7 8.6 10.3 12.8 7.2 12.8 7.2 23.5 3.3 23.5 3.3 12.8 0 12.8 0 8.6 3.3 8.6 3.3 5.6C3.3 2.1 5.2 0 8.1 0 9.4 0 10.6 0.1 11 0.1L11 4 10.7 4Z"></path></svg></a>
                                <a href="" title="Instagram"><svg width="20" height="20" xmlns="http://www.w3.org/2000/svg"><path d="M17.510373 0H2.406639C1.078838 0 0 1.0788382 0 2.3236515v15.1867219c0 1.3278009 1.078838 2.406639 2.406639 2.406639h15.186722C18.921162 19.9170124 20 18.8381743 20 17.593361V2.3236515C19.917012 1.0788382 18.838174 0 17.510373 0zm-2.572614 2.4896266h1.659751c.497926 0 .829876.3319502.829876.8298755v1.659751c0 .4979253-.33195.8298755-.829876.8298755h-1.659751c-.497925 0-.829875-.3319502-.829875-.8298755v-1.659751c0-.4979253.33195-.8298755.829875-.8298755zM9.958506 6.1410788c2.074689 0 3.817428 1.7427386 3.817428 3.8174274s-1.742739 3.8174274-3.817428 3.8174274c-2.074689 0-3.817427-1.7427386-3.817427-3.8174274s1.742738-3.8174274 3.817427-3.8174274zm6.639004 11.2863071H3.319502c-.497925 0-.829875-.3319502-.829875-.8298755V8.2987552h1.659751c-.248963.9128631-.331951 1.9917012-.082988 2.9875519.497925 2.3236514 2.406639 4.1493775 4.73029 4.5643153 3.900415.746888 7.302905-2.1576763 7.302905-5.8921162 0-.5809128-.165975-1.1618257-.248963-1.659751h1.659751v8.2987552c-.082987.4979253-.414937.8298755-.912863.8298755z" fill-rule="evenodd"></path></svg></a>
                                <a href="" title="Twitter"><svg width="24" height="19" xmlns="http://www.w3.org/2000/svg"><path d="M20.957 4.543v.606c0 6.209-4.777 13.327-13.56 13.327-2.774 0-5.24-.758-7.397-2.12.462 0 .77.15 1.233.15 2.157 0 4.314-.756 6.01-1.968-2.004 0-3.853-1.363-4.47-3.332.309 0 .617.152.925.152.463 0 .463 0 1.079-.152C2.466 10.752.462 8.783.462 6.512c0 .454 1.695.454 2.466.606C1.695 6.209.925 4.846.925 3.18c0-.908.308-1.666.77-2.423 2.311 2.878 6.01 4.695 9.862 4.998-.154-.455-.154-.758-.154-1.06C11.403 2.12 13.56 0 16.18 0c1.387 0 2.62.454 3.544 1.514 1.079-.302 2.004-.605 2.928-1.211-.462 1.211-1.233 1.969-2.003 2.574a14.785 14.785 0 0 0 2.774-.757c-.77.909-1.541 1.817-2.466 2.423z" fill-rule="evenodd"></path></svg></a>
                                <a href="" title="Youtube"><svg width="24" height="17" xmlns="http://www.w3.org/2000/svg"><path d="M23.8 3.6s-.2-1.7-1-2.4c-.9-1-1.9-1-2.4-1C17 0 12 0 12 0S7 0 3.6.2c-.5.1-1.5.1-2.4 1-.7.7-1 2.4-1 2.4S0 5.5 0 7.5v1.8c0 1.9.2 3.9.2 3.9s.2 1.7 1 2.4c.9 1 2.1.9 2.6 1 1.9.2 8.2.2 8.2.2s5 0 8.4-.3c.5-.1 1.5-.1 2.4-1 .7-.7 1-2.4 1-2.4s.2-1.9.2-3.9V7.4c0-1.9-.2-3.8-.2-3.8zM9.5 11.5V4.8L16 8.2l-6.5 3.3z" fill-rule="evenodd"></path></svg></a>
                                <a href="" title="LinkedIn"><svg width="19" height="19" xmlns="http://www.w3.org/2000/svg"><path d="M3.859375 19h-3.5625V5.9375h3.5625V19zM2.078125 4.43175C.931 4.43175 0 3.493625 0 2.337S.931.24225 2.078125.24225 4.15625 1.180375 4.15625 2.337s-.929812 2.09475-2.078125 2.09475zM18.109375 19h-3.5625v-6.65475c0-3.9995-4.75-3.6966875-4.75 0V19h-3.5625V5.9375h3.5625v2.0959375c1.65775-3.070875 8.3125-3.2976875 8.3125 2.94025V19z" fill-rule="nonzero"></path></svg></a>
                            </div>
                        </div>
                        <div style="clear: both;">
                            <br>
                        </div>
                    </div>
                </div>
                <div class="subRodape">
                    <div class="grupo">
                        <div class="txt1">
                            <p>??Copyright 2021 - todos os direitos reservados Papina</p>
                        </div>
                        <div class="txt2">
                            <p>Desenvolvido por konex</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

