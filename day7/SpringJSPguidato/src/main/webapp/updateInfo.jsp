<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>SITES</title>
</head>
<body>
<p>Update site info</p>
<form method="POST" action="/updateInfo">
    <div>
        <input type="hidden" name="id" value="${currInfo.getId()}">
    </div>
    <div>
        <label for="name">Name</label>
        <input type="text" name="name" id="name" value="${currInfo.getName()}">
    </div>
    <div>
        <label for="description">Description</label>
        <input type="text" name="description" id="description" value="${currInfo.getDescription()}">
    </div>
    <div>
        <input type="submit" value="Send">
    </div>
</form>

</body>
</html>
