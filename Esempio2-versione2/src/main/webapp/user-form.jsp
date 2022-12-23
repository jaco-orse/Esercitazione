<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<html>
<head>
  <title>Insert-Form</title>
  <jsp:include page="style.jsp"></jsp:include>
</head>
<body>

<jsp:include page="header.jsp">
  <jsp:param name="insert" value="active"/>
</jsp:include>

<br>

<div>
  <form method="post" action="ServletInserUser">
    <div class="mb-3">
    <label  class="form-label">Nome</label>
    <input type="text" class="form-control" name="name" required="required">
    </div>
    <div class="mb-3">
    <label class="form-label">email</label>
    <input type="text" class="form-control" name="email" required="required">
    </div>
      <div class="mb-3">
    <label  class="form-label">Stato</label>
    <input type="text" class="form-control" name="country" required="required">
      </div>
      <div class="mb-3">
    <label  class="form-label">Età</label>
    <input type="number" class="form-control" name="eta" required="required">
      </div>
    <button type="submit" class="btn btn-success">Save</button>
  </form>

</div>
</body>
</html>
