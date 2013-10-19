package edu.unsw.triangle.view;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import edu.unsw.triangle.util.Errors;

public class AdminItemBinder implements RequestBinder {

	@Override
	public Object bindAndValidate(HttpServletRequest request, Errors errors) 
	{
		// Retrieve list of profiles selected on form
		String[] itemValues = request.getParameterValues("suspend.items");
		List<Integer> items = new ArrayList<Integer>();
		if (itemValues != null)
		{
			for (String id : itemValues)
			{
				items.add(Integer.parseInt(id));
			}
		}
		return items;
	}
}
