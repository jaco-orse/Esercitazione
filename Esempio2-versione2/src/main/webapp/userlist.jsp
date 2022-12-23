<%--
  Created by IntelliJ IDEA.
  User: Jaco
  Date: 23/12/2022
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Lista utenti</title>
    <jsp:include page="style.jsp"></jsp:include>
</head>
<body>

<jsp:include page="header.jsp">
    <jsp:param name="showAll" value="active"/>
</jsp:include>

<br>
<table>
    <thead>
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Email</th>
            <th>Country</th>
            <th>Eta</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="user" items="${listaUtenti}">
            <tr>
                <td><c:out value = "${user.getId()}" /></td>
                <td><c:out value = "${user.getName()}" /></td>
                <td><c:out value = "${user.getEmail()}" /></td>
                <td><c:out value = "${user.getCountry()}" /></td>
                <td><c:out value = "${user.getEta()}" /> </td>
                <td><a href="ServletDeleteUser?id=${user.getId()}">DEL</a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>

</body>
</html>
