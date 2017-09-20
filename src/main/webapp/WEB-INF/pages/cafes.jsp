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
    <jsp:include page="header/header.jsp"/>
  <body>

    <div class="container">

          <c:forEach var="cafe" items="${cafeList}" >
              <a href="/cafe/${cafe.id}" target="_blank">
            <div class="row">
              <div class="col-md-2" >
                <img src="/images/loading.png" width="80" height="80">
              </div>
              <div class="col-md-8">
                <p>Кафе: ${cafe.name}, находится по адресу ${cafe.address}.<br><br>
                Директор: ${cafe.director.firstName} ${cafe.director.lastName}.
                </p>
              </div>
              <div class="col-md-2">
                <h2>${cafe.rating}</h2>
              </div>
            </div>
              </a>
          <br><hr><br>
          </c:forEach>
    </div>

  </body>
</html>
