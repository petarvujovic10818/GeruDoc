package actions;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import app.MainFrame;
import view.PageView;

public class ResizeAction extends AbstractGetAction{
	
	public ResizeAction() {
		putValue(SMALL_ICON,new ImageIcon("images/resize_icon.png"));
		putValue(NAME, "Resize");
		putValue(SHORT_DESCRIPTION, "Resize");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		PageView pageView=(PageView)MainFrame.getInstance().getRightPanel().getDocumentView().getDesktop().getSelectedFrame();
		pageView.startResizeState();
	}
	
}
