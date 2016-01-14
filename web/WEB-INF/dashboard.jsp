<%-- 
    Document   : dashboard
    Created on : Dec 15, 2015, 7:16:36 AM
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
        <title><fmt:message key="dashboard.title" /></title>
    </head>
    <body>
        <hr>
        <c:import url="header.jsp"/>
        <div class="container">
            <form name="add" method="post" action="controller" >
                <button name="command" value="addTourPage" class="btn btn-primary"><fmt:message key="dashboard.addtour" /></button>
            </form>
            <p>
            <p>
            <form name="orders" method="post" action="controller" >
                <button name="command" value="showOrders" class="btn btn-primary"><fmt:message key="dashboard.showorders" /></button>
            </form>
            <p>
            <p>
            <form name="exception" method="post" action="controller" >
                <button name="command" value="exception" class="btn btn-primary"><fmt:message key="dashboard.exception" /></button>
            </form>
        </div>
        <c:import url="footer.jsp" />
    </body>
</html>
