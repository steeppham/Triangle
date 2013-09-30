package edu.unsw.triangle.util;

import javax.xml.bind.ValidationException;

import edu.unsw.triangle.model.Bid;

public class BidValidator implements Validator {

	@SuppressWarnings("rawtypes")
	public boolean canHandle(Class objectClass) 
	{
		return Bid.class.isAssignableFrom(objectClass);
	}
	
	@Override
	public void validate(Object obj, Errors errors) throws ValidationException
	{
		if (!canHandle(obj.getClass()))
		{
			throw new ValidationException("Cannot validate class type: " + obj.getClass().getName());
		}
		
		Bid bid = (Bid) obj;
		
		ValidationUtility.rejectInvalidMonetary(errors, "bid", bid.getBidFloat(), "bid must be greater than 0");
	}

}
