package commands;

import app.MainFrame;
import elements.PageElement;
import page.model.PageModel;
import page.model.PageSelectionModel;
import view.PageView;

public class RotateCommand extends AbstractCommand{
	
	
	private PageElement element;
	private PageSelectionModel selectionModel;
	
	public RotateCommand(PageSelectionModel selectionModel,PageElement element) {
		
		this.selectionModel=selectionModel;
		this.element=element;
	}
	
	@Override
	public void doCommand() {
		PageView pageView=(PageView)MainFrame.getInstance().getRightPanel().getDocumentView().getDesktop().getSelectedFrame();
		if(selectionModel.getSelectionList().contains(element)) {
			for(PageElement el : selectionModel.getSelectionList()) {
				el.setRotation(el.getRotation()+45);
				pageView.revalidate();
				pageView.repaint();
			}
		}
	}

	@Override
	public void undoCommand() {
		PageView pageView=(PageView)MainFrame.getInstance().getRightPanel().getDocumentView().getDesktop().getSelectedFrame();
		if(selectionModel.getSelectionList().contains(element)) {
			for(PageElement el : selectionModel.getSelectionList()) {
				el.setRotation(el.getRotation()-45);
				pageView.revalidate();
				pageView.repaint();
			}
		}
	}

}
