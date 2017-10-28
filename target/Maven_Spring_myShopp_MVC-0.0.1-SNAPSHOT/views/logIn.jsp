<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: ooo
  Date: 6/17/2017
  Time: 11:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link rel="icon" href="images/tesla-129.ico" type="image/x-icon">
    <title>Login In</title>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>

    <link rel="stylesheet" href="css/logIn.css">
</head>
<body>
<sec:authorize access="isAuthenticated()">
    <% response.sendRedirect("/"); %>
</sec:authorize>

<div class="wrapper">
    <form:form class="form-signin" action="/login" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <span style="font-family: 'Times New Roman', serif; font-style: italic;; color:red;">${userLoginExeption}</span>
        <h2 class="form-signin-heading"><spring:message code="label.loginWord"/></h2>
        <input type="text" class="form-control" name="username" placeholder="Name"/>
        <br>
        <input type="password" class="form-control" name="password" placeholder="Password"/>
        <p><spring:message code="label.doYouHaveAcc"/></p><a style="color: #7e7f84" href="/signup"><spring:message code="label.click"/></a>
        <br>
        <br>
        <button class="btn btn-lg btn-primary btn-block" type="submit"><spring:message code="label.logIn"/></button>
    </form:form>
</div>

</body>
</html>
