<%--
  Created by IntelliJ IDEA.
  User: justlex
  Date: 12/15/15
  Time: 1:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="com.tours.utils.text" />
<html lang="${lang}">
    <head>
        <title><fmt:message key="shopping.title" /></title>
        <link href="css/table.css" rel="stylesheet">
    </head>
    <c:import url="header.jsp"/>
    <body>
        <div class="container">
            <hr>
            <h1><fmt:message key="shopping.h1" /></h1>
            <div class="datagrid"><table>
                    <thead>
                        <tr><th><fmt:message key="table.country" /></th><th><fmt:message key="table.price" /></th><th><fmt:message key="table.starts" /></th><th><fmt:message key="table.ends" /></th><th><fmt:message key="table.food" /></th><th><fmt:message key="table.hotel" /></th><th></th></tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${availableShoppings}" var="shopping">
                            <c:choose>
                                <c:when test="${shopping.hot == true}">
                                    <tr bgcolor="#A9D0F5">
                                    </c:when>
                                    <c:otherwise>
                                    <tr>
                                    </c:otherwise>
                                </c:choose>
                                <td>${shopping.destCountry}</td>
                                <td>${shopping.price}$</td>
                                <td>${shopping.startDay}</td>
                                <td>${shopping.endDay}</td>
                                <td>${shopping.food}</td>
                                <td>${shopping.hotelClass}</td>
                                <td>
                                    <form name="order" method="post" action="controller">
                                        <input type="hidden" name="idTour" value="${shopping.id}">
                                        <input type="hidden" name="idUser" value="${user.id}">
                                        <input type="hidden" name="tourPrice" value="${shopping.price}">
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

