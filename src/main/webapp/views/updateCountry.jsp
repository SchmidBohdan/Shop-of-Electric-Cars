<%--
  Created by IntelliJ IDEA.
  User: ooo
  Date: 6/2/2017
  Time: 6:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix=""%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link rel="icon" href="images/tesla-129.ico" type="image/x-icon">
    <title>Update Country page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="dist/css/bootstrap-select.css">
</head>
<body>

<form action="/updateCountry/${currentCountry.id}" method="post">
    <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
    <div class="container">
        <form>
            <fieldset>
                <legend>Update Country</legend>
                <div class="form-group">
                    <label for="usr">Country Name:</label>
                    <br>
                    <span style="color:red">${updateCountryNameException}</span>
                    <input name="name" type="text" class="form-control" value="${currentCountry.name}" id="usr" placeholder="CountryName">
                    <br>
                    <select name="cityId" class="form-control" id="exampleSelect1" aria-haspopup="true" aria-expanded="false" required arial-required="true">
                        <option value="${currentCountry.city.id}">${currentCountry.city.name}</option>
                        <c:forEach var="city" items="${cities}">
                            <option value="${city.id}">${city.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <button type="submit" value="Send" class="btn btn-danger">Update</button>
                <hr>
            </fieldset>
        </form>
    </div>
</form>




<%--<form:form modelAttribute="updateCountry" method="post">--%>
<%--<form:input path="name" value="" ></form:input>--%>
<%--</form:form>--%>


<%--<form action="/updateCountry/${currentCountry.id}" method="post">--%>
        <%--<input type="text" name="" value=${currentCountry.name}>--%>


        <%--&lt;%&ndash;<form action="/updateCity/${currentCity.id}${countries}" method="post">&ndash;%&gt;--%>
            <%--&lt;%&ndash;<span style="text-align: center; color: red">${cityNameException}</span>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<input type="text" name="name" value="${currentCity.name}">&ndash;%&gt;--%>


    <%--<select  name="cityId" required aria-required>  &lt;%&ndash;??? ???? ???? ??? ????? multiple="multiple"&ndash;%&gt;--%>
        <%--<option>choose city</option>--%>
        <%--<s:forEach var="city" items="${currentCity}">--%>
            <%--<option value="${city.id}">${city.name}</option>--%>
        <%--</s:forEach>--%>
    <%--</select>--%>

    <%--</form>--%>
    <%--&lt;%&ndash;<select name="countryId" required aria-required>&ndash;%&gt;--%>
        <%--&lt;%&ndash;<option value="">Select City</option>&ndash;%&gt;--%>
        <%--&lt;%&ndash;<c:forEach var="country" items="${currentCountry}">&ndash;%&gt;--%>
            <%--&lt;%&ndash;<option value="${country.id}">${country.name}</option>&ndash;%&gt;--%>
        <%--&lt;%&ndash;</c:forEach>&ndash;%&gt;--%>
    <%--&lt;%&ndash;</select>&ndash;%&gt;--%>
    <%--<br>--%>
    <%--<button>Update City</button>--%>


</body>
</html>
