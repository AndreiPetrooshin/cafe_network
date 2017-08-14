<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Cafes</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
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
          <li><a href="index.html"><span class="glyphicon glyphicon-home" ></span> Главная</a></li>
          <li><a href="/servlet"><span class="glyphicon glyphicon-align-justify" ></span> Заведения</a></li>
          <li><a href="#"><span class="glyphicon glyphicon-share-alt" ></span>   Кофе  </a></li>
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
  <div class="container">
    <div class="row">
      <div class="col-md-12 head-block"></div>
      <div class="col-md-12 top-menu"></div>
      <div class="col-md-12 top-material"></div>
      <div class="col-md-3 left-sidebar"></div>
      <div class="col-md-9 content"></div>
    </div>
  </div>

    <div class="container">
      <h2>Cafes Table</h2>
      <table class="table table-striped">
        <thead>
        <tr>
          <th>Name</th>
          <th>Address</th>
          <th>Director</th>
          <th>Rating</th>
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
