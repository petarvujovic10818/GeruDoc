package state;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
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
import view.PageView.Handle;

public class ResizeState extends State{
	
	private PageView med;
	
	private Handle activeHandle;
	private PageDevice activeDevice;
	private Point position;
	
	public ResizeState(PageView med) {
		this.med=med;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		position=e.getPoint();
		activeHandle = med.getDeviceAndHandleForPoint(position);
		activeDevice = med.getDeviceForHandlePoint(position);
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		PageDevice device=this.activeDevice;
		double diffX=0;
		double diffY=0;
		double newWidth=0;
		double newHeight=0;
		double x=e.getPoint().getX()-device.getPosition().getX();
		double y=e.getPoint().getY()-device.getPosition().getY();
		
		if (activeHandle==Handle.NorthWest) {	
			diffX = device.getPosition().getX()-e.getPoint().getX();
			diffY = device.getPosition().getY()-e.getPoint().getY();
		}	
		else if(activeHandle==Handle.SouthEast) {
			diffX = e.getPoint().getX()-device.getPosition().getX();
			diffY = e.getPoint().getY()-device.getPosition().getY();
		}
		else if(activeHandle==Handle.NorthEast) {
			diffX = e.getPoint().getX()-device.getPosition().getX();
			diffY = device.getPosition().getY()-e.getPoint().getY();
		}
		else if(activeHandle==Handle.SouthWest) {
			diffX = device.getPosition().getX()-e.getPoint().getX();
			diffY = e.getPoint().getY()-device.getPosition().getY();
		}
		else if(activeHandle==Handle.North) {
			diffY = device.getPosition().getY()-e.getPoint().getY();
		}
		else if(activeHandle==Handle.South) {
			diffY = e.getPoint().getY()-device.getPosition().getY();
		}
		else if(activeHandle==Handle.East) {
			diffX = e.getPoint().getX()-device.getPosition().getX();
		}
		else if(activeHandle==Handle.West) {
			diffX = device.getPosition().getX()-e.getPoint().getX();
		}
		
		newWidth = device.getSize().getWidth() + diffX;
		newHeight = device.getSize().getHeight() + diffY;
		
		ArrayList<PageElement>elements=med.getPage().getSelectionModel().getSelectionList();
		
		for(PageElement elem : elements) {
			PageDevice shape2=(PageDevice)elem;
			if (activeHandle==Handle.NorthWest) {
				shape2.setPosition(new Point((int) ((int) shape2.getPosition().getX()+x), (int) ((int) shape2.getPosition().getY()+y)));
				shape2.setSize(new Dimension((int) newWidth, (int) newHeight));
			}	
			else if(activeHandle==Handle.SouthEast) {
				shape2.setSize(new Dimension((int) newWidth, (int) newHeight));
			}
			else if(activeHandle==Handle.NorthEast) {
				shape2.setPosition(new Point((int) shape2.getPosition().getX(), (int) ((int) shape2.getPosition().getY()+y)));
				shape2.setSize(new Dimension((int) newWidth, (int) newHeight));
			}
			else if(activeHandle==Handle.SouthWest) {
				shape2.setPosition(new Point((int) ((int) shape2.getPosition().getX()+x), (int) shape2.getPosition().getY()));
				shape2.setSize(new Dimension((int) newWidth, (int) newHeight));
			}
			else if(activeHandle==Handle.North) {
				shape2.setSize(new Dimension((int) shape2.getSize().getWidth(), (int) newHeight));
				shape2.setPosition(new Point((int) shape2.getPosition().getX(), (int) ((int) shape2.getPosition().getY()+y)));					
			}
			else if(activeHandle==Handle.South) {
				shape2.setSize(new Dimension((int) shape2.getSize().getWidth(), (int) newHeight));
			}
			else if(activeHandle==Handle.East) {
				shape2.setSize(new Dimension((int) newWidth, (int) shape2.getSize().getHeight()));

			}
			else if(activeHandle==Handle.West) {
				shape2.setSize(new Dimension((int) newWidth, (int) shape2.getSize().getHeight()));
				shape2.setPosition(new Point((int) ((int) shape2.getPosition().getX()+x), (int) shape2.getPosition().getY()));
			}
			
			if (shape2 instanceof CircleElement){
				shape2.setElementPainter(new CirclePainter(shape2));
			}else if (shape2 instanceof RectangleElement){
				shape2.setElementPainter(new RectanglePainter(shape2));
			}else if(shape2 instanceof TriangleElement) {
				shape2.setElementPainter(new TrianglePainter(shape2));
			}
			med.revalidate();
			med.repaint();
			}
	}
	
}
