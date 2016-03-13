<%@ page session="false" isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<html>
<head>
	<meta charset="UTF-8"/>
	<%@include file="../include/head.jsp"%>
</head>
<body>
	<div class="head-block">
		<h1>Алгоритм быстрого возведения в степень по модулю</h1>
		<div class="count">
			<form action="/count_degree_with_mod" method="get">
				<input type="number" name="number" style="width: 50px"/>
				^
				<input type="number" name="degree" style="width: 50px"/>
				mod
				<input type="number" name="mod" style="width: 50px"/>
				<br/>
				<div class="button-block"><input class="button" type="submit" value="Вычислить"/></div>

			</form>
		</div>
	</div>


</body>
</html>