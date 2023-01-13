<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>SITES</title>
</head>
<body>

    <c:forEach items="${sites}" var="site">
        <p>sito: ${site.getName()} , ${site.getDescription()}</p>
    </c:forEach>



</body>
</html>
