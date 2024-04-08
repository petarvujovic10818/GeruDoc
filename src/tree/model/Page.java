package tree.model;

import java.io.Serializable;
import java.util.Enumeration;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

import page.model.PageModel;
import page.model.PageSelectionModel;

public class Page extends DefaultMutableTreeNode implements Serializable{
	
	private String name;
	private Document document;
	
	private PageModel model; //*
		
	private PageSelectionModel selectionModel;
	
	public Page(String name, Document document) {
		this.name=name;
		this.document=document;
		this.model=new PageModel();
	}
		
	@Override
	public String toString() {
		return name;
	}
	
	@Override
	public Enumeration children() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getAllowsChildren() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TreeNode getChildAt(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getChildCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getIndex(TreeNode arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TreeNode getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isLeaf() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
		
	public Document getRoditelj() {
		return document;
	}
	
	public PageModel getModel() {
		return model;
	}
	
	public PageSelectionModel getSelectionModel() {
		if(selectionModel == null)
			selectionModel = new PageSelectionModel();
		return selectionModel;
	}
	
}