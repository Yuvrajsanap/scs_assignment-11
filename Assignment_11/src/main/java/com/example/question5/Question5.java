package com.example.question5;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/processRequest")
public class Question5 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Retrieve user input from the form
		String destination = request.getParameter("destination5");

		// Determine where to forward the request
		if ("servlet".equals(destination)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("destinationServlet");
			dispatcher.forward(request, response);
		} else if ("jsp".equals(destination)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("destination5.jsp");
			dispatcher.forward(request, response);
		} else {
			response.getWriter().write("Invalid destination selected.");
		}
	}
}
