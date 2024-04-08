package actions;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import app.MainFrame;
import view.PageView;

public class RedoAction extends AbstractGetAction{
	
	public RedoAction() {
		putValue(SMALL_ICON,new ImageIcon("images/redo_icon.png"));
		putValue(NAME, "Redo");
		putValue(SHORT_DESCRIPTION, "Redo");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		PageView pageView=(PageView)MainFrame.getInstance().getRightPanel().getDocumentView().getDesktop().getSelectedFrame();
		pageView.getCommandManager().doCommand();
	}

}
