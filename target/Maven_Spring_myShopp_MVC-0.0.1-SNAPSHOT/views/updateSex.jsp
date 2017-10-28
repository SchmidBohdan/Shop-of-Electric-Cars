<%--
  Created by IntelliJ IDEA.
  User: ooo
  Date: 6/11/2017
  Time: 12:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Sex</title>
</head>
<body>

    <form action="/updateSex/${currentSex.id}" method="post">
        <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
        <input type="text" name="type" value="${currentSex.type}">
        <button>Update Sex</button>
    </form>

</body>
</html>
