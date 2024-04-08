package factory;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import app.MainFrame;
import tree.model.Document;
import tree.model.Page;

public class PageNode extends Node{

	@Override
	public void newNode(Object o) {
		String name=JOptionPane.showInputDialog("Unesite ime stranice");
		if(name!=null && !name.equals("")) {
			Page pg=new Page(name,((Document)o));
			((Document)o).add(pg);
		}
		SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
	}

}
