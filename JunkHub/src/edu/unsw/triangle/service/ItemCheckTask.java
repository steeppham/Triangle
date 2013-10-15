package edu.unsw.triangle.service;

import java.util.logging.Logger;

public class ItemCheckTask  implements Runnable
{
	private final static Logger logger = Logger.getLogger(ItemCheckTask.class.getName());
    
	@Override
    public void run() {
        logger.info("Running item bid check...");
    }

}
