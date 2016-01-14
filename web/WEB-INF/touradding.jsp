<%-- 
    Document   : touradding
    Created on : Dec 20, 2015, 2:03:27 PM
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
        <title><fmt:message key="touradding.title" /></title>
        <link rel="stylesheet" href="css/register.css">
    </head>
    <body>
        <c:import url="header.jsp"/>
        <div class="container">
            <form name="add" method="post" action="controller" class="register">
                <input type="text" name="tourType" class="register-input" placeholder="<fmt:message key="touradding.tourtype" />">
                <input type="text" name="hotelClass" class="register-input" placeholder="<fmt:message key="touradding.hotel" />">
                <input type="text" name="price" class="register-input" placeholder="<fmt:message key="touradding.price" />">
                <input type="text" name="destCountry" class="register-input" placeholder="<fmt:message key="touradding.destination" />">
                <input type="text" name="startDay" class="register-input" placeholder="<fmt:message key="touradding.start" />">
                <input type="text" name="endDay" class="register-input" placeholder="<fmt:message key="touradding.end" />">
                <input type="text" name="food" class="register-input" placeholder="<fmt:message key="touradding.food" />">
                <input type="text" name="hot" class="register-input" placeholder="<fmt:message key="touradding.hot" />">
                <button name="command" value="addTour" class="register-button"><fmt:message key="touradding.button" /></button>
            </form>
        </div>
        <c:import url="footer.jsp" />
    </body>
</html>
