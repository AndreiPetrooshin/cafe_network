
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Cafe</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <jsp:include page="header/header.jsp"/>
</head>


<body>
<table class="table table-hover">
    <thead class="thead-inverse">
    <tr>
        <th>КОФЕ</th>
        <th>В КАФЕ</th>
        <th>ПО АДРЕСУ</th>
        <th>ОБЪЁМ</th>
        <th>СТОИМОСТЬ</th>
    </tr>
    </thead>
    <tr>
        <td>${cafe.name}</td>
        <td>${cafe.address}</td>
        <td>${cafe.director.firstName} ${cafe.director.lastName}</td>
        <td>${cafe.rating}</td>
    </tr>

    <hr/>
</table>
<c:choose>
    <c:when test="${!empty drinkList}">
        <h2> Напитки в кофейне:</h2>

        <div class="container-fluid">
            <div class="row">
                <div class="col-md-10">
                    <div class="container">

                        <c:forEach var="drink" items="${drinkList}">
                            <a href="/coffee/${drink.id}" target="_blank">
                                <div class="row">
                                    <div class="col-md-2" align="center">
                                        <img src="/images/coffee.png" width="100" height="100"/>
                                        <hr>
                                    </div>
                                    <div class="col-md-4">
                                        <p class="text-left">
                                            Название: ${drink.name}
                                            <br>
                                            Цена: ${drink.price}
                                            <br>
                                            Кафе: ${drink.cafe.name}
                                    </div>
                                    </p>
                                </div>
                            </a>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </c:when>
    <c:otherwise>
        <h2>Напитков нет</h2>
    </c:otherwise>
</c:choose>

</body>
</html>
