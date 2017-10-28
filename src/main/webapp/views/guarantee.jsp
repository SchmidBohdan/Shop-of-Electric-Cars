<%@ taglib prefix="g" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: ooo
  Date: 25.05.2017
  Time: 23:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="icon" href="images/tesla-129.ico" type="image/x-icon">
    <title>Guarantee Page</title>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>

    <link rel="stylesheet" href="/css/guarantee.css" type="text/css">
    <script src="/js/guarantee.js"></script>
</head>
<body>

<%--<div style="text-align: center;">--%>
    <%--<form action="/guarantee" method="post">--%>
        <%--<input type="text" name="guaranteeTime" placeholder="guaranteeTime">--%>

        <%--<button>Save Guarantee</button>--%>
    <%--</form>--%>
<%--</div>--%>
<%--<ol>--%>
    <%--<g:forEach var="g" items="${guaranties}">--%>
        <%--<li>${g.startTime}, ${g.guaranteeTime}, ${g.endTime}--%>
            <%--<a href="deleteGuarantee/${g.id}">delete</a>--%>
            <%--<a href="updateGuarantee/${g.id}">update</a>--%>
        <%--</li>--%>
    <%--</g:forEach>--%>



    <form:form action="/guarantee" method="post">
        <%--<input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>--%>
        <nav id="menu"><img style="height: 48px; width: 60px; position: relative; top: -22px; left: -60px;" src="/images/ecoimg.png"/>
            <h1 id="sitename">MySite</h1>
            <ul>
                <li><a href="/"><spring:message code="label.home"/></a></li>
                <li><a href="/specefication"><spring:message code="label.specefication"/></a></li>
                <li><a href="/guarantee"><spring:message code="label.guarantee"/></a></li>
                <li><a href="/speceficationType"><spring:message code="label.speceficationTypes"/></a></li>
                <li><a href="/product"><spring:message code="label.product"/></a></li>
                <li><a href="/country"><spring:message code="label.country"/></a></li>
                <li><a href="/city"><spring:message code="label.city"/></a></li>
                <li><a href="/manufacturer"><spring:message code="label.manufacrurer"/></a></li>
                <li><a href="/property"><spring:message code="label.property"/></a></li>
            </ul>
        </nav>
        <br><br><br>
        <div class="container">
            <fieldset>
                    <legend>Guarantee</legend>
                    <div class="form-group">
                        <label for="usr">Guarantee Time:</label>
                        <br>
                        <span style="color:red">${guaranteeNameExceptions}</span>
                        <input name="guaranteeTime" type="text" class="form-control" id="usr" placeholder="GuaranteeTime">
                        <br>
                    </div>
                    <button type="submit" value="Send" class="btn btn-success">Submit</button>
                    <hr>
            </fieldset>

        </div>
    </form:form>

    <%--Table--%>

    <div class="form-group pull-right">
        <input type="text" class="search form-control" placeholder="What you looking for?">
    </div>
    <span class="counter pull-right"></span>
    <table class="table table-hover table-bordered results">
        <thead>
        <tr>
            <th>#</th>
            <th class="col-md-4 col-xs-4">Guarantee Time</th>
            <th class="col-md-4 col-xs-4">Delete</th>
            <th class="col-md-4 col-xs-4">Update</th>
        </tr>
        <tr class="warning no-result">
            <td colspan="4"><i class="fa fa-warning"></i> No result</td>
        </tr>
        </thead>
        <tbody>
        <g:forEach var="guarantee" items="${guaranties}">
            <tr>
                <th scope="row" class="count"></th>
                <td>${guarantee.guaranteeTime}</td>
                <td><a href="/deleteGuarantee/${guarantee.id}">delete</a></td>
                <td><a href="/updateGuarantee/${guarantee.id}">update</a></td>
            </tr>
        </g:forEach>
        </tbody>
    </table>



</body>
</html>
