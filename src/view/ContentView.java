package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import app.MainFrame;
import content.ImageCreator;
import elements.PageElement;

public class ContentView extends JFrame implements ImageCreator{
	
	private JPanel panelBot;
	private JPanel panelLeft;
	private JPanel panelRight;
	private JPanel panelTop;
	private JPanel panelCenter;
	
	private JButton btnEdit;
	private JButton btnOK;
	
	private JLabel label;
	
	private PageElement element=null;
	
	private Font font=null;
	
	public ContentView() {
		this.label=null;
		this.setSize(new Dimension(500,500));
		this.setTitle("Content Editor");
		this.setLocationRelativeTo(MainFrame.getInstance().getRightPanel());
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		
		btnEdit=new JButton("Edit");
		btnOK=new JButton("OK");
		label=new JLabel();
		
		
		panelBot=new JPanel();
		panelLeft=new JPanel();
		panelRight=new JPanel();
		panelTop=new JPanel();
		panelCenter= new JPanel();
		
		panelLeft.setBackground(Color.LIGHT_GRAY);
		panelLeft.setPreferredSize(new Dimension(50,50));
		
		panelRight.setBackground(Color.LIGHT_GRAY);
		panelRight.setPreferredSize(new Dimension(50,50));
		
		panelBot.setBackground(Color.LIGHT_GRAY);
		panelBot.setPreferredSize(new Dimension(50,50));
		panelBot.add(btnEdit);
		panelBot.add(btnOK);
		
		panelTop.setBackground(Color.LIGHT_GRAY);
		panelTop.setPreferredSize(new Dimension(50,50));
		
		panelCenter.setBackground(Color.WHITE);
		panelCenter.add(label);
		
		this.add(panelLeft,BorderLayout.WEST);
		this.add(panelRight,BorderLayout.EAST);
		this.add(panelTop,BorderLayout.NORTH);
		this.add(panelBot,BorderLayout.SOUTH);
		this.add(panelCenter,BorderLayout.CENTER);
		
	}
	
	@Override
	public ImageIcon setImageContent(String url) {
			ImageIcon icon=new ImageIcon(url);
			Image img=icon.getImage();
			Image newImg=img.getScaledInstance(panelCenter.getWidth(), panelCenter.getHeight(), Image.SCALE_SMOOTH);
			ImageIcon image=new ImageIcon(newImg);
			return image;
			
	}
	
	public void setLblFont(Font font) {
		label.setFont(font);
	}
	
	public void setFont(Font font) {
		this.font = font;
	}
	
	public Font getFont() {
		return font;
	}
	
	public JButton getBtnEdit() {
		return btnEdit;
	}
	
	public JButton getBtnOK() {
		return btnOK;
	}
	
	public JPanel getPanelCenter() {
		return panelCenter;
	}
	
	public JLabel getLabel() {
		return label;
	}
	
	public PageElement getElement() {
		return element;
	}
	
	public void setElement(PageElement element) {
		this.element = element;
	}
}