<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="/WEB-INF/date.tld" prefix="datetag" %>
<%@taglib prefix="myTags" tagdir="/WEB-INF/tags" %>

<myTags:template>
    <jsp:attribute name="header">
        <h1>Consoles</h1>
        (<datetag:DateTag plus="1"/>)
    </jsp:attribute>
    <jsp:body>
        <ul>
            <li><a href="${pageContext.request.contextPath}/allconsoles">List consoles</a></li>
            <li><a href="${pageContext.request.contextPath}/addconsole">Add console</a></li>
        </ul>
    </jsp:body>
</myTags:template>