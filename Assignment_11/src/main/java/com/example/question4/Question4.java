package com.example.question4;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/visitCounter")
public class Question4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Get the session object, create one if it doesn't exist
		HttpSession session = request.getSession(true);

		// Retrieve the visit count from the session
		Integer visitCount = (Integer) session.getAttribute("visitCount");

		// If it's the first visit, initialize visitCount
		if (visitCount == null) {
			visitCount = 0;
		}

		// Increment the visit count
		visitCount++;

		// Store the new visit count in the session
		session.setAttribute("visitCount", visitCount);

		// Set the response content type
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		// Generate the response
		response.getWriter().write("<h1>Visit Counter</h1>");
		response.getWriter().write("<p>You have visited this page " + visitCount + " times during this session.</p>");
	}
}
