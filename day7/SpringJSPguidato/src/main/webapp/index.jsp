<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>SITES</title>
</head>
<body>
    <h1>SpringJSP esercizio guidato</h1>
    <jsp:include page="navbar.jsp" />
    <p>Last inserted info name: ${info.getName()}</p>
</body>
</html>
