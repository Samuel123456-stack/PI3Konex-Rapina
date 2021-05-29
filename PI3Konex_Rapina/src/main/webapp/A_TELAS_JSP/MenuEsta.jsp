<!--
    TELA REFERENTE AO MARCO II
-->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">    <title>Document</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/menuEsta.css">
</head>
<body>
    <div id="container-landingesta">
        <section class="menu-baresta">
            <div class="menulogoesta">
                 <img src="${pageContext.request.contextPath}/images/icons/logotipo.png" alt="logo-image" class="logo-icon" />
            </div>
            <div class="nomeMenuesta">
                <h1>Olá </h1><p><c:out value="${sessionScope.nomeEsta}"/></p><h1>, essa é a sua área :)</h1>
            </div>
            <div class="direitamenuesta">
                
                <form action="${pageContext.request.contextPath}/SubMenusEsta">
                    <button name="btn" value="alteraCartao">
                <svg width="42" height="33" viewBox="0 0 42 33" fill="none" xmlns="http://www.w3.org/2000/svg">
                    <path d="M0 5.76267C0 4.36981 0.544344 3.03399 1.51328 2.04908C2.48222 1.06418 3.79638 0.510864 5.16667 0.510864H36.1667C37.537 0.510864 38.8511 1.06418 39.8201 2.04908C40.789 3.03399 41.3333 4.36981 41.3333 5.76267V18.8922H0V5.76267ZM29.7083 8.38857C29.3658 8.38857 29.0372 8.5269 28.795 8.77313C28.5528 9.01936 28.4167 9.35331 28.4167 9.70153V12.3274C28.4167 12.6756 28.5528 13.0096 28.795 13.2558C29.0372 13.5021 29.3658 13.6404 29.7083 13.6404H34.875C35.2176 13.6404 35.5461 13.5021 35.7883 13.2558C36.0306 13.0096 36.1667 12.6756 36.1667 12.3274V9.70153C36.1667 9.35331 36.0306 9.01936 35.7883 8.77313C35.5461 8.5269 35.2176 8.38857 34.875 8.38857H29.7083ZM0 24.144V26.7699C0 28.1628 0.544344 29.4986 1.51328 30.4835C2.48222 31.4684 3.79638 32.0217 5.16667 32.0217H36.1667C37.537 32.0217 38.8511 31.4684 39.8201 30.4835C40.789 29.4986 41.3333 28.1628 41.3333 26.7699V24.144H0Z" fill="#4361EE"/>
                </svg>
                </button>

                <button name="btn" value="validaReserva">
                    <img src="${pageContext.request.contextPath}/images/Vector (1).png" alt="" style="width: 30px; height: 30px; margin-left: 12.5px; margin-right: 12.5px;">
                </button>
                
                <button name="btn" >
                    <img src="${pageContext.request.contextPath}/images/Vector (2).png" alt="" style="width: 30px; height: 30px; margin-left: 12.5px; margin-right: 12.5px;">
                </button>   
                
                <button>
                <svg width="32" height="34" viewBox="0 0 32 34" fill="none" xmlns="http://www.w3.org/2000/svg">
                <path d="M14.9495 33.28C15.5795 33.2655 16.184 33.0287 16.6561 32.6114C17.1283 32.1942 17.4377 31.6234 17.5295 31H12.2695C12.364 31.6403 12.6879 32.2245 13.1808 32.6439C13.6738 33.0633 14.3024 33.2894 14.9495 33.28Z" fill="#4361EE"/>
                <path d="M29.8 27.1299L29.46 26.8299C28.4954 25.9705 27.6512 24.985 26.95 23.8999C26.1842 22.4025 25.7252 20.7671 25.6 19.0899V14.1499C25.5959 13.5499 25.5424 12.9512 25.44 12.3599C23.7461 12.0117 22.2246 11.0889 21.133 9.74768C20.0414 8.40644 19.4469 6.7292 19.45 4.9999V4.3699C18.4059 3.85609 17.2842 3.51821 16.13 3.3699V2.1099C16.13 1.75584 15.9893 1.41628 15.739 1.16591C15.4886 0.915554 15.1491 0.774902 14.795 0.774902C14.4409 0.774902 14.1014 0.915554 13.851 1.16591C13.6007 1.41628 13.46 1.75584 13.46 2.1099V3.4199C10.8757 3.78446 8.51057 5.07165 6.80122 7.04384C5.09187 9.01602 4.15373 11.54 4.16 14.1499V19.0899C4.03475 20.7671 3.57578 22.4025 2.81 23.8999C2.12088 24.9823 1.29019 25.9676 0.34 26.8299L0 27.1299V29.9499H29.8V27.1299Z" fill="#4361EE"/>
                <path d="M26.9502 10C29.7116 10 31.9502 7.76142 31.9502 5C31.9502 2.23858 29.7116 0 26.9502 0C24.1888 0 21.9502 2.23858 21.9502 5C21.9502 7.76142 24.1888 10 26.9502 10Z" fill="#EE4362"/>
                </svg>
                </button>
            
                <div class="infousermenuesta" style="margin-right: 65px;">
                    <img src="${pageContext.request.contextPath}/images/Squircle.png" alt=""></li>
                
                    <h1><c:out value="${sessionScope.nomeEsta}"/></h1>
                    <button name="btn" value="alteraDadosEsta">
                    <p>Alterar Dados</p>
                    </button>
                </div>
                <svg width="34" height="33" viewBox="0 0 34 33" fill="none" xmlns="http://www.w3.org/2000/svg">
                    <path d="M22.1876 2.63265C22.2726 1.76794 23.6961 1.70142 24.7796 2.05396C24.8433 2.07391 26.635 2.69916 26.1251 3.065C24.1493 2.57278 22.131 4.2756 22.1876 2.63265ZM7.95319 3.09161C10.1273 2.55283 12.3439 4.42193 12.2802 2.61935C12.1881 1.67481 10.623 1.60165 9.43329 1.98079C9.36247 2.00074 7.40081 2.67921 7.95319 3.09161ZM22.6267 10.1157C22.0035 10.1157 21.4936 10.5946 21.4936 11.18C21.4936 11.7653 22.0035 12.2442 22.6267 12.2442C23.2499 12.2442 23.7598 11.7653 23.7598 11.18C23.7598 10.5946 23.2499 10.1157 22.6267 10.1157ZM11.3171 10.1157C10.6939 10.1157 10.184 10.5946 10.184 11.18C10.184 11.7653 10.6939 12.2442 11.3171 12.2442C11.9403 12.2442 12.4501 11.7653 12.4501 11.18C12.4501 10.5946 11.9403 10.1157 11.3171 10.1157ZM33.8726 20.9712C33.1715 22.5676 30.9903 21.7028 29.3474 20.8913C28.3913 25.4876 25.2328 28.3013 20.403 29.1527C20.4243 29.2125 20.2614 29.146 22.1027 29.2192C24.4821 29.3123 26.6209 29.013 29.0003 28.687C27.5981 27.7691 28.193 26.2193 28.3063 26.1528C28.4055 26.0929 29.3474 26.2659 29.836 26.9177C30.445 26.0863 31.8472 25.9333 31.9747 26.0131C32.088 26.0863 32.4421 27.4033 31.4861 28.3146C31.8189 28.2547 32.0668 28.2081 32.1801 28.1749C32.3642 28.1217 33.4336 28.9265 32.3996 29.0595C31.3869 29.2125 30.7991 29.3988 29.0641 29.7779C25.8135 30.4896 22.9808 30.5628 20.7288 30.6293L20.7996 31.4009C21.0687 32.6049 19.1425 33.0173 18.845 31.8133C18.9017 33.004 16.9259 33.2634 16.8338 31.7468L16.7984 32.0993C16.7488 33.3232 14.7871 33.29 14.7942 32.0594C14.2631 32.9574 12.8042 32.5117 12.9246 31.494L13.0096 30.6692C10.4106 30.7291 8.78177 30.8754 8.63305 30.8754C7.15295 30.8754 7.15295 28.7735 8.63305 28.7735C8.80301 28.7735 10.5947 28.86 13.1088 28.9598C8.78177 27.9288 5.76491 25.3014 4.97175 21.0975C3.2013 21.949 0.899707 22.8802 0.141952 21.1508C-0.601638 19.4613 1.66454 18.3172 4.8726 16.2685C4.92218 15.8295 4.98591 15.3838 5.06381 14.9515C4.04403 13.6477 4.24232 12.5369 3.92364 10.9339C2.7339 11.0935 2.28066 10.3286 2.25233 9.39735C2.27358 8.91178 2.40105 8.40626 2.4223 8.373C2.5002 8.25327 3.13756 8.23997 3.32169 8.20006C3.7466 6.09149 6.90508 5.99172 9.75906 5.90525C11.1542 4.45519 12.96 3.14482 15.4882 2.69251C14.4047 1.4021 15.2475 0.0385161 15.3183 0.00525797C15.4387 -0.047955 16.8196 0.291278 17.1808 1.54843C17.5491 0.963091 18.4768 0.790149 18.5688 0.836711C18.6467 0.87662 19.0221 1.83445 18.2218 2.55948C21.0758 2.79229 23.3349 4.20243 25.0204 5.93185C27.5769 6.03163 30.1051 6.3243 30.4804 8.1934C30.6717 8.23331 31.3019 8.24662 31.3798 8.36635C31.4011 8.3996 31.5286 8.90513 31.5498 9.3907C31.5144 10.3153 31.0682 11.0802 29.8785 10.9272C29.6519 12.0779 29.6873 13.1156 29.2624 14.1C29.4323 14.8783 29.5456 15.6831 29.6023 16.5212C32.2226 18.2107 34.5808 19.3482 33.8726 20.9712ZM14.6951 10.1091C14.7588 7.18236 12.0111 7.30209 9.12877 7.42847C7.59202 7.49498 6.37395 7.55485 5.90655 8.35304C5.09922 9.74323 6.32438 14.5324 7.54953 15.0845C8.24355 15.3971 12.7476 15.61 13.6611 14.6122C14.2418 13.987 14.7234 11.3263 14.6951 10.1091ZM18.3776 13.987C18.0731 13.1622 17.9527 11.9848 17.2941 11.8119C17.1525 11.7786 16.6567 11.7786 16.5151 11.8119C15.8069 11.9981 15.7503 13.2819 15.3112 14.2863C16.4018 14.2863 16.678 14.9315 16.9896 14.9315C17.2941 14.9315 17.4357 14.1799 18.3776 13.987ZM27.9876 8.35304C27.5202 7.5482 26.2314 7.49498 24.6946 7.42847C21.8477 7.30209 19.1566 7.1757 19.2204 10.1091C19.1849 11.3263 19.5744 13.987 20.1552 14.6189C21.0758 15.61 25.5798 15.4038 26.2668 15.0911C27.3857 14.5856 28.8516 9.84301 27.9876 8.35304Z" fill="#4361EE"/>
                </svg>
                <svg width="37" height="30" viewBox="0 0 37 30" fill="none" xmlns="http://www.w3.org/2000/svg">
                    <path d="M28.404 7.05L37 15.03L28.404 22.95V17.64H15.5412V12.36H28.404V7.05ZM23.234 22.41L26.5354 25.62C23.2963 28.54 19.7873 30 16.0084 30C11.5028 30 7.70833 28.565 4.625 25.695C1.54167 22.825 0 19.24 0 14.94C0 12.24 0.705948 9.74 2.11785 7.44C3.52974 5.14 5.43476 3.325 7.83291 1.995C10.2311 0.665 12.8316 0 15.6347 0C19.4551 0 23.0783 1.48 26.5042 4.44L23.234 7.62C20.867 5.54 18.3443 4.5 15.6658 4.5C12.5721 4.5 9.96114 5.54 7.83291 7.62C5.70469 9.7 4.64057 12.24 4.64057 15.24C4.64057 18.04 5.73583 20.45 7.92635 22.47C10.1169 24.49 12.6863 25.5 15.6347 25.5C18.3547 25.5 20.8878 24.47 23.234 22.41Z" fill="#4361EE"/>
                </svg>
                    
                   </form> 
            </div>
        </section>
    </div>

