<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>SITES</title>
</head>
<body>
<p> create your own site info</p>
<form method="POST" action="/createSite">
    <div>
        <labe for="name">Name</labe>
        <input type="text" name="name" id="name">
    </div>
    <div>
        <labe for="description">Description</labe>
        <input type="text" name="description" id="description">
    </div>
    <div>
        <input type="submit" value="Send">
    </div>
</form>

</body>
</html>
