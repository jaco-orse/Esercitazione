package it.corso.esempiopagine.esempio2.controller;

import it.corso.esempiopagine.esempio2.dao.UserDAO;
import it.corso.esempiopagine.esempio2.model.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletUpdateUser", value = "/ServletUpdateUser")
public class ServletUpdateUser extends HttpServlet {
    private UserDAO userDAO;
    public void init() {
        userDAO = new UserDAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id =Integer.parseInt(request.getParameter("id"));
        User currUser;
        try {
            currUser = userDAO.selectUser(id);
            //System.out.println("user: " + currUser.getId() + currUser.getName() + currUser.getCountry() + currUser.getEmail() + currUser.getEta());

            request.setAttribute("user", currUser);

        } catch (Exception e) {
            response.sendRedirect("error.jsp");
            //throw new RuntimeException(e);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("user-update-form.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        String eta =request.getParameter("eta");

        User currUser = new User(id,name,email,country,eta);
        try {
            userDAO.updateUser(currUser);
            response.sendRedirect("ServletShowAllUser");
        } catch (Exception e) {
            response.sendRedirect("error.jsp");
            //throw new RuntimeException(e);
        }
    }
}
