package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

public class LeftPanel extends JPanel{
	
	public LeftPanel() {
		super();
		setLayout(new FlowLayout(FlowLayout.LEFT));
		setMinimumSize(new Dimension(150,150));
		setBackground(Color.WHITE);
	}

}
