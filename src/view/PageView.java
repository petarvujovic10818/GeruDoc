package view;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.datatransfer.Transferable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;

import app.MainFrame;
import commands.CommandManager;
import elements.CircleElement;
import elements.PageDevice;
import elements.PageElement;
import elements.RectangleElement;
import elements.TriangleElement;
import iobserver.IListener;
import page.model.PageElementsSelection;
import painters.CirclePainter;
import painters.ElementPainter;
import painters.RectanglePainter;
import painters.TrianglePainter;
import state.StateManager;
import tree.model.Page;

public class PageView extends JInternalFrame implements IListener{
	 
	static int openFrameCount = 0;
	static final int xOffset = 30, yOffset = 30;
	
	private Page page;
	private JPanel framework;
	
	private Point2D lastPosition=null;
	private Rectangle2D selectionRectangle=new Rectangle2D.Double();
	
	private StateManager stateManager=new StateManager(this);
	private CommandManager commandManager=new CommandManager();
	
	public enum Handle{
		North,South,East,West,SouthEast,SouthWest,NorthEast,NorthWest
	}
	static final int handleSize=7;
	
	public static final int CIRCLE=1;
	public static final int RECTANGLE=2;
	public static final int TRIANGLE=3;
	
	
	public PageView() {
		super("",true,true,true,true);
		++openFrameCount;
		setLocation(xOffset*openFrameCount, yOffset*openFrameCount);
		setIconifiable(true);
		setClosable(true);
		setSize(450,450);
 	    setVisible(true);
 	    framework=new Framework(); 
 	    framework.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
 	    framework.setBackground(Color.WHITE);
 	    getContentPane().add(framework,BorderLayout.CENTER);
 	    PageController pc=new PageController();
 	    framework.addMouseListener(pc);
		framework.addMouseMotionListener(pc);
	}
	
	public void startCircleState() {
		page.getSelectionModel().removeAllFromSelectionList();
		stateManager.setCircleState();
		}
	
	public void startRectangleState() {
		page.getSelectionModel().removeAllFromSelectionList();
		stateManager.setRectangleState();
		}
	
	public void startTriangleState() {
		page.getSelectionModel().removeAllFromSelectionList();
		stateManager.setTriangleState();
	}
	
	public void startSelectState() {
    	stateManager.setSelectState();
		}
	
	public void startLassoState() {
    	stateManager.setLassoState();
		}
	
	public void startDeleteElementState() {
		stateManager.setDeleteElementState();
	}
	
	public void startRotateState() {
		stateManager.setRotateState();
	}
	
	public void startDragAndDropState() {
		stateManager.setDragAndDropState();
	}
	
	public void startResizeState() {
		stateManager.setResizeState();
	}
	
	private class PageController extends MouseAdapter implements MouseMotionListener{

		public void mousePressed(MouseEvent e) {
				lastPosition=e.getPoint();
				getStateManager().getCurrentState().mousePressed(e);
		}

		public void mouseReleased(MouseEvent e) {
			   getStateManager().getCurrentState().mouseReleased(e);
		}
		
		public void mouseDragged(MouseEvent e ){
			   getStateManager().getCurrentState().mouseDragged(e);
		}
		
		public void mouseMoved(MouseEvent e) {
			getStateManager().getCurrentState().mouseMoved(e);
		}
		
	}
	
