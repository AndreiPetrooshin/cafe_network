<%--
  Created by IntelliJ IDEA.
  User: draqo
  Date: 10.08.2017
  Time: 23:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Title</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  </head>
  <body>

    <form action="servletCafe" method="get">
       <input type="submit" name="show"/>
    </form>

    <div class="container">
      <h2>Cafes Table</h2>
      <table class="table">
        <thead>
        <tr>
          <th>name</th>
          <th>address</th>
          <th>director</th>
          <th>rating</th>
        </tr>
        </thead>
        <tbody>
          <c:forEach var="cafe" items="${cafes}" >
            <tr>
              <td>${cafe.name}</td>
              <td>${cafe.address}</td>
              <td>${cafe.director.firstName} ${cafe.director.lastName}</td>
              <td>${cafe.rating}</td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>

  </body>
</html>
