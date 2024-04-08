package actions;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import app.MainFrame;
import page.model.PageElementsSelection;
import tree.model.Document;
import tree.model.DocumentNodeSelection;
import view.PageView;

public class CopyAction extends AbstractGetAction{
	
	public CopyAction() {
		putValue(SMALL_ICON,new ImageIcon("images/copy_icon.png"));
		putValue(NAME, "Copy");
		putValue(SHORT_DESCRIPTION, "Copy");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {	
			if(!(((PageView)(MainFrame.getInstance().getRightPanel().getDocumentView().getDesktop().getSelectedFrame())).getPage().getSelectionModel().getSelectionListSize()==0)) {
				PageElementsSelection contents=new PageElementsSelection(((PageView)(MainFrame.getInstance().getRightPanel().getDocumentView().getDesktop().getSelectedFrame())).getPage().getSelectionModel().getSelected());
				MainFrame.getInstance().getClipboard().setContents(contents, MainFrame.getInstance());
			} 
	}

}
