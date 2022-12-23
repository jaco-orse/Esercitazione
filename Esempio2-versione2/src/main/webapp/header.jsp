<%--
  Created by IntelliJ IDEA.
  User: Jaco
  Date: 23/12/2022
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header>
  <nav class="navbar navbar-expand-md navbar-dark"
       style="background-color: #50788b">
    <div>
      <a href="https://www.javaguides.net" class="navbar-brand">java guide</a>
    </div>

    <ul class="navbar-nav">
      <li><a href="<%=request.getContextPath()%>/" class="nav-link ${param.home}">home</a></li>
      <li><a href="ServletInserUser" class="nav-link ${param.insert}">ServletInserUser</a></li>
      <li><a href="ServletDeleteUser" class="nav-link ${param.delete}">ServletDeleteUser</a></li>
      <li><a href="ServletShowAllUser" class="nav-link ${param.showAll}">ServletShowAllUser</a></li>
    </ul>
  </nav>
</header>
