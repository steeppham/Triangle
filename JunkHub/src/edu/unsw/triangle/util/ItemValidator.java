package edu.unsw.triangle.util;

import javax.xml.bind.ValidationException;

import edu.unsw.triangle.model.Item;

public class ItemValidator implements Validator {

	@SuppressWarnings("rawtypes")
	@Override
	public boolean canHandle(Class objectClass) 
	{
		return Item.class.isAssignableFrom(objectClass);
	}
	
	@Override
	public void validate(Object obj, Errors errors) throws ValidationException
	{
		if (!canHandle(obj.getClass()))
		{
			throw new ValidationException("Cannot validate class type: " + obj.getClass().getName());
		}
		
		Item item = (Item) obj;
		
		ValidationUtility.rejectNullOrEmpty(errors, "title", item.getTitle(), "title cannot be empty");
		ValidationUtility.rejectNullOrEmpty(errors, "category", item.getCategory(), "category cannot be empty");
		ValidationUtility.rejectNullOrEmpty(errors, "description", item.getDescription(), "description cannot be empty");
		ValidationUtility.rejectNullOrEmpty(errors, "postage", item.getTitle(), "postage details cannot be empty");
		
		
		ValidationUtility.rejectInvalidMonetary(errors, "reserve", item.getReserve(), "reserve price must be greater than 0.00");
		ValidationUtility.rejectInvalidMonetary(errors, "start", item.getStart(), "starting price must be greater than 0.00");
		ValidationUtility.rejectInvalidMonetary(errors, "increment", item.getIncrement(), "bid increment must be greater than 0.00");

		// Reserve price must be greater or equal to start price
		ValidationUtility.rejectNotGreaterThan(errors, "reserve", item.getReserve(), item.getStart(), "reserve price must be greater than starting price");
	}

}
