package edu.unsw.triangle.util;

import javax.xml.bind.ValidationException;

import edu.unsw.triangle.model.Login;

public class LoginValidator implements Validator 
{
	@SuppressWarnings("rawtypes")
	@Override
	public boolean canHandle(Class objectClass) 
	{
		return Login.class.isAssignableFrom(objectClass);
	}
	
	// TODO too much coupling here between request parameter and validation of backing object
	@Override
	public void validate(Object obj, Errors errors) throws ValidationException
	{
		if (!canHandle(obj.getClass()))
		{
			throw new ValidationException("Cannot validate class type: " + obj.getClass().getName());
		}
		
		Login login = (Login) obj;
		ValidationUtility.rejectIfNullOrEmpty(errors, "username", login.getUsername(), "username cannot be empty");
		ValidationUtility.rejectIfNullOrEmpty(errors, "password", login.getPassword(), "password cannot be empty");
	}


}
