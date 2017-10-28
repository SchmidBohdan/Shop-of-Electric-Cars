<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport"
		  content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>Country page</title>

	<link rel="stylesheet"
		  href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
		  integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
		  crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script
			src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
			integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
			crossorigin="anonymous"></script>

	<link rel="stylesheet" href="/css/country.css" type="text/css">

	<script src="/js/country.js"></script>
</head>
<body>




<%--<form action="/country" method="post">--%>

	<%--${countryNameEmptys}--%>
	<%--${countryNameExists}--%>
	<%--<input type="text" name="countryName"  placeholder="CountryName">--%>

	<%--<select  name="cityId">  &lt;%&ndash;??? ???? ???? ??? ????? multiple="multiple"&ndash;%&gt;--%>
		<%--<option>choose city</option>--%>
		<%--<c:forEach var="city" items="${cities}">--%>
			<%--<option value="${city.id}">${city.name}</option>--%>
		<%--</c:forEach>--%>
	<%--</select>--%>

	<%--<c:forEach var="city" items="${cities}">--%>
		<%--<input type="checkbox" name="cityId">${city.name}--%>
		<%--</c:forEach>--%>

	<%--<button>Save Country</button>--%>
<%--</form>--%>

<%--<ol>--%>
	<%--<c:forEach var="country" items="${countries}">--%>
		<%--<li>${country.name}${country.city.name}--%>
			<%--<a href="/deleteCountry/${country.id}">delete</a>--%>
			<%--<a href="/updateCountry/${country.id}">update</a>--%>
		<%--</li>--%>
	<%--</c:forEach>--%>
<%--</ol>--%>


<form:form action="/country" method="post">
	<input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
	<br>
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
				<legend>Country</legend>
				<div class="form-group">
					<label for="usr">Country Name:</label>
					<br>
					<span style="color:red">${countryNameException}</span>

					<input name="name" type="text" class="form-control" id="usr" placeholder="CountryName">
					<br>

					<select name="cityId" class="form-control" id="exampleSelect1" aria-haspopup="true" aria-expanded="false" required arial-required="true">
						<c:choose>
							<c:when test="${empty country.city.name}">
								<option value="">Choose City</option>
								<c:forEach var="city" items="${cities}">
									<option value="${city.id}">${city.name}</option>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<option value="${country.city.id}">${country.city.name}</option>
								<c:forEach var="city" items="${cities}">
									<option value="${city.id}">${city.name}</option>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</select>
				</div>
				<button type="submit" value="Send" class="btn btn-success">Submit</button>
				<hr>
			</fieldset>
		</form>
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
		<th class="col-md-2 col-xs-2">Name Country</th>
		<th class="col-md-4 col-xs-4">Name City</th>
		<th class="col-md-4 col-xs-4">Delete</th>
		<th class="col-md-4 col-xs-4">Update</th>
	</tr>
	<tr class="warning no-result">
		<td colspan="4"><i class="fa fa-warning"></i> No result</td>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="country" items="${countries}">
		<tr>
			<th scope="row" class="count"></th>
			<td>${country.name}</td>
			<td>${country.city.name}</td>
			<td><a href="/deleteCountry/${country.id}">delete</a></td>
			<td><a href="/updateCountry/${country.id}">update</a></td>

		</tr>
	</c:forEach>
	</tbody>
</table>

<%--<ol>--%>
<%--<c:forEach var="country" items="${countries}">--%>
<%--<li>${country.name}${country.city.name}--%>
<%--<a href="/deleteCountry/${country.id}">delete</a>--%>
<%--<a href="/updateCountry/${country.id}">update</a>--%>
<%--</li>--%>
<%--</c:forEach>--%>
<%--</ol>--%>

</body>
</html>