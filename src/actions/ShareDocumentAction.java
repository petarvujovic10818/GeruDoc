package actions;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import app.MainFrame;
import tree.model.Document;
import tree.model.DocumentNodeSelection;

public class ShareDocumentAction extends AbstractGetAction{
	
	public ShareDocumentAction() {
		putValue(SMALL_ICON,new ImageIcon("images/share_document_icon.png"));
		putValue(NAME, "ShareDocument");
		putValue(SHORT_DESCRIPTION, "ShareDocument");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object o=MainFrame.getInstance().getMyTree().getLastSelectedPathComponent();
		if(o instanceof Document) {
			Document document=(Document)o;
			DocumentNodeSelection docContent=new DocumentNodeSelection(document);
			MainFrame.getInstance().getClipboard().setContents(docContent, MainFrame.getInstance());
		} 
	}
	

}
