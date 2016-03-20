<%@ page session="false" isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<html>
<head>
	<meta charset="UTF-8"/>
	<%@include file="../include/head.jsp"%>
	<script>
		function getCount(number, degree, mod) {
			$.ajax({
				url: "/count_degree_with_mod?number="+number+"&degree="+degree+"&mod="+mod,
				success: function(response){
					$('#answer').html(response);
				},
				error: function(e){
					alert('Error: ' + e);
				}
			});
		}
	</script>
</head>
<body>
<div class="head-block">
	<h1>Алгоритм быстрого возведения в степень по модулю</h1>
	<div class="count">
		<div>
			Введите число
			<br/>
			<input id="number" type="number" name="number" placeholder="number"/>
			^
			<input id="degree" type="number" name="degree" placeholder="degree"/>
			mod
			<input id="mod" type="number" name="mod" placeholder="mod"/>
		</div>
		<input type="button" class="button" value="Узнать" onclick="getCount($('#number').val(), $('#degree').val(), $('#mod').val())"/>
	</div>
	<div id="answer"></div>
</div>


</body>
</html>