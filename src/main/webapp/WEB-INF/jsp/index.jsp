<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/public/css/index.css"/>

<body>
<div id="root">
    <form method="post" action="${pageContext.request.contextPath}/equation">
        <label>a
            <input type="number" name="a"/>
        </label>
        <label>b
            <input type="number" name="b"/>
        </label>
        <label>c
            <input type="number" name="c"/>
        </label>
        <label>
            <input type="submit" value="Calculate roots"/>
        </label>
    </form>

    <h2>${response}</h2>
</div>
</body>
</html>
