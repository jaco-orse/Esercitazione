package it.course.servletexample;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "page1_Servlet", value = "/page1_Servlet")
public class page1_Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String newPag = "page1.jsp";
        String nome = "Jacopo";
        request.setAttribute("varNome", nome);

        RequestDispatcher view = request.getRequestDispatcher(newPag);
        view.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
