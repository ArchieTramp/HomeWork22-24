<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="newGameConsole" class="com.pojo.NewGameConsole" />
    <c:set target="${newGameConsole}" property="name" value="FIRST" />
    <jsp:setProperty name="newGameConsole" property="price" value="0" />


<h1>Adding a new console</h1>
<form method="post" action="${pageContext.request.contextPath}/addconsole" autocomplete="off">
    <div class="form-group">
	<label for="name">Name</label>
	<input name="name" type="text" class="form-control" id="name" value="<jsp:getProperty name="newGameConsole" property="name" />">
   </div>
   <div class="form-group">
        <label for="model">Model</label>
        <input name="model" type="text" class="form-control" id="model" value="<jsp:getProperty name="mobile" property="model" />">
    </div>
    <div class="form-group">
        <label for="price">Price</label>
        <input name="price" type="text" class="form-control" id="price" value="<jsp:getProperty name="mobile" property="price" />">
    </div>
    <div class="form-group">
        <label for="includeGames">Include</label>
        <input name="includeGames" type="text" class="form-control" id="includeGames" value="<jsp:getProperty name="newGameConsole" property="includeGames" />">
    </div>
    <div class="form-group">
        <label for="company">Company</label>
        <input name="company" type="text" class="form-control" id="company" value="<jsp:getProperty name="newgameConsole" property="company" />">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
