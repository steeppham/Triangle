package edu.unsw.triangle.util;

import java.text.Normalizer;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.ValidationException;

/**
 * Performs simple validation on request parameters and attributes checking for null, empty or invalid encoding.
 */
public class HttpRequestValidation 
{
	// Regex pattern for only allowing
	private Pattern pattern = Pattern.compile("^[a-zA-Z0-9]{0,20}$");
	
	
	public void validate(HttpServletRequest request) throws ValidationException 
	{
		// Check parameters by iterating through map
		Map<String, String[]> parameters = request.getParameterMap();
		for(String key: parameters.keySet())
		{
			String[] values = parameters.get(key);
			if (values == null)
			{
				throw new ValidationException("Parameter " + key + " is null");
			}
			for (String value : values)
			{
				
			}
		}
		
	}
	
	
	private String process(String name, String input) throws ValidationException 
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
	
	//--A.in.the.k 08:57, 19 March 2009 (UTC) for correct implementation 
    // see http://www.owasp.org/index.php/How_to_perform_HTML_entity_encoding_in_Java
    // Return HTML Entity code equivalents for any special characters
	public static String HTMLEntityEncode(String input) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < input.length(); ++i) {
			char ch = input.charAt(i);
			if (ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z' || ch >= '0'
					&& ch <= '9') {
				sb.append(ch);
			} else {
				sb.append("&#" + (int) ch + ";");
			}
		}
		return sb.toString();
	}

}
