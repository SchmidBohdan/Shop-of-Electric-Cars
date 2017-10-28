<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="st"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="icon" href="images/tesla-129.ico" type="image/x-icon">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>SpeceficationType page</title>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>

    <link rel="stylesheet" href="/css/speceficationType.css" type="text/css">
    <script src="/js/speceficationType.js"></script>
</head>
<body>

    <st:form>
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
            <st:form modelAttribute="speceficationType" action="/speceficationType" method="post">
                <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
                <fieldset>
                    <legend>SpeceficationType</legend>
                    <div class="form-group">
                        <label for="usr">Name SpeceficationType:</label>
                        <br>
                        <span style="color:red">${speceficationTypeEmptyNameExeptions}
                                ${speceficationTypeExistNameExeptions}</span>
                        <sf:input path="name" id="usr" type="text" class="form-control" placeholder="Name"/>
                        <br>

                    </div>
                    <button type="submit" value="Send" class="btn btn-success">Submit</button>
                    <hr>
                </fieldset>
            </st:form>
        </div>
    </st:form>

    <%--<ol>--%>
        <%--<s:forEach var="specefType" items="${speceficationType}">--%>
            <%--<li>${speceficationType.name}--%>
                <%--<a href="/deleteSpeceficationType/${specefType.id}">delete</a>--%>
                <%--<a href="/updateSpeceficationType/${specefType.id}">update</a>--%>
            <%--</li>--%>
        <%--</s:forEach>--%>
    <%--</ol>--%>

    <div class="form-group pull-right">
        <input type="text" class="search form-control" placeholder="What you looking for?">
    </div>
    <span class="counter pull-right"></span>
    <table class="table table-hover table-bordered results">
        <thead>
        <tr>
            <th>#</th>
            <th class="col-md-6 col-xs-6">Name</th>
            <th class="col-md-3 col-xs-3">Delete</th>
            <th class="col-md-3 col-xs-3">Update</th>
        </tr>
        <tr class="warning no-result">
            <td colspan="4"><i class="fa fa-warning"></i> No result</td>
        </tr>
        </thead>
        <tbody>
        <s:forEach var="speceficationType" items="${speceficationTypes}">
            <tr>
                <th scope="row" class="count"></th>
                <td>${speceficationType.name}</td>
                <td><a href="/deleteSpeceficationType/${speceficationType.id}">delete</a></td>
                <td><a href="/updateSpeceficationType/${speceficationType.id}">update</a></td>

            </tr>
        </s:forEach>
        </tbody>
    </table>
</body>
</html>