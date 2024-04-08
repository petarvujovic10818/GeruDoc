package elements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.geom.Point2D;

public abstract class PageDevice extends PageElement{
	
	protected Point2D position;
	protected Dimension size;
	
	public PageDevice(Point2D position, Dimension size, Stroke stroke, Paint paint,Color  strokeColor){
		super(stroke, paint,strokeColor);
		this.size = size;
		this.position = position;
		position.setLocation(position.getX()-size.getWidth()/2,position.getY()-size.getHeight()/2);
		
	}
	
	public PageDevice(PageDevice device) {
		super(device);
		this.size=device.size;
		this.position=device.position;
	}
	
	public Point2D getPosition() {
		return position;
	}
	
	public void setPosition(Point2D position) {
		this.position = position;
	}
	
	public Dimension getSize() {
		return size;
	}
	
	public void setSize(Dimension size) {
		this.size = size;
	}
	
	
}
