package edu.unsw.triangle.command;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.unsw.triangle.controller.Command;
import edu.unsw.triangle.controller.Dispatcher2;
import edu.unsw.triangle.controller.FrontController;
import edu.unsw.triangle.model.ItemCollection;
import edu.unsw.triangle.service.SearchService;
import edu.unsw.triangle.view.MainViewHelper;
import edu.unsw.triangle.view.ViewAction;

/**
 * Handles listing search requests.
 */
public class SearchAction implements Command 
{
	private final static Logger logger = Logger.getLogger(FrontController.class.getName());
	
	@Override
	public Dispatcher2 handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception 
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
		Dispatcher2 dispatcher = new Dispatcher2.DispatcherBuilder("main.jsp").action(ViewAction.FORWARD).resource(true).build();
		return dispatcher;
	}

}
