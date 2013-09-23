package edu.unsw.triangle.ui;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import edu.unsw.triangle.model.Profile;

public class RegisterViewHelper extends ViewHelper
{
	public final static String REGISTER_VIEW = "register.jsp";
	public final static String ATTRIBUTE_MESSAGE = "message";
	public final static String PARAMETER_USERNAME = "username";
	public final static String PARAMETER_PASSWORD = "password";
	public final static String PARAMETER_EMAIL = "email";
	public final static String PARAMETER_FIRSTNAME = "firstname";
	public final static String PARAMETER_LASTNAME = "lastname";
	public final static String PARAMETER_DOB = "dob";
	public final static String PARAMETER_ADDRESS= "address";
	public final static String PARAMETER_CREDIT= "credit";
	public final static String BEAN_PROFILE = "profile";
	
	private Profile profile = null;

	public RegisterViewHelper(HttpServletRequest request) 
	{
		super(request);
	}
	
	/**
	 * Validate the register view form and return a result object.
	 * @return result
	 */
	public ValidatorResult validate()
	{
		profile = new Profile();
		ValidatorResult result = new ValidatorResult();
		
		String username = request.getParameter(PARAMETER_USERNAME);
		if (username == null || username.isEmpty())
			result.rejectNullOrEmpty(PARAMETER_USERNAME);
		else
			profile.setUsername(username);
		
		String password = request.getParameter(PARAMETER_PASSWORD);
		if (password == null || password.isEmpty())
			result.rejectNullOrEmpty(PARAMETER_PASSWORD);
		else
			profile.setPassword(password);
		
		String email = request.getParameter(PARAMETER_EMAIL);
		if (email == null || email.isEmpty())
			result.rejectNullOrEmpty(PARAMETER_EMAIL);
		else
			profile.setEmail(email);
		
		String firstname = request.getParameter(PARAMETER_FIRSTNAME);
		if (firstname == null || firstname.isEmpty())
			result.rejectNullOrEmpty(PARAMETER_FIRSTNAME);
		else
			profile.setFirstname(firstname);
		
		String lastname = request.getParameter(PARAMETER_LASTNAME);
		if (lastname == null || lastname.isEmpty())
			result.rejectNullOrEmpty(PARAMETER_LASTNAME);
		else
			profile.setLastname(lastname);
		
		String dob = request.getParameter(PARAMETER_DOB);
		if (dob == null || dob.isEmpty())
			result.rejectNullOrEmpty(PARAMETER_DOB);
		else
		{
			// TODO Parse as a date object
			profile.setDob(new Date());
		}
		
		String address = request.getParameter(PARAMETER_ADDRESS);
		if (address == null || address.isEmpty())
			result.rejectNullOrEmpty(PARAMETER_ADDRESS);
		else
			profile.setAddress(address);
		
		String credit = request.getParameter(PARAMETER_CREDIT);
		if (credit == null || credit.isEmpty())
			result.rejectNullOrEmpty(PARAMETER_CREDIT);
		else
		{
		// Parse as number
			try 
			{
				profile.setCredit(Integer.parseInt(credit));
			}
			catch (NumberFormatException e)
			{
				result.rejectInvalidFormat(PARAMETER_CREDIT);
			}
		}
		
		return result;
	}

	public Profile getProfile() 
	{
		if (profile == null)
		{
			validate();
		}
		
		return profile;
	}
	
	public void setMessage(String message)
	{
		request.setAttribute("message", message);
	}
}
