package it.course.servletexample;

import it.course.model.Studente;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "getStudente", value = "/getStudente")
public class getStudente extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // prendere il parametro dalla request
        String nome_in = request.getParameter("name_input");

        Studente stud = new Studente();

        String newPag;
        if(stud.getNome().equals(nome_in)){
            request.setAttribute("studente", stud);
            newPag = "/studenteInfo.jsp";
        }
        else{
             newPag = "/index.jsp";
        }

        // forward to jsp
        RequestDispatcher view = request.getServletContext().getRequestDispatcher(newPag);
        view.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
