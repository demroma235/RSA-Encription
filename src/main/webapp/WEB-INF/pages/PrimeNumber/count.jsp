<html>
<head>
  <%@include file="../include/head.jsp"%>
  <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
  <script type="text/javascript">
    google.charts.load('current', {'packages':['corechart']});
    google.charts.setOnLoadCallback(drawChart);

    function drawChart() {
      var data = google.visualization.arrayToDataTable([
        ['Key', 'Value'],
        <c:forEach var="listValue" items="${timetest}">
        ['${listValue.key}',  ${listValue.value}],
        </c:forEach>
      ]);

      var options = {
        title: 'Замеры скорости работы',
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
  <div id="curve_chart" style="width: 500px; height: 300px;"></div>
  <div>
    <c:forEach var="listValue" items="${timetest}">
      [${listValue.key},  ${listValue.value}],
    </c:forEach>
  </div>
  <div id="answer"></div>
</div>
</body>
</html>