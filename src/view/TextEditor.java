package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import content.TextCreator;
import view.controller.FontController;

public class TextEditor extends JFrame implements TextCreator{
	
	private JButton btnConfirm;
	private JToolBar toolBar;
	private JTextPane txtArea;
	
	private JButton btnOk;
	private ArrayList<String>list=new ArrayList<>();
	private ArrayList<String>list2=new ArrayList<>();
	private JComboBox comboBox;
	private JComboBox comboBox2;
	
	private String fontName;
	private int fontStyle;
	private int fontSize;
	
	private Font font=null;
	
	public TextEditor() {
		this.setSize(new Dimension(500,500));
		this.setTitle("TextEditor");
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		int x=10;
		for(int i=0;i<11;i++) {
			list.add(Integer.toString(x));
			x+=2;
		}
		list2.add("Plain");
		list2.add("Bold");
		list2.add("Italic");
		btnOk=new JButton("OK");
		btnOk.addActionListener(new FontController(this));
		comboBox=new JComboBox(list.toArray());
		comboBox2=new JComboBox(list2.toArray());
		toolBar=new JToolBar(SwingConstants.HORIZONTAL);
		toolBar.setFloatable(true);
		toolBar.setBackground(Color.BLUE);
		toolBar.addSeparator();
		toolBar.add(comboBox2);
		toolBar.addSeparator();
		toolBar.add(comboBox);
		toolBar.addSeparator();
		toolBar.add(btnOk);
		txtArea=new JTextPane();
		btnConfirm=new JButton("Confirm");
		JScrollPane scroll=new JScrollPane(txtArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.add(toolBar,BorderLayout.NORTH);
		this.add(btnConfirm,BorderLayout.SOUTH);
		this.add(scroll,BorderLayout.CENTER);
	}
	
	public void setTxtFont(Font font) {
		txtArea.setFont(font);
	}
	
	@Override
	public String setTextContent() {
		return txtArea.getText();
	}
	
	public JTextPane getTxtArea() {
		return txtArea;
	}
	
	public JButton getBtnConfirm() {
		return btnConfirm;
	}
	
	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}
	public int getFontSize() {
		return fontSize;
	}
	
	public void setFontStyle(int fontStyle) {
		this.fontStyle = fontStyle;
	}
	
	public int getFontStyle() {
		return fontStyle;
	}
	public void setFontName(String fontName) {
		this.fontName = fontName;
	}
	public String getFontName() {
		return fontName;
	}
	
	public JComboBox getComboBox() {
		return comboBox;
	}
	
	public JComboBox getComboBox2() {
		return comboBox2;
	}
	
	public void setFont(Font font) {
		this.font = font;
	}
	
	public Font getFont() {
		return font;
	}
}
