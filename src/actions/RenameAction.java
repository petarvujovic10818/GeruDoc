package actions;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import app.MainFrame;
import tree.model.Document;
import tree.model.Page;
import tree.model.Project;

public class RenameAction extends AbstractGetAction {

	public RenameAction() {
		putValue(SMALL_ICON,new ImageIcon("images/rename_icon.png"));
		putValue(NAME, "Rename");
		putValue(SHORT_DESCRIPTION, "Rename");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object x=MainFrame.getInstance().getMyTree().getLastSelectedPathComponent();
		String name=JOptionPane.showInputDialog("Unesite novo ime");
		if(name!=null && !name.equals("")) {
		if(x instanceof Project) {
			((Project) x).setName(name);
			SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
		} else if(x instanceof Document) {
			((Document)x).setName(name);
			SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
		} else if(x instanceof Page){
			((Page)x).setName(name);
			SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
		} else {
			System.out.println("Can't change workspace name");
		}
		}
	}
	
}
