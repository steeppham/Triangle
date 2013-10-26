package edu.unsw.triangle.util;

import javax.xml.bind.ValidationException;

import edu.unsw.triangle.model.Profile;

public class ProfileValidator implements Validator {

	@SuppressWarnings("rawtypes")
	@Override
	public boolean canHandle(Class objectClass) 
	{
		return Profile.class.isAssignableFrom(objectClass);
	}

	@Override
	public void validate(Object obj, Errors errors) throws ValidationException 
	{
		if (!canHandle(obj.getClass()))
		{
			throw new ValidationException("Cannot validate class type: " + obj.getClass().getName());
		}
		
		Profile profile = (Profile) obj;
		ValidationUtility.rejectNullOrEmpty(errors, "username", profile.getUsername(), "username cannot be empty");
		ValidationUtility.rejectNotInRange(errors, "username", 5, 20, profile.getUsername().length(), "username must contain 5 to 20 characters");
		ValidationUtility.rejectNullOrEmpty(errors, "password", profile.getPassword(), "password cannot be empty");
		ValidationUtility.rejectNotInRange(errors, "password", 5, 20, profile.getPassword().length(), "password must contain 5 to 20 characters");
		ValidationUtility.rejectInvalidEmail(errors, "email", profile.getEmail(), "email must contain valid address format");
		ValidationUtility.rejectNullOrEmpty(errors, "nickname", profile.getNickname(), "nickname cannot be empty");
		ValidationUtility.rejectNullOrEmpty(errors, "address", profile.getAddress(), "address cannot be empty");
		ValidationUtility.rejectInvalidCredit(errors, "credit", profile.getCredit(), "credit must be 8 digits");
	}
}
