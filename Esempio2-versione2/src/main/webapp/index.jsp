<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
    <jsp:include page="style.jsp"></jsp:include>
</head>
<body>

<jsp:include page="header.jsp">
    <jsp:param name="home" value="active"/>
</jsp:include>


<h1><%= "Esempio 2 versione 2" %>
</h1>
<br/>


<c:forEach var = "i" begin = "1" end = "5">
    Item <c:out value = "${i}"/>
</c:forEach>

</body>
</html>