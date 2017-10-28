<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="p"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="icon" href="images/tesla-129.ico" type="image/x-icon">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Property page</title>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>

    <link rel="stylesheet" href="/css/property.css" type="text/css">
    <script src="/js/property.js"></script>
</head>
<body>


    <%--<form action="/property" method="post">--%>
        <%--${propertyEmptyNameExeptions}--%>
        <%--${propertyExistNameExeptions}--%>
        <%--<input name="name" type="text" placeholder="Property Name">--%>
        <%--<button>Save Property</button>--%>
    <%--</form>--%>

    <%--<ol>--%>
        <%--<p:forEach var="property" items="${properties}">--%>
            <%--<li>${property.name}--%>
                <%--<a href="/delete/${property.id}">delete</a>--%>
                <%--<a href="/updateProperty/${property.id}">update</a>--%>
            <%--</li>--%>
        <%--</p:forEach>--%>

    <%--</ol>--%>


    <form action="/property" method="post">
        <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
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
            <form>
                <fieldset>
                    <legend>Property</legend>
                    <div class="form-group">
                        <label for="usr">Property Name:</label>
                        <br>
                        <span style="color:red">${propertyEmptyNameExeptions} <br> ${propertyExistNameExeptions}</span>
                        <input name="name" type="text" class="form-control" id="usr" placeholder="PropertyName">

                    </div>
                    <button type="submit" value="Send" class="btn btn-success">Success</button>
                    <hr>
                </fieldset>
            </form>
        </div>
    </form>

    <%--<ol>--%>
    <%--<c:forEach var="city" items="${cities}">--%>

    <%--<li>${city.name}--%>
    <%--<a href="/deleteCity/${city.id}">delete</a>--%>
    <%--<a href="/updateCity/${city.id}">update</a>--%>
    <%--</li>--%>
    <%--</c:forEach>--%>
    <%--</ol>--%>


    <%--Table--%>

    <div class="form-group pull-right">
        <input type="text" class="search form-control" placeholder="What you looking for?">
    </div>
    <span class="counter pull-right"></span>
    <table class="table table-hover table-bordered results">
        <thead>
        <tr>
            <th>#</th>
            <th class="col-md-5 col-xs-5">Name Property</th>
            <th class="col-md-5 col-xs-5">Delete</th>
            <th class="col-md-5 col-xs-5">Update</th>
        </tr>
        <tr class="warning no-result">
            <td colspan="4"><i class="fa fa-warning"></i> No result</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="property" items="${properties}">
            <tr>
                <th scope="row" class="count"></th>

                <td>${property.name}</td>
                <td><a href="/deleteProperty/${property.id}">delete</a></td>
                <td><a href="/updateProperty/${property.id}">update</a></td>

            </tr>
        </c:forEach>
        </tbody>
    </table>

</body>
</html>