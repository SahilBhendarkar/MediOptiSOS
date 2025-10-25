package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import operateDao.crud;

@WebServlet("/ambbook")
public class ambulancebook extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name=request.getParameter("name");
        String ph_no=request.getParameter("ph_no");
        String destination=request.getParameter("destination");
        String pickup_location=request.getParameter("pickup_location");
        String date_time=request.getParameter("date_time");

        int amb=crud.ambulancebook(name, ph_no, destination, pickup_location, date_time);
        if(amb==1) {
            response.sendRedirect("index.html");
        }


    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
