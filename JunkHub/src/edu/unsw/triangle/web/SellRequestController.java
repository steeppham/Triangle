package edu.unsw.triangle.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.unsw.triangle.controller.Controller;
import edu.unsw.triangle.controller.ModelView;

public class SellRequestController implements Controller {

	@Override
	public ModelView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		ModelView modelView = new ModelView(getFormView()).forward();
		return modelView;
	}

	@Override
	public String getFormView() 
	{
		return "sell.view";
	}

}
