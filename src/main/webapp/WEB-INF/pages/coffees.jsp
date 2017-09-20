<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Cafes</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <jsp:include page="header/header.jsp"/>
</head>
<body>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-10">
            <div class="container">
                <c:forEach var="drink" items="${coffeeList}">
                    <div class="col-md-2" ></div>
                   <a href="/coffee/${drink.id}" target="_blank"> <div class="row">
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


</body>
</html>
