package edu.unsw.triangle.util;

import java.util.regex.Pattern;

public class ValidationUtility 
{
	public static void rejectNullOrEmpty(Errors errors, String field, String value, String message)
	{
		if (value == null || value.isEmpty())
		{
			errors.rejectValue(field, message);
		}
	}

	public static void rejectInvalidEmail(Errors errors, String field, String value, String message) 
	{
		Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+.[A-Z]{2,4}$");
		if (!pattern.matcher(value.toLowerCase()).matches())
		{
			errors.rejectValue(field, message);
		}
	}

	public static void rejectInvalidCredit(Errors errors, String field, int credit, String message) 
	{
		int digits = (int)(Math.log10(credit)+1);
		if (digits != 8)
		{
			errors.rejectValue(field, message);
		}
	}
	
	public static void rejectNotFloat(Errors errors, String field, String value, String message)
	{
		try
		{
			float reservePrice = Float.parseFloat(value);
		}
		catch (NumberFormatException e)
		{
			
		}
	}

	public static void rejectInvalidPrice(Errors errors, String field,
			float value, String message) 
	{
		if (value <= 0)
		{
			errors.rejectValue(field, message);
		}
	}

	public static void rejectNotGreaterThan(Errors errors, String field1,
			float value1, float value2, String message) {
		if (value1 < value2)
		{
			errors.rejectValue(field1, message);
		}
	}
}
