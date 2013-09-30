package edu.unsw.triangle.view;

import javax.servlet.http.HttpServletRequest;

import edu.unsw.triangle.model.Query;
import edu.unsw.triangle.util.Errors;

public class SearchBinder implements RequestBinder {

	@Override
	public Object bindAndValidate(HttpServletRequest request, Errors errors) 
	{
		String query = request.getParameter("query");
		Query search = new Query();
		search.setFindByTitle(query);
		return search;
	}
}
