<%@ page session="false" isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <%@include file="../include/head.jsp"%>
    <script>
        function getCount(number) {
            $.ajax({
                url: "/count_prime?number="+number,
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
    <h1>Простое число</h1>
    <div class="count">
            <div>
                Введите число
                <br/>
                <input id="number" type="number" name="number"/>
            </div>
            <input type="button" class="button" value="Узнать" onclick="getCount($('#number').val())"/>

        </form>
    </div>
    <div id="answer"></div>
</div>


</body>
</html>