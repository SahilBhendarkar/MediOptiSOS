package servlet;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import operateDao.crud;


@WebServlet("/bloodBank")
public class bloodBank extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");
        String address=request.getParameter("address");
        int age=Integer.parseInt(request.getParameter("age"));
        String gender=request.getParameter("gender");
        String bloodType=request.getParameter("bloodType");

        int status=crud.addblood(name, address, age, gender, bloodType);
        if(status==1) {
            response.sendRedirect("index.html");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
