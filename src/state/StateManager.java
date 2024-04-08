package state;

import java.io.Serializable;

import view.PageView;

public class StateManager implements Serializable{

	private State currentState;
	
	private CircleState circleState; 
	private RectangleState rectangleState;
	private TriangleState triangleState;
	private SelectState selectState;
	private LassoState lassoState;
	
	private DeleteElementState deleteElementState;
	private RotateState rotateState;
	private DragAndDropState dragAndDropState;
	private ResizeState resizeState;
	
	public StateManager(PageView med)
	{
		 
		circleState = new CircleState(med); 
		rectangleState=new RectangleState(med);
		triangleState=new TriangleState(med);
		selectState=new SelectState(med);
		lassoState=new LassoState(med);
		deleteElementState=new DeleteElementState(med);
		rotateState=new RotateState(med);
		dragAndDropState=new DragAndDropState(med);
		resizeState=new ResizeState(med);
		currentState=selectState;
	}
	
	public void setResizeState() {
		currentState=resizeState;
	}
	
	public void setDragAndDropState() {
		currentState=dragAndDropState;
	}
	
	public void setRotateState() {
		currentState=rotateState;
	}
	
	public void setDeleteElementState() {
		currentState=deleteElementState;
	}
	
	public void setLassoState() {
		currentState=lassoState;
	}
	
	public void setSelectState() {
		currentState=selectState;
	}
	
	public void setTriangleState() {
		currentState=triangleState;
	}
	
	public void setCircleState() {
		currentState = circleState; 
	}
	
	public void setRectangleState(){
		currentState = rectangleState; 
	}
	
	public State getCurrentState() {
		return currentState;
	}
	
}