package edu.unsw.triangle.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Defines the implementation of delegated actions from a web request.
 */
public interface Command 
{
	public Dispatcher2 handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
