package it.course.servletexample;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "page2_Servlet", value = "/page2_Servlet")
public class page2_Servlet extends HttpServlet {


    public boolean checkLogin( String nome, String pw){
        if(nome.equals("jaco") && pw.equals("123")){
            return true;
        }
        else{
            return false;
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // prendere il parametro dalla request
        String name_in = request.getParameter("name_input");
        String pw_in = request.getParameter("pw_input");


        String newPag;
        if(checkLogin(name_in,pw_in)){
            newPag = "/page2.jsp";
            // set new var in request
            request.setAttribute("varNome", name_in);
        }
        else{
            newPag = "/index.jsp";
            // set new var in request
            request.setAttribute("logged", false);
        }

        // forward to jsp
        RequestDispatcher view = request.getServletContext().getRequestDispatcher(newPag);
        view.forward(request,response);

    }
}
