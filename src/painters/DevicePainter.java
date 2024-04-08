package painters;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.font.TextAttribute;
import java.awt.geom.AffineTransform;
import java.text.AttributedString;

import elements.PageDevice;
import elements.PageElement;

public class DevicePainter extends ElementPainter{
	
	protected Shape shape;
	
	public DevicePainter(PageElement element) {
		super(element);
	}
	
	@Override
	public void paint(Graphics2D g, PageElement element) {
		AffineTransform at=new AffineTransform();
		at.rotate(Math.toRadians(element.getRotation()), ((PageDevice)element).getPosition().getX()+((PageDevice)element).getSize().getWidth()/2,((PageDevice)element).getPosition().getY()+((PageDevice)element).getSize().getHeight()/2);
		Shape transformed = at.createTransformedShape(shape);
		
		
		g.setPaint(element.getStrokeColor());
		
		g.setStroke(element.getStroke());
		g.draw(transformed);
		
		if(element.getType()!=null) {
			Font font=new Font("mama",Font.BOLD,20);
			AttributedString aString=new AttributedString(element.getType());
			aString.addAttribute(TextAttribute.FONT, font);
			g.drawString(aString.getIterator(), (int)((PageDevice)element).getPosition().getX(), (int)((PageDevice)element).getPosition().getY());			
		}
	
		g.setPaint(element.getPaint());
		g.fill(getShape());	
	}

	
	@Override
	public boolean isElementAt(Point position) {
		return getShape().contains(position);
	}

	public Shape getShape() {
		return shape;
	}
	
	public void setShape(Shape shape) {
		this.shape = shape;
	}	
	
}
