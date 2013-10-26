package edu.unsw.triangle.service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class ServletContextService implements ServletContextListener 
{
	private final static Logger logger = Logger.getLogger(ServletContextService.class.getName());
	private ScheduledExecutorService scheduler;
	
	@Override
	public void contextInitialized(ServletContextEvent sce) 
	{
		logger.info("item scheduler initiated");
		scheduler = Executors.newSingleThreadScheduledExecutor();
		// Get schedule period from configuration
		ServletContext sc = sce.getServletContext();
		String value = sc.getInitParameter("itemSchedulerPeriod");
		// Default period 180 seconds
		int period = 0;
		try
		{
			period = Integer.parseInt(value);
		}
		catch (NumberFormatException e)
		{
			logger.warning("invalid itemSchedulerPeriod parameter " + value);
		}
		
		if (period > 0)
		{
			logger.info("item scheduler period=" + period);
			scheduler.scheduleAtFixedRate(new ItemBidTask(), 0, period, TimeUnit.SECONDS);
		}
		else
		{
			logger.info("item scheduler disabled");
		}
		
		// Context parameters defined in web.xml
		logger.info("loading web.xml context parameters");
		String emailEnabled = sc.getInitParameter("email.enabled");
		String emailAdmin = sc.getInitParameter("host.email");
		String emailPassword = sc.getInitParameter("host.password");
		String emailTimeout = sc.getInitParameter("email.timeout");
		
		// Default values
		boolean isNotificationEnabled = false;
		int timeout = 5;
		String admin = "triangle.junkhub@gmail.com";
		String password = "5andst0ne";
		
		if (emailAdmin != null && !emailAdmin.isEmpty())
			admin = emailAdmin;
		else
			logger.warning("servlet init param 'host.password' is empty");
		
		if (emailPassword != null && !emailPassword.isEmpty())
			password = emailPassword;
		else
			logger.warning("servlet init param 'host.password' is empty");
		
		if (emailTimeout != null && !emailTimeout.isEmpty()) 
		{
			try
			{
				timeout = Integer.parseInt(emailTimeout);
			}
			catch (NumberFormatException e) 
			{
				logger.warning("servlet init param 'email.timeout' not valid number: " + emailTimeout);
			}
		}
		else
			logger.warning("servlet init param 'email.timeout' is empty");
		
		if (emailEnabled != null && !emailEnabled.isEmpty())
			isNotificationEnabled = (emailEnabled.equals("true")) ? true : false;
		else
			logger.warning("servlet init param 'email.enabled' is empty");
		
		// Load configuration to static classes
		NotificationService.enabled(isNotificationEnabled);
		NotificationService.setTimeout(timeout);
		NotificationService.setAdminAddress(admin);
		NotificationService.setAdminPassword(password);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) 
	{
		 scheduler.shutdownNow();
	}
}
