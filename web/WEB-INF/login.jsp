<%-- 
    Document   : login.jsp
    Created on : Dec 16, 2015, 3:53:15 AM
    Author     : justlex
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="com.tours.utils.text" />
<!DOCTYPE html>
<html language="${lang}">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/register.css">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message key="login.title" /></title>
    </head>
    <body>
        <c:import url="header.jsp" />
        <hr>
        <hr>
        <section class="container">
            <div class="login"> 
                <form method="post" action="controller">
                    <input style="position: relative; left: -10px;" type="text" name="login" class="register-input" placeholder="<fmt:message key="login.email" />">
                    <input style="position: relative; left: -10px;" type="password" name="password" class="register-input" placeholder="<fmt:message key="login.password" />">
                    <button name="command" value="loginCheckCommand" class="register-button"><fmt:message key="login.button" /></button></p>
                </form>
            </div>
        </section>
        <c:import url="footer.jsp" />
    </body>
</html>
