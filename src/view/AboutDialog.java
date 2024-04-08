package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AboutDialog extends JDialog{
	
	private JFrame parent;
	
		public AboutDialog(JFrame parent) {
			super(parent,true);
			setSize(600,350);
			setTitle("About Me");
			setLocationRelativeTo(parent);
			setLayout(new BorderLayout());
			
			JPanel panelPetar=new JPanel(new BorderLayout());
			
			JLabel lblPetar=new JLabel("Petar Vujovic RN 108/18");
			lblPetar.setHorizontalAlignment(JLabel.CENTER);
			panelPetar.add(lblPetar,BorderLayout.NORTH);
			
			ImageIcon imgIcon2=new ImageIcon("images/Petar_Vujovic.png");
			JLabel lblPic2=new JLabel(imgIcon2);
			
			panelPetar.add(lblPic2,BorderLayout.CENTER);
			
			add(panelPetar,BorderLayout.CENTER);
		}
}