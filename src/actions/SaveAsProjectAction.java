package actions;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

import app.MainFrame;
import tree.model.Project;

public class SaveAsProjectAction extends AbstractGetAction{
	
	public SaveAsProjectAction() {
		putValue(SMALL_ICON,new ImageIcon("images/save_project_icon.png"));
		putValue(NAME, "Save as project");
		putValue(SHORT_DESCRIPTION, "Save as project");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JFileChooser jfc = new JFileChooser();
		Project project=(Project)MainFrame.getInstance().getMyTree().getLastSelectedPathComponent();
		File projectFile=project.getProjectFile();
		
		if(jfc.showSaveDialog(MainFrame.getInstance())==JFileChooser.APPROVE_OPTION){
            projectFile=jfc.getSelectedFile();           	 
 	 
		}else{
			return; 
		}
		
		ObjectOutputStream os;
		try {
			os = new ObjectOutputStream(new FileOutputStream(projectFile));
			os.writeObject(project);
			project.setProjectFile(projectFile);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
