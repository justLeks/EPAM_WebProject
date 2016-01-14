<%-- 
    Document   : register
    Created on : Dec 16, 2015, 4:02:44 AM
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
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title><fmt:message key="register.title" /></title>
        <link rel="stylesheet" href="css/register.css">
    </head>
    <body>
        <c:import url="header.jsp" />
        <hr>
        <div class="container">
            <form name="register" method="post" action="controller" class="register">
                <input type="name" name="name" class="register-input" placeholder="<fmt:message key="register.name" />">
                <input type="email" name="email" class="register-input" placeholder="<fmt:message key="register.email" />">
                <input type="password" name="password" class="register-input" placeholder="<fmt:message key="register.password" />">
                <button name="command" value="register" class="register-button"><fmt:message key="register.button" /></button>
            </form>
        </div>
        <c:import url="footer.jsp" />
    </body>
</html>