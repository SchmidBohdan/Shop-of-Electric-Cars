<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: ooo
  Date: 7/2/2017
  Time: 10:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="icon" href="images/tesla-129.ico" type="image/x-icon">
    <link rel="icon" href="images/tesla-129.ico" type="image/x-icon">
    <title>Profile page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <link href="/css/profile.css" type="text/css" rel="stylesheet">

    <script
            src="https://code.jquery.com/jquery-3.1.1.slim.js"
            integrity="sha256-5i/mQ300M779N2OVDrl16lbohwXNUdzL/R2aVUXyXWA="
            crossorigin="anonymous"></script>

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<%--<c:forEach var="p" items="${userBasket.specefications}">--%>
 <%--${p.product.name}--%>
    <%--<a href="/deleteFromBasket/${userBasket.id}/${p.id}">delete</a>--%>
    <%--<br>--%>
<%--</c:forEach>--%>

<%--<form:form action="buy/${userBasket.id}" method="post">--%>
    <%--<button class="btn btn-success">Buy</button>--%>
<%--</form:form>--%>
${userBasket.firstName}
${userBasket.lastName}
${userBasket.address}
${userBasket.email}
${userBasket.numberPhone}
<nav id="menu"><img style="height: 48px; width: 60px; position: relative; top: -20px; right: 350px;" src="/images/ecoimg.png"/>
    <h1 id="sitename">MySite</h1>
    <ul>
        <li><a href="/"><spring:message code="label.home"/></a></li>
        <li><a href="/specefication"><spring:message code="label.aboutUs"/></a></li>

    </ul>
</nav>

<br><br><br><br>
<div class="container">
    <fieldset>
        <legend>My Garage</legend>
        <div class="form-group">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-xs-2 col-xm-2col-md-2">Image Car</div>
                    <div class="col-xs-2 col-xm-2col-md-2">Manufactorurer</div>
                    <div class="col-xs-2 col-xm-2col-md-2">Model</div>
                    <div class="col-xs-2 col-xm-2col-md-2">Price</div>
                    <div class="col-xs-2 col-xm-2col-md-2">Currency</div>
                    <div class="col-xs-2 col-xm-2col-md-2">Delete</div>
                    <hr>

                    <c:forEach var="p" items="${userBasket.specefications}">
                    <div class="col-xs-2 col-xm-2col-md-2"><img style="width: 50px; height: 40px;" src="${p.pathImage}"></div>
                    <div class="col-xs-2 col-xm-2col-md-2">${p.product.manufacturer.name}</div>
                    <div class="col-xs-2 col-xm-2col-md-2">${p.product.name}</div>
                    <div class="col-xs-2 col-xm-2col-md-2" id="price">${p.product.price}</div>
                    <div class="col-xs-2 col-xm-2col-md-2">${p.product.currency}</div>
                    <div class="col-xs-2 col-xm-2col-md-2"> <a href="/deleteFromBasket/${userBasket.id}/${p.id}"><button class="button delete">Delete <i class="fa fa-trash-o" aria-hidden="true"></i></button>
                    </a></div>
                        <br>
                        <hr>
                    </c:forEach>
                </div>
            <br>
            <form:form action="buy/${userBasket.id}" method="post">
                <button style="background-color: #3BBE13" class="btn btn-warning">Buy</button>
            </form:form>
        </div>

        <hr>
        </div>
    </fieldset>

</div>

</body>
</html>
