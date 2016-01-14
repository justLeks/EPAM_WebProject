<%--
  Created by IntelliJ IDEA.
  User: justlex
  Date: 12/15/15
  Time: 1:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="com.tours.utils.text" />
<html lang="${lang}">
    <head>
        <title><fmt:message key="vacations.title" /></title>
        <link href="css/table.css" rel="stylesheet">
    </head>
    <c:import url="header.jsp"/>
    <body>
        <div class="container">
            <hr>
            <h1><fmt:message key="vacations.h1" /></h1>
            <div class="datagrid"><table>
                    <thead>
                        <tr><th><fmt:message key="table.country" /></th><th><fmt:message key="table.price" /></th><th><fmt:message key="table.starts" /></th><th><fmt:message key="table.ends" /></th><th><fmt:message key="table.food" /></th><th><fmt:message key="table.hotel" /></th><th></th></tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${availableVacations}" var="vacation">
                            <c:choose>
                                <c:when test="${vacation.hot == true}">
                                    <tr bgcolor="#A9D0F5">
                                    </c:when>
                                    <c:otherwise>
                                    <tr>
                                    </c:otherwise>
                                </c:choose>
                                <td>${vacation.destCountry}</td>
                                <td>${vacation.price}$</td>
                                <td>${vacation.startDay}</td>
                                <td>${vacation.endDay}</td>
                                <td>${vacation.food}</td>
                                <td>${vacation.hotelClass}</td>
                                <td>
                                    <form name="order" method="post" action="controller">
                                        <input type="hidden" name="idTour" value="${vacation.id}">
                                        <input type="hidden" name="idUser" value="${user.id}">
                                        <input type="hidden" name="tourPrice" value="${vacation.price}">
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
