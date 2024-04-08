package page.model;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import elements.PageElement;
import iobserver.IListener;
import iobserver.IObserver;

public class PageModel implements IObserver,Serializable{
	
	private static int count=0;
	private String name;
	
	protected ArrayList<PageElement>pageElements=new ArrayList<PageElement>();
	
	private ArrayList<IListener>listeners=new ArrayList<IListener>();
	
	public int getElementAtPosition(Point point) {
		for(int i=getElementCount()-1;i>=0;i--){
			PageElement element = getElementAt(i);
			if(element.getElementPainter().isElementAt(point)){
				return i;
			}
		}
		return -1;
	}	
	
	public void removeElement(PageElement element) {
		pageElements.remove(element);
		notifyObservers(element);
	}
	
	public int getElementCount(){
		return pageElements.size();
	}
	
	public PageElement getElementAt(int i){
		return pageElements.get(i);
	}
	
	public static int getCount() {
		return count;
	}
	
	public static void setCount(int count) {
		PageModel.count = count;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	public Iterator<PageElement> getElementIterator(){
		return pageElements.iterator();
	}
	
	public void addPageElements(PageElement device){
		pageElements.add(device);
		notifyObservers(device);
	}
	//******
	public void removePageElementsList(ArrayList<PageElement>list) {
		pageElements.removeAll(list);
		notifyObservers(list);
	}
	
	public void addPageElementsList(ArrayList<PageElement>list) {
		pageElements.addAll(list);
		notifyObservers(list);
	}

	@Override
	public void addObserver(IListener listener) {
		listeners.add(listener);
		
	}

	@Override
	public void removeObserver(IListener listener) {
		listeners.remove(listener);
	}

	@Override
	public void notifyObservers(Object event) {
		for(IListener listener : listeners){
			listener.update(event);
		}
	}	
	
	public ArrayList<PageElement> getPageElements() {
		return pageElements;
	}
	
}