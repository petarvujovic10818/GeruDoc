package tree.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import app.MainFrame;

public class EditController implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		String[] choices= {"text","image"};
		String s=(String)JOptionPane.showInputDialog(MainFrame.getInstance(), "Izaberite sadrzaj", "ContentEditor", JOptionPane.PLAIN_MESSAGE, null, choices, null);
		if(s=="image") {
			JFileChooser file=new JFileChooser();
			int result=file.showSaveDialog(null);
			if(result==JFileChooser.APPROVE_OPTION) {
				String path=file.getSelectedFile().getAbsolutePath();
				
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
