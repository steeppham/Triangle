package edu.unsw.triangle.service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

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
		scheduler.scheduleAtFixedRate(new ItemCheckTask(), 0, 5, TimeUnit.SECONDS);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) 
	{
		 scheduler.shutdownNow();
	}
}
