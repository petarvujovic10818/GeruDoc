package tree.controller;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JDesktopPane;

import app.MainFrame;
import tree.model.Document;
import tree.model.Page;
import tree.model.Project;
import view.DocumentView;
import view.PageView;
import view.ProjectView;
import view.RightPanel;

public class MyMouseListener2 implements MouseListener{
	
	
	public MyMouseListener2() {
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		Object o=MainFrame.getInstance().getMyTree().getLastSelectedPathComponent();
		if(e.getClickCount()==2 && e.getButton()==1) {
			if(o instanceof Project) {
				Project project=(Project)o;
				ProjectView pw=new ProjectView(project);
				project.setName(project.getName());
				RightPanel rightPanel= MainFrame.getInstance().getRightPanel();
				
				rightPanel.removeAll();
				rightPanel.add(pw,BorderLayout.NORTH);
				
				DocumentView documentView=new DocumentView();
				rightPanel.setDocumentView(documentView);
				for(int i=0;i<project.getDocumentCount();i++) {
					Document document=project.getDocument(i);
					JDesktopPane panel=new JDesktopPane();
					documentView.setDocument(document,panel);
					rightPanel.revalidate();
					
					for(int j=0;j<document.getPageCount();j++) {
						Page page=document.getPage(j);
						PageView pageView=new PageView();
						pageView.setPage(page);
						panel.add(pageView);
						rightPanel.revalidate();
					}
					
				}
				rightPanel.addDocumentView(documentView);
				rightPanel.revalidate();
				
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