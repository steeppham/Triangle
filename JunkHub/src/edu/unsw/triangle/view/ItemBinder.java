package edu.unsw.triangle.view;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import edu.unsw.triangle.model.Item;
import edu.unsw.triangle.model.Item.ItemStatus;
import edu.unsw.triangle.model.WebSession;
import edu.unsw.triangle.util.Errors;
import edu.unsw.triangle.util.ValidationUtility;

public class ItemBinder implements RequestBinder {

	@Override
	public Object bindAndValidate(HttpServletRequest request, Errors errors)
	{
		Map<String, String> parameters = new HashMap<String, String>();
		
		// Retrieve multi-part request
		try 
		{
			List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
			for (FileItem item : items) 
			{
				if (item.isFormField()) 
				{
					// Process regular form field (input
					String fieldname = item.getFieldName();
					String fieldvalue = item.getString();
					parameters.put(fieldname, fieldvalue);
				} 
				else 
				{
					// Process form file field (input type="file").
					String fieldname = item.getFieldName();
					String filename = FilenameUtils.getName(item.getName());
					InputStream filecontent = item.getInputStream();
					parameters.put(fieldname, filename);
					
					// Save file to directory if there is a file to upload
					if (!filename.isEmpty()) 
					{
						String pictureDirectory = request.getServletContext().getRealPath("/images");
						OutputStream outputStream = new FileOutputStream(new File(pictureDirectory + "/" + filename));
				 
						int read = 0;
						byte[] bytes = new byte[1024];
				 
						while ((read = filecontent.read(bytes)) != -1)
						{
							outputStream.write(bytes, 0, read);
						}
						
						outputStream.close();
					}
				}
			}
		} 
		catch (FileUploadException e) 
		{
			//throw new ServletException("Cannot parse multipart request.", e);
		}
		catch (IOException e)
		{
			
		}
		
		String title = parameters.get("title");
		String category = parameters.get("category");
		String description = parameters.get("description");
		String postage = parameters.get("postage");
		String reserve = parameters.get("reserve");
		String start = parameters.get("start");
		String increment = parameters.get("increment");
		String period = parameters.get("period");
		String picture = parameters.get("picture");
		
		Item item = new Item();
		item.setTitle(title).setCategory(category).setDescription(description).setPostage(postage).setPicture(picture);
		
		// Current time of server as start bid time
		item.setStartTime(new Date());
		
		
		// Parse bidding period
		if (period != null)
		{
			// Must be value between 3 to 60
			item.setPeriod(ValidationUtility.tryRejectNotInteger(errors, "period", period, "period must be a valid integer"));
		}
		else
		{
			// Default period value 10 min
			item.setPeriod(10);
		}
		
		// Parse reserve price
		item.setReserve(ValidationUtility.tryRejectNotFloat(errors, "reserve", reserve, "reserve price must be a valid number"));
		// Parse starting price
		item.setStart(ValidationUtility.tryRejectNotFloat(errors, "start", start, "starting price must be a valid number"));
		// Parse bid increment
		item.setIncrement(ValidationUtility.tryRejectNotFloat(errors, "increment", increment, "increment price must be a valid number"));
		
		// Add meta data
		WebSession websession = (WebSession) request.getSession().getAttribute("websession");
		item.setOwner(websession.getUsername());
		item.setStatus(ItemStatus.ACTIVE);
		
		return item;
	}
}
