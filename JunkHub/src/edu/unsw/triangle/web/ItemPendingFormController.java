package edu.unsw.triangle.web;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import edu.unsw.triangle.controller.AbstractFormController;
import edu.unsw.triangle.controller.ModelView;
import edu.unsw.triangle.model.Item.ItemStatus;
import edu.unsw.triangle.model.ItemPendingResult;
import edu.unsw.triangle.service.ItemService;
import edu.unsw.triangle.util.Errors;
import edu.unsw.triangle.util.Validator;
import edu.unsw.triangle.view.ItemPendingBinder;
import edu.unsw.triangle.view.RequestBinder;

public class ItemPendingFormController extends AbstractFormController {

	private final static Logger logger = Logger.getLogger(ItemPendingFormController.class.getName());
	
	@Override
	public void handleSession(HttpServletRequest request) 
	{
		//Not implemented
	}

	@Override
	public String getFormView() {
		return "item.view";
	}

	@Override
	protected Object createBackingObject(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected ModelView handleFormSubmit(Object command) 
	{
		ItemPendingResult itemPending = (ItemPendingResult) command;
		
		try
		{
			if (itemPending.isAccept())
			{
				// Owner of item has accepted pending bid
				// Update repository
				ItemService.updateItemStatus(itemPending.getItemId(), ItemStatus.PENDING_ACCEPT);
				logger.info("item id: " + itemPending.getItemId() + " has been accepted by owner: " + itemPending.getOwner());
			}
			else
			{
				// Owner of item has rejected pending bid
				// Update repository 
				ItemService.updateItemStatus(itemPending.getItemId(), ItemStatus.UNSOLD);
				logger.info("item id: " + itemPending.getItemId() + " has been rejected by owner: " + itemPending.getOwner());
			}
		}
		catch (Exception e)
		{
			logger.severe("item pending submit failed reason: " + e.getMessage());
			e.printStackTrace();
			Errors errors = new Errors().rejectValue("pending", "item pending submit failed reason: " + e.getMessage());
			return handleFormError(null, errors).addParameter("id", String.valueOf(itemPending.getItemId()));
		}
		
		return new ModelView(getSuccessView()).redirect().addParameter("id", String.valueOf(itemPending.getItemId())).
				addModel("pendingSuccess", "your action has been saved");
	}

	@Override
	protected Validator getValidator() {
		// Not implemented
		return null;
	}

	@Override
	protected RequestBinder getBinder() {
		return new ItemPendingBinder();
	}

	@Override
	protected String getSuccessView() {
		return "item";
	}

	@Override
	protected ModelView handleFormError(Object command, Errors errors) {
		return new ModelView(getFormView()).forward().addModel("errors", errors);
	}

}
