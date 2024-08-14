package com.example.question3;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/submitData")
public class Question3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Retrieve form data
		String name = request.getParameter("name");
		String email = request.getParameter("email");

		// Set content type
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		// Generate response
		response.getWriter().write("<h1>Welcome, " + name + "!</h1>");
		response.getWriter().write("<p>Your email is: " + email + "</p>");
	}
}
