<%-- 
    Document   : alltours
    Created on : Dec 21, 2015, 7:23:36 AM
    Author     : justlex
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="com.tours.utils.text" />
<!DOCTYPE html>
<%--
  Created by IntelliJ IDEA.
  User: justlex
  Date: 12/15/15
  Time: 1:18 AM
  To change this template use File | Settings | File Templates.
--%>
<html language="lang">
    <head>
        <title><fmt:message key="alltours.title" /></title>
        <link href="css/table.css" rel="stylesheet">
    </head>
    <c:import url="header.jsp"/>
    <body>
        <div class="container">
            <hr>
            <h1><fmt:message key="alltours.h1" /></h1>
            <div class="datagrid"><table>
                    <thead>
                        <tr><th><fmt:message key="table.country" /></th><th><fmt:message key="table.price" /></th><th><fmt:message key="table.starts" /></th><th><fmt:message key="table.ends" /></th><th><fmt:message key="table.food" /></th><th><fmt:message key="table.hotel" /></th><th><fmt:message key="table.tourtype" /></th><th></th></tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${allTours}" var="tour">
                            <c:choose>
                                <c:when test="${tour.hot == true}">
                                    <tr bgcolor="#A9D0F5">
                                    </c:when>
                                    <c:otherwise>
                                    <tr>
                                    </c:otherwise>
                                </c:choose>
                                <td>${tour.destCountry}</td>
                                <td>${tour.price}$</td>
                                <td>${tour.startDay}</td>
                                <td>${tour.endDay}</td>
                                <td>${tour.food}</td>
                                <td>${tour.hotelClass}</td>
                                <td>
                                    <c:choose>
                                        <c:when test="${tour.tourType == 1}">
                                            <fmt:message key="table.vacation" />
                                        </c:when>
                                        <c:when test="${tour.tourType == 2}">
                                            <fmt:message key="table.excursion" />
                                        </c:when>
                                        <c:otherwise>
                                            <fmt:message key="table.shopping" />
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                                <td>
                                    <form name="order" method="post" action="controller">
                                        <input type="hidden" name="idTour" value="${tour.id}">
                                        <input type="hidden" name="idUser" value="${user.id}">
                                        <input type="hidden" name="tourPrice" value="${tour.price}">
                                        <button name="command" value="order" class="btn btn-primary"><fmt:message key="table.buy" /></button>
                                    </form> 
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table></div>
        </div>
        <c:import url="footer.jsp"/>
    </body>
</html>
