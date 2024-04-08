package view.controller;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.TextEditor;

public class FontController implements ActionListener{
	
	private TextEditor txtEditor;
	
	public FontController(TextEditor txtEditor) {
		this.txtEditor=txtEditor;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int style=0;
		String name=txtEditor.getComboBox2().getSelectedItem().toString();
		int size=Integer.parseInt(txtEditor.getComboBox().getSelectedItem().toString());
		if(name.equals("Bold")) {
			style=Font.BOLD;
		}else if(name.equals("Plain")) {
			style=Font.PLAIN;
		}else if(name.equals("Italic")) {
			style=Font.ITALIC;
		}
		
		Font font=new Font(name,style,size);
		txtEditor.setTxtFont(font);
		txtEditor.setFont(font);
		txtEditor.revalidate();
		txtEditor.repaint();
	}

}
