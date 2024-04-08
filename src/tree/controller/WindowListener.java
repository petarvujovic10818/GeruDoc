package tree.controller;

import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import app.MainFrame;
import tree.model.Workspace;

public class WindowListener implements java.awt.event.WindowListener{

	@Override
	public void windowClosing(WindowEvent e) {
		int confirmed = JOptionPane.showConfirmDialog(null, 
		        "Da li zelite da sacuvate workspace?", "Save Workspace?",
		        JOptionPane.YES_NO_OPTION);

		    if (confirmed == JOptionPane.YES_OPTION) {
		    	JFileChooser jfc = new JFileChooser();
		    	Workspace workspace=(Workspace)MainFrame.getInstance().getMyTree().getLastSelectedPathComponent();
		    	File workspaceFile=workspace.getWorkspaceFile();
		    	
		    	if(jfc.showSaveDialog(MainFrame.getInstance())==JFileChooser.APPROVE_OPTION){
	                   workspaceFile=jfc.getSelectedFile();           	 
		    	}else{
		    		return; 
		    	}  
		    	
		    	ObjectOutputStream os;
				try {
					os = new ObjectOutputStream(new FileOutputStream(workspaceFile));
					os.writeObject(workspace);
					workspace.setWorkspaceFile(workspaceFile);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
		    	
		      MainFrame.getInstance().dispose();
		    } else {
		    	MainFrame.getInstance().dispose();
		    }
		  }
	
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
