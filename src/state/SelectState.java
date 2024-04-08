package state;


import java.awt.Point;
import java.awt.event.MouseEvent;

import elements.PageElement;
import view.PageView;
import view.PageView.Handle;

public class SelectState extends State{
	
	private PageView med;
	
	private int elementInMotion = -1;
	private Handle handleInMotion = null;
	
	public SelectState(PageView med) {
		this.med=med;
	}
	
	public void mousePressed(MouseEvent e) {
		if(!e.isControlDown()){
		med.getPage().getSelectionModel().removeAllFromSelectionList();
		}
		
		Point position = e.getPoint();
		if (e.getButton()==MouseEvent.BUTTON1){
			handleInMotion = med.getDeviceAndHandleForPoint(position);
			if(handleInMotion == null){
				elementInMotion = med.getPage().getModel().getElementAtPosition(position);
				if(elementInMotion != -1){
					PageElement element=med.getPage().getModel().getElementAt(elementInMotion);
					
					if (med.getPage().getSelectionModel().isElementSelected(element)){
						med.getPage().getSelectionModel().removeFromSelectionList(element);
					}else{
						med.getPage().getSelectionModel().addToSelectionList(element);
					}	
					
				}
			}	
		}
	}	
	
	public void mouseDragged(MouseEvent e) {
		med.startLassoState();
	}
}
