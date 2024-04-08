package tree.controller;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import app.MainFrame;

public class MyTreeSelectionListener implements TreeSelectionListener{

	@Override
	public void valueChanged(TreeSelectionEvent e) {
		DefaultMutableTreeNode node=(DefaultMutableTreeNode)MainFrame.getInstance().getMyTree().getLastSelectedPathComponent();
		if(node==null) return;
		
	}

}
