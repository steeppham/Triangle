package edu.unsw.triangle.util;

import java.text.Normalizer;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.xml.bind.ValidationException;

/**
 * Http request wrapper class which performs simple validations on servlet
 * request object. Implements decorator pattern. Reference
 * https://www.owasp.org/
 * index.php/How_to_add_validation_logic_to_HttpServletRequest
 * TODO not implemented yet due to inability to pass out exceptions
 */
@Deprecated
public class RequestValidator extends HttpServletRequestWrapper {
	
	public RequestValidator(HttpServletRequest request) 
	{
		super(request);
	}

	// Regex pattern for only allowing
	private Pattern pattern = Pattern.compile("^[a-zA-Z0-9]{0,20}$");

	private String validate(String name, String input) throws ValidationException 
	{
		// Canonicalize before validating
		String canonical = canonicalize(input);

		// Check if input string does not pass regex pattern
		if (!pattern.matcher(canonical).matches()) 
		{
			throw new ValidationException("Improper format in " + name + " field");
		}
		
		// TODO deal with html encode?

		return canonical;
	}

	// Simplifies input to its simplest form to make encoding tricks more difficult
	private String canonicalize(String input) 
	{
		String canonical = Normalizer.normalize(input, Normalizer.Form.NFD);
		return canonical;
	}
	
	private HttpServletRequest getHttpServletRequest()
	{
		return (HttpServletRequest) super.getRequest();
	}

	@Override
	public Object getAttribute(String name) 
	{
		// TODO Auto-generated method stub
		return super.getAttribute(name);
	}

	@Override
	public String getParameter(String name)
	{
		String value = getHttpServletRequest().getParameter(name);
		return value;
	}

	@Override
	public Map<String, String[]> getParameterMap() 
	{
		// TODO Auto-generated method stub
		return super.getParameterMap();
	}

	@Override
	public String[] getParameterValues(String name) 
	{
		// TODO Auto-generated method stub
		return super.getParameterValues(name);
	}
}
