<%-- 
    Document   : success
    Created on : Dec 21, 2015, 6:52:43 AM
    Author     : justlex
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="com.tours.utils.text" />
<!DOCTYPE html>
<html language="${lang}">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message key="successful.title" /></title>
    </head>
    <c:import url="header.jsp"/>
    <body>
        <div class="container">
            <h1><fmt:message key="successful.h1" /></h1>
            <form name="backToMain" method="post" action="controller">
                <button name="command" value="mainPage" class="btn btn-primary"><fmt:message key="successful.mainpage" /></button>
            </form>
            <p>
            <p>
            <form name="backToVacations" method="post" action="controller">
                <button name="command" value="vacationPage" class="btn btn-primary"><fmt:message key="successful.vacationpage" /></button>
            </form>
            <p>
            <p>
             <form name="backToExcursions" method="post" action="controller">
                <button name="command" value="excursionPage" class="btn btn-primary"><fmt:message key="successful.excursionpage" /></button>
            </form>
            <p>
            <p>
             <form name="backToShoppingPages" method="post" action="controller">
                <button name="command" value="shoppingPage" class="btn btn-primary"><fmt:message key="successful.shoppingpage" /></button>
            </form>
        </div>
    </body>
    <c:import url="footer.jsp"/>
</html>
