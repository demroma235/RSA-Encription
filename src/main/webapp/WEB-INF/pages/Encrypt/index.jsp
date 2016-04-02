<%@ page session="false" isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <%@include file="../include/head.jsp"%>
    <script>


        function getCount(first_number, second_number) {
            var first_prime_value = parseInt($('#first_prime_value').html());
            var second_prime_value = parseInt($('#second_prime_value').html());
            var first_prime_update = $('#first_prime').val();
            var second_prime_update = $('#second_prime').val();
            if (first_number != first_prime_value) {
                $.ajax({
                    url: "/count_prime?number="+first_number,
                    success: function(response) {
                        if (response == 'true') {
                            $.get('update/first_prime?first_prime=' + first_number);
                            window.location.reload();
                        }
                        else{
                            alert('Не простое число!');
                        }
                    },
                    error: function(e){
                        alert('Ошибочка');
                    }
                });
            }
            if (second_number != second_prime_value){
                $.ajax({
                    url: "/count_prime?number="+second_number,
                    success: function(response) {
                        if (response == 'true') {
                            $.get('update/second_prime?second_prime=' + second_number);
                            window.location.reload();
                        }
                        else{
                            alert('Не простое число!');
                        }
                    },
                    error: function(e){
                        alert('Ошибочка');
                    }
                });
            }

        }
        function take_numbers(){
            var first_prime_value = parseInt($('#first_prime_value').html());
            var second_prime_value = parseInt($('#second_prime_value').html());
            var first_prime_update = $('#first_prime').val();
            var second_prime_update = $('#second_prime').val();
            if ((first_prime_update == '') && (second_prime_update == '')){
                $('#error-red').html('Пустые значения полей');
                $('#error-red').css("display", "block");
            }
            if ((first_prime_update == '') && (second_prime_update != '')){
                if (second_prime_update <= first_prime_value) {
                    $('#error-red').html('Второе простое число должно быть больше первого');
                    $('#error-red').css("display", "block");
                }
                else {
                    getCount(first_prime_value, second_prime_update);
                }
            }
            if ((first_prime_update != '') && (second_prime_update == '')){
                if (second_prime_value < first_prime_update) {
                    $('#error-red').html('Первое простое число должно быть меньше второго');
                    $('#error-red').css("display", "block");
                }
                else {
                    getCount(first_prime_update, second_prime_value);
                }
            }
            if ((first_prime_update != '') && (second_prime_update != '')){
                $('#error-red').html('Можно обновить только одно значение');
                $('#error-red').css("display", "block");
            }
        }
    </script>
</head>
<body>
<div class="head-block">
    <h1>Шифрование</h1>
    <div class="count">
        <div id="error-red"></div>
        <c:if test="${empty data.private_key_1}">
            <div id="error-yellow" style="display: block;">Для дальнейшей работы необходимо сгенерировать первый секретный ключ.</div>
        </c:if>
        <div>
            <table id="prime_number" align="center">
                <tr>
                    <td>Первое простое число</td>
                    <td id="first_prime_value">${data.first_prime}</td>
                    <td>
                            <input type="number" name="first_prime" id="first_prime">
                            <br/>
                            <input class="small_button" type="button" onclick="take_numbers()" value="Изменить">
                    </td>
                </tr>
                <tr>
                    <td>Второе простое число</td>
                    <td id="second_prime_value">${data.second_prime}</td>
                    <td>
                        <input type="number" name="second_prime" id="second_prime">
                        <br/>
                        <input class="small_button" type="button" onclick="take_numbers()" value="Изменить">
                    </td>
                </tr>
                <tr>
                    <td>Модуль</td>
                    <td>${data.module}</td>
                    <td>!depend!</td>
                </tr>
                <tr>
                    <td>Функция Эйлера</td>
                    <td>${data.function_Euler}</td>
                    <td>!depend!</td>
                </tr>
                <tr>
                    <td>E</td>
                    <td>${data.e}</td>
                    <td>!depend!</td>
                </tr>
                <tr>
                    <td>Открытый ключ</td>
                    <td>{${data.open_key_1}, ${data.open_key_2}}</td>
                    <td>!depend!</td>
                </tr>
                <tr>
                    <td>Секретный ключ</td>
                    <td>{${data.private_key_1}, ${data.private_key_2}}</td>
                    <td>!depend!</td>
                </tr>
            </table>

        </div>
    </div>
    <div id="info"></div>
</div>


</body>
</html>