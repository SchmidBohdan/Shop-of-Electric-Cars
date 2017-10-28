<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="icon" href="images/tesla-129.ico" type="image/x-icon">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>

    <sf:form modelAttribute="sex" action="/sex" method="post">

        <sf:input path="type"/>

        <button>Save Type Sex</button>
    </sf:form>


    <%--<ol>--%>
        <%--<s:forEach var="sex" items="${sex}">--%>
            <%--<li>${sex.type}--%>
                <%--<a href="/deleteSex/${sex.id}">delete</a>--%>
                <%--<a href="/updateSex/${sex.id}">update</a>--%>
            <%--</li>--%>
        <%--</s:forEach>--%>
    <%--</ol>--%>

</body>
</html>