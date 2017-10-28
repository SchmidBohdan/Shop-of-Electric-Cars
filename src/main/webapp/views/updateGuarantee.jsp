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
    <title>Update Guarantee</title>
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

<form action="/updateGuarantee/${currentGuarantee.id}" method="post">
    <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
    <div class="container">
        <form>
            <fieldset>
                <legend>Guarantee</legend>
                <div class="form-group">
                    <label for="usr">Guarantee Time:</label>
                    <br>
                    <span style="color:red">${updateGuaranteeNameExceptions}</span>
                    <input name="guaranteeTime" type="text" class="form-control" id="usr" value="${currentGuarantee.guaranteeTime}">
                    <br>
                </div>
                <button type="submit" value="Send" class="btn btn-danger">Submit</button>
                <hr>
            </fieldset>
        </form>
    </div>

</form>
</body>
</html>
