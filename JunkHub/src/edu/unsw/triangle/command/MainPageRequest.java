package edu.unsw.triangle.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.unsw.triangle.control.Command;
import edu.unsw.triangle.control.Dispatcher;
import edu.unsw.triangle.view.ViewAction;

public class MainPageRequest implements Command {

	@Override
	public Dispatcher execute(HttpServletRequest request, HttpServletResponse response)throws Exception 
	{
		Dispatcher dispatcher = new Dispatcher.DispatcherBuilder("main.jsp").action(ViewAction.FORWARD).build();
		return dispatcher;
	}

}