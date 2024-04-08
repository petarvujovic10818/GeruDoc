package actions;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import app.MainFrame;
import view.PageView;

public class SelectAction extends AbstractGetAction{
	
	public SelectAction() {
		putValue(SMALL_ICON,new ImageIcon("images/select_iconn.png"));
		putValue(NAME, "Select");
		putValue(SHORT_DESCRIPTION, "Select");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		PageView pageView=(PageView)MainFrame.getInstance().getRightPanel().getDocumentView().getDesktop().getSelectedFrame();
		pageView.startSelectState();
	}

}
