package factory;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import app.MainFrame;
import tree.model.Project;
import tree.model.Workspace;

public class ProjectNode extends Node{
	
	@Override
	public void newNode(Object o) {
		String name=JOptionPane.showInputDialog("Unesite ime projekta");
		if(name!=null && !name.equals("")) {
			Project p=new Project(name,((Workspace)o));
			((Workspace)o).add(p);
		}
		SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
	}

}