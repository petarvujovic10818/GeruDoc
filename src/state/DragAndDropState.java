package state;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import elements.CircleElement;
import elements.PageDevice;
import elements.PageElement;
import elements.RectangleElement;
import elements.TriangleElement;
import painters.CirclePainter;
import painters.RectanglePainter;
import painters.TrianglePainter;
import view.PageView;

public class DragAndDropState extends State{
	
	private PageView med;
	private PageDevice device=null;
	private Point2D newLocation=null;
	
	public DragAndDropState(PageView med) {
		this.med=med;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		Point position = e.getPoint();
		int index=med.getPage().getModel().getElementAtPosition(position);
		if(e.getButton()==MouseEvent.BUTTON1) {
			if(index!=-1) {
				device=(PageDevice)med.getPage().getModel().getElementAt(index);
				if(med.getPage().getSelectionModel().getSelectionList().contains(device)) {
					newLocation=(Point2D) device.getPosition();
					med.getPage().getModel().removeElement(device);					
				}
			}
		}
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		//uzimamo x i y od selektovanog elementa
		//posle pustanja misa racunamo razliku izmedju x i y na pocetku i na kraju
		//tu razliku dodajemo ostalim elementima(tacnije oduzimamo)
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		double diffX=newLocation.getX()-e.getX(); //razlika izmedju stare i nove
		double diffY=newLocation.getY()-e.getY();//koordinate
		ArrayList<PageElement>lista=med.getPage().getSelectionModel().getSelectionList();
		
		for(PageElement element:lista) {
			PageDevice pd=(PageDevice)element;
			newLocation=pd.getPosition();
			newLocation.setLocation(newLocation.getX()-diffX-pd.getSize().getWidth()/2, newLocation.getY()-diffY-pd.getSize().getHeight()/2);
			pd.setPosition(newLocation);
			
			
			if (pd instanceof CircleElement){
				pd.setElementPainter(new CirclePainter(pd));
			}else if (pd instanceof RectangleElement){
				pd.setElementPainter(new RectanglePainter(pd));
			}else if(pd instanceof TriangleElement) {
				pd.setElementPainter(new TrianglePainter(pd));
			}
			
			med.getPage().getModel().addPageElements(pd);
		}
		device=null;
		newLocation=null;
		
	}
	
}
