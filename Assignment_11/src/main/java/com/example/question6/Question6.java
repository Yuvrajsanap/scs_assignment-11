package com.example.question6;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/listUsers")
public class Question6 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Database connection details
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/Assignment11_db";
	private static final String JDBC_USER = "root";
	private static final String JDBC_PASSWORD = "Yuvraj@12345"; // Update this with your MySQL password

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Set content type
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		try (PrintWriter out = response.getWriter()) {
			// Load the JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Establish a connection to the database
			try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
					Statement stmt = conn.createStatement()) {

				// Execute a query to retrieve users
				String sql = "SELECT * FROM users";
				ResultSet rs = stmt.executeQuery(sql);

				// Generate HTML response
				out.println("<html><body>");
				out.println("<h1>List of Users</h1>");
				out.println("<table border='1'>");
				out.println("<tr><th>ID</th><th>Name</th><th>Email</th></tr>");

				// Process the result set
				while (rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String email = rs.getString("email");
					out.println("<tr>");
					out.println("<td>" + id + "</td>");
					out.println("<td>" + name + "</td>");
					out.println("<td>" + email + "</td>");
					out.println("</tr>");
				}

				out.println("</table>");
				out.println("</body></html>");
			} catch (Exception e) {
				e.printStackTrace();
				out.println("<p>Error connecting to the database.</p>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
