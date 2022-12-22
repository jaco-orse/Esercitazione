package it.course.servletexample;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "page2_Servlet", value = "/page2_Servlet")
public class page2_Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // prendere il parametro dalla request
        String name_in = request.getParameter("name_input");
        // set new var in request
        request.setAttribute("varNome", name_in);
        // forward to jsp
        String newPag = "/page2.jsp";
        RequestDispatcher view = request.getServletContext().getRequestDispatcher(newPag);
        view.forward(request,response);


    }
}
