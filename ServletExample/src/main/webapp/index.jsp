<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - HOME</title>
    <!-- css -->
    <jsp:include  page="head.jsp"></jsp:include>
</head>
<body>

    <jsp:include  page="header.jsp"></jsp:include>
    <h1><%= "Jaco's Hello World!" %></h1>
    <br>
    <a href="hello-servlet">Hello Servlet</a>
    <br>
    <a href="page1_Servlet">page servlet num 1</a>
    <br>
    <jsp:include  page="footer.jsp"></jsp:include>

</body>
</html>