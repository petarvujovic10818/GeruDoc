package tree.model;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

import iobserver.IListener;
import iobserver.IObserver;


public class Project extends DefaultMutableTreeNode implements IObserver,Serializable{
	
	private  ArrayList<IListener>listeners=new ArrayList<IListener>();
	
	private ArrayList<Document>documents=new ArrayList<Document>();
	private String name;
	private Workspace workspace;
	
	private File projectFile;
	
	public Project(String name, Workspace workspace) {
		this.name=name;
		this.workspace=workspace;
		
		this.projectFile=null;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	@Override
	public Enumeration<Document> children() {
		return (Enumeration<Document>)documents;
	}

	@Override
	public boolean getAllowsChildren() {
		return true;
	}

	@Override
	public TreeNode getChildAt(int childIndex) {
		return getDocument(childIndex);
	}

	@Override
	public int getChildCount() {
		return getDocumentCount();
	}

	@Override
	public int getIndex(TreeNode node) {
		return getDocumentIndex((Document)node);
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
	
	public Document getDocument(int index) {
		return documents.get(index);
	}
	
	public int getDocumentIndex(Document document) {
		return documents.indexOf(document);
	}
	
	public int getDocumentCount() {
		return documents.size();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
		notifyObservers(name);
	}

	
	public Workspace getRoditelj() {
		return workspace;
	}
	
	@Override
	public void add(MutableTreeNode newChild) {
		documents.add((Document)newChild);
	}
	
	@Override
	public void remove(MutableTreeNode aChild) {
		documents.remove((Document)aChild);
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
	
	public File getProjectFile() {
		return projectFile;
	}
	
	public void setProjectFile(File projectFile) {
		this.projectFile = projectFile;
	}
	
	public ArrayList<Document> getDocuments() {
		return documents;
	}
}

