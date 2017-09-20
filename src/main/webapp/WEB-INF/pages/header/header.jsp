<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">Good Day Cafes</a>
            <button class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li>
                    <a href="/"><span class="glyphicon glyphicon-home"></span> Главная</a>
                </li>
                <li>
                    <a href="/cafes"><span class="glyphicon glyphicon-align-justify"></span> Заведения</a>
                </li>
                <li>
                    <a href="/coffees"><span class="glyphicon glyphicon-share-alt"></span> Кофе </a>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><c:if test="${pageContext.request.userPrincipal.name != null}">
                    <form id="logoutForm" method="post" action="${contextPath}/logout">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    </form>
                    <a  onclick="document.forms['logoutForm'].submit()">Logout</a>
                    </c:if>
                </li>
                <li>
                    <c:if test="${pageContext.request.userPrincipal.name == null}" >
                    <a href="/login"><span class="glyphicon glyphicon-log-in"></span> Login</a>
                    </c:if>
                </li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="#">Контакты </a>
                </li>
                <li>
                    <a href="#">О нас</a>
                </li>
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

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/assets/js/bootstrap.min.js"></script>
