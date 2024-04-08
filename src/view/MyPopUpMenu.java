package view;

import javax.swing.JPopupMenu;

import app.MainFrame;

public class MyPopUpMenu extends JPopupMenu{
	
		public MyPopUpMenu() {
			add(MainFrame.getInstance().getActionManager().getNewNodeAction());
			addSeparator();
			add(MainFrame.getInstance().getActionManager().getRenameAction());
			addSeparator();
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
		}
}