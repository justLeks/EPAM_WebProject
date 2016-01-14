<%-- 
    Document   : userorders
    Created on : Dec 21, 2015, 8:47:32 AM
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
        <title><fmt:message key="room.title" /></title>
        <link href="css/table.css" rel="stylesheet">
    </head>
    <c:import url="header.jsp"/>
    <body>
        <div class="container">
            <hr>
            <h1><fmt:message key="room.h1" /></h1>
            <div class="datagrid"><table>
                    <thead>
                        <tr><th><fmt:message key="table.name" /></th><th><fmt:message key="table.country" /></th><th><fmt:message key="table.price" /></th>
                            <th><fmt:message key="table.starts" /></th><th><fmt:message key="table.ends" /></th><th><fmt:message key="table.food" /></th>
                            <th><fmt:message key="table.hotel" /></th><th><fmt:message key="table.tourtype" /></th><th><fmt:message key="table.afterprice" /></th>
                            <th><fmt:message key="table.date" /></th><th><fmt:message key="table.approved" /></th><th><fmt:message key="table.paid" /></th></tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${userOrders}" var="order">
                            <tr>
                                <td>${order.name}</td>
                                <td>${order.destCountry}</td>
                                <td>${order.price}$</td>
                                <td>${order.startDay}</td>
                                <td>${order.endDay}</td>
                                <td>${order.food}</td>
                                <td>${order.hotelClass}</td>
                                <td>
                                    <c:choose>
                                        <c:when test="${order.tourType == 1}">
                                            <fmt:message key="table.vacation" />
                                        </c:when>
                                        <c:when test="${order.tourType == 2}">
                                            <fmt:message key="table.excursion" />
                                        </c:when>
                                        <c:otherwise>
                                            <fmt:message key="table.shopping" />
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                                <td>${order.afterPrice}$</td>                               
                                <td>${order.date}</td>
                                <td>
                                    <c:choose>
                                        <c:when test="${order.approved == true}">
                                            <fmt:message key="table.approved" />
                                        <td>
                                            <c:choose>
                                                <c:when test="${order.paid == true}">
                                                    <fmt:message key="table.paid" />
                                                </c:when>
                                                <c:when test="${order.paid == false}">
                                                    <form name="pay" method="post" action="controller">
                                                        <input type="hidden" name="idOrder" value="${order.idOrder  }">
                                                        <button name="command" value="pay" class="btn btn-primary"><fmt:message key="table.pay" /></button>
                                                    </form> 
                                                </c:when>
                                            </c:choose>
                                        </td>
                                    </c:when>
                                    <c:when test="${order.approved == false}">
                                            <fmt:message key="table.notapproved" />
                                        <td>
                                            <fmt:message key="table.approvewait" />
                                        </td>
                                    </c:when>
                                </c:choose>
                                </td>                 
                            </tr>
                        </c:forEach>
                    </tbody>
                </table></div>
        </div>
        <c:import url="footer.jsp"/>
    </body>
</html>
