package page.model;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.DefaultSingleSelectionModel;

import elements.PageDevice;
import elements.PageElement;
import iobserver.IListener;
import iobserver.IObserver;

public class PageSelectionModel extends DefaultSingleSelectionModel implements IObserver{
	
	private ArrayList<PageElement>selectionList=new ArrayList<PageElement>();
	private ArrayList<IListener>listeners=new ArrayList<IListener>();
	
	public void addToSelectionList(PageElement element) {
		selectionList.add(element);
		notifyObservers(element);
	}
	
	public void addToSelectionList(ArrayList<PageElement> list) {
		selectionList.addAll(list);
		notifyObservers(list);
	}
	
	public int getSelectionListSize() {
		return selectionList.size();
	}
	
	public PageElement getElementFromSelectionListAt(int index) {
		return (PageElement)selectionList.get(index);
	}
	
	public int getIndexByObject(PageElement element) {
		return selectionList.indexOf(element);
	}
	
	public void removeFromSelectionList(PageElement element) {
		selectionList.remove(element);
		notifyObservers(element);
	}
	
	public void removeAllFromSelectionList() {
		selectionList.clear();
		notifyObservers(null);
	}
	
	public ArrayList<PageElement>  getSelectionList() {
		return selectionList;
	}
	
	public Iterator<PageElement> getSelectionListIterator(){
		return selectionList.iterator();
	}
	
	public boolean isElementSelected(PageElement element){
		return selectionList.contains(element);
	}
	
	public ArrayList<PageElement> getSelected() {
		ArrayList<PageElement> selected=new ArrayList<PageElement>();
		selected.addAll(selectionList);
		
		return selected;
	}
	
	public void selectElements(Rectangle2D rec,ArrayList<PageElement>elements) {
		Iterator<PageElement>it=elements.iterator();
		while(it.hasNext()) {
			PageElement element=it.next();
			if(element instanceof PageDevice) {
				PageDevice device=(PageDevice)element;
				if(rec.intersects(device.getPosition().getX(), device.getPosition().getY(),
						device.getSize().getWidth(), device.getSize().getHeight())){
					if(!isElementSelected(device))
						selectionList.add(device);
				}
			}
		}
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
	
}
