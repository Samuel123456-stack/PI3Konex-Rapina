<!--
    TELA REFERENTE AO MARCO II
-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cadastro- Rapinante</title>
        
        <meta charset="UTF-8">
        <link rel='stylesheet' type='text/css' href="${pageContext.request.contextPath}/CSS/cadastroCli.css"/>
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/icons/logotipo.png">

        <style>
            .erroInput{
                border: 1px solid red;
            }
        </style>
    </head>
    <body>
        <div id="container-landing">
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
                            <a href="${pageContext.request.contextPath}/TelaDoacao">Doações</a>
                            <a href="${pageContext.request.contextPath}/Home">Site Institucional</a>
                        </div>
                      </div>
                </div>
            </section>
        </div>
        <div class="Foguete" style=" background-image: url(${pageContext.request.contextPath}/images/Saly1.png); ">
            <div class="check">
                <div class="bloco">

                    <div class="topobloco">
                        <svg width="42" height="41" viewBox="0 0 42 41" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M27.4083 3.27087C27.5132 2.19653 29.2716 2.11389 30.6101 2.55189C30.6888 2.57668 32.9021 3.35351 32.2722 3.80803C29.8315 3.19649 27.3383 5.31211 27.4083 3.27087ZM9.82453 3.84109C12.5102 3.1717 15.2484 5.49392 15.1696 3.25434C15.0559 2.08083 13.1226 1.98993 11.6529 2.46098C11.5654 2.48577 9.14218 3.32872 9.82453 3.84109ZM27.9506 12.568C27.1808 12.568 26.5509 13.163 26.5509 13.8903C26.5509 14.6175 27.1808 15.2125 27.9506 15.2125C28.7205 15.2125 29.3503 14.6175 29.3503 13.8903C29.3503 13.163 28.7205 12.568 27.9506 12.568ZM13.9799 12.568C13.2101 12.568 12.5802 13.163 12.5802 13.8903C12.5802 14.6175 13.2101 15.2125 13.9799 15.2125C14.7497 15.2125 15.3796 14.6175 15.3796 13.8903C15.3796 13.163 14.7497 12.568 13.9799 12.568ZM41.8427 26.0551C40.9766 28.0385 38.2822 26.9641 36.2526 25.9559C35.0716 31.6664 31.17 35.1622 25.2037 36.22C25.23 36.2944 25.0288 36.2117 27.3033 36.3026C30.2427 36.4183 32.8846 36.0464 35.824 35.6415C34.0918 34.501 34.8267 32.5755 34.9666 32.4929C35.0891 32.4185 36.2526 32.6333 36.8562 33.4432C37.6086 32.4102 39.3407 32.2201 39.4982 32.3193C39.6381 32.4102 40.0755 34.0465 38.8945 35.1787C39.3057 35.1043 39.6119 35.0465 39.7519 35.0051C39.9793 34.939 41.3003 35.939 40.0231 36.1043C38.7721 36.2943 38.046 36.5257 35.9027 36.9968C31.8873 37.8811 28.3881 37.972 25.6061 38.0546L25.6936 39.0133C26.0261 40.5091 23.6466 41.0214 23.2791 39.5256C23.3491 41.0049 20.9084 41.3272 20.7947 39.443L20.7509 39.881C20.6897 41.4016 18.2665 41.3603 18.2752 39.8314C17.6191 40.9471 15.817 40.3934 15.9657 39.1289L16.0707 38.1042C12.8601 38.1786 10.8481 38.3604 10.6644 38.3604C8.83599 38.3604 8.83599 35.7489 10.6644 35.7489C10.8743 35.7489 13.0876 35.8563 16.1932 35.9803C10.8481 34.6994 7.12136 31.435 6.14157 26.2121C3.95454 27.2699 1.1114 28.4269 0.175353 26.2782C-0.7432 24.1791 2.0562 22.7577 6.0191 20.2123C6.08034 19.6669 6.15907 19.1132 6.2553 18.576C4.99557 16.9563 5.24052 15.5762 4.84685 13.5845C3.37717 13.7828 2.81729 12.8325 2.78229 11.6755C2.80854 11.0722 2.966 10.4441 2.99225 10.4028C3.08848 10.2541 3.87581 10.2375 4.10326 10.1879C4.62815 7.56822 8.52981 7.44425 12.0553 7.33682C13.7787 5.53524 16.0095 3.9072 19.1325 3.34524C17.7941 1.742 18.8351 0.0478533 18.9226 0.00653263C19.0713 -0.0595805 20.7772 0.361891 21.2233 1.92381C21.6782 1.19657 22.8242 0.981701 22.938 1.03955C23.0342 1.08913 23.4979 2.27917 22.5093 3.17996C26.0348 3.46921 28.8255 5.2212 30.9075 7.36988C34.0656 7.49384 37.1887 7.85746 37.6523 10.1797C37.8885 10.2293 38.6671 10.2458 38.7633 10.3946C38.7896 10.4359 38.947 11.0639 38.9733 11.6672C38.9295 12.8159 38.3784 13.7663 36.9087 13.5762C36.6288 15.0059 36.6725 16.2951 36.1476 17.5182C36.3576 18.4851 36.4976 19.4851 36.5675 20.5264C39.8043 22.6255 42.7175 24.0386 41.8427 26.0551ZM18.1527 12.5598C18.2315 8.92353 14.8372 9.07229 11.2767 9.22931C9.37838 9.31195 7.8737 9.38633 7.29633 10.378C6.29904 12.1052 7.81246 18.0554 9.32589 18.7413C10.1832 19.1297 15.747 19.3942 16.8755 18.1546C17.5929 17.3777 18.1877 14.0721 18.1527 12.5598ZM22.7018 17.3777C22.3256 16.353 22.1769 14.8902 21.3633 14.6754C21.1883 14.6341 20.576 14.6341 20.401 14.6754C19.5262 14.9068 19.4562 16.5017 18.9138 17.7496C20.261 17.7496 20.6022 18.5513 20.9871 18.5513C21.3633 18.5513 21.5383 17.6174 22.7018 17.3777ZM34.573 10.378C33.9956 9.37806 32.4034 9.31195 30.5051 9.22931C26.9883 9.07229 23.6641 8.91527 23.7428 12.5598C23.6991 14.0721 24.1802 17.3777 24.8975 18.1628C26.0348 19.3942 31.5986 19.138 32.4472 18.7496C33.8294 18.1215 35.6402 12.2292 34.573 10.378Z" fill="#4361EE"/>
                        </svg>
                        <h1 style="font-weight: bold;">Registrando uma nova águia</h1>
                        <p>Esta é primeira e penúltima etapa do seu cadastro</p>
                    </div>

                    <form action="${pageContext.request.contextPath}/ControlaClientes" method="post">
                        <div class="svg">
                            <svg width="18" height="19" viewBox="0 0 18 19" fill="none" xmlns="http://www.w3.org/2000/svg">
                            <path opacity="0.4" d="M9 0C6.243 0 4 2.243 4 5C4 7.757 6.243 10 9 10C11.757 10 14 7.757 14 5C14 2.243 11.757 0 9 0ZM9 8C7.346 8 6 6.654 6 5C6 3.346 7.346 2 9 2C10.654 2 12 3.346 12 5C12 6.654 10.654 8 9 8ZM18 19V18C18 14.141 14.859 11 11 11H7C3.14 11 0 14.141 0 18V19H2V18C2 15.243 4.243 13 7 13H11C13.757 13 16 15.243 16 18V19H18Z" fill="black"/>
                            </svg>
                        </div>
                        <!-- INPUT 1-->
                        <input type="text" id="nome" name="nome" placeholder="Digite seu nome" value="${cliente.nome}" class="text ${not empty erroNome ? 'erroInput' : '' }">

                        <div class="margin"></div>

                        <div class="svg">
                            <svg width="18" height="18" viewBox="0 0 18 18" fill="none" xmlns="http://www.w3.org/2000/svg">
                            <g opacity="0.4">
                            <path d="M1 5V3C1 2.46957 1.21071 1.96086 1.58579 1.58579C1.96086 1.21071 2.46957 1 3 1H5" stroke="black" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
                            <path d="M1 13V15C1 15.5304 1.21071 16.0391 1.58579 16.4142C1.96086 16.7893 2.46957 17 3 17H5" stroke="black" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
                            <path d="M13 1H15C15.5304 1 16.0391 1.21071 16.4142 1.58579C16.7893 1.96086 17 2.46957 17 3V5" stroke="black" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
                            <path d="M13 17H15C15.5304 17 16.0391 16.7893 16.4142 16.4142C16.7893 16.0391 17 15.5304 17 15V13" stroke="black" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
                            <path d="M6 7H6.01" stroke="black" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
                            <path d="M12 7H12.01" stroke="black" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
                            <path d="M6.5 12C6.82588 12.3326 7.21485 12.5968 7.64413 12.7772C8.07341 12.9576 8.53436 13.0505 9 13.0505C9.46564 13.0505 9.92659 12.9576 10.3559 12.7772C10.7852 12.5968 11.1741 12.3326 11.5 12" stroke="black" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
                            </g>
                            </svg>                
                        </div>           
                        <!-- INPUT 2-->
                        <input type="text"  name="cpf" maxlength="15" placeholder="Informe seu CPF" value="${cliente.cpf}" class="text ${not empty erroCpf ? 'erroInput' : '' }">
                        <div class="svg">
                            <svg width="20" height="16" viewBox="0 0 20 16" fill="none" xmlns="http://www.w3.org/2000/svg">
                            <path opacity="0.4" d="M20 2C20 0.9 19.1 0 18 0H2C0.9 0 0 0.9 0 2V14C0 15.1 0.9 16 2 16H18C19.1 16 20 15.1 20 14V2ZM18 2L10 7L2 2H18ZM18 14H2V4L10 9L18 4V14Z" fill="black"/>
                            </svg>                               
                        </div> 

                        <!-- INPUT 3-->
                        <input type="text" id="email" name="email" placeholder="Email para login" value="${cliente.email}" class="text ${not empty erroEmail ? 'erroInput' : '' }">

                        <div class="genero">
                            <h1 style="font-weight: bold;" >Qual é o seu gênero?</h1>
                            <div class="radio">
                                <label for="Masculino">
                                    <!-- INPUT 4-->
                                    <input type="radio" id="Masculino" name="genero" value="Masculino" value="${cliente.genero}">
                                    <p>Masculino</p>
                                </label>
                                <div class="marginRadio"></div>
                                <label for="Feminino">
                                    <!-- INPUT 5-->
                                    <input type="radio" id="Feminino" name="genero" value="Feminino" value="${cliente.genero}">
                                    <p>Feminino</p>
                                </label>
                            </div>
                        </div>

                        <!-- INPUT 6-->                         
                        <input type="text" id="data" name="dataNasc" placeholder="Qual é a sua data de nascimento?" value="${cliente.data_nascimento}" class="data ${not empty erroDataNasc ? 'erroInput' : '' }">
                        <div class="svgdata">
                            <svg width="22" height="22" viewBox="0 0 22 22" fill="none" xmlns="http://www.w3.org/2000/svg">
                            <g opacity="0.4">
                            <path d="M17 3H5C2.79086 3 1 4.79086 1 7V17C1 19.2091 2.79086 21 5 21H17C19.2091 21 21 19.2091 21 17V7C21 4.79086 19.2091 3 17 3Z" stroke="black" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
                            <path d="M7 1V5" stroke="black" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
                            <path d="M15 1V5" stroke="black" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
                            <path d="M1 9H21" stroke="black" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
                            </g>
                            </svg>      
                        </div>

                        <div class="svg">
                            <svg width="20" height="20" viewBox="0 0 20 20" fill="none" xmlns="http://www.w3.org/2000/svg">
                            <path opacity="0.4" d="M15 5H20V15H15V17C15 17.2652 15.1054 17.5196 15.2929 17.7071C15.4804 17.8946 15.7348 18 16 18H18V20H15.5C14.95 20 14 19.55 14 19C14 19.55 13.05 20 12.5 20H10V18H12C12.2652 18 12.5196 17.8946 12.7071 17.7071C12.8946 17.5196 13 17.2652 13 17V3C13 2.73478 12.8946 2.48043 12.7071 2.29289C12.5196 2.10536 12.2652 2 12 2H10V0H12.5C13.05 0 14 0.45 14 1C14 0.45 14.95 0 15.5 0H18V2H16C15.7348 2 15.4804 2.10536 15.2929 2.29289C15.1054 2.48043 15 2.73478 15 3V5ZM0 5H11V7H2V13H11V15H0V5ZM18 13V7H15V13H18ZM6.5 10C6.5 9.60218 6.34196 9.22064 6.06066 8.93934C5.77936 8.65804 5.39782 8.5 5 8.5C4.60218 8.5 4.22064 8.65804 3.93934 8.93934C3.65804 9.22064 3.5 9.60218 3.5 10C3.5 10.3978 3.65804 10.7794 3.93934 11.0607C4.22064 11.342 4.60218 11.5 5 11.5C5.39782 11.5 5.77936 11.342 6.06066 11.0607C6.34196 10.7794 6.5 10.3978 6.5 10ZM11 8.89C10.39 8.33 9.44 8.38 8.88 9C8.32 9.6 8.37 10.55 9 11.11C9.55 11.63 10.43 11.63 11 11.11V8.89Z" fill="black"/>
                            </svg>                
                        </div>  

                        <!-- INPUT 6-->
                        <input type="password" id="senha" name="senha" placeholder="Digite uma senha" minlength="8" class="text ${not empty ErroSenhaRe ? 'erroInput' : ''}">

                        <div class="margin"></div>

                        <div class="svg">
                            <svg width="18" height="21" viewBox="0 0 18 21" fill="none" xmlns="http://www.w3.org/2000/svg">
                            <path opacity="0.4" d="M15 7H17C17.2652 7 17.5196 7.10536 17.7071 7.29289C17.8946 7.48043 18 7.73478 18 8V20C18 20.2652 17.8946 20.5196 17.7071 20.7071C17.5196 20.8946 17.2652 21 17 21H1C0.734784 21 0.48043 20.8946 0.292893 20.7071C0.105357 20.5196 0 20.2652 0 20V8C0 7.73478 0.105357 7.48043 0.292893 7.29289C0.48043 7.10536 0.734784 7 1 7H3V6C3 4.4087 3.63214 2.88258 4.75736 1.75736C5.88258 0.632141 7.4087 0 9 0C10.5913 0 12.1174 0.632141 13.2426 1.75736C14.3679 2.88258 15 4.4087 15 6V7ZM2 9V19H16V9H2ZM8 13H10V15H8V13ZM4 13H6V15H4V13ZM12 13H14V15H12V13ZM13 7V6C13 4.93913 12.5786 3.92172 11.8284 3.17157C11.0783 2.42143 10.0609 2 9 2C7.93913 2 6.92172 2.42143 6.17157 3.17157C5.42143 3.92172 5 4.93913 5 6V7H13Z" fill="black"/>
                            </svg>                   
                        </div> 

                        <!-- INPUT 7-->
                        <input  type="password" id="senhacon" name="senhaRepete" placeholder="Confirme a sua senha"  class="text ${not empty ErroSenhaRe ? 'erroInput' : ''}">

                        <div class="terms">
                            <!-- INPUT 8-->
                            <input type="checkbox" id="condicoes" name="concordar" value="Sim" value="${cliente.concorda}">
                            <label for="condicoes"><p id="Pcond">Concordo com os termos e condições de uso</p></label>
                            <!-- INPUT 9-->
                            <input type="checkbox" id="novidades" name="concordarNews" value="Sim" value="${cliente.concorda_newstalleter}">
                            <label for="novidades"><p>Eu aceito receber novidades e ofertas Rapina</p></label>
                        </div>

                        <!--Pega os inputs-->
                        <input type="hidden" name="idEstab" value="${sessionScope.idEst}">
                        <input type="hidden" name="dataReserva" value="${sessionScope.dataRes}">
                        <input type="hidden" name="horaReserva" value="${sessionScope.horaRes}">
                        <input type="hidden" name="Acomp" value="${sessionScope.qtdAcom}">
                        
                        <div class="cadastrar">
                            <button type="Submit">Cadastrar</button>  
                        </div>
                    </form>
                </div>
            </div>
        </div>


    </body>
</html>
