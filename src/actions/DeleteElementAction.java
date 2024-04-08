package actions;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import app.MainFrame;
import view.PageView;

public class DeleteElementAction extends AbstractGetAction{
	
	public DeleteElementAction() {
		putValue(SMALL_ICON,new ImageIcon("images/delete_icon.png"));
		putValue(NAME, "Delete Element");
		putValue(SHORT_DESCRIPTION, "Delete Element");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		PageView pageView=(PageView)MainFrame.getInstance().getRightPanel().getDocumentView().getDesktop().getSelectedFrame();
		pageView.startDeleteElementState();
	}
	
}
