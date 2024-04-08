package actions;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import app.MainFrame;
import view.PageView;

public class DragAndDropAction extends AbstractGetAction{
	
	public DragAndDropAction() {
		putValue(SMALL_ICON,new ImageIcon("images/drag_and_drop_icon.png"));
		putValue(NAME, "Drag and Drop");
		putValue(SHORT_DESCRIPTION, "Drag and Drop");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		PageView pageView=(PageView)MainFrame.getInstance().getRightPanel().getDocumentView().getDesktop().getSelectedFrame();
		pageView.startDragAndDropState();
	}

}
