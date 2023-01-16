<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>SITES</title>
</head>
<body>
    <h1>INDEX Page</h1>
    <h1>INDEX Page</h1>
    <p>Last info name: ${info.getName()}</p>

    <p>choose an action</p>
    <dl>
        <dd><a href="/sites">see all sites</a></dd>
        <dd><a href="/createSite">create a site</a></dd>
    </dl>

</body>
</html>
