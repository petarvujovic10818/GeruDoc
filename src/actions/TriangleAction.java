package actions;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import app.MainFrame;
import view.PageView;

public class TriangleAction extends AbstractGetAction{
	
	public TriangleAction() {
		putValue(SMALL_ICON,new ImageIcon("images/triangle_iconn.png"));
		putValue(NAME, "Triangle");
		putValue(SHORT_DESCRIPTION, "Triangle");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		PageView pageView=(PageView)MainFrame.getInstance().getRightPanel().getDocumentView().getDesktop().getSelectedFrame();
		pageView.startTriangleState();
	}

}
