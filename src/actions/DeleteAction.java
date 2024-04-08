package actions;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import app.MainFrame;
import tree.model.Document;
import tree.model.Page;
import tree.model.Project;

public class DeleteAction extends AbstractGetAction {

	public DeleteAction() {
		putValue(SMALL_ICON,new ImageIcon("images/delete_icon.png"));
		putValue(NAME, "Delete");
		putValue(SHORT_DESCRIPTION, "Delete");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
			Object x =MainFrame.getInstance().getMyTree().getLastSelectedPathComponent();
			if(x instanceof Project) {
				String options[]= {"Prebaciti","Ostaviti"};
				int c=JOptionPane.showOptionDialog(null, "Sta sa dokumentima", "Izaberite Odgovor", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, null);
				if(c==0) {
					System.out.println("prebaciti");
					String s=JOptionPane.showInputDialog("Unesite ime projekta");
					Project proj=((Project)x).getRoditelj().projekatPoImenu(s);
					ArrayList<Document>documents=((Project)x).getDocuments();
					for(Document d:documents) {
						proj.add(d);
					}
				} else if(c==1) {
					System.out.println("ostaviti");
				} else System.out.println("Nista");
				((Project) x).getRoditelj().remove((Project)x);
				SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
			} else if(x instanceof Document) {
				((Document) x).getRoditelj().remove((Document)x);
				SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
			} else if(x instanceof Page) {
				((Page) x).getRoditelj().remove((Page)x);
				SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMyTree());
			}
		}
	
}
