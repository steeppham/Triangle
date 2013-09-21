package edu.unsw.triangle.core;

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

import edu.unsw.trianlge.model.Keychain;

/**
 * Performs user authentication check for incoming requests.
 */
public class AuthenticationFilter implements Filter
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
		HttpSession httpSession = httpRequest.getSession(false);

		Keychain keychain = (Keychain) httpSession.getAttribute("keychain");
		if (keychain == null)
		{
			// Session has not been initialised
			// Create session and login
			logger.info("Authentication not found, initialising session");
			//TODO initialise session
			filterConfig.getServletContext().getRequestDispatcher("/controller/login").forward(request, response);
		}
		else if (keychain.isValid())
		{
			// Credentials are valid
			// Proceed with request
			chain.doFilter(request, response);
		}
		else
		{
			// Session is logged out or invalid
			// forward to login page
			logger.info("Authentication failed, forward to login");
			filterConfig.getServletContext().getRequestDispatcher("/controller/login").forward(request, response);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
