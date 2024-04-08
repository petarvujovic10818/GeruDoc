package actions;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import app.MainFrame;
import view.PageView;

public class RectangleAction extends AbstractGetAction{
	
	public RectangleAction() {
		putValue(SMALL_ICON,new ImageIcon("images/rectangle_icon.png"));
		putValue(NAME, "Rectangle");
		putValue(SHORT_DESCRIPTION, "Rectangle");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		PageView pageView=(PageView)MainFrame.getInstance().getRightPanel().getDocumentView().getDesktop().getSelectedFrame();
		pageView.startRectangleState();
	}

}
