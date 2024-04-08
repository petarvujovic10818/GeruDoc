package commands;

import java.awt.geom.Point2D;
import java.util.ArrayList;

import elements.PageElement;
import page.model.PageModel;
import page.model.PageSelectionModel;

public class DeleteElementCommand extends AbstractCommand{
	
	private PageModel model;
	private PageSelectionModel selectionModel;
	private ArrayList<PageElement>elements=new ArrayList<PageElement>();
	
	public DeleteElementCommand(PageModel model,PageSelectionModel selectionModel) {
		this.model=model;
		this.selectionModel=selectionModel;
	}
	
	@Override
	public void doCommand() {
		elements=selectionModel.getSelectionList();
		model.removePageElementsList(selectionModel.getSelectionList());
		selectionModel.removeAllFromSelectionList();
	}

	@Override
	public void undoCommand() {
		model.addPageElementsList(elements);
		selectionModel.addToSelectionList(elements);
	}
	
		
	}

