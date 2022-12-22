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
    <br/>
    <a href="hello-servlet">Hello Servlet</a>
    <br/>
    <a href="page1_Servlet">page servlet num 1</a>
    <br><br>

    <!-- simula login -->
    <p>Log-in:</p>
    <form action="page2_Servlet" method="post">
        <labe>nome</labe>
        <input type="text" name="name_input">
        <labe>password</labe>
        <input type="password" name="pw_input">
        <input type="submit" value="invia">
    </form>
    ${logged}
    <jsp:include  page="footer.jsp"></jsp:include>

    <br/><br/>
    <form action="getStudente" method="get">
        <labe>nome studente da cercare</labe>
        <input type="text" name="name_input">
        <input type="submit" value="invia">
    </form>

</body>
</html>