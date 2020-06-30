<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<ul class="list-group">
   <li class="list-group-item">${newGameConsole.id}</li>
   <li class="list-group-item">${newGameConsole.name}</li>
   <li class="list-group-item">${newGameConsole.model}</li>
   <li class="list-group-item">${newGameConsole.price}</li>
   <li class="list-group-item">${newGameConsole.includeGames}</li>
   <li class="list-group-item">${newGameConsole.company}</li>
</ul>

<br>
<a href="/Consoles/">Main page</a>