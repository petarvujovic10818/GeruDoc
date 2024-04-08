package elements;

import java.awt.Color;
import java.awt.Paint;
import java.awt.Stroke;
import java.io.Serializable;

import painters.ElementPainter;
import serialization.SerializableStrokeAdapter;

public abstract class PageElement implements Serializable{
	
	protected Paint paint;
	protected SerializableStrokeAdapter stroke;
	protected Color strokeColor;
	protected ElementPainter elementPainter;
	
	protected double rotation;
	
	protected String imageUrl=null;
	protected String textContent=null;
	
	protected String type;
	
	abstract public PageElement clone();
	
	public PageElement(Stroke stroke, Paint paint,Color strokeColor) {
		setStroke(stroke);
		this.paint=paint;
		this.strokeColor=strokeColor;
		this.rotation=0;
	}
	
	public PageElement(PageElement element){
		this.stroke=element.stroke;
		this.paint=element.paint;
		this.strokeColor=element.strokeColor;
		this.elementPainter=element.elementPainter;
	}
		
	public ElementPainter getElementPainter() {
		return elementPainter;
	}
	
	public void setElementPainter(ElementPainter elementPainter) {
		this.elementPainter = elementPainter;
	}
	
	public Paint getPaint() {
		return paint;
	}
	
	public void setPaint(Paint paint) {
		this.paint = paint;
	}
	
	public Stroke getStroke() {
		return stroke;
	}
	
	public void setStroke(Stroke stroke) {
		this.stroke = new SerializableStrokeAdapter(stroke);
	}
	
	public Color getStrokeColor() {
		return strokeColor;
	}
	
	public void setStrokeColor(Color strokeColor) {
		this.strokeColor = strokeColor;
	}
	
	public double getRotation() {
		return rotation;
	}
	
	public void setRotation(double rotation) {
		this.rotation = rotation;
	}

	public String getImageUrl() {
		return imageUrl;
	}
	
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	public String getTextContent() {
		return textContent;
	}
	
	public void setTextContent(String textContent) {
		this.textContent = textContent;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
}