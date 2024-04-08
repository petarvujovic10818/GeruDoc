package actions;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import app.MainFrame;
import tree.model.Document;
import tree.model.DocumentNodeSelection;

public class DocumentCopyAction extends AbstractGetAction{
	
	public DocumentCopyAction() {
		putValue(SMALL_ICON,new ImageIcon("images/copy_icon.png"));
		putValue(NAME, "DocumentCopy");
		putValue(SHORT_DESCRIPTION, "DocumentCopy");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o=MainFrame.getInstance().getMyTree().getLastSelectedPathComponent();
		if(o instanceof Document) {
			Document document=(Document)o;
			DocumentNodeSelection docContent=new DocumentNodeSelection(document);
			MainFrame.getInstance().getClipboard().setContents(docContent, MainFrame.getInstance());
		} 
	}

}
