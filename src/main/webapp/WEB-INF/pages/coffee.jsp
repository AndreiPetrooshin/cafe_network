<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Cafes</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Coffee</title>
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
        <td>${coffee.name}</td>
        <td>${coffee.cafe.name}</td>
        <td>${coffee.cafe.address}</td>
        <td>${coffee.capacity}</td>
        <td>${coffee.price}</td>
    </tr>
</table>

</body>
</html>
