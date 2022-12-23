<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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

</body>
</html>