<div class="todo">    
    <div class="tabela">
        <p>Reservas agendadas</p>
        <div class="select">
            <select>
            <option>Ordenar por status</option>
            </select>
            <div class="select__arrow"></div>
        </div>
        <table class="tbreservas">
            <thead>
                <tr>
                    <th style="width: 50px;">Cód.</th>
                    <th style="width: 150px;">Clientes</th>
                    <th>Data e Horário</th>
                    <th style="width: 20px;">Status</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="listaRes" items="${sessionScope.dadosListaRes}">
                <tr>
                    <td><c:out value="${listaRes.num_reserva}"/></td>
                    <td><c:out value="${listaRes.nome_reservado}"/></td>
                    <td><c:out value="${listaRes.data_reservada}"/> <c:out value="${listaRes.horario_reservado}"/></td>
                    <c:if test="${listaRes.reserva_status=='Cancelada'}">
                    <td><div class="desativada">1</div></td>
                    </c:if>
                    <c:if test="${listaRes.reserva_status=='Ativa'}">
                    <td><div class="ativa">1</div></td>
                    </c:if>
                </tr>
                </c:forEach>
                </tbody>
        </table>
    </div>

    <div class="tabelas" style="background: #567BFC; box-shadow: 0px 6px 15px 7px rgba(53, 88, 170, 0.2);">
        <p style="color: #fff; ">Minhas jornadas</p>
        <form action="${pageContext.request.contextPath}/TelaLogSenha" method="get">
        <table class="tbminjor">
            <thead>
                <tr>
                    <th>
                        <svg width="32" height="25" viewBox="0 0 32 25" fill="none" xmlns="http://www.w3.org/2000/svg">
                            <path d="M28.125 12.5C28.125 13.3288 28.4542 14.1237 29.0403 14.7097C29.6263 15.2958 30.4212 15.625 31.25 15.625V21.875C31.25 22.7038 30.9208 23.4987 30.3347 24.0847C29.7487 24.6708 28.9538 25 28.125 25H3.125C2.2962 25 1.50134 24.6708 0.915291 24.0847C0.32924 23.4987 0 22.7038 0 21.875V15.625C0.828802 15.625 1.62366 15.2958 2.20971 14.7097C2.79576 14.1237 3.125 13.3288 3.125 12.5C3.125 11.6712 2.79576 10.8763 2.20971 10.2903C1.62366 9.70424 0.828802 9.375 0 9.375V3.125C0 2.2962 0.32924 1.50134 0.915291 0.915291C1.50134 0.32924 2.2962 0 3.125 0H28.125C28.9538 0 29.7487 0.32924 30.3347 0.915291C30.9208 1.50134 31.25 2.2962 31.25 3.125V9.375C30.4212 9.375 29.6263 9.70424 29.0403 10.2903C28.4542 10.8763 28.125 11.6712 28.125 12.5ZM22.6562 19.1406C22.6562 16.7969 17.9688 15.625 15.625 15.625C13.2812 15.625 8.59375 16.7969 8.59375 19.1406V20.3125H22.6562V19.1406ZM15.625 12.8906C16.5574 12.8906 17.4516 12.5202 18.1109 11.8609C18.7702 11.2016 19.1406 10.3074 19.1406 9.375C19.1406 8.4426 18.7702 7.54839 18.1109 6.88908C17.4516 6.22977 16.5574 5.85938 15.625 5.85938C14.6926 5.85938 13.7984 6.22977 13.1391 6.88908C12.4798 7.54839 12.1094 8.4426 12.1094 9.375C12.1094 10.3074 12.4798 11.2016 13.1391 11.8609C13.7984 12.5202 14.6926 12.8906 15.625 12.8906Z" fill="white"/>
                        </svg>                            
                    </th>
                    <th>
                        <svg width="25" height="25" viewBox="0 0 25 25" fill="none" xmlns="http://www.w3.org/2000/svg">
                            <path d="M12.5 0C5.6075 0 0 5.6075 0 12.5C0 19.3925 5.6075 25 12.5 25C19.3925 25 25 19.3925 25 12.5C25 5.6075 19.3925 0 12.5 0ZM16.8662 7.5C17.1155 7.49363 17.3635 7.53724 17.5956 7.62823C17.8277 7.71923 18.0392 7.85578 18.2177 8.02983C18.3962 8.20389 18.538 8.41192 18.6349 8.64166C18.7317 8.8714 18.7815 9.11821 18.7814 9.36752C18.7813 9.61683 18.7313 9.86359 18.6344 10.0933C18.5374 10.3229 18.3954 10.5309 18.2168 10.7048C18.0382 10.8788 17.8266 11.0152 17.5944 11.106C17.3622 11.1968 17.1142 11.2403 16.865 11.2338C16.3782 11.221 15.9157 11.0186 15.576 10.6698C15.2363 10.3209 15.0463 9.85319 15.0464 9.36627C15.0466 8.87934 15.2369 8.41173 15.5769 8.06311C15.9168 7.71449 16.3795 7.51243 16.8662 7.5ZM8.125 7.5C8.37131 7.50008 8.61519 7.54868 8.84272 7.64301C9.07025 7.73735 9.27697 7.87557 9.45108 8.0498C9.62519 8.22402 9.76328 8.43084 9.85747 8.65843C9.95165 8.88602 10.0001 9.12994 10 9.37625C9.99992 9.62256 9.95132 9.86644 9.85699 10.094C9.76265 10.3215 9.62443 10.5282 9.4502 10.7023C9.27598 10.8764 9.06916 11.0145 8.84157 11.1087C8.61398 11.2029 8.37006 11.2513 8.12375 11.2513C7.6263 11.2511 7.1493 11.0533 6.79767 10.7015C6.44604 10.3496 6.24858 9.87245 6.24875 9.375C6.24892 8.87755 6.44668 8.40055 6.79855 8.04892C7.15041 7.69729 7.62755 7.49983 8.125 7.5ZM12.5 20C6.25 20 5 13.75 5 13.75H20C20 13.75 18.75 20 12.5 20Z" fill="white"/>
                        </svg>                        
                    </th>
                    <th>
                        <svg width="36" height="25" viewBox="0 0 36 25" fill="none" xmlns="http://www.w3.org/2000/svg">
                            <path d="M3.57143 0H32.1429C33.0901 0 33.9985 0.376274 34.6682 1.04605C35.338 1.71582 35.7143 2.62423 35.7143 3.57143V21.4286C35.7143 22.3758 35.338 23.2842 34.6682 23.954C33.9985 24.6237 33.0901 25 32.1429 25H3.57143C2.62423 25 1.71582 24.6237 1.04605 23.954C0.376274 23.2842 0 22.3758 0 21.4286V3.57143C0 2.62423 0.376274 1.71582 1.04605 1.04605C1.71582 0.376274 2.62423 0 3.57143 0ZM28.5714 3.57143H7.14286C7.14286 4.51863 6.76658 5.42704 6.09681 6.09681C5.42704 6.76658 4.51863 7.14286 3.57143 7.14286V17.8571C4.51863 17.8571 5.42704 18.2334 6.09681 18.9032C6.76658 19.573 7.14286 20.4814 7.14286 21.4286H28.5714C28.5714 20.4814 28.9477 19.573 29.6175 18.9032C30.2873 18.2334 31.1957 17.8571 32.1429 17.8571V7.14286C31.1957 7.14286 30.2873 6.76658 29.6175 6.09681C28.9477 5.42704 28.5714 4.51863 28.5714 3.57143ZM10.7143 7.14286H14.2857V17.8571H10.7143V7.14286ZM21.4286 14.2857C21.9022 14.2857 22.3564 14.0976 22.6913 13.7627C23.0261 13.4278 23.2143 12.9736 23.2143 12.5C23.2143 12.0264 23.0261 11.5722 22.6913 11.2373C22.3564 10.9024 21.9022 10.7143 21.4286 10.7143C20.955 10.7143 20.5008 10.9024 20.1659 11.2373C19.831 11.5722 19.6429 12.0264 19.6429 12.5C19.6429 12.9736 19.831 13.4278 20.1659 13.7627C20.5008 14.0976 20.955 14.2857 21.4286 14.2857ZM21.4286 17.8571C20.0078 17.8571 18.6452 17.2927 17.6405 16.2881C16.6358 15.2834 16.0714 13.9208 16.0714 12.5C16.0714 11.0792 16.6358 9.71659 17.6405 8.71193C18.6452 7.70727 20.0078 7.14286 21.4286 7.14286C22.8494 7.14286 24.212 7.70727 25.2166 8.71193C26.2213 9.71659 26.7857 11.0792 26.7857 12.5C26.7857 13.9208 26.2213 15.2834 25.2166 16.2881C24.212 17.2927 22.8494 17.8571 21.4286 17.8571Z" fill="white"/>
                        </svg>                        
                    </th>
                    <th>
                        <svg width="26" height="25" viewBox="0 0 26 25" fill="none" xmlns="http://www.w3.org/2000/svg">
                            <path d="M1.25058 14.9927H3.75239V23.7491C3.75239 24.0809 3.88419 24.399 4.11878 24.6336C4.35337 24.8682 4.67154 25 5.0033 25H20.0142C20.3459 25 20.6641 24.8682 20.8987 24.6336C21.1333 24.399 21.2651 24.0809 21.2651 23.7491V14.9927H23.7669C24.0087 14.993 24.2453 14.923 24.448 14.7913C24.6507 14.6596 24.8109 14.4719 24.909 14.251C25.0078 14.0301 25.0402 13.7853 25.0025 13.5464C24.9647 13.3074 24.8584 13.0846 24.6963 12.905L13.4382 0.395912C12.9641 -0.131971 12.0534 -0.131971 11.5793 0.395912L0.321156 12.905C0.159402 13.0847 0.0531961 13.3074 0.0153885 13.5462C-0.022419 13.785 0.0097924 14.0297 0.108125 14.2506C0.206458 14.4715 0.366698 14.6591 0.569454 14.7908C0.772211 14.9225 1.0088 14.9927 1.25058 14.9927ZM8.32196 12.0419C8.84262 11.5278 9.54483 11.2396 10.2765 11.2396C11.0082 11.2396 11.7104 11.5278 12.231 12.0419L12.5112 12.3171L12.7902 12.0419C13.3111 11.5277 14.0135 11.2395 14.7454 11.2395C15.4772 11.2395 16.1797 11.5277 16.7005 12.0419C16.9589 12.2905 17.1645 12.5887 17.3049 12.9186C17.4454 13.2485 17.5177 13.6034 17.5177 13.962C17.5177 14.3206 17.4454 14.6755 17.3049 15.0054C17.1645 15.3353 16.9589 15.6335 16.7005 15.8821L12.5112 19.9964L8.32196 15.8821C8.06355 15.6335 7.85797 15.3353 7.71755 15.0054C7.57713 14.6755 7.50475 14.3206 7.50475 13.962C7.50475 13.6034 7.57713 13.2485 7.71755 12.9186C7.85797 12.5887 8.06355 12.2905 8.32196 12.0419Z" fill="white"/>
                        </svg> 
                    </th>
                </tr>
                <tr>
                    <th>Reservas validadas</th>
                    <th>Doações recebidas</th>
                    <th>Qtd. de recebidos</th>
                    <th>Qtd. de favoritos</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><c:out value="${sessionScope.dadosResVal}"/></td>
                    <td><c:out value="${sessionScope.dadosDoacao}"/></td>
                    <td><c:out value="${sessionScope.dadosRec}"/></td>
                    <td><c:out value="${sessionScope.dadosFav}"/></td>
                </tr>
            </tbody>
        </table>
      </form>
    </div>

    <div class="tabelas2">
        <div class="limpar">
            <h1>Consultar reservas</h1>
        </div>
        <form action="${pageContext.request.contextPath}/MenuEstabelecimento">
            <input type="text" placeholder="Digite o cód. reserva" name="idRes" id="busca">
            <button name="btn" value="consultaRes">OK</button>
        </form>
        <table class="tbConsulres">
            <thead>
                <tr>
                    <th>Status</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="res" items="${consRes}">
                <tr>
                    <c:if test="${res.reserva_status=='Cancelada'}">
                        <td><div class="desativada2"></div><c:out value="${res.reserva_status}"/></td>
                    </c:if>
                    <c:if test="${res.reserva_status=='Ativa'}">
                        <td><div class="ativa2"></div><c:out value="${res.reserva_status}"/></td>
                    </c:if>
                </tr>

                <tr>
                    <th>Data e Horário</th>
                </tr>
                
                <tr>
                    <td style="padding-bottom: 20px;"><c:out value="${res.data_reservada}"/> <c:out value="${res.horario_reservado}"/></td>
                </tr>
                
            </tbody>
            </c:forEach>
        </table>
    </div>

    <div class="tabelas2">
        <p>Doações Recebidas</p>
        <table class="tbDorec">
            
            <thead>
                <tr>
                    <th>RapinaLovers</th>
                    <th style="width: 50px;">Valor</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="doa" items="${sessionScope.dadosListaDoacao}">
                <tr>
                    <td><c:out value="${doa.nome}"/></td>
                    <td style="width: 50px;">R$<c:out value="${doa.valor}"/></td>
                </tr>
            </tbody>
            </c:forEach>
        </table>
    </div>

    <div class="tabelas">
        <p style="float: left;">meus pagamentos</p>
        <div class="select" style="margin-left: 49px; width :110px;">
            <select style="width :110px;">
            <option>Período</option>
            </select>
            <div class="select__arrow"></div>
        </div>
        <table class="tbmeuspag">
        <thead>
            <tr>
                <th>Taxa/multas</th>
                <th>Data</th>
                <th>Valor</th>
                <th>Opcoes</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach var="mes" items="${sessionScope.dadosListaMensal}">
                <tr>
                    <td>mensalidade</td>
                    <td><c:out value="${mes.data_cobranca}"/></td>
                    <td><c:out value="${mes.valor}"/></td>
                    <td>
                        <form action="${pageContext.request.contextPath}/RespondePagEsta">
                            <button name="btn" value="notificaEsta">
                                <input type="hidden" name="lineData" value="${mes.data_cobranca}">
                                <input type="hidden" name="lineIDEsta" value="${mes.id_estabelecimento}">       
                                <input type="hidden" name="lineValor" value="${mes.valor}">
                                <svg width="23" height="21" viewBox="0 0 23 21" fill="none" xmlns="http://www.w3.org/2000/svg">
                                <g opacity="0.6">
                                <path d="M12.7131 21L11.3077 20.1923L14.5385 14.5385H19.3846C19.813 14.5385 20.2239 14.3683 20.5269 14.0653C20.8298 13.7624 21 13.3515 21 12.9231V3.23077C21 2.80234 20.8298 2.39146 20.5269 2.08852C20.2239 1.78558 19.813 1.61538 19.3846 1.61538H3.23077C2.80234 1.61538 2.39146 1.78558 2.08852 2.08852C1.78558 2.39146 1.61538 2.80234 1.61538 3.23077V12.9231C1.61538 13.3515 1.78558 13.7624 2.08852 14.0653C2.39146 14.3683 2.80234 14.5385 3.23077 14.5385H10.5V16.1538H3.23077C2.37392 16.1538 1.55216 15.8135 0.94627 15.2076C0.340384 14.6017 0 13.7799 0 12.9231V3.23077C0 2.37392 0.340384 1.55216 0.94627 0.94627C1.55216 0.340383 2.37392 0 3.23077 0H19.3846C20.2415 0 21.0632 0.340383 21.6691 0.94627C22.275 1.55216 22.6154 2.37392 22.6154 3.23077V12.9231C22.6154 13.7799 22.275 14.6017 21.6691 15.2076C21.0632 15.8135 20.2415 16.1538 19.3846 16.1538H15.4754L12.7131 21Z" fill="#6075A5"/>
                                <path d="M4.8457 4.84619H17.7688V6.46158H4.8457V4.84619Z" fill="#6075A5"/>
                                <path d="M4.8457 9.69238H12.9226V11.3078H4.8457V9.69238Z" fill="#6075A5"/>
                                </g>
                                </svg>                        
                            </button>
                        </form>
                    </td>
                </tr>
        </tbody>
        </c:forEach>
        </table>
        </div>
</div>
</body>
</html>
