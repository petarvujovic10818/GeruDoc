package actions;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

import app.MainFrame;

public class ShareDocumentToAction extends AbstractGetAction{
	
	public ShareDocumentToAction() {
		putValue(SMALL_ICON,new ImageIcon("images/share_document_icon.png"));
		putValue(NAME, "ShareDocumentTo");
		putValue(SHORT_DESCRIPTION, "ShareDocumentTo");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		MainFrame.getInstance().getMyTree().pasteDocument();
		SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
	}
}
