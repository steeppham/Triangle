package edu.unsw.triangle.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import edu.unsw.triangle.model.Profile;
import edu.unsw.triangle.util.Errors;

public class ProfileBinder implements RequestBinder {

	@Override
	public Object bindAndValidate(HttpServletRequest request, Errors errors) 
	{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String nickname = request.getParameter("nickname");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String credit = request.getParameter("credit");
		String dob = request.getParameter("dob");
		
		Profile profile = new Profile();
		
		// Parse date
		try
		{
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			profile.setDob(dateFormat.parse(dob));
		}
		catch (ParseException e)
		{
			errors.rejectValue("dob", "date format must be of form dd/mm/yyyy");
		}
		
		// Parse number
		try
		{
			profile.setCredit(Integer.parseInt(credit));
		}
		catch (NumberFormatException e)
		{
			errors.rejectValue("credit", "credit must be a integer value");
		}
		
		profile.setUsername(username).setPassword(password).setFirstname(firstname).setLastname(lastname).
		setNickname(nickname).setEmail(email).setAddress(address);
		
		return profile;
	}

}
