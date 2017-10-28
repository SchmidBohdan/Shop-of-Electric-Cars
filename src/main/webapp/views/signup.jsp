<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="icon" href="images/tesla-129.ico" type="image/x-icon">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>

    <script type="text/javascript"
            src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.5.3/js/bootstrapValidator.js"></script>


    <link rel="stylesheet" href="/css/signup.css" type="text/css">

    <script src="/js/signup.js"></script>

</head>
<body>

<div class="goodstyle">

    <form action="/saveUser" method="post"/>

    <h1>Registration</h1>
    <hr>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    <div class="form-group">
        <label> First Name:</label>
        <span style="color:red">${userFirstNameExeptions}</span>
        <input type="text" name="userfirstName" placeholder="UserFirstName" class="form-control">
    </div>
    <div class="form-group">
        <label for="pwd">Last Name:</label>
        <span style="color:red">${userLastNameExeption}</span>
        <input type="text" name="userlastName" placeholder="UserLastName" class="form-control" id="pwd">
    </div>
    <div class="form-group">
        <label for="pwd">Password:</label>
        <span style="color:red">${userPasswordExeption}</span>
        <input type="password" type="password" name="userpassword" placeholder="Password" class="form-control">
    </div>
    <div class="form-group">
        <label>Email:</label>
        <span style="color:red">${userEmailExeption}</span>
        <input type="email" type="email" name="useremail" placeholder="Email" class="form-control">
    </div>
    <div class="form-group">
        <label for="pwd">Phone:</label>
        <span style="color:red">${userNumberPhoneExeption}</span>
        <input type="text" name="usernumberPhone" placeholder="(845)555-1212" class="form-control">
    </div>
    <div class="form-group">
        <label for="pwd">Sex Type:</label>
        <span style="color:red">${userNumberPhoneExeption}</span>
        <select  name="sexId" class="form-control" id="exampleSelect1" aria-haspopup="true" aria-expanded="false" required arial-required="true">
         <option value="">Choose Sex Type </option>
         <c:forEach var="sex" items="${sex}">
         <option value="${sex.id}">${sex.type}</option>
         </c:forEach>
        </select>
    </div>
    <div class="form-group">
        <label for="pwd">Adress:</label>
        <span style="color:red">${userAdressExeption}</span>
        <input type="text" name="useraddress" placeholder="Address" class="form-control">
    </div>

    <button type="submit" class="btn btn-default">Send</button>

    </form>

</div>

<%--<form class="well form-horizontal" action="/saveUser" method="post"  id="contact_form">--%>
<%--<fieldset>--%>

<%--<!-- Form Name -->--%>
<%--<legend>Registration!</legend>--%>

<%--<!-- Text input-->--%>

<%--<div class="form-group">--%>
<%--<label class="col-md-4 control-label">First Name</label>--%>
<%--<div class="col-md-4 inputGroupContainer">--%>
<%--<div class="input-group">--%>
<%--<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>--%>
<%--<input type="text" name="userfirstName"  placeholder="UserFirstName" class="form-control">--%>
<%--</div>--%>
<%--</div>--%>
<%--</div>--%>

<%--<!-- Text input-->--%>

<%--<div class="form-group">--%>
<%--<label class="col-md-4 control-label" >Last Name</label>--%>
<%--<div class="col-md-4 inputGroupContainer">--%>
<%--<div class="input-group">--%>
<%--<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>--%>
<%--<input type="text" name="userlastName" placeholder="UserLastName" class="form-control" >--%>
<%--</div>--%>
<%--</div>--%>
<%--</div>--%>

<%--&lt;%&ndash;Text input&ndash;%&gt;--%>

<%--<div class="form-group">--%>
<%--<label class="col-md-4 control-label">Password</label>--%>
<%--<div class="col-md-4 inputGroupContainer">--%>
<%--<div class="input-group">--%>
<%--<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>--%>
<%--<input type="password" name="userpassword"  placeholder="Password" class="form-control">--%>
<%--</div>--%>
<%--</div>--%>
<%--</div>--%>

<%--<!-- Text input-->--%>
<%--<div class="form-group">--%>
<%--<label class="col-md-4 control-label">E-Mail</label>--%>
<%--<div class="col-md-4 inputGroupContainer">--%>
<%--<div class="input-group">--%>
<%--<span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>--%>
<%--<input type="email" name="useremail" placeholder="Email" class="form-control">--%>
<%--</div>--%>
<%--</div>--%>
<%--</div>--%>


<%--<!-- Text input-->--%>

<%--<div class="form-group">--%>
<%--<label class="col-md-4 control-label">Phone #</label>--%>
<%--<div class="col-md-4 inputGroupContainer">--%>
<%--<div class="input-group">--%>
<%--<span class="input-group-addon"><i class="glyphicon glyphicon-earphone"></i></span>--%>
<%--<input type="text" name="usernumberPhone" placeholder="(845)555-1212" class="form-control" >--%>
<%--</div>--%>
<%--</div>--%>
<%--</div>--%>

<%--<!-- Text input-->--%>

<%--<div class="form-group">--%>
<%--<label class="col-md-4 control-label">Address</label>--%>
<%--<div class="col-md-4 inputGroupContainer">--%>
<%--<div class="input-group">--%>
<%--<span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>--%>
<%--<input type="text" name="useraddress" placeholder="Address" class="form-control" >--%>
<%--</div>--%>
<%--</div>--%>
<%--</div>--%>

<%--<!-- Success message -->--%>
<%--<div class="alert alert-success" role="alert" id="success_message">Success <i class="glyphicon glyphicon-thumbs-up">--%>
<%--</i> Thanks for contacting us, we will get back to you shortly. PLEASE SUBMIT ACAUNT IN YOUR EMAIL!!!</div>--%>

<%--<!-- Button -->--%>
<%--<div class="form-group">--%>
<%--<label class="col-md-4 control-label"></label>--%>
<%--<div class="col-md-4">--%>
<%--<button type="submit" class="btn btn-warning" >Send <span class="glyphicon glyphicon-send"></span></button>--%>
<%--</div>--%>
<%--</div>--%>

<%--</fieldset>--%>
<%--</form>--%>
<%--</div>--%>
<%--</div><!-- /.container -->--%>


</body>
</html>