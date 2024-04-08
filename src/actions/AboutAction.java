package actions;

import java.awt.event.ActionEvent;

import app.MainFrame;
import view.AboutDialog;

public class AboutAction extends AbstractGetAction {

	public AboutAction() {
		super();
		putValue(NAME,"Tim_204_01");
		putValue(SHORT_DESCRIPTION,"Tim_204_01");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		AboutDialog aboutDialog=new AboutDialog(MainFrame.getInstance());
		aboutDialog.setVisible(true);
	}
	
}
