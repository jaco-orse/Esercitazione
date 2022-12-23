<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>
<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: #50788b">
        <div>
            <a href="https://www.javaguides.net" class="navbar-brand">java guide</a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/" class="nav-link">home</a></li>
            <li><a href="ServletInserUser" class="nav-link">ServletInserUser</a></li>
            <li><a href="ServletDeleteUser" class="nav-link">ServletDeleteUser</a></li>
        </ul>
    </nav>
</header>
<h1><%= "Esempio 2 versione 2" %>
</h1>
<br/>

</body>
</html>