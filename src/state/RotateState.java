package state;

import java.awt.Point;
import java.awt.event.MouseEvent;

import commands.RotateCommand;
import elements.PageElement;
import view.PageView;

public class RotateState extends State{
	
	private PageView med;
	
	public RotateState(PageView med) {
		this.med=med;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		Point position=e.getPoint();
		int index=med.getPage().getModel().getElementAtPosition(position);
		if(e.getButton()==MouseEvent.BUTTON1) {
			if(index!=-1) {
				/**
				PageElement ele=med.getPage().getModel().getElementAt(index);
				if(med.getPage().getSelectionModel().getSelectionList().contains(ele)) {
					for(PageElement element:med.getPage().getSelectionModel().getSelectionList()) {						
						element.setRotation(element.getRotation()+45);
						med.revalidate();
						med.repaint();
					}
				}
				**/
				
				PageElement element=med.getPage().getModel().getElementAt(index);
				med.getCommandManager().addCommand(new RotateCommand(med.getPage().getSelectionModel(),element));
				med.revalidate();
				med.repaint();
			}
		}
	}
	
}
