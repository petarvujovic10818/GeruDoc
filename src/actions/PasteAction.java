package actions;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

import app.MainFrame;
import commands.PasteCommand;
import view.PageView;

public class PasteAction extends AbstractGetAction{
	
	public PasteAction() {
		putValue(SMALL_ICON,new ImageIcon("images/paste_icon.png"));
		putValue(NAME, "Paste");
		putValue(SHORT_DESCRIPTION, "Paste");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		//((PageView)(MainFrame.getInstance().getRightPanel().getDocumentView().getDesktop().getSelectedFrame())).paste();
		
		PageView pageView=(PageView)MainFrame.getInstance().getRightPanel().getDocumentView().getDesktop().getSelectedFrame();
		pageView.getCommandManager().addCommand(new PasteCommand());
		
		
	}

}
