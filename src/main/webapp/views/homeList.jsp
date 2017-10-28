<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="/WEB-INF/custom.tld" prefix="custom" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html lang="en">
<head>
    <link rel="icon" href="images/tesla-129.ico" type="image/x-icon">
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Home page</title>

    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>

    <link rel="stylesheet" type="text/css" href="/css/main.css">

    <script src="/js/home.js"></script>



    <link href="css/cssCarusel/mystyle.css" rel="stylesheet" type="text/css"/>
    <link href="css/cssCarusel/slimbox2.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="js/jsCarusel/jquery.hoverIntent.minified.js"></script>
    <!-- dla plavnogo poiavlana Kontenty -->
    <script src="/js/jsCarusel/jquery.js" type="text/javascript"></script>
    <script src="/js/jsCarusel/scriptsForlndex.js" type="text/javascript"></script>
    <script src="/js/jsCarusel/cloud-carousel.1.0.4.min.js" type="text/javascript"></script>
    <script src="/js/jsCarusel/jquery.mousewheel.min.js" type="text/javascript"></script>
    <script src="/js/jsCarusel/slimbox2.js" type="text/javascript"></script>

    <script src="/js/sortPrice/jquery-3.2.1.js" type="text/javascript"></script>
    <link href="/css/sortPrice/jquery-ui.css" rel="stylesheet">
    <script  src="/js/sortPrice/jquery-ui.js" type="text/javascript"></script>


</head>
<body>


<%--<sec:authentication property="name"/>--%>

<%--Tree Sample--%>

<%--Header menu--%>
<div class="mainmenu-wrapper">
    <div class="container mystyle">
        <div class="menuextras">
            <div class="extras">
                <ul>
                    <sec:authorize access="isAuthenticated()">
                    <li class="shopping-cart-items">
                        <form:form action="/logout" method="post">
                            <button style="border-radius: 40px 10px; background-color:#69DAFF; border: 0px solid black;">
                                <span class="glyphicon glyphicon-log-out"></span><spring:message code="label.logout"/>
                            </button>
                        </form:form>
                        </sec:authorize>
                    </li>
                    <sec:authorize access="hasRole('ROLE_USER')">
                        <li class="garage">
                            <a href="/profile"><img src="/images/GarageCars.jpg"/></a>
                        </li>
                        <li class="shopping-cart-items b-cart"><a href="/profile"><spring:message code="label.garageCars"/></a></li>
                    </sec:authorize>
                    <li class="dropdown active">
                        <a class="dropdown-toggle" data-toggle="dropdown" role="button"
                           aria-haspopup="true" aria-expanded="false">
                            <spring:message code="label.lang"/> <span class="caret"></span>
                            <ul class="dropdown-menu">
                                <li><a href="/?lang=ua">ua</a></li>
                                <li><a href="/?lang=en" id="ua">en</a></li>
                            </ul>
                        </a>
                    </li>
                    <sec:authorize access="!isAuthenticated()">
                        <li class="active"><i class="glyphicon glyphicon-log-in "></i><a href="/logIn"><spring:message
                                code="label.logIn"/></a></li>
                    </sec:authorize>
                    <sec:authorize access="!isAuthenticated()">
                        <li class="active"><i class="glyphicon glyphicon-user icon-white"></i><a
                                href="/signup"><spring:message code="label.signup"/></a></li>
                    </sec:authorize>
                </ul>
            </div>
        </div>
        <nav id="mainmenu" class="mainmenu">
            <ul>
                <li class="logo-wrapper" id="main-logo"><a href="/"><img alt="" src="/images/new%20Logo.png"
                                                                         alt="Multipurpose Twitter Bootstrap Template"></a>
                </li>
                <li class="active"><a href="/" style="color: #4F8DB3"><spring:message code="label.home"/></a></li>
                <li class="active"><a href="/aboutUs" style="color: #4F8DB3"><spring:message code="label.aboutUs"/></a></li>

                <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <li class="dropdown active"><a style="color: #4F8DB3" href="" class="dropdown-toggle"
                                                   data-toggle="dropdown" role="button" aria-haspopup="true"
                                                   aria-expanded="false"><spring:message
                            code="label.administrator"/><span
                            class="caret"></span></a>
                        <ul class="dropdown-menu back_Ground">

                            <li><a href="/signup"><strong><spring:message code="label.signup"/></strong></a></li>
                            <li><a href="/city"><strong><spring:message code="label.city"/></strong></a></li>
                            <li><a href="/country"><strong><spring:message code="label.country"/></strong></a></li>

                            <li><a href="/manufacturer"><strong><spring:message code="label.manufacrurer"/></strong></a>
                            </li>
                            <li><a href="/product"><strong><spring:message code="label.product"/></strong></a></li>
                            <li><a href="/specefication"><strong><spring:message
                                    code="label.specefication"/></strong></a></li>
                            <li><a href="/speceficationType"><strong><spring:message
                                    code="label.speceficationTypes"/></strong></a></li>
                            <li><a href="/property"><strong><spring:message code="label.property"/></strong></a></li>
                            <li><a href="/guarantee"><strong><spring:message code="label.guarantee"/></strong></a></li>
                        </ul>
                    </li>
                </sec:authorize>
            </ul>
        </nav>
    </div>
