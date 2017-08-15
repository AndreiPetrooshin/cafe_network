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
</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="index.html">Good Day Cafes</a>
            <button class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="index.html"><span class="glyphicon glyphicon-home"></span> Главная</a></li>
                <li><a href="servlet?value=cafeList"><span class="glyphicon glyphicon-align-justify"></span>
                    Заведения</a></li>
                <li><a href="servlet?value=drinkList"><span class="glyphicon glyphicon-share-alt"></span> Кофе </a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">Контакты </a></li>
                <li><a href="#">О нас</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-2">
            <div class="list-group">
                <h3> Фильтр по: </h3>
                <a class="list-group-item" href="servlet?value=drinkSortByPriceDown">Самый дешевый</a>
                <a class="list-group-item" href="servlet?value=drinkSortByPriceUp">Самый дорогой</a>
                <a class="list-group-item" href="servlet?value=drinkSortByAlphabetUp">В алфавитном порядке от А до Я</a>
                <a class="list-group-item" href="servlet?value=drinkSortByAlphabetDown">В алфавитном порядке от Я до А</a>
            </div>
        </div>
        <div class="col-md-10">
            <div class="container">
                <c:forEach var="drink" items="${drinks}">
                    <div class="col-md-2" ></div>
                    <div class="row">
                        <div class="col-md-2" align="center">
                            <img src="images/coffee.png" width="100" height="100"/>
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
                </c:forEach>

            </div>
        </div>

    </div>
</div>


</body>
</html>
