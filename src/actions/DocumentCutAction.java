package actions;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

public class DocumentCutAction extends AbstractGetAction{
	
	public DocumentCutAction() {
		putValue(SMALL_ICON,new ImageIcon("images/cut_icon.png"));
		putValue(NAME, "DocumentCut");
		putValue(SHORT_DESCRIPTION, "DocumentCut");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
