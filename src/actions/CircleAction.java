package actions;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import app.MainFrame;
import view.PageView;

public class CircleAction extends AbstractGetAction{
	
	public CircleAction() {
		putValue(SMALL_ICON,new ImageIcon("images/circle_icon.png"));
		putValue(NAME, "Circle");
		putValue(SHORT_DESCRIPTION, "Circle");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		PageView pageView=(PageView)MainFrame.getInstance().getRightPanel().getDocumentView().getDesktop().getSelectedFrame();
		pageView.startCircleState();
	}

}
