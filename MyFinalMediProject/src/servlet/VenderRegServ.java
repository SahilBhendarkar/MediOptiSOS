package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import operateDao.crud;

@WebServlet("/VenderRegServ")
public class VenderRegServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("=== Vendor Registration Started ===");

		String first = request.getParameter("fname");
		String last = request.getParameter("lname");
		String email = request.getParameter("email");
		String phone = request.getParameter("phno");
		String venderName = request.getParameter("vender");
		String address = request.getParameter("address");
		String glink = request.getParameter("link");
		String pincode = request.getParameter("pin");
		String password = request.getParameter("pass1");

		// Input validation
		if (first == null || last == null || email == null || password == null) {
			System.out.println("❌ Missing required fields!");
			request.setAttribute("errorMsg", "Please fill in all required fields!");
			request.getRequestDispatcher("venderReg.jsp").forward(request, response);
			return;
		}

		try {
			int status = crud.addVenderreg(first, last, email, phone, venderName, address, pincode, password, glink);
			System.out.println("Database insert status: " + status);

			if (status == 1) {
				System.out.println("✅ Vendor registration successful!");
				response.sendRedirect("login.jsp");
			} else {
				System.out.println("❌ Vendor registration failed (status=0)!");
				request.setAttribute("errorMsg", "Registration failed! Please try again.");
				request.getRequestDispatcher("venderReg.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", "Server error: " + e.getMessage());
			request.getRequestDispatcher("venderReg.jsp").forward(request, response);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("venderReg.jsp").forward(request, response);
	}
}
