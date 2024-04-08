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
import tree.model.Document;
import tree.model.Page;
import tree.model.Project;
import tree.model.Workspace;
import view.PageView;

public class OpenProjectAction extends AbstractGetAction{
	
	public OpenProjectAction() {
		putValue(SMALL_ICON,new ImageIcon("images/open_project_icon.png"));
		putValue(NAME, "Open project");
		putValue(SHORT_DESCRIPTION, "Open project");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JFileChooser jfc = new JFileChooser();
		if(jfc.showOpenDialog(MainFrame.getInstance())==JFileChooser.APPROVE_OPTION){
			try {
				ObjectInputStream os = new ObjectInputStream(new FileInputStream(jfc.getSelectedFile()));
				  
				Project p=null;
				try {
					p = (Project) os.readObject();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			     Workspace workspace =(Workspace)MainFrame.getInstance().getMyTree().getLastSelectedPathComponent();
			     workspace.add(p);
			      
				
				  for (int i=0;i<p.getDocumentCount();i++){
					  Document document=p.getDocument(i);
					  for(int j=0;j<document.getPageCount();j++) {
						  Page page=document.getPage(j);
						  PageView pageView=new PageView();
						  pageView.setPage(page);
					  }
				}
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
