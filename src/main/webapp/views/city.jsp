<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="test_app">
<link rel="stylesheet"
	  href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	  integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	  crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous"></script>




<head>

	<title>City</title>

	<script src="/js/angularJs/angular.min.js"></script>

	<link rel="stylesheet" href="/css/city.css" type="text/css">

	<script src="/js/city.js"></script>


</head>
<body>

	<%--<form action="/city" method="post">--%>
		<%--${cityEmptyNameExeptions}--%>
		<%--${cityExistNameExeptions}--%>
		<%--<input name="name" type="text"  placeholder="CityName">--%>
		<%--<button>Save City</button>--%>
	<%--</form>--%>

	<%--<ol>--%>
	<%--<c:forEach var="city" items="${cities}">--%>

	<%--<li>${city.name}--%>
	<%--<a href="/deleteCity/${city.id}">delete</a>--%>
	<%--<a href="/updateCity/${city.id}">update</a>--%>
	<%--</li>--%>
	<%--</c:forEach>--%>
	<%--</ol>--%>

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
	<form action="/city" method="post">
		<input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
	<div class="container">
		<form>
			<fieldset>
				<legend>City</legend>
			<div class="form-group">
				<label for="usr">City Name:</label>
				<span style="color:red">${cityEmptyNameExeptions}
					${cityExistNameExeptions}</span>
				<br>
				<input name="name" type="text" class="form-control" id="usr" placeholder="CityName">

			</div>
				<button type="submit" value="Send" class="btn btn-success">Success</button>
			<hr>
			</fieldset>
		</form>
	</div>
	</form>


	<%--Table--%>

	<div class="form-group pull-right">
		<input type="text" class="search form-control" placeholder="What you looking for?">
	</div>
	<span class="counter pull-right"></span>
	<table class="table table-hover table-bordered results">
		<thead>
		<tr>
			<th>#</th>
			<th class="col-md-5 col-xs-5">Name City</th>
			<th class="col-md-5 col-xs-5">Delete</th>
			<th class="col-md-5 col-xs-5">Update</th>
		</tr>
		<tr class="warning no-result">
			<td colspan="4"><i class="fa fa-warning"></i> No result</td>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="city" items="${cities}">
		<tr>
				<th scope="row" class="count"></th>
			<td>${city.name}</td>
			<td><a href="/deleteCity/${city.id}">delete</a></td>
			<td><a href="/updateCity/${city.id}">update</a></td>

		</tr>
		</c:forEach>
		</tbody>
	</table>

	<%--<p>Angular in down</p>--%>

    <%--<div ng-cotroller="demoCtrl">--%>

		<%--{{city}}--%>

	<%--</div>--%>

	<%--<script>--%>

		<%--var app = angular.module('test_app', []);--%>

		<%--app.controller('demoCtrl', ['$scope', function ($scope) {--%>

            <%--$scope.city = 'new city';--%>
        <%--}])--%>

	<%--</script>--%>

	<div>  </div>

</body>
</html>
