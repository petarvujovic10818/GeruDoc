package tree.model;

import javax.swing.tree.DefaultTreeModel;

public class TreeModel extends DefaultTreeModel{
	
	public TreeModel() {
		super(new Workspace());
	}
	
}
