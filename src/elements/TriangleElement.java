package elements;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.geom.Point2D;

import painters.TrianglePainter;

public class TriangleElement extends PageDevice{

	public TriangleElement(Point2D position, Dimension size, Stroke stroke, Paint paint, Color strokeColor) {
		super(position, size, stroke, paint, strokeColor);
		elementPainter=new TrianglePainter(this);
	}
	
	public TriangleElement(TriangleElement triangle){
		super(triangle);
		elementPainter=new TrianglePainter(this);
	}
	
	public static PageDevice createDefault(Point2D pos, int elementNumber){
		Point2D position = (Point2D) pos.clone();
		
        Paint fill = Color.WHITE;
        TriangleElement triangleElement=new TriangleElement(position, 
	    		                       new Dimension(100,100),
	    		                      new BasicStroke((float)(2), BasicStroke.CAP_SQUARE,BasicStroke.JOIN_BEVEL ),
             	                      fill,
	    		                      Color.BLACK);
        return triangleElement;
	}

	@Override
	public PageElement clone() {
		return this;
	}
	
}
