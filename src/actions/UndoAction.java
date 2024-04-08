package actions;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import app.MainFrame;
import view.PageView;

public class UndoAction extends AbstractGetAction{
	
	public UndoAction() {
		putValue(SMALL_ICON,new ImageIcon("images/undo_icon.png"));
		putValue(NAME, "Undo");
		putValue(SHORT_DESCRIPTION, "Undo");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		PageView pageView=(PageView)MainFrame.getInstance().getRightPanel().getDocumentView().getDesktop().getSelectedFrame();
		pageView.getCommandManager().undoCommand();
	}

}