</div>

<%--HOOLDS ON WALL--%>


<br><br><br>
<div class="products-heading">
    <h3>Shop Eco Cars</h3>
</div>
<div class="container">
    <div class="row">
        <%--View on site--%>
        <div col="col-md-12 col-xs-12">
            <div style="position: relative; left: 900px; top: 50px;" >
                <div style="height: 25px; width: 25px; border-radius: 9px; position: relative; top: 25px; right: 30px;">
                    <a href="/"><div style="position: relative; left: 5px; top: 4px" class="glyphicon glyphicon-align-justify"></div></a>
                </div>
                <div style="height: 25px; width: 25px; background-color: #B4FFFA; border-radius: 9px;">
                    <a href="/homeList"> <div style="position: relative; left: 5px; top: 4px"  class="glyphicon glyphicon-list"></div> </a>
                </div>
            </div>
        </div>
        <%--Sort By Price--%>
        <div col="col-md-3 col-xs-3">

            <div style="position: relative; left: 1000px;">
                <p>
                    <label for="amount">Price range:</label>
                    <input type="text" id="amount" style="border:0; color:#1CB23A; font-weight:bold;" />
                </p>
                <div style="width: 250px;" id="slider-range"></div>
            </div>
        </div>
        <script type="text/javascript">
            $.noConflict();
            jQuery( document ).ready(function( $ ) {
                var $filters = $("input:radio[name='brand'],input:radio[name=team]").prop('checked', false); // start all checked
                var $categoryContent = $('#CategoryContent b');
                $filters.click(function () {
                    // if any of the checkboxes for brand or team are checked, you want to show LIs containing their value, and you want to hide all the rest.
                    $categoryContent.hide();
                    $filters.filter(':checked').each(function (i, el) {
                        $categoryContent.filter(':contains(' + el.value + ')').show();
                    });
                });

                function showProducts(minPrice, maxPrice) {
                    $("#products b").hide().filter(function () {
                        var price = parseInt($(this).data("price"), 10);
                        return price >= minPrice && price <= maxPrice;
                    }).show();
                }

                $(function () {
                    var options = {
                        range: true,
                        min: 0,
                        max: 100000,
                        values: [0, 100000],
                        slide: function (event, ui) {
                            var min = ui.values[0],
                                max = ui.values[1];

                            $("#amount").val("$" + min + " - $" + max);
                            showProducts(min, max);
                        }
                    }, min, max;

                    $("#slider-range").slider(options);

                    min = $("#slider-range").slider("values", 0);
                    max = $("#slider-range").slider("values", 1);

                    $("#amount").val("$" + min + " - $" + max);

                    showProducts(min, max);
                });
            });

        </script>
    </div>
</div>

