<%--
  Created by IntelliJ IDEA.
  User: ooo
  Date: 6/10/2017
  Time: 6:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="m"%>
<html>
<head>
    <link rel="icon" href="images/tesla-129.ico" type="image/x-icon">
    <title>Update Manufacturer page</title>
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

    <form action="/updateManufacturer/${currentManufactory.id}?${_csrf.parameterName}=${_csrf.token}"
          method="post" enctype="multipart/form-data">
        <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
        <div class="container">
            <form>
                <fieldset>
                    <legend>Update Manufacturer</legend>
                    <div class="form-group">
                        <label for="usr">Manufacturer Name:</label>
                        <br>
                        <span style="color:red">${updateManufacturerNameExeptions}</span>
                        <input name="name" type="text" value="${currentManufactory.name}" class="form-control" id="usr8">
                        <br>
                        <label for="usr">Manufacturer Description:</label>
                        <br>
                        <span style="color:red">${updateManufacturerDescriptionExeptions}</span>
                        <input name="description" type="text" value="${currentManufactory.description}" class="form-control" id="usr">
                        <br>
                        <select name="countryId" class="form-control" id="exampleSelect1" aria-haspopup="true" aria-expanded="false" required arial-required="true">
                            <option value="${currentManufactory.country.id}">${currentManufactory.country.name}</option>
                            <m:forEach var="c" items="${countries}">
                                <option value="${c.id}">${c.name}</option>
                            </m:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <input name="image" type="file" value="add image" class="form-control">

                        <%--<img src="${currentManufactory.pathImage}" height="100px" width="100px">--%>

                    </div>
                    <button type="submit" value="Send" class="btn btn-danger">Update</button>
                    <hr>
                </fieldset>
            </form>
        </div>
    </form>
</body>
</html>
