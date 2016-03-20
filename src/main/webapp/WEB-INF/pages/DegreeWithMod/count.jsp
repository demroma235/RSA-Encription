<html>
<head>
    <%@include file="../include/head.jsp"%>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

    <script type="text/javascript">
        google.charts.load('current', {'packages':['bar']});
        google.charts.setOnLoadCallback(drawStuff);

        function drawStuff() {
            var data = new google.visualization.arrayToDataTable([
                ['Run',  'Time'],
                <c:forEach var="listValue" items="${timetest}">
                ["${listValue.key}",  ${listValue.value}],
                </c:forEach>
            ]);

            var options = {
                title: 'TimeTest',
                width: 500,
                legend: { position: 'none' },
                axes: {
                    x: {
                        0: { side: 'top', label: '50 000 operations'} // Top x-axis.
                    }
                },
                bar: { groupWidth: "90%" }
            };

            var chart = new google.charts.Bar(document.getElementById('top_x_div'));
            // Convert the Classic options to Material options.
            chart.draw(data, google.charts.Bar.convertOptions(options));
        };

    </script>
</head>
<body>
<div class="head-block">
    <div id="top_x_div" style="width: 500px; height: 300px;"></div>
    <div>
        <c:forEach var="listValue" items="${timetest}">
            [${listValue.key},  ${listValue.value}],
        </c:forEach>
    </div>
    <div id="answer"></div>
</div>
</body>
</html>