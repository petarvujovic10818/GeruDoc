package factory;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import app.MainFrame;
import tree.model.Document;
import tree.model.Project;

public class DocumentNode extends Node{

	@Override
	public void newNode(Object o) {
		String name=JOptionPane.showInputDialog("Unesite ime dokumenta");
		if(name!=null && !name.equals("")) {
			Document d=new Document(name,((Project)o));
			((Project)o).add(d);
		}
		SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
	}

}
