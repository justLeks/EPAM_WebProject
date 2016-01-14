<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="com.tours.utils.text" />
<link rel="stylesheet" href="css/buttons.css">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/heroic-features.css" rel="stylesheet">

<html languange="${lang}"> 
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <form name="mainPage" method="post" action="controller" >
                    <button name="command" value="mainPage" class="button"><fmt:message key="header.mainpage" /></button>
                </form>
            </div>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <form name="ua" method="post" action="controller" >
                            <button name="command" value="ukrainian" class="button"><fmt:message key="header.ukrainian" /></button>
                        </form>
                    </li>
                    <li>
                        <form name="en" method="post" action="controller" >
                            <button name="command" value="english" class="button"><fmt:message key="header.english" /></button>
                        </form>
                    </li>   
                    <c:choose>
                        <c:when test="${user == null}">
                            <li>
                                <form name="register" method="post" action="controller" >
                                    <button name="command" value="registerPage" class="button"><fmt:message key="header.register" /></button>
                                </form>
                            </li>
                            <li>
                                <form name="login" method="post" action="controller" >
                                    <button name="command" value="loginPage" class="button"><fmt:message key="header.login" /></button>
                                </form>
                            </li>
                        </c:when>
                        <c:when test="${user.idUserType == 1}">
                            <li>
                                <form name="dashboard" method="post" action="controller" >
                                    <button name="command" value="dashboardPage" class="button"><fmt:message key="header.dashboard" /></button>
                                </form>
                            </li>
                            <li>
                                <form name="room" method="post" action="controller" >
                                    <button name="command" value="room" class="button"><fmt:message key="header.room" /></button>
                                </form>
                            </li>
                            <li>
                                <form name="logout" method="post" action="controller" >
                                    <button name="command" value="logout" class="button"><fmt:message key="header.logout" /></button>
                                </form>
                            </li>
                            <li>
                                <font style="line-height: 2.5em;" size="1.5" color="white"><b><fmt:message key="header.greetingsadmin" /> ${user.name}</b></font>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li>
                                <form name="room" method="post" action="controller" >
                                    <button name="command" value="room" class="button"><fmt:message key="header.room" /></button>
                                </form>
                            </li>
                            <li>
                                <form name="logout" method="post" action="controller" >
                                    <button name="command" value="logout" class="button"><fmt:message key="header.logout" /></button>
                                </form>
                            </li>
                            <li>
                                <font size="1.5" color="white">
                                <b style="line-height: 2.5em;"><fmt:message key="header.greetingsuser" /> ${user.name}</b>
                                </font>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </div>
        </div>
    </nav>
</html>