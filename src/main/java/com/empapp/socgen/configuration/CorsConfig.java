package com.empapp.socgen.configuration;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;

/**
 * 
 * This CORS configuration class enables CORS requests from any origin to any
 * endpoint in the application.
 * 
 * @author sumedh
 *
 */
@Configuration
public class CorsConfig implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST,GET,OPTIONS,DELETE,PUT");
		response.setHeader("Access-Control-Max-Age", "60");
		response.setHeader("Access-Control-Allow-Headers", "*");
		response.setHeader("Access-Control-Expose-Headers", "*");
		System.out.println("request.getMethod() " + request.getMethod());
		/**
		 * Allowing request if first request is OPTIONS
		 */
		if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
			response.setStatus(HttpServletResponse.SC_OK);
		}
		chain.doFilter(req, res);

	}
}