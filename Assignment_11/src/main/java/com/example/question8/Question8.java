package com.example.question8;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/errorDemo")
public class Question8 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Simulate an error
		try {
			// Intentionally throw an exception
			throw new RuntimeException("Simulated error for demonstration purposes");
		} catch (Exception e) {
			// Log the error (could be logged to a file or monitoring system)
			e.printStackTrace();
			// Forward to an error page
			request.setAttribute("errorMessage", e.getMessage());
			request.getRequestDispatcher("/errorPage8.jsp").forward(request, response);
		}
	}
}