	@SuppressWarnings("serial")
	private class Framework extends JPanel {
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2=(Graphics2D)g;
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f));
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			
			
			
			Iterator<PageElement> it = page.getModel().getElementIterator();
			while(it.hasNext()){
				PageElement pe = (PageElement) it.next();
				ElementPainter paint = pe.getElementPainter();
				paint.paint(g2, pe);
			}
			
			paintSelectionHandles(g2);
			
			g2.setColor(Color.BLACK);
			g2.setStroke(new BasicStroke((float)1, BasicStroke.CAP_SQUARE, 
					BasicStroke.JOIN_BEVEL, 1f, new float[]{(float)3, (float)6}, 0 ));
			g2.draw(selectionRectangle);
			
		}
	}
	
	private void paintSelectionHandles(Graphics2D g2) {
		
		Iterator<PageElement> it = page.getSelectionModel().getSelectionListIterator();
		while(it.hasNext()){
			PageElement element =  it.next();
			if (element instanceof PageDevice){
				PageDevice device=(PageDevice)element;
				
				g2.setStroke(new BasicStroke((float)1, BasicStroke.CAP_SQUARE, 
						BasicStroke.JOIN_BEVEL, 1f, new float[]{3f, 6f}, 0 ));
				g2.setPaint(Color.BLACK);
				
				
				Rectangle rectangle=new Rectangle();
				rectangle.setBounds((int)device.getPosition().getX(), (int)device.getPosition().getY(),
						(int)device.getSize().getWidth(), (int)device.getSize().getHeight());
				
				g2.draw(rectangle);
				
				for(Handle e: Handle.values()){
					paintSelectionHandle(g2, getHandlePoint(device.getPosition(), device.getSize(), e));
				}
			}
		}
	}
	
	private void paintSelectionHandle(Graphics2D g2, Point2D position){
		double size = handleSize;
		g2.fill(new Rectangle2D.Double(position.getX()-size/2, position.getY()-size/2, 
			size, size));	
	}
	
	
	private Point2D getHandlePoint(Point2D topLeft, Dimension2D size, Handle handlePosition ){
		double x=0, y=0;
				
		if(handlePosition == Handle.NorthWest || handlePosition == Handle.North || handlePosition == Handle.NorthEast){
			y = topLeft.getY();
		}
		if(handlePosition == Handle.East || handlePosition == Handle.West){
			y = topLeft.getY()+size.getHeight()/2;
		}
		if(handlePosition == Handle.SouthWest || handlePosition == Handle.South || handlePosition == Handle.SouthEast){
			y = topLeft.getY() + size.getHeight();
		}

		if(handlePosition == Handle.NorthWest || handlePosition == Handle.West || handlePosition == Handle.SouthWest){
			x = topLeft.getX();
		}
		if(handlePosition == Handle.North || handlePosition == Handle.South){
			x = topLeft.getX() + size.getWidth()/2;
		}
		if(handlePosition == Handle.NorthEast || handlePosition == Handle.East || handlePosition == Handle.SouthEast){
			x = topLeft.getX() + size.getWidth();
		}
		
		return new Point2D.Double(x,y);
	}
	
	public Handle getDeviceAndHandleForPoint(Point2D point){
		PageElement element;
		
		Iterator<PageElement> it = page.getSelectionModel().getSelectionListIterator();
		while(it.hasNext()){
			element = it.next();
			return getHandleForPoint(element, point);
		}
		return null;
	}
	
	public PageDevice getDeviceForHandlePoint(Point2D point) {
        PageDevice shape;

        for(PageElement e : getPage().getModel().getPageElements()){
            if(e instanceof PageDevice){
                shape = (PageDevice) e;
                if(getHandleForPoint((PageDevice) e, point) != null){
                    return shape;
                }
            }
        }
        return null;
    }
	
	private Handle getHandleForPoint(PageElement element, Point2D point){
		for(Handle h: Handle.values()){
			if(isPointInHandle(element, point, h)){
				return h;
			}
		}
		return null;
	}
	
	private boolean isPointInHandle(PageElement element, Point2D point, Handle handle){
		if (element instanceof PageDevice){
			PageDevice device=(PageDevice)element;
			Point2D handleCenter = getHandlePoint(device.getPosition(), device.getSize(), handle);
			return ( (Math.abs(point.getX()-handleCenter.getX())<=(double)handleSize/2) && 
					(Math.abs(point.getY()-handleCenter.getY())<=(double)handleSize/2) );
		}else 
			return false;
	}
	
	public void setPage(Page page) {
		this.page=page;
		this.setName(page.getName());
		this.page.getModel().addObserver(this);
		this.page.getSelectionModel().addObserver(this);
		setTitle(page.getName());
	}
	
	public Point2D getLastPosition() {
		return lastPosition;
	}

	public void setLastPosition(Point2D lastPosition) {
		this.lastPosition = lastPosition;
	}

	public Rectangle2D getSelectionRectangle() {
		return selectionRectangle;
	}

	public void setSelectionRectangle(Rectangle2D selectionRectangle) {
		this.selectionRectangle = selectionRectangle;
	}
	
	public Page getPage() {
		return page;
	}

	@Override
	public void update(Object event) {
		revalidate();
		repaint();
	}
	
	public StateManager getStateManager() {
		return stateManager;
	}
	
	public CommandManager getCommandManager() {
		return commandManager;
	}
	
	
	public void paste (){
		
		Transferable clipboardContent = MainFrame.getInstance().getClipboard().getContents (MainFrame.getInstance()); 
		if ((clipboardContent != null) &&
		 	(clipboardContent.isDataFlavorSupported (PageElementsSelection.elementFlavor))) {
			try {
				PageDevice device = null;
				ArrayList<PageElement> tempElements = (ArrayList<PageElement>) clipboardContent.getTransferData (PageElementsSelection.elementFlavor);					
		 		for(int i=0;i<tempElements.size();i++){

		 			if(tempElements.get(i) instanceof PageDevice){
		 				device=(PageDevice) tempElements.get(i).clone();
			 			Point2D newLocation=(Point2D) device.getPosition();
			 			newLocation.setLocation(device.getPosition().getX(),device.getPosition().getY());
			 			device.setPosition(newLocation);
			 			
			 			if (device instanceof CircleElement){
			 				device.setElementPainter(new CirclePainter(device));
			 			}else if (device instanceof RectangleElement){
			 				device.setElementPainter(new RectanglePainter(device));
			 			}else if(device instanceof TriangleElement) {
			 				device.setElementPainter(new TrianglePainter(device));
			 			}
			 			
			 			page.getModel().addPageElements(device);
			 			page.getSelectionModel().addToSelectionList(device);
		 			}
		 		}
			}catch (Exception ex) {
		 		ex.printStackTrace ();
		 	}
		}
	}
	
	public void unPaste() {
		page.getModel().removePageElementsList(page.getSelectionModel().getSelectionList());
		page.getSelectionModel().removeAllFromSelectionList();
		//revalidate();
		//repaint();
	}
	
	
}

