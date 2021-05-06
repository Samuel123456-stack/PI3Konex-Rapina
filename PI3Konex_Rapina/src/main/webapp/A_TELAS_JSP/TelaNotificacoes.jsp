<%-- 
    Document   : TelaNotificacoes
    Created on : 4 de mai de 2021, 19:56:55
    Author     : gusta
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel='stylesheet' type='text/css' href="${pageContext.request.contextPath}/CSS/notificacoes.css">
        <title>Document</title>
    </head>
    <body>
        <div class="todo">
            <div class="link">
                <a href=""><svg width="13" height="25" viewBox="0 0 13 25" fill="none" xmlns="http://www.w3.org/2000/svg">
                    <path opacity="1" d="M10.4231 24.9999C10.1564 25.0008 9.89279 24.9419 9.65177 24.8276C9.41076 24.7133 9.19843 24.5464 9.03038 24.3392L0.40619 13.626C0.143569 13.3065 0 12.9057 0 12.4921C0 12.0786 0.143569 11.6778 0.40619 11.3583L9.33392 0.645033C9.637 0.280394 10.0725 0.0510867 10.5447 0.00755554C11.0168 -0.0359756 11.4869 0.109836 11.8515 0.412911C12.2162 0.715987 12.4455 1.1515 12.489 1.62365C12.5325 2.09579 12.3867 2.56589 12.0837 2.93053L4.10227 12.5011L11.8158 22.0716C12.0342 22.3337 12.1729 22.6528 12.2155 22.9913C12.2581 23.3297 12.2029 23.6733 12.0564 23.9814C11.9099 24.2894 11.6782 24.5491 11.3888 24.7296C11.0993 24.9101 10.7642 25.0039 10.4231 24.9999Z" fill="#4361EE"/>
                    </svg>
                    <p>Voltar para o menu principal</p>
                </a>
            </div>
            <div class="info">
                <form action="${pageContext.request.contextPath}/FazListagem" method="get">
                    <!--BUSCA MENSAGEM  TIPO DE USUARIO-->
                    <div style="float: left; margin-right: 100px;">
                        <h3>Busca Mensagem por tipo de usuário</h3><br><br>
                        <input type="text" name="btn" placeholder="Qual é o tipo de usuário" class="inputR">
                        <button type="submit" class="btn1">Mostrar</button>
                    </div>
                    <div>
                        <h3>Selecionar Mensagem por ID</h3><br><br>
                        <input type="text" name="id" placeholder="Digite o id da notificação" class="inputR">
                        <button type="submit" class="btn2">Identificar</button><br><br>
                    </div>
                    <div style="margin-top: 50px;">
                        <h3>Cliente identificado: </h3><br><br>
                        <button type="submit" class="btn3">Responder Mensagem</button>
                    </div>
                    
                </form>
            </div>    
            <br><br><br><br>
            <div class="tabela">
                <table>
                    <thead>
                        <tr>
                            <th class="selec">Deletar</th>
                            <th class="idU">ID. Msg.</th>
                            <th class="remetente">Nome</th>
                            <th class="assunto">Mensagem</th>
                            <th class="data">Data de recebimento</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="item" items="${listaNoti}">
                            <tr>
                                <td class="selec" >
                                    <a style="background-color: #4361EE; width: 70px; height: 20px; border-radius: 5px; color: white;" href="FazListagem?action=deletar&id_notification=<c:out value="${item.id_notification}"/>"><img src="${pageContext.request.contextPath}/images/icons/delete.png" width="auto" height="16px" ></a>
                                </td>
                                <!--ID-->
                                <td class="idU"><p><c:out value="${item.id_notification}"/></p></td>
                                    
                                <!--NOME-->
                                <td class="remetente">
                                    <svg width="50" height="50" viewBox="0 0 50 50" fill="none" xmlns="http://www.w3.org/2000/svg">
                                    <path d="M11.8215 36.649L11.5969 36.9794L11.8696 37.2713C15.1541 40.7871 19.8167 43 25 43C30.1833 43 34.8459 40.7871 38.1304 37.2713L38.4031 36.9794L38.1786 36.649C35.8498 33.222 31.9623 30.93 27.5 30.93H22.5C18.0402 30.93 14.1503 33.222 11.8215 36.649ZM0.5 25C0.5 11.7236 11.7236 0.5 25 0.5C38.2764 0.5 49.5 11.7236 49.5 25C49.5 38.2764 38.2764 49.5 25 49.5C11.7236 49.5 0.5 38.2764 0.5 25ZM33 20C33 15.4037 29.5935 12 25 12C20.4091 12 17 15.4036 17 20C17 24.5964 20.4091 28 25 28C29.5935 28 33 24.5963 33 20Z" stroke="black"/>
                                    </svg>
                                    <p><c:out value="${item.nome_noti}"/></p>
                                </td>
                                <td class="assunto"><c:out value="${item.mensagem}"/></td>
                                <td class="data"><c:out value="${item.data}"/></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>

        </div>
    </body>
</html>

