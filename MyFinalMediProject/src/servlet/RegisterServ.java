package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import operateDao.crud;

@WebServlet("/UserRegServ")
public class RegisterServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterServ() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("\n========== REGISTRATION STARTED ==========");

		// Get form parameters
		String first = request.getParameter("fname");
		String last = request.getParameter("lname");
		String email = request.getParameter("email");
		String phone = request.getParameter("phno");
		String password = request.getParameter("pass1");
		String repassword = request.getParameter("pass2");

		// Debug: Print received data
		System.out.println("First Name: " + first);
		System.out.println("Last Name: " + last);
		System.out.println("Email: " + email);
		System.out.println("Phone: " + phone);

		// Validate passwords match
		if (!password.equals(repassword)) {
			System.out.println("❌ Passwords do not match!");
			request.setAttribute("errorMsg", "Passwords do not match!");
			request.getRequestDispatcher("UserReg.jsp").forward(request, response);
			return;
		}

		System.out.println("✓ Passwords match");
		System.out.println("Calling DAO...");

		// Call DAO method
		int status = crud.addUsrreg(first, last, email, phone, password, repassword);

		System.out.println("DAO returned status: " + status);

		if (status == 1) {
			System.out.println("✓ Registration successful!");
			System.out.println("Redirecting to login.jsp...");
			System.out.println("========== REGISTRATION COMPLETED ==========\n");
			response.sendRedirect("login.jsp");
		} else {
			System.out.println("❌ Registration failed!");
			System.out.println("========== REGISTRATION FAILED ==========\n");
			request.setAttribute("errorMsg", "Registration failed! Please try again.");
			request.getRequestDispatcher("UserReg.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
