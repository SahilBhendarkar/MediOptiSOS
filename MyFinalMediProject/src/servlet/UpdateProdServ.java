package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import operateDao.crud;

@WebServlet("/UpdateProdServ")
public class UpdateProdServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateProdServ() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Get parameters from the request
		String pid = request.getParameter("pid");
		String pname = request.getParameter("pname");
		String mfname = request.getParameter("mfname");
		String mgfdate = request.getParameter("mgfdate");
		String exp = request.getParameter("expdate");
		String mg = request.getParameter("power");
		String qty = request.getParameter("quantity");
		String price = request.getParameter("price");

		// Debugging logs to verify parameters received
		System.out.println("Update request received with:");
		System.out.println("pid = " + pid);
		System.out.println("pname = " + pname);
		System.out.println("mfname = " + mfname);
		System.out.println("mgfdate = " + mgfdate);
		System.out.println("expdate = " + exp);
		System.out.println("power = " + mg);
		System.out.println("quantity = " + qty);
		System.out.println("price = " + price);

		int status = crud.updateProd(pid, pname, mfname, mgfdate, exp, mg, qty, price);

		if (status > 0) {
			System.out.println("Data updated successfully.");
			response.sendRedirect("viewProduct.jsp");

			} else {
				request.setAttribute("errorMsg", "Update failed! Please try again.");
				// You may also send back the pid to re-display edit form in JSP
				request.setAttribute("editPid", pid);
				request.getRequestDispatcher("viewProduct.jsp").forward(request, response);
			}

		}

	// Redirect GET requests to POST handler
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}
