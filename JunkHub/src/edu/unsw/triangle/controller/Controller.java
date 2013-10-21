package edu.unsw.triangle.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller 
{
	public void handleSession(HttpServletRequest request);
	
	public ModelView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
	public String getFormView();
}
