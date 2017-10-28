<%--
  Created by IntelliJ IDEA.
  User: ooo
  Date: 6/10/2017
  Time: 10:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="p"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link rel="icon" href="images/tesla-129.ico" type="image/x-icon">
    <title>Update Product page</title>
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

    <form action="/updateProduct/${currentProduct.id}" method="post">
        <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
        <div class="container">
            <form>
                <fieldset>
                    <legend>Product</legend>
                    <div class="form-group">
                        <label for="usr">Product Name:</label>
                        <br>
                        <span style="color:red">${updateProductNameException}</span>
                        <input type="text" name="name"  class="form-control" value="${currentProduct.name}" id="usr8">

                       <br>

                        <label for="usr">Product Description:</label>
                        <br>
                        <span style="color:red">${updateProductDescriptionException}</span>
                        <input type="text" name="description"  class="form-control" value="${currentProduct.description}" id="usr">

                        <br>

                        <label for="usr">Product Price:</label>
                        <br>
                        <span style="color:red">${updateProductPriceException}</span>
                        <input type="text" name="price"  class="form-control" value="${currentProduct.price}" id="usr7">

                        <br>

                        <label for="usr">Product Currency:</label>
                        <br>
                        <span style="color:red">${updateProductCurrencyException}</span>
                        <input type="text" name="currency"  class="form-control" value="${currentProduct.currency}" id="usr5">

                        <br>

                        <select name="manufacturerId"  class="form-control" aria-haspopup="true" aria-expanded="false" required arial-required="true">
                            <option value="${currentProduct.manufacturer.id}">${currentProduct.manufacturer.name}</option>
                            <p:forEach var="manufacturer" items="${manufacturers}">
                                <option value="${manufacturer.id}">${manufacturer.name}</option>
                            </p:forEach>
                        </select>

                        <br>

                        <select name="guaranteeId"  class="form-control" aria-haspopup="true" aria-expanded="false" required arial-required="true">
                            <option value="${currentProduct.guarantees.id}">${currentProduct.guarantees.guaranteeTime}</option>
                            <p:forEach var="g" items="${guaranties}">
                                <option value="${g.id}">${g.guaranteeTime}</option>
                            </p:forEach>
                        </select>
                    </div>
                    <button type="submit" value="Send" class="btn btn-danger">Update</button>
                    <hr>
                </fieldset>
            </form>
        </div>
    </form>



</body>
</html>
