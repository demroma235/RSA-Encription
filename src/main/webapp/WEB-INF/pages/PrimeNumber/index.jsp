<%@ page session="false" isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <%@include file="../include/head.jsp"%>
</head>
<body>
<div class="head-block">
    <h1>Простое число</h1>
    <div class="count">
        <form action="/count_prime" method="get">
            <div>
                Введите число
                <br/>
                <input type="number" name="number"/>
            </div>

            <div class="button-block"><input class="button" type="submit" value="Узнать"/></div>

        </form>
    </div>
</div>


</body>
</html>