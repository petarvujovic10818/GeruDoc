package actions;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JTextArea;

import app.MainFrame;
import elements.PageElement;
import view.ContentView;
import view.PageView;
import view.controller.EditController;
import view.controller.OkController;

public class PreviewAction extends AbstractGetAction{
	
	
	public PreviewAction() {
		putValue(SMALL_ICON,new ImageIcon("images/preview_icon.png"));
		putValue(NAME, "Preview");
		putValue(SHORT_DESCRIPTION, "Preview");
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		PageView pageView=(PageView)MainFrame.getInstance().getRightPanel().getDocumentView().getDesktop().getSelectedFrame();
		PageElement element=pageView.getPage().getSelectionModel().getSelectionList().get(0);
		ContentView cv=new ContentView();
		cv.setVisible(true);
		cv.setElement(element);
		ImageIcon icon=cv.setImageContent(cv.getElement().getImageUrl());
		cv.getLabel().setIcon(icon);
		String txt=element.getTextContent();
		cv.getLabel().setFont(cv.getFont());
		cv.getLabel().setText(txt);
		cv.revalidate();
		cv.repaint();
		cv.getBtnEdit().addActionListener(new EditController(cv,element));
		cv.getBtnOK().addActionListener(new OkController(pageView,cv));

			
	}
		

}
