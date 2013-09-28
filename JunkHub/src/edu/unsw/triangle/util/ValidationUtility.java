package edu.unsw.triangle.util;

public class ValidationUtility 
{
	public static void rejectIfNullOrEmpty(Errors errors, String field, String value, String message)
	{
		if (value == null || value.isEmpty())
		{
			errors.rejectValue(field, message);
		}
	}

}
