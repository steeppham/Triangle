package edu.unsw.triangle.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.unsw.triangle.util.MessageModel;
import edu.unsw.triangle.view.ValidatorResult;

public abstract class CommandAbstract implements Command {

	/**
	 * Common execution method which performs a servlet page request or action.
	 * Uses template method pattern.
	 */
	@Override
	public Dispatcher2 handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		// Perform simple validation on request parameter and attributes
		Dispatcher2 dispatcher = null;
		// TODO
		CommandState state = new CommandState(request);
		// Perform concrete implementation validation specific for command
		if (validate(state))
		{
			// Report feedback to view
			dispatcher = resolve(state);
		}
		
		// Perform processing of request
		process(state);
		
		// Report feedback to view
		dispatcher = resolve(state);
		
		return dispatcher;
	}
	
	abstract protected boolean validate(CommandState state);
	
	abstract protected Dispatcher2 resolve(CommandState state);
	
	abstract protected Dispatcher2 process(CommandState state);
		
	//abstract protected 

	protected class CommandState
	{
		HttpServletRequest request;
		
		public CommandState(HttpServletRequest request)
		{
			this.request = request;
		}
		
		public HttpServletRequest httpRequest()
		{
			return request;
		}
		
		public void addFeedback(String name, String value)
		{
			
		}
		
		
	}
}
