package actions;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import app.MainFrame;
import view.PageView;

public class RotateAction extends AbstractGetAction{
	
	public RotateAction() {
		putValue(SMALL_ICON,new ImageIcon("images/rotate_icon.png"));
		putValue(NAME, "Rotate");
		putValue(SHORT_DESCRIPTION, "Rotate");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		PageView pageView=(PageView)MainFrame.getInstance().getRightPanel().getDocumentView().getDesktop().getSelectedFrame();
		pageView.startRotateState();
	}
	
}
