<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <%@include file="include/head.jsp"%>
</head>
<body>
<div id="wrapper">
    <h1>Алгоритм шифрования RSA</h1>
    <div class="algoritms">
        <div class="algoritm">
            <h3>Алгоритм быстрого возведения в степень по модулю</h3>
            <div class="algoritm-button-load">
                <a href="/degree_with_mod">
                    <div class="button">Перейти</div>
                </a>
                <a href="/test_degree_with_mod_number">
                    <div class="button">Тест скорости <br/>Изменяется Number</div>
                </a>
                <a href="/test_degree_with_mod_degree">
                    <div class="button">Тест скорости <br/>Изменяется Degree</div>
                </a>
                <a href="/test_degree_with_mod_mod">
                    <div class="button">Тест скорости <br/>Изменяется Mod</div>
                </a>
            </div>
        </div>
        <div class="algoritm">
            <h3>Определение простого числа</h3>
            <div class="algoritm-button-load">
                <a href="/prime">
                    <div class="button">Перейти</div>
                </a>
                <a href="/test_prime">
                    <div class="button">Тест скорости</div>
                </a>
            </div>
        </div>
        <div class="algoritm">
            <h3>Шифрование</h3>
            <div class="algoritm-button-load">
                <a href="/encryption/">
                    <div class="button">Перейти</div>
                </a>
                <a href="/test_prime">
                    <div class="button">Тест скорости</div>
                </a>
            </div>
        </div>
    </div>
</div>

</body>
</html>