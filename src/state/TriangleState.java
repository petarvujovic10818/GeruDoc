package state;

import java.awt.Point;
import java.awt.event.MouseEvent;

import commands.AddElementCommand;
import view.PageView;

public class TriangleState extends State{
	
	private PageView med;
	
	public TriangleState(PageView med) {
	    this.med = med;
	}
	
	public void mousePressed(MouseEvent e) {
		Point position = e.getPoint();
		if (e.getButton()==MouseEvent.BUTTON1){
			 if (med.getPage().getModel().getElementAtPosition(position)==-1){
				 //PageDevice device = TriangleElement.createDefault(position,med.getPage().getModel().getElementCount());
				 //med.getPage().getModel().addPageElements(device);
				 med.getCommandManager().addCommand(new AddElementCommand(med.getPage().getModel(), position, med.getPage().getSelectionModel(), PageView.TRIANGLE));
			 }
		}
	}
	
}
