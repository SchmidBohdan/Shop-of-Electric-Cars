<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="icon" href="images/tesla-129.ico" type="image/x-icon">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product page</title>
	<link rel="stylesheet"
		  href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
		  integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
		  crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script
			src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
			integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
			crossorigin="anonymous"></script>

	<link rel="stylesheet" href="/css/product.css" type="text/css">
	<script src="/js/product.js"></script>
</head>
<body>

	<%--<form action="/product" method="post"--%>
		  <%--action="/product?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">--%>


		<%----%>
		 <%--<input type="text" name="name"  placeholder="ProductName">--%>
		 <%--<input type="text" name="description"  placeholder="Description">--%>
		 <%--<input type="text" name="price"  placeholder="Price">--%>
		 <%--<input type="text" name="currency"  placeholder="Currency">--%>

		<%--<select  name="manufacturerId">  &lt;%&ndash;THERE MAY BE multiple="multiple"&ndash;%&gt;--%>
			<%--<option>choose manufacturer</option>--%>
			<%--<c:forEach var="manufacturer" items="${manufacturers}">--%>
				<%--<option value="${manufacturer.id}">${manufacturer.name}</option>--%>
			<%--</c:forEach>--%>
		<%--</select>--%>

		<%--<select  name="guaranteeId">  &lt;%&ndash;THERE MAY BE multiple="multiple"&ndash;%&gt;--%>
			<%--<option>choose guarantee</option>--%>
			<%--<c:forEach var="guarantee" items="${guaranties}">--%>
				<%--<option value="${guarantee.id}">${guarantee.guaranteeTime}</option>--%>
			<%--</c:forEach>--%>
		<%--</select>--%>


		<%--<button>save product</button>--%>

	<%--</form>--%>


	<%--<div class="form-group">--%>
		<%--<input name="img" type="file" class="form-control"/>--%>
		<%--<img src="${product.pathImg}" alt="" width="20%" height="20%">--%>
	<%--</div>--%>


	<%--<ol>--%>
		<%--<c:forEach var="product" items="${products}">--%>
			<%--<li>${product.name}${product.description}${product.price}${product.currency}--%>
				<%--<a href="/deleteProduct/${product.id}">delete</a></li>--%>
			    <%--<a href="/updateProduct/${product.id}">update</a>--%>
		<%--</c:forEach>--%>
	<%--</ol>--%>

	<sf:form>
		<div>
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
		</div>
		<br><br><br>
		<div class="container">
			<sf:form modelAttribute="product" action="/product" method="post">
				<input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
				<fieldset>
					<legend>Product</legend>
					<div class="form-group">

                        <label for="usr">Product Name:</label>
                        <br>
                        <span style="color:red"> ${productNameException}</span>
						<sf:input path="name" id="usr" type="text" class="form-control" placeholder="ProductName"/>
						<br>

                        <label for="usr">Description:</label>
                        <br>
                        <span style="color:red"> ${productDescriptionException}</span>
						<sf:input path="description" id="usr" type="text" class="form-control" placeholder="Description"/>
						<br>

                        <label for="usr">Price:</label>
                        <br>
                        <span style="color:red"> ${productPriceException}</span>
						<sf:input path="price" id="usr" type="text" class="form-control" placeholder="Price"/>
						<br>

                        <label for="usr">Currency:</label>
                        <br>
                        <span style="color:red">${productCurrencyException}</span>
						<sf:input path="currency" id="usr" type="text" class="form-control" placeholder="currency"/>
						<br>

						<select name="manufacturerId" class="form-control" id="exampleSelect1" aria-haspopup="true" aria-expanded="false" required arial-required="true">
							<c:choose>
								<c:when test="${empty product.manufacturer.name}">
									<option value="">Choose Manufacturer</option>
									<c:forEach var="manufacturer" items="${manufacturers}">
										<option value="${manufacturer.id}">${manufacturer.name}</option>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<option value="${product.manufacturer.id}">${product.manufacturer.name}</option>
									<c:forEach var="manufacturer" items="${manufacturers}">
										<option value="${manufacturer.id}">${manufacturer.name}</option>
									</c:forEach>
								</c:otherwise>
							</c:choose>
								<%--//--%>
							<%--<option value="">choose manufacturer</option>--%>
						<%--<c:forEach var="manufacturer" items="${manufacturers}">--%>
							<%--<option value="${manufacturer.id}">${manufacturer.name}</option>--%>
						<%--</c:forEach>--%>
					    </select>
						<br>
						<select name="guaranteeId" class="form-control" id="exampleSelect1" aria-haspopup="true" aria-expanded="false" required arial-required="true">
							<c:choose>
								<c:when test="${empty product.guarantees.guaranteeTime}">
									<option value="">Choose Guarantee</option>
									<c:forEach var="guarantee" items="${guaranties}">
										<option value="${guarantee.id}">${guarantee.guaranteeTime}</option>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<option value="${product.guarantees.id}">${product.guarantees.guaranteeTime}</option>
									<c:forEach var="guarantee" items="${guaranties}">
										<option value="${guarantee.id}">${guarantee.guaranteeTime}</option>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</select>
					</div>
					<button type="submit" value="Send" class="btn btn-success">Submit</button>
					<hr>
				</fieldset>
			</sf:form>
		</div>
	</sf:form>

	<%--Table--%>

	<div class="form-group pull-right">
		<input type="text" class="search form-control" placeholder="What you looking for?">
	</div>
	<span class="counter pull-right"></span>
	<table class="table table-hover table-bordered results">
		<thead>
		<tr>
			<th>#</th>
			<th class="col-md-3 col-xs-3">Product Name</th>
			<th class="col-md-3 col-xs-3">Description</th>
			<th class="col-md-3 col-xs-3">Price</th>
			<th class="col-md-3 col-xs-3">Currency</th>
			<th class="col-md-3 col-xs-3">Manufacturer</th>
			<th class="col-md-3 col-xs-3">Guarantee</th>
			<th class="col-md-3 col-xs-3">Delete</th>
			<th class="col-md-3 col-xs-3">Update</th>
		</tr>
		<tr class="warning no-result">
			<td colspan="4"><i class="fa fa-warning"></i> No result</td>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="product" items="${products}">
			<tr>
				<th scope="row" class="count"></th>
				<td>${product.name}</td>
				<td>${product.description}</td>
				<td>${product.price}</td>
				<td>${product.currency}</td>
				<td>${product.manufacturer.name}</td>
				<td>${product.guarantees.guaranteeTime}</td>
				<td><a href="/deleteProduct/${product.id}">delete</a></td>
				<td><a href="/updateProduct/${product.id}">update</a></td>

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