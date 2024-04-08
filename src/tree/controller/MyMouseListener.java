package tree.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import app.MainFrame;
import view.MyPopUpMenu;

public class MyMouseListener implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount()==1 && e.getButton()==3) {
			MyPopUpMenu popUp=new MyPopUpMenu();
			popUp.show(MainFrame.getInstance().getMyTree(), e.getX(), e.getY());
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
