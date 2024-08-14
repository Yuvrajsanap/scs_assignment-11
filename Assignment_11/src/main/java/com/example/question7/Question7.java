package com.example.question7;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/upload")
@MultipartConfig
public class Question7 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Set content type
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		try (PrintWriter out = response.getWriter()) {
			// Get the file part from the request
			Part filePart = request.getPart("file");

			// Extract file name and size
			String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
			long fileSize = filePart.getSize();

			// Write output to response
			out.println("<html><body>");
			out.println("<h1>File Upload Details</h1>");
			out.println("<p>File Name: " + fileName + "</p>");
			out.println("<p>File Size: " + fileSize + " bytes</p>");
			out.println("</body></html>");
		}
	}
}
