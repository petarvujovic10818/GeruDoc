package commands;

import java.awt.geom.Point2D;

import elements.CircleElement;
import elements.PageDevice;
import elements.PageElement;
import elements.RectangleElement;
import elements.TriangleElement;
import page.model.PageModel;
import page.model.PageSelectionModel;
import view.PageView;

public class AddElementCommand extends AbstractCommand{
	
	private PageModel model;
	private Point2D lastPosition;
	private PageElement element=null;
	private PageSelectionModel selectionModel;
	private int elementType;
	
	public AddElementCommand(PageModel model,Point2D lastPosition,PageSelectionModel selectionModel,int elementType) {
		this.model=model;
		this.lastPosition=lastPosition;
		this.selectionModel=selectionModel;
		this.elementType=elementType;
	}
	
	@Override
	public void doCommand() {
		if(element==null) {
			if(elementType==PageView.CIRCLE) {
				element=CircleElement.createDefault(lastPosition, model.getElementCount());
			}else if(elementType==PageView.RECTANGLE) {
				element=RectangleElement.createDefault(lastPosition, model.getElementCount());
			}else if(elementType==PageView.TRIANGLE) {
				element=TriangleElement.createDefault(lastPosition, model.getElementCount());
			}
		}
		selectionModel.removeAllFromSelectionList();
		model.addPageElements(element);
		selectionModel.addToSelectionList(element);
		
	}

	@Override
	public void undoCommand() {
		selectionModel.removeAllFromSelectionList();
		model.removeElement(element);
	}

}
