package edu.unsw.triangle.command;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.unsw.triangle.control.Command;
import edu.unsw.triangle.control.Control;
import edu.unsw.triangle.control.Dispatcher;
import edu.unsw.triangle.model.ItemCollection;
import edu.unsw.triangle.service.SearchService;
import edu.unsw.triangle.view.MainViewHelper;
import edu.unsw.triangle.view.ViewAction;

/**
 * Handles listing search requests.
 */
public class SearchAction implements Command 
{
	private final static Logger logger = Logger.getLogger(Control.class.getName());
	
	@Override
	public Dispatcher execute(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		MainViewHelper mainView = new MainViewHelper(request);
		// Validate search query
		String query = mainView.getQuery();
		// Search database for listing entry
		ItemCollection result = SearchService.search(query);
		logger.info(String.format("Search query \"%s\" returned %d results", query, result.size()));
		// Prepare view to display result
		mainView.setSearchResult(result);
		// Forward result to main page
		Dispatcher dispatcher = new Dispatcher.DispatcherBuilder("main.jsp").action(ViewAction.FORWARD).resource(true).build();
		return dispatcher;
	}

}
