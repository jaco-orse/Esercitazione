<%--
  Created by IntelliJ IDEA.
  User: Jaco
  Date: 23/12/2022
  Time: 12:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <title>Update-Form</title>
  <jsp:include page="style.jsp"></jsp:include>
</head>
<body>

<jsp:include page="header.jsp">
  <jsp:param name="update" value="active"/>
</jsp:include>

<br>
<h1>Update User</h1>
<div>
  <form method="post" action="ServletUpdateUser">
    <div class="mb-3">
      <label  class="form-label">ID</label>
      <input type="text" class="form-control" name="id" required="required"  readonly value="${user.getId()}">
    </div>
    <div class="mb-3">
      <label  class="form-label">Nome</label>
      <input type="text" class="form-control" name="name" required="required" value="${user.getName()}">
    </div>
    <div class="mb-3">
      <label class="form-label">email</label>
      <input type="text" class="form-control" name="email" required="required" value="${user.getEmail()}">
    </div>
    <div class="mb-3">
      <label  class="form-label">Stato</label>
      <input type="text" class="form-control" name="country" required="required" value="${user.getCountry()}">
    </div>
    <div class="mb-3">
      <label  class="form-label">Età</label>
      <input type="number" class="form-control" name="eta" required="required" value="${user.getEta()}">
    </div>
    <button type="submit" class="btn btn-success">Salva modifiche</button>
  </form>

</div>
</body>
</html>

