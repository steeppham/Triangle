package edu.unsw.triangle.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.unsw.triangle.controller.Command;
import edu.unsw.triangle.controller.Dispatcher2;
import edu.unsw.triangle.view.ViewAction;

public class MainPageRequest implements Command {

	@Override
	public Dispatcher2 handleRequest(HttpServletRequest request, HttpServletResponse response)throws Exception 
	{
		Dispatcher2 dispatcher = new Dispatcher2.DispatcherBuilder("main.jsp").action(ViewAction.FORWARD).build();
		return dispatcher;
	}

}
