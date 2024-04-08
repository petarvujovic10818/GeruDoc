package view.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import elements.PageElement;
import view.ContentView;
import view.TextEditor;

public class ConfirmController implements ActionListener{
	
	private TextEditor txtEditor;
	private ContentView cv;
	private PageElement element;
	
	public ConfirmController(TextEditor txtEditor,ContentView cv,PageElement element) {
		this.txtEditor=txtEditor;
		this.cv=cv;
		this.element=element;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String tekst=txtEditor.getTxtArea().getText();
		element.setTextContent(tekst);
		cv.setLblFont(txtEditor.getFont());
		cv.setFont(txtEditor.getFont());
		//cv.setFont(txtEditor.getFont());
		//System.out.println(txtEditor.getFont().toString());
		cv.getLabel().setText(element.getTextContent());
		txtEditor.dispose();
	}

}
