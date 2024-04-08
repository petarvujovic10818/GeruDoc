package actions;

import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;

import app.MainFrame;
import tree.model.TreeModel;
import tree.model.Workspace;

public class SwitchWorkspaceAction extends AbstractGetAction{
	
	public SwitchWorkspaceAction() {
		putValue(SMALL_ICON,new ImageIcon("images/open_project_icon.png"));
		putValue(NAME, "Switch Workspace");
		putValue(SHORT_DESCRIPTION, "Switch Workspace");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JFileChooser jfc = new JFileChooser();
		if(jfc.showOpenDialog(MainFrame.getInstance())==JFileChooser.APPROVE_OPTION){
			try {
				ObjectInputStream os = new ObjectInputStream(new FileInputStream(jfc.getSelectedFile()));
				  
				Workspace ws=new Workspace();
				try {
					ws = (Workspace) os.readObject();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				
				TreeModel treeModel=(TreeModel)MainFrame.getInstance().getMyTree().getModel();
				treeModel.setRoot(ws);
				 
				  SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
				  MainFrame.getInstance().getRightPanel().revalidate();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			} 
				
	}
	}

}
