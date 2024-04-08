package actions;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import app.MainFrame;
import elements.PageElement;
import page.model.PageElementsSelection;
import view.PageView;

public class CutAction extends AbstractGetAction{
	
	public CutAction() {
		putValue(SMALL_ICON,new ImageIcon("images/cut_icon.png"));
		putValue(NAME, "Cut");
		putValue(SHORT_DESCRIPTION, "Cut");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		PageView pageView=(PageView)MainFrame.getInstance().getRightPanel().getDocumentView().getDesktop().getSelectedFrame();
		ArrayList<PageElement>elementi=pageView.getPage().getSelectionModel().getSelectionList();
		if(!(elementi.size()==0)) {
			PageElementsSelection contents=new PageElementsSelection(((PageView)(MainFrame.getInstance().getRightPanel().getDocumentView().getDesktop().getSelectedFrame())).getPage().getSelectionModel().getSelected());
			MainFrame.getInstance().getClipboard().setContents(contents, MainFrame.getInstance());
			
		}
		pageView.getPage().getModel().removePageElementsList(elementi);
		pageView.getPage().getSelectionModel().removeAllFromSelectionList();
	}

}
