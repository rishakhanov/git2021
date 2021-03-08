<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page pageEncoding="UTF-8"%>



<c:set var="current" value="${param.ddlLanguage}" scope="session"/>
<c:if test="${not empty current}">
    <fmt:setLocale value="${current}" scope="session"/>
</c:if>

<fmt:setBundle basename="myResource" scope="session"/>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message key="title"/></title>
    </head>
    <body>
        <h1><fmt:message key="message"/></h1>
        <fmt:message key="language"/>
        <form action="#" method="POST">
            <select name="ddlLanguage">
                <option value="en_US">English</option>
                <option value="es_ES">Spanish</option>
                <option value="fr_FR">French</option>
                <option value="ru_RU">Russian</option>
            </select>
            <input type="submit" value="<fmt:message key="button"/>"/>
        </form>
    </body>
</html>
