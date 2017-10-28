<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="icon" href="images/tesla-129.ico" type="image/x-icon">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Specefication page</title>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>

    <link rel="stylesheet" href="/css/specefication.css" type="text/css">
    <script src="/js/specefication.js"></script>
</head>
<body>

    <%--<form action="/specefication" method="post">--%>
        <%--<input type="text" name="description" placeholder="Discription">--%>

        <%--&lt;%&ndash;<select name="propertyId" multiple="multiple">&ndash;%&gt;--%>
            <%--&lt;%&ndash;<option>choose property</option>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<s:forEach var="property" items="${properties}">&ndash;%&gt;--%>
                <%--&lt;%&ndash;<input value="${propertyId}">${property.name}>&ndash;%&gt;--%>
            <%--&lt;%&ndash;</s:forEach>&ndash;%&gt;--%>
        <%--&lt;%&ndash;</select>&ndash;%&gt;--%>

        <%--<select name="productId">--%>
            <%--<option>choose Product</option>--%>
            <%--<s:forEach var="product" items="${products}">--%>
                <%--<option value="${product.id}">${product.name}</option>--%>
            <%--</s:forEach>--%>
        <%--</select>--%>


        <%--<select name="speceficationTypeId">--%>
            <%--<option>choose speceficationType</option>--%>
            <%--<s:forEach var="speceficationType" items="${speceficationTypes}">--%>
                <%--<option value="${speceficationType.id}">${speceficationType.name}</option>--%>
            <%--</s:forEach>--%>
        <%--</select>--%>

        <%--<select name = "propertyId">--%>
            <%--<option>choose Properties</option>--%>
            <%--<s:forEach var="property" items="${properties}">--%>
                <%--<option value="${property.id}">${property.name}</option>--%>
            <%--</s:forEach>--%>
        <%--</select>--%>

        <%--<button>Save Specefication</button>--%>
    <%--</form>--%>

    <%--<ol>--%>
        <%--<s:forEach var="specefication" items="${specefications}">--%>
            <%--<li style="color: limegreen">${specefication.description}${specefication.product.name}${specefication.speceficationType.name}--%>
                    <%--${specefication.property.name}--%>

                <%--<a href="/deleteSpecefication/${specefication.id}">delete</a>--%>
                <%--<a href="/updateSpecefication/${specefication.id}">update</a>--%>
            <%--</li>--%>
        <%--</s:forEach>--%>
    <%--</ol>--%>

    <sf:form modelAttribute="specefication" action="/specefication?${_csrf.parameterName}=${_csrf.token}"
             method="post" enctype="multipart/form-data">
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
            <sf:form modelAttribute="specefication" action="/specefication?${_csrf.parameterName}=${_csrf.token}"
                     method="post" enctype="multipart/form-data">
                <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
                <fieldset>
                    <legend>Specefication</legend>
                    <div class="form-group">
                        <label for="usr">Description:</label>
                        <br>
                        <span style="color:red">${speceficationDescriptionExeptions}</span>
                        <sf:input path="description" id="usr" type="text" class="form-control" placeholder="Description"/>
                        <br>


                        <select name="productId" class="form-control" id="exampleSelect1" aria-haspopup="true" aria-expanded="false" required arial-required="true">
                            <s:choose>
                        <s:when test="${empty specefication.product.name}">
                            <option value="">Choose Product</option>
                            <s:forEach var="product" items="${products}">
                                <option value="${product.id}">${product.name}</option>
                            </s:forEach>
                        </s:when>
                        <s:otherwise>
                            <option value="${specefication.product.id}">${specefication.product.name}</option>
                            <s:forEach var="product" items="${products}">
                                <option value="${product.id}">${product.name}</option>
                            </s:forEach>
                        </s:otherwise>
                    </s:choose>
                        </select>
                        <br>

                        <select name="speceficationTypeId" class="form-control" id="exampleSelect1" aria-haspopup="true" aria-expanded="false" required arial-required="true">
                            <s:choose>
                                <s:when test="${empty specefication.speceficationType.name}">
                                    <option value="">Choose SpeceficationType</option>
                                    <s:forEach var="speceficationType" items="${speceficationTypes}">
                                        <option value="${speceficationType.id}">${speceficationType.name}</option>
                                    </s:forEach>
                                </s:when>
                                <s:otherwise>
                                    <option value="${specefication.speceficationType.id}">${specefication.speceficationType.name}</option>
                                    <s:forEach var="speceficationType" items="${speceficationTypes}">
                                        <option value="${speceficationType.id}">${speceficationType.name}</option>
                                    </s:forEach>
                                </s:otherwise>
                            </s:choose>

                        </select>
                        <br>



                        <select name="propertyId" class="form-control" id="exampleSelect1" aria-haspopup="true" aria-expanded="false" required arial-required="true">
                            <s:choose>
                                <s:when test="${empty specefication.property.name}">
                                    <option value="">Choose Property</option>
                                    <s:forEach var="property" items="${properties}">
                                        <option value="${property.id}">${property.name}</option>
                                    </s:forEach>
                                </s:when>
                                <s:otherwise>
                                    <option value="${specefication.property.id}">${specefication.property.name}</option>
                                    <s:forEach var="property" items="${properties}">
                                        <option value="${property.id}">${property.name}</option>
                                    </s:forEach>
                                </s:otherwise>
                            </s:choose>
                        </select>
                    </div>

                    <div class="form-group">
                        <input name="image" type="file" class="form-control">
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
            <th class="col-md-3 col-xs-3">Description</th>
            <th class="col-md-3 col-xs-3">Image</th>
            <th class="col-md-3 col-xs-3">Product</th>
            <th class="col-md-3 col-xs-3">SpeceficationType</th>
            <th class="col-md-3 col-xs-3">Property</th>
            <th class="col-md-3 col-xs-3">Delete</th>
            <th class="col-md-3 col-xs-3">Update</th>
        </tr>
        <tr class="warning no-result">
            <td colspan="4"><i class="fa fa-warning"></i> No result</td>
        </tr>
        </thead>
        <tbody>

        <s:forEach var="specefication" items="${specefications.content}">
            <tr>
                <th scope="row" class="count"></th>
                <td>${specefication.description}</td>

                <td>
                    <img src="${specefication.pathImage}" height="100px" width="160px">
                </td>

                <td>${specefication.product.name}</td>
                <td>${specefication.speceficationType.name}</td>
                <td>${specefication.property.name}</td>
                <td><a href="/deleteSpecefication/${specefication.id}">delete</a></td>
                <td><a href="/updateSpecefication/${specefication.id}">update</a></td>


            </tr>
        </s:forEach>
        </tbody>
    </table>

    <div style="display: flex; justify-content: center; margin-left: 10%">
        <div class="col-md-12 col-xs-12">
            <div class="row">
                <div class="col-md-2 col-xs-6">
                    <div class="dropdown">
                        <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Sort
                            <span
                                    class="caret"></span>
                        </button>
                        <ul class="dropdown-menu">
                            <custom:sort innerHtml="Name asc" paramValue="description"/>
                            <custom:sort innerHtml="Name desc" paramValue="description,desc"/>
                        </ul>
                    </div>
                </div>
                <div class="col-md-6 col-xs-12 text-center">
                    <custom:pageable page="${specefications}" cell="<li></li>" container="<ul class='pagination'></ul>"/>
                </div>
                <div class="col-md-2 col-xs-6">
                    <custom:size posibleSizes="1,2,5,10" size="${specefications.size}"/>
                </div>
            </div>
        </div>
    </div>

</body>
</html>