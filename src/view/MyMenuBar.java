package view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

import app.MainFrame;

public class MyMenuBar extends JMenuBar{

	public MyMenuBar() {
		JMenu fileMenu=new JMenu("File");
		fileMenu.add(MainFrame.getInstance().getActionManager().getNewNodeAction());
		fileMenu.addSeparator();
		fileMenu.add(MainFrame.getInstance().getActionManager().getRenameAction());
		fileMenu.addSeparator();
		fileMenu.add(MainFrame.getInstance().getActionManager().getDeleteAction());
		fileMenu.addSeparator();
		fileMenu.add(MainFrame.getInstance().getActionManager().getSaveProjectAction());
		fileMenu.add(MainFrame.getInstance().getActionManager().getSaveAsProjectAction());
		fileMenu.addSeparator();
		fileMenu.add(MainFrame.getInstance().getActionManager().getOpenProjectAction());
		fileMenu.add(MainFrame.getInstance().getActionManager().getSwitchWorkspaceAction());
		fileMenu.addSeparator();
		fileMenu.add(MainFrame.getInstance().getActionManager().getUndoAction());
		fileMenu.add(MainFrame.getInstance().getActionManager().getRedoAction());
		fileMenu.addSeparator();
		fileMenu.add(MainFrame.getInstance().getActionManager().getDocumentCopyAction());
		fileMenu.add(MainFrame.getInstance().getActionManager().getDocumentCutAction());
		fileMenu.add(MainFrame.getInstance().getActionManager().getDocumentPasteAction());
		fileMenu.addSeparator();
		fileMenu.add(MainFrame.getInstance().getActionManager().getPreviewAction());
		fileMenu.addSeparator();
		fileMenu.add(MainFrame.getInstance().getActionManager().getShareDocumentAction());
		fileMenu.addSeparator();
		fileMenu.add(MainFrame.getInstance().getActionManager().getShareDocumentToAction());
		
		add(fileMenu);
		
		JMenu aboutMenu=new JMenu("About");
		aboutMenu.add(MainFrame.getInstance().getActionManager().getAboutAction());
		add(aboutMenu);
		
	}
	
}