package edu.unsw.triangle.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import edu.unsw.triangle.model.Keychain;
import edu.unsw.triangle.model.WebSession;

/**
 * Performs user authentication check for incoming requests.
 */
public class ControllerFilter implements Filter
{
	private FilterConfig filterConfig;
	final Logger logger = Logger.getLogger(this.getClass().getName());
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException 
	{
		this.filterConfig = filterConfig;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException 
	{
		logger.info("Invoking authentication filter");
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession httpSession = httpRequest.getSession();
		
		// Check if request is for register page
		if (httpRequest.getPathInfo().equals("/register"))
		{
			logger.info("Bypassing filter to register");
			chain.doFilter(request, response);
			return;
		}
		
		// Check if request if for confirm page
		if (httpRequest.getPathInfo().equals("/confirm"))
		{
			logger.info("Bypassing filter to confirm");
			chain.doFilter(request, response);
			return;
		}
		
		
		WebSession websession = (WebSession) httpSession.getAttribute("websession");
		if (websession == null)
		{
			logger.info("Authentication not found, forward to login");
			filterConfig.getServletContext().getRequestDispatcher("/control/login").forward(request, response);
		}
		else
		{
			logger.info("Authenticated for username '" + websession.getUsername() + "'");
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
