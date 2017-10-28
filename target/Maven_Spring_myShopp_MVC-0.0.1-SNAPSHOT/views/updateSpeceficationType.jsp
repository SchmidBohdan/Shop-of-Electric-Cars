<%@ taglib prefix="st" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ooo
  Date: 6/11/2017
  Time: 12:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="icon" href="images/tesla-129.ico" type="image/x-icon">
    <title>Update Specefication Type page</title>
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

<form action="/updateSpeceficationType/${currentSpeceficationType.id}" method="post">
    <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
    <div class="container">
        <form>
            <fieldset>
                <legend>SpeceficationType</legend>
                <div class="form-group">
                    <label for="usr">SpeceficationType:</label>
                    <br>
                    <span style="color:red">${updateSpeceficationTypeEmptyNameExeptions}
                        ${updateSpeceficationTypeExistNameExeptions}</span>
                    <input name="name" type="text" class="form-control" value="${currentSpeceficationType.name}" id="usr">
                    <br>
                </div>
                <button type="submit" value="Send" class="btn btn-danger">Update</button>
                <hr>
            </fieldset>
        </form>
    </div>
</form>




</body>
</html>
