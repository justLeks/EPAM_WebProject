<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="com.tours.utils.text" />
<html language="${lang}">

    <link rel="stylesheet" href="css/buttons.css">
    <head>
        <title><fmt:message key="index.title" /></title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/heroic-features.css" rel="stylesheet">
    </head>

    <body>
        <c:import url="WEB-INF/header.jsp" />
        <div class="container">
            <header class="jumbotron hero-spacer">
                <h1><fmt:message key="index.greetings" /></h1>
                <h3><fmt:message key="index.subgreetings" /></h3>
            </header>
            <hr>
            <div class="row">
                <div class="col-lg-12">
                    <h3 aling="center"><fmt:message key="index.choose" /></h3>
                </div>
            </div>
            <div class="row text-center">
                <div class="col-md-3 col-sm-6 hero-feature">
                    <div class="thumbnail">
                        <img src="img/vacation.jpg" alt="">
                        <div class="caption">
                            <h3><fmt:message key="index.vacations" /></h3>
                            <p><fmt:message key="index.vacationinfo" /></p>
                            <p>
                            <form name="vacations" method="post" action="controller" >
                                <button name="command" value="vacationPage" class="btn btn-primary"><fmt:message key="index.vacationbutton" /></button>
                            </form>
                            </p>
                        </div>
                    </div>
                </div>
                <div class="col-md-3 col-sm-6 hero-feature">
                    <div class="thumbnail">
                        <img src="img/shopping.jpg" alt="">
                        <div class="caption">
                            <h3><fmt:message key="index.shopping" /></h3>
                            <p><fmt:message key="index.shoppinginfo" /></p>
                            <p>
                            <form name="shopping" method="post" action="controller" >
                                <button name="command" value="shoppingPage" class="btn btn-primary"><fmt:message key="index.shoppingbutton" /></button>
                            </form> 
                            </p>
                        </div>
                    </div>
                </div>
                <div class="col-md-3 col-sm-6 hero-feature">
                    <div class="thumbnail">
                        <img src="img/excursion.JPG" alt="">
                        <div class="caption">
                            <h3><fmt:message key="index.excursion" /></h3>
                            <p><fmt:message key="index.excursioninfo" /></p>
                            <p>
                            <form name="excursion" method="post" action="controller" >
                                <button name="command" value="excursionPage" class="btn btn-primary"><fmt:message key="index.excursionbutton" /></button>
                            </form>
                            </p>
                        </div>
                    </div>
                </div>
                <div class="col-md-3 col-sm-6 hero-feature">
                    <div class="thumbnail">
                        <img src="img/all.jpg" alt="">
                        <div class="caption">
                            <h3><fmt:message key="index.alltours" /></h3>
                            <p><fmt:message key="index.allinfo" /></p>
                            <p>
                            <form name="allTours" method="post" action="controller" >
                                <button name="command" value="allToursPage" class="btn btn-primary"><fmt:message key="index.alltoursbutton" /></button>
                            </form>
                            </p>
                        </div>
                    </div>
                </div>

            </div>
            <hr>
            <c:import url="WEB-INF/footer.jsp"/>
        </div>
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
