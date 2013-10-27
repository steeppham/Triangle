package edu.unsw.triangle.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

public abstract class AbstractRequestController implements Controller {

	private final static Logger logger = Logger.getLogger(AbstractRequestController.class.getName());
	
	abstract public String[] getRedirectObjects();
	
	protected void handleSessionObjects(HttpServletRequest request)
	{
		String[] sessionObjects = getRedirectObjects();
		if (sessionObjects == null || sessionObjects.length == 0)
			return;
		for (String attributeName : sessionObjects)
		{
			if (request.getSession().getAttribute(attributeName) != null)
			{
				logger.info("handling redirect object: " + attributeName);
				// Add redirect model to request attribute
				request.setAttribute(attributeName, request.getSession().getAttribute(attributeName));
				// Remove from websession
				request.getSession().removeAttribute(attributeName);
			}
		}
	}
}