<div class="container">
    <br> <br><br>
    <div class="row">
        <s:forEach var="specefication" items="${specefications.content}">
            <div id="CategoryContent">
                <ul id="products">
                    <b class="product" data-price="${specefication.product.price}">
                        <div class="col-sm-12">
                            <input class="toggle" id="toggle" type="checkbox">
                            <div class="social-share-wrap">
                                <div class="cover">
                                    <label class="label" for="toggle"><i class="fa fa-share-alt"></i></label>
                                    <img class="image" src="${specefication.pathImage}">
                                </div>
                                <div class="content">
                                    <div>

                                        <img style="height: 50px; width: 50px; position: relative; left: 220px; top: 5px;" class="image" src="${specefication.product.manufacturer.pathImage}">
                                    </div>
                                    <div class="title" style=" position: relative; top: -50px; height: 10px;"><p style="font-size: 40px;">${specefication.product.name}</p></div>
                                    <div class="text"><p style="font-size: 20px;">${specefication.description},${specefication.property.name},${specefication.speceficationType.name}</p></div>
                                    <div class="price ">${specefication.product.currency}${specefication.product.price}</div>

                                    <sec:authorize access="hasRole('ROLE_USER')">
                                        <a class="buy" href="/addIntoGarage/${specefication.id}"><i
                                                class="fa fa-shopping-cart"></i><spring:message code="label.inGarage"/></a>
                                    </sec:authorize>

                                </div>
                                <div class="social-share-overlay">
                                    <label class="close" for="toggle">&times;</label>
                                    <div class="social-share-links">
                                        <a target="_blank" href="#"><i class="fa fa-facebook"></i> Facebook</a>
                                        <a target="_blank" href="#"><i class="fa fa-twitter"></i> Twitter</a>
                                        <a target="_blank" href="#"><i class="fa fa-pinterest"></i> Pinterest</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </b>
                </ul>
            </div>
        </s:forEach>

    </div>
</div>


<br><br><br><br><br><br>
<div style="display: flex; justify-content: center; margin-left: 15%">
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

<br>
<br><br>
<div class="products-heading">
    <h3>Gallery</h3>

    <div id="forbody">
        <div id="carousel1">
            <div id="innerCarousel">
                <a href="images/imagesCarusel/carousel/m1.jpg" rel="lightbox"><img class="cloudcarousel"
                                                                                   src="images/imagesCarusel/carousel/m1sm.jpg"
                                                                                   alt="image1"/></a>
                <a href="images/imagesCarusel/carousel/m2.jpg" rel="lightbox"><img class="cloudcarousel"
                                                                                   src="images/imagesCarusel/carousel/m2sm.jpg"
                                                                                   alt="image2"/></a>
                <a href="images/imagesCarusel/carousel/m4.jpg" rel="lightbox"><img class="cloudcarousel"
                                                                                   src="images/imagesCarusel/carousel/m4sm.png"
                                                                                   alt="image3"/></a>
                <a href="images/imagesCarusel/carousel/t1.jpg" rel="lightbox"><img class="cloudcarousel"
                                                                                   src="images/imagesCarusel/carousel/t1sm.jpg"
                                                                                   alt="image4"/></a>
                <a href="images/imagesCarusel/carousel/t2.jpg" rel="lightbox"><img class="cloudcarousel"
                                                                                   src="images/imagesCarusel/carousel/t2sm.jpg"
                                                                                   alt="image5"/></a>
                <a href="images/imagesCarusel/carousel/t3.jpg" rel="lightbox"><img class="cloudcarousel"
                                                                                   src="images/imagesCarusel/carousel/t3sm.jpg"
                                                                                   alt="image6"/></a>
                <a href="images/imagesCarusel/carousel/a1.jpg" rel="lightbox"><img class="cloudcarousel"
                                                                                   src="images/imagesCarusel/carousel/a1sm.jpg"
                                                                                   alt="image7"/></a>
                <a href="images/imagesCarusel/carousel/h1.jpg" rel="lightbox"><img class="cloudcarousel"
                                                                                   src="images/imagesCarusel/carousel/h1sm.jpg"
                                                                                   alt="image8"/></a>
                <a href="images/imagesCarusel/carousel/j1.jpg" rel="lightbox"><img class="cloudcarousel"
                                                                                   src="images/imagesCarusel/carousel/j1sm.jpg"
                                                                                   alt="image9"/></a>
                <a href="images/imagesCarusel/carousel/v1.jpg" rel="lightbox"><img class="cloudcarousel"
                                                                                   src="images/imagesCarusel/carousel/v1sm.jpg"
                                                                                   alt="image10"/></a>
            </div>
            <div id="buttonLeft"></div>
            <div id="buttonRight"></div>

        </div>
    </div>

