package view.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import elements.PageElement;
import view.ContentView;
import view.TextEditor;

public class EditController implements ActionListener{
	
	private ContentView cv;
	private PageElement element;
	
	public EditController(ContentView cv,PageElement element) {
		this.cv=cv;
		this.element=element;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String[] poss= {"text","image"};
		String s=(String)JOptionPane.showInputDialog(cv, "Erande yuki", "Choose Content", JOptionPane.PLAIN_MESSAGE, null, poss, null);
		if(s.equals("image")) {
		JFileChooser jfc=new JFileChooser();
		int result = jfc.showSaveDialog(null);
		if(result==JFileChooser.APPROVE_OPTION) {
			element.setType("image");
			ImageIcon icon=cv.setImageContent(jfc.getSelectedFile().getAbsolutePath());
			cv.getLabel().setIcon(icon);
			cv.revalidate();
			cv.repaint();
			cv.getElement().setImageUrl(jfc.getSelectedFile().getAbsolutePath());
		} else if(result==JFileChooser.CANCEL_OPTION) {
			System.out.println("No file selected");
		}
	}else if(s.equals("text")) {
		element.setType("text");
		TextEditor txtEditor=new TextEditor();
		txtEditor.setLocationRelativeTo(cv);
		txtEditor.setVisible(true);
		
		txtEditor.getBtnConfirm().addActionListener(new ConfirmController(txtEditor,cv,element));
	}
	}
}
