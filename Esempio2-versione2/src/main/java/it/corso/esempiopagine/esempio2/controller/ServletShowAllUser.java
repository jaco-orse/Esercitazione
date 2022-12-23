package it.corso.esempiopagine.esempio2.controller;

import it.corso.esempiopagine.esempio2.dao.UserDAO;
import it.corso.esempiopagine.esempio2.model.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletShowAllUser", value = "/ServletShowAllUser")
public class ServletShowAllUser extends HttpServlet {

    private UserDAO userDAO;
    public void init() {
        userDAO = new UserDAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<User> listaUtenti;
        try {
            listaUtenti = userDAO.selectAllUsers();
            request.setAttribute("listaUtenti",listaUtenti);
            //response.sendRedirect("userlist.jsp");
            RequestDispatcher dispatcher = request.getRequestDispatcher("userlist.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            response.sendRedirect("error.jsp");
            //throw new RuntimeException(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
