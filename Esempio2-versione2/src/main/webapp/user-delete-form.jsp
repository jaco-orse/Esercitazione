<%--
  Created by IntelliJ IDEA.
  User: Jaco
  Date: 22/12/2022
  Time: 17:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<html>
<head>
    <title>Delete-Form</title>
    <jsp:include page="style.jsp"></jsp:include>
</head>
<body>

<jsp:include page="header.jsp">
    <jsp:param name="delete" value="active"/>
</jsp:include>

<br>

<div>
    <form method="post" action="ServletDeleteUser">
        <div class="mb-3">
            <label  class="form-label">ID</label>
            <input type="number" class="form-control" name="id" required="required">
        </div>
        <button type="submit" class="btn btn-success">Save</button>
    </form>

</div>
</body>
</html>