</div>
<br><br><br><br>

<!-- Under main. -->
<div class="container" id="content">
    <!-- Example row of columns -->
    <div class="row">
        <div class="col-md-4">
            <h2>Tesla New Model</h2>

            <p>Donec id elit non mi porta gravida at eget metus. Fusce
                dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh,
                ut fermentum massa justo sit amet risus. Etiam porta sem malesuada
                magna mollis euismod. Donec sed odio dui.</p>
            <p>
                <a class="btn btn-default" href="#" role="button">View details
                    &raquo;</a>
            </p>
        </div>
        <div class="col-md-4">
            <h2>The Price of Electro Cars in 2017</h2>

            <p>Donec id elit non mi porta gravida at eget metus. Fusce
                dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh,
                ut fermentum massa justo sit amet risus. Etiam porta sem malesuada
                magna mollis euismod. Donec sed odio dui.</p>
            <p>
                <a class="btn btn-default" href="#" role="button">View details
                    &raquo;</a>
            </p>
        </div>
        <div class="col-md-4">
            <h2>New batterys</h2>

            <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in,
                egestas eget quam. Vestibulum id ligula porta felis euismod semper.
                Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum
                nibh, ut fermentum massa justo sit amet risus.</p>
            <p>
                <a class="btn btn-default" href="#" role="button">View details
                    &raquo;</a>
            </p>
        </div>
    </div>
</div>

<br><br><br>
<div class="products-heading">
    <h3>Video</h3>

    <%--Video--%>
    <%--?ecver=2?rel=0&autoplay=1--%>
    <br>
    <div style="margin-left: 280px; width: 100%;  padding: 10px;">
        <div class="container">
            <div class="row">
                <div class="col-sm-6 col-xs-6 col-md-6">

                    <div class="embed-responsive embed-responsive-16by9">
                        <iframe class="embed-responsive-item" src="///www.youtube.com/embed/0sH5X9xbcUg"></iframe>
                    </div>
                </div>
            </div>
        </div>
    </div>


</div>
<br><br><br>
<footer>
    <div style="border-top: 2px solid #7e7f84; height: 250px; width: auto" >
        <div class="container">
            <div class="row">
                <br>
                <div class="col-sm-4 col-xs-4 col-md-4">
                    <p>&copy; Company Eco Cars 2017</p>
                </div>
                <div class="col-sm-4 col-xs-4 col-md-4">
                    <p>&copy; Company Eco Cars 2017</p>
                </div>
                <div class="col-sm-4col-xs-4 col-md-4">
                    <p>&copy; Company Eco Cars 2017</p>
                </div>
                <br>
                <div class="col-sm-4 col-xs-4 col-md-4">
                    <p>&copy; Company Eco Cars 2017</p>
                </div>
                <div class="col-sm-4 col-xs-4 col-md-4">
                    <p>&copy; Company Eco Cars 2017</p>
                </div>
                <div class="col-sm-4col-xs-4 col-md-4">
                    <p>&copy; Company Eco Cars 2017</p>
                </div>
                <br>
                <div class="col-sm-4 col-xs-4 col-md-4">
                    <p>&copy; Company Eco Cars 2017</p>
                </div>
                <div class="col-sm-4 col-xs-4 col-md-4">
                    <p>&copy; Company Eco Cars 2017</p>
                </div>
                <div class="col-sm-4col-xs-4 col-md-4">
                    <p>&copy; Company Eco Cars 2017</p>
                </div>
                <br>
                <div class="col-sm-4 col-xs-4 col-md-4">
                    <p>&copy; Company Eco Cars 2017</p>
                </div>
                <div class="col-sm-4 col-xs-4 col-md-4">
                    <p>&copy; Company Eco Cars 2017</p>
                </div>
                <div class="col-sm-4col-xs-4 col-md-4">
                    <p>&copy; Company Eco Cars 2017</p>
                </div>
            </div>
        </div>
    </div>
</footer>



</body>
</html>