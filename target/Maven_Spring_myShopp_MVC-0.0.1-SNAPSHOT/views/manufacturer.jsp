<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="m"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="icon" href="images/tesla-129.ico" type="image/x-icon">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manufacturer Page</title>
	<link rel="stylesheet"
		  href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
		  integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
		  crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script
			src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
			integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
			crossorigin="anonymous"></script>

	<link rel="stylesheet" href="/css/manufacturer.css" type="text/css">
	<script src="/js/manufacturer.js"></script>
</head>
<body>

	<%--<form action="/manufacturer" method="post">--%>

	<%--<input name="name" type="text"  placeholder="ManufacturerName">--%>
	<%--<input name="description" type="text"  placeholder="description" class="description">--%>

	<%--<select name="countryId">--%>
		<%--<option>Choose Country</option>--%>
		<%--<m:forEach var="country" items="${countries}">--%>
	       	<%--<option value="${country.id}">${country.name}</option>--%>
		<%--</m:forEach>--%>
	<%--</select>--%>

		<%--&lt;%&ndash;<select name="cityId">&ndash;%&gt;--%>
			<%--&lt;%&ndash;<option>Choose City</option>&ndash;%&gt;--%>
			<%--&lt;%&ndash;<m:forEach var="city" items="${cities}">&ndash;%&gt;--%>
				<%--&lt;%&ndash;<option value="${city.id}">${city.name}</option>&ndash;%&gt;--%>
			<%--&lt;%&ndash;</m:forEach>&ndash;%&gt;--%>
		<%--&lt;%&ndash;</select>&ndash;%&gt;--%>
	<%----%>
	<%----%>
	<%--<button>save manufacturer</button>--%>
		<%--</form>--%>
		<%----%>
		<%--<ol>--%>
			<%--<m:forEach var="m" items="${manufacturers}">--%>
				<%--<li>${m.name}${m.description}${m.country.name}--%>
					<%--<a href="/deleteManufacturer/${m.id}">delete</a>--%>
					<%--<a href="/updateManufacturer/${m.id}">update</a>--%>
				<%--</li>--%>
			<%--</m:forEach>--%>
		<%--</ol>--%>

	<form action="/manufacturer?${_csrf.parameterName}=${_csrf.token}"
		  method="post" enctype="multipart/form-data">

		<input type="hidden"  name="${_csrf.parameterName}" value="${_csrf.token}"/>
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
					<legend>Manufacturer</legend>
					<div class="form-group">
						<label for="usr">Manufacturer Name:</label>
						<span style="color:red">${manufacturerNameExeptions}</span>
						<input name="name" type="text" class="form-control" id="usr8" placeholder="ManufacturerName">
						<br>
						<span style="color:red">${manufacturerDescriptionExeptions}</span>
						<input name="description" type="text" class="form-control" id="usr" placeholder="DescriptionName">
						<br>

						<select name="countryId" class="form-control" id="exampleSelect1" aria-haspopup="true" aria-expanded="false" required arial-required="true">
							<c:choose>
								<c:when test="${empty currentManufacturer.country.name}">
									<option value="">Choose Country</option>
									<c:forEach var="country" items="${countries}">
										<option value="${country.id}">${country.name}</option>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<option value="${currentManufacturer.country.id}">${currentManufacturer.country.name}</option>
									<c:forEach var="country" items="${countries}">
										<option value="${country.id}">${country.name}</option>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</select>


							<%--<option value="">choose country</option>--%>
							<%--<m:forEach var="c" items="${countries}">--%>
								<%--<option value="${c.id}">${c.name}</option>--%>
							<%--</m:forEach>--%>
						</select>
					</div>
					<div class="form-group">
						<input name="image" type="file" value="add image" class="form-control">
					</div>
					<button type="submit" value="Send" class="btn btn-success">Submit</button>
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
			<th class="col-md-2 col-xs-2">Manufacturer Name</th>
			<th class="col-md-2 col-xs-2">Description</th>
			<th class="col-md-2 col-xs-2">Image</th>
			<th class="col-md-2 col-xs-2">Country</th>
			<th class="col-md-2 col-xs-2">Delete</th>
			<th class="col-md-2 col-xs-2">Update</th>
		</tr>
		<tr class="warning no-result">
			<td colspan="4"><i class="fa fa-warning"></i> No result</td>
		</tr>
		</thead>
		<tbody>
		<m:forEach var="manufacturer" items="${manufacturers}">
			<tr>
				<th scope="row" class="count"></th>
				<td>${manufacturer.name}</td>
				<td>${manufacturer.description}</td>

				<td>
					<img src="${manufacturer.pathImage}" height="100px" width="100px">
				</td>

				<td>${manufacturer.country.name}</td>
				<td><a href="/deleteManufacturer/${manufacturer.id}">delete</a></td>
				<td><a href="/updateManufacturer/${manufacturer.id}">update</a></td>
			</tr>
		</m:forEach>
		</tbody>
	</table>

</body>
</html>