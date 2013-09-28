package edu.unsw.triangle.util;

import javax.xml.bind.ValidationException;

public interface Validator
{
	@SuppressWarnings("rawtypes")
	public boolean canHandle(Class objectClass);
	
	public void validate(Object obj, Errors errors) throws ValidationException;

}
