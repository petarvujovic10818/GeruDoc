package view;

import java.awt.Color;

import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import app.MainFrame;

public class MyToolBar extends JToolBar{

	public MyToolBar() {
		super(SwingConstants.HORIZONTAL);
	
		add(MainFrame.getInstance().getActionManager().getNewNodeAction());
		add(MainFrame.getInstance().getActionManager().getRenameAction());
		add(MainFrame.getInstance().getActionManager().getDeleteAction());
		addSeparator();
		add(MainFrame.getInstance().getActionManager().getSaveProjectAction());
		add(MainFrame.getInstance().getActionManager().getSaveAsProjectAction());
		addSeparator();
		add(MainFrame.getInstance().getActionManager().getOpenProjectAction());
		add(MainFrame.getInstance().getActionManager().getSwitchWorkspaceAction());
		addSeparator();
		add(MainFrame.getInstance().getActionManager().getUndoAction());
		add(MainFrame.getInstance().getActionManager().getRedoAction());
		addSeparator();
		add(MainFrame.getInstance().getActionManager().getDocumentCopyAction());
		add(MainFrame.getInstance().getActionManager().getDocumentCutAction());
		add(MainFrame.getInstance().getActionManager().getDocumentPasteAction());
		addSeparator();
		add(MainFrame.getInstance().getActionManager().getPreviewAction());
		addSeparator();
		add(MainFrame.getInstance().getActionManager().getShareDocumentAction());
		addSeparator();
		add(MainFrame.getInstance().getActionManager().getShareDocumentToAction());
		
		setFloatable(true);
		setBackground(Color.WHITE);
		
		
	}
}