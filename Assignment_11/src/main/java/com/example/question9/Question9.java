package com.example.question9;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

@WebFilter("/*") // Apply this filter to all requests
public class Question9 implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// Initialization code, if needed
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;

		// Log IP address and request URL
		String ipAddress = httpRequest.getRemoteAddr();
		String requestUrl = httpRequest.getRequestURL().toString();

		System.out.println("Request IP Address: " + ipAddress);
		System.out.println("Request URL: " + requestUrl);

		// Continue with the request
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// Cleanup code, if needed
	}
}
