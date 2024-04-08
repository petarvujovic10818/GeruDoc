package state;

import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import view.PageView;

public class LassoState extends State{
	
	Rectangle2D rect=new Rectangle2D.Double();
	
	private PageView med;
	
	public LassoState(PageView med) {
		this.med=med;
	}
	
	public void mouseDragged(MouseEvent e) {
		Point2D mousePos=e.getPoint();

		if(!e.isControlDown()){

			med.getPage().getSelectionModel().removeAllFromSelectionList();
		}
		
		double width=mousePos.getX()-med.getLastPosition().getX();
		double height=mousePos.getY()-med.getLastPosition().getY();
		if((width<0)&&(height<0)){
			rect.setRect(mousePos.getX(), mousePos.getY(),Math.abs(width),Math.abs(height));
		}
		else if((width<0)&&(height>=0)){
			rect.setRect(mousePos.getX(), med.getLastPosition().getY(),Math.abs(width),Math.abs(height));
		}
		else if((width>0)&&(height<0)){
			rect.setRect(med.getLastPosition().getX(), mousePos.getY(), Math.abs(width),Math.abs(height));
		}
		else{
			rect.setRect(med.getLastPosition().getX(), med.getLastPosition().getY(),Math.abs(width),Math.abs(height));
		}
		med.setSelectionRectangle(rect);
		
		
		med.getPage().getSelectionModel().selectElements(rect, med.getPage().getModel().getPageElements());
		 
		
		med.repaint();
	}
	
	public void mouseReleased(MouseEvent e) {		
		med.setSelectionRectangle(new Rectangle2D.Double(0,0,0,0));
		med.repaint();
		med.startSelectState();
	}
}
