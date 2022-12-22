<%--
  Created by IntelliJ IDEA.
  User: Jaco
  Date: 22/12/2022
  Time: 09:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Navbar</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                       LogIn exercise
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <p>LogIn</p>
                        <form action="page2_Servlet" method="post">
                            <labe>nome</labe>
                            <input type="text" name="name_input">
                            <labe>password</labe>
                            <input type="password" name="pw_input">
                            <input type="submit" value="invia">
                        </form>
                        ${logged}
                    </ul>
                </li>

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Cerca studente 1
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <p>form cerca studente</p>
                        <form action="getStudente" method="get">
                            <labe>nome studente da cercare</labe>
                            <input type="text" name="name_input">
                            <input type="submit" value="invia">
                        </form>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>
