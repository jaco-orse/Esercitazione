<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>SITES</title>
    <style>
        table{
            width: 100%;
            text-align: center;
            border: solid black 1px;
        }
        tr{
            border: solid black 1px;
        }
    </style>
</head>
<body>
    <jsp:include page="navbar.jsp" />
    <br>
    <table>
        <thead>
        <tr>
            <th>Name</th>
            <th>Description</th>
            <th colspan="2">Actions</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${sites}" var="site">
                <tr>
                    <td>${site.getName()}</td>
                    <td>${site.getDescription()}</td>
                    <td><a href="deleteInfo?id=${site.getId()}">elimina</a></td>
                    <td><a href="updateInfo?id=${site.getId()}">modifica</a></td>
                </tr>
            </c:forEach>
        </tbody>

    </table>
</body>
</html>
