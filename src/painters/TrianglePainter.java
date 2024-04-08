package painters;

import java.awt.geom.GeneralPath;

import elements.PageElement;
import elements.TriangleElement;

public class TrianglePainter extends DevicePainter{

	public TrianglePainter(PageElement element) {
		super(element);
		TriangleElement triangle=(TriangleElement)element;
		shape=new GeneralPath();
		double x=triangle.getPosition().getX()+triangle.getSize().width;
		double y=triangle.getPosition().getY()+triangle.getSize().height;
		((GeneralPath)shape).moveTo(x,y);
		
		((GeneralPath)shape).lineTo(triangle.getPosition().getX(),triangle.getPosition().getY()+triangle.getSize().height);		
				
		((GeneralPath)shape).lineTo(triangle.getPosition().getX()+(triangle.getSize().width/2),triangle.getPosition().getY());
		
		((GeneralPath)shape).closePath();
	}

}
