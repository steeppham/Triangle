package edu.unsw.triangle.util;

import javax.xml.bind.ValidationException;

import edu.unsw.triangle.model.Query;

public class SearchValidator implements Validator {

	@SuppressWarnings("rawtypes")
	@Override
	public boolean canHandle(Class objectClass) 
	{
		return Query.class.isAssignableFrom(objectClass);
	}

	@Override
	public void validate(Object obj, Errors errors) throws ValidationException 
	{
		if (!canHandle(obj.getClass()))
		{
			throw new ValidationException("Cannot validate class type: " + obj.getClass().getName());
		}

		// TODO validate search query ?
		Query search = (Query) obj;
		ValidationUtility.rejectIfNullOrEmpty(errors, "query", search.getFindByTitle(), "No search results");
	}
}
