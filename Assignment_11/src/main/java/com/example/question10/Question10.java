package com.example.question10;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/processForm")
public class Question10 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Get user input from the form
		String name = request.getParameter("name");
		String email = request.getParameter("email");

		// Create a User bean
		User user = new User(name, email);

		// Store the User bean in the session
		HttpSession session = request.getSession();
		session.setAttribute("user", user);

		// Forward to the JSP view
		request.getRequestDispatcher("/userView.jsp").forward(request, response);
	}
}
