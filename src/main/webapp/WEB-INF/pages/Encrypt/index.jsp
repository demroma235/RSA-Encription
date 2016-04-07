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
        function getEncrypt(number) {
                $.ajax({
                    url: "count_encrypt?number="+number,
                    success: function(response) {
                        $('#result-encrypt').html(response);
                    },
                    error: function(e){
                        alert('Ошибочка' + e);
                    }
                });
        }
        function getDeEncrypt(number) {
            $.ajax({
                url: "count_interpretation?number="+number,
                success: function(response) {
                    $('#result-interpretation').html(response);
                },
                error: function(e){
                    alert('Ошибочка' + e);
                }
            });
        }
        function getEncryptString(string) {
            $.ajax({
                url: "count_encrypt_string?string="+string,
                success: function(response) {
                    $('#result-encrypt-string').html(response);
                },
                error: function(e){
                    alert('Ошибочка' + e);
                }
            });
        }
        function getDeEncryptString(string) {
            $.ajax({
                url: "count_deencrypt_string?string="+string,
                success: function(response) {
                    $('#result-interpretation-string').html(response);
                },
                error: function(e){
                    alert('Ошибочка' + e);
                }
            });
        }
    </script>
</head>
<body>
<div class="head-block">
    <h1>Шифрование</h1>
    <div class="encrypt">
        <h2>Шифрование числа</h2>
        <div class="block-encrypt">
            <input type="number" id="number_for_encrypt">
            <br>
            <input type="button" class="button number_for_encrypt_button" value="Зашифровать" onclick="getEncrypt($('#number_for_encrypt').val())">
            <div id="result-encrypt"></div>
        </div>
        <div class="block-encrypt">
            <input type="number" id="number_for_interpretation">
            <br>
            <input type="button" class="button number_for_encrypt_button" value="Расшифровать" onclick="getDeEncrypt($('#number_for_interpretation').val())">
            <div id="result-interpretation"></div>
        </div>
        <a href="test">Тест</a>
    </div>
    <div class="encrypt">
        <h2>Шифрование Текста</h2>
        <div class="block-encrypt-string">
            <textarea name="" id="string_for_encrypt" cols="30" rows="5"></textarea>
            <br>
            <input type="button" class="button number_for_encrypt_button" value="Зашифровать" onclick="getEncryptString($('#string_for_encrypt').val())">
            <div class="result" id="result-encrypt-string"></div>
        </div>
        <div class="block-encrypt-string">
            <textarea name="" id="string_for_interpretation" cols="30" rows="5"></textarea>
            <br>
            <input type="button" class="button number_for_encrypt_button" value="Расшифровать" onclick="getDeEncryptString($('#string_for_interpretation').val())">
            <div class="result" id="result-interpretation-string"></div>
        </div>
    </div>
    <div class="count">
        <h2>Настройки</h2>
        <div id="error-red"></div>
        <c:if test="${empty data.private_key_1}">
            <script>
                $('.number_for_encrypt_button').prop("disabled", true);
            </script>
            <div id="error-yellow" style="display: block;">Для дальнейшей работы необходимо сгенерировать первый секретный ключ. Подберите подходящую пару простых чисел.</div>
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