package view.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.ContentView;
import view.PageView;

public class OkController implements ActionListener{
	
	private PageView pageView;
	private ContentView cv;
	
	public OkController(PageView pageView,ContentView cv) {
		this.pageView=pageView;
		this.cv=cv;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		cv.dispose();
		pageView.revalidate();
		pageView.repaint();
	}

}
