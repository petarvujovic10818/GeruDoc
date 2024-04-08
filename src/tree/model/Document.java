package tree.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

import iobserver.IListener;
import iobserver.IObserver;

public class Document extends DefaultMutableTreeNode implements IObserver,Serializable{
	
	private  ArrayList<IListener>listeners=new ArrayList<IListener>(); //list of listeners(subscribers)
	
	private ArrayList<Page>pages=new ArrayList<Page>(); //list of pages
	private String name;
	private Project project; //project it belongs to
	
	public Document(String name, Project project) {
		this.name=name;
		this.project=project;
	}
	
	public Document cloneDocument() {
		return this;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	@Override
	public Enumeration<TreeNode> children() {
		return (Enumeration<TreeNode>)pages;
	}

	@Override
	public boolean getAllowsChildren() {
		return true;
	}

	@Override
	public TreeNode getChildAt(int childIndex) {
		return getPage(childIndex);
	}

	@Override
	public int getChildCount() {
		return getPageCount();
	}

	@Override
	public int getIndex(TreeNode node) {
		return getPageIndex((Page)node);
	}

	@Override
	public TreeNode getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isLeaf() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public Page getPage(int index) {
		return pages.get(index);
	}
	
	public int getPageIndex(Page page) {
		return pages.indexOf(page);
	}
	
	public int getPageCount() {
		return pages.size();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
		notifyObservers(name); //notify others that name has changed
	}
	
	
	public Project getRoditelj() {
		return project;
	}
	
	public void setRoditelj(Project projectt) {
		this.project=projectt;
	}
	
	@Override
	public void add(MutableTreeNode newChild) {
		pages.add((Page)newChild);
	}
	
	@Override
	public void remove(MutableTreeNode aChild) {
		pages.remove((Page)aChild);
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
	
	public ArrayList<Page> getPages() {
		return pages;
	}
	
	public void setPages(ArrayList<Page> pages) {
		this.pages = pages;
	}
	
}