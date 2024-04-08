package view;

import java.util.ArrayList;

import javax.swing.JDesktopPane;
import javax.swing.JTabbedPane;

import iobserver.IListener;
import tree.model.Document;

public class DocumentView extends JTabbedPane implements IListener{
	
	private Document document;
	
	private JDesktopPane desktop;
	
	public DocumentView() {
		
	}

	@Override
	public void update(Object event) {
		
	}
	
	public void setDocument(Document document,JDesktopPane desktop) {
		this.document=document;
		
		this.addTab(this.document.getName(),this.desktop=desktop);
	}
	
	public JDesktopPane getDesktop() {
		return desktop;
	}
	
}
