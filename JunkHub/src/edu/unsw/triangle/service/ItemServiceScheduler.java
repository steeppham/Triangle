package edu.unsw.triangle.service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class ItemServiceScheduler implements ServletContextListener 
{
	private final static Logger logger = Logger.getLogger(ItemServiceScheduler.class.getName());
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
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) 
	{
		 scheduler.shutdownNow();
	}
}
