package tree.model;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;


public class Workspace extends DefaultMutableTreeNode implements Serializable{
	
	private ArrayList<Project>projects=new ArrayList<Project>();
	private String name;
	private File workspaceFile;
	
	public Workspace() {
		super();
		this.name="Workspace";
	}
			
	@Override
	public String toString() {
		return name;
	}
	
	@Override
	public Enumeration<Project> children() {
		return (Enumeration<Project>)projects;
	}

	@Override
	public boolean getAllowsChildren() {
		return true;
	}

	@Override
	public TreeNode getChildAt(int childIndex) {
		return getProject(childIndex);
	}

	@Override
	public int getChildCount() {
		return getProjectsCount();
	}

	@Override
	public int getIndex(TreeNode node) {
		return getProjectIndex((Project)node);
	}

	@Override
	public TreeNode getParent() {
		return null;
	}

	@Override
	public boolean isLeaf() {
		return false;
	}
	
	public Project getProject(int index) {
		return projects.get(index);
	}
	
	public int getProjectsCount() {
		return projects.size();
	}
	
	public int getProjectIndex(Project project) {
		return projects.indexOf(project);
	}

	@Override
	public void add(MutableTreeNode newChild) {
		projects.add((Project)newChild);
	}
	
	@Override
	public void remove(MutableTreeNode aChild) {
		projects.remove((Project)aChild);
	}

	public File getWorkspaceFile() {
		return workspaceFile;
	}
	
	public void setWorkspaceFile(File workspaceFile) {
		this.workspaceFile = workspaceFile;
	}
	
	public Project projekatPoImenu(String name) {
		for(Project p:projects) {
			if(p.getName().equals(name)) {
				return p;
			}
		}
		return null;
	}
	
	public ArrayList<Project> getProjects() {
		return projects;
	}
}

