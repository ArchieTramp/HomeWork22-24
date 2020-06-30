<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<table class="table">
   <thead>
   <tr>
      <th>ID</th>
      <th>name</th>
      <th>model</th>
      <th>price</th>
      <th>includeGames</th>
      <th>company</th>
   </tr>
   </thead>
   <tbody>
   <c:forEach var="newGameConsole" items="${Consoles}">
      <tr>
         <td scope="row">${newGameConsole.id}</td>
	 <td>${newGameConsole.name}</td>
         <td>${newGameConsole.model}</td>
         <td>${newGameConsole.price}</td>
         <td>${newGameConsole.manufacturer}</td>
         <td><a href="${pageContext.request.contextPath}/showconsole?id=${newGameConsole.id}">Link</a></td>
      </tr>
   </c:forEach>
   </tbody>
</table>

<br>
<a href="/Consoles/">Main page</a>