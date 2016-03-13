<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <%@include file="../include/head.jsp"%>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
        google.charts.load('current', {'packages':['corechart']});
        google.charts.setOnLoadCallback(drawChart);

        function drawChart() {
            var data = google.visualization.arrayToDataTable([
                ['Run',  'Time'],
                <c:forEach var="listValue" items="${timetest}">
                [${listValue.key},  ${listValue.value}],
                </c:forEach>
            ]);
            var options = {
                title: 'Statistic',
                curveType: 'function',
                legend: { position: 'bottom' }
            };

            var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));

            chart.draw(data, options);
        }
    </script>
</head>
<body>
<div class="head-block">
    <div id="answer">Ответ: ${count}</div>
    <div id="curve_chart" style="width: 500px; height: 300px"></div>
    <div>
        <c:forEach var="listValue" items="${timetest}">
            [${listValue.key},  ${listValue.value}],
        </c:forEach>
    </div>
</div>

</body>
</html>