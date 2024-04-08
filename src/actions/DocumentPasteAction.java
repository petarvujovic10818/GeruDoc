package actions;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

import app.MainFrame;

public class DocumentPasteAction extends AbstractGetAction{
	
	public DocumentPasteAction() {
		putValue(SMALL_ICON,new ImageIcon("images/paste_icon.png"));
		putValue(NAME, "DocumentPaste");
		putValue(SHORT_DESCRIPTION, "DocumentPaste");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		MainFrame.getInstance().getMyTree().pasteDocument2();
		SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
	}

}
