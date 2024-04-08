package commands;

import app.MainFrame;
import view.PageView;

public class PasteCommand extends AbstractCommand{

	@Override
	public void doCommand() {
		((PageView)(MainFrame.getInstance().getRightPanel().getDocumentView().getDesktop().getSelectedFrame())).paste();
	}

	@Override
	public void undoCommand() {
		((PageView)(MainFrame.getInstance().getRightPanel().getDocumentView().getDesktop().getSelectedFrame())).unPaste();
	}
	
}
