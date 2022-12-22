<%--
  Created by IntelliJ IDEA.
  User: Jaco
  Date: 22/12/2022
  Time: 12:35
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>page 2</title>
  <%@ include file="head.jsp" %>
</head>
<body>
<%@ include file="header.jsp" %>
<p>Studente scelto :</p>
<p>nome :  ${studente.getNome()}</p>
<p>cognome :  ${studente.getCognome()}</p>
<p>email :  ${studente.getEmail()}</p>
<p>pw :  ${studente.getPassword()}</p>
<%@ include file="footer.jsp" %>
</body>
</html>