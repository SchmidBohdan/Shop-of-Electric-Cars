<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/xml" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: ooo
  Date: 6/3/2017
  Time: 11:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="icon" href="images/tesla-129.ico" type="image/x-icon">
    <title>Title</title>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
</head>
<body>

<form action="/updateSpecefication/${currentSpecefication.id}?${_csrf.parameterName}=${_csrf.token}"
      method="post" enctype="multipart/form-data">
    <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
    <div class="container">
    <form:form>
        <fieldset>
            <legend>Specefication</legend>
            <div class="form-group">
                <label>Description:</label>
                <br>
                <span style="color:red">${updateSpeceficationDescriptionExeptions}</span>
                <input type="text" class="form-control" name="description" value="${currentSpecefication.description}">

                <br>

                <select id=dbType" name="productId" class="form-control" aria-haspopup="true" aria-expanded="false" required arial-required="true">
                    <option value="${currentSpecefication.product.id}">${currentSpecefication.product.name}</option>
                    <s:forEach var="p" items="${products}">
                        <option value="${p.id}">${p.name}</option>
                    </s:forEach>
                </select>

                <br>

                <select name="propertyId" class="form-control" aria-haspopup="true" aria-expanded="false" required arial-required="true">
                    <option value="${currentSpecefication.property.id}">${currentSpecefication.property.name}</option>
                    <s:forEach var="p" items="${properties}">
                        <option value="${p.id}">${p.name}</option>
                    </s:forEach>
                </select>
                <br>
                <select name="speceficationTypeId" class="form-control" aria-haspopup="true" aria-expanded="false" required arial-required="true">
                    <option value="${currentSpecefication.speceficationType.id}">${currentSpecefication.speceficationType.name}</option>
                    <s:forEach var="s" items="${speceficationTypes}">
                        <option value="${s.id}">${s.name}</option>
                    </s:forEach>
                </select>

                <br>
            </div>
            <div class="form-group">
                <input name="image" value="${currentSpecefication.pathImage}"  type="file" value="add image" class="form-control"/>

                <%--<img src="${currentSpecefication.pathImage}" height="100px" width="100px">--%>

            </div>
            <button type="submit" value="Send" class="btn btn-danger">Update</button>
            <hr>
        </fieldset>
    </form:form>
    </div>





</form>



</body>
</html>
