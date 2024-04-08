package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import iobserver.IListener;

public class RightPanel extends JPanel{
	
	private DocumentView documentView;
	
	public RightPanel() {
		setBackground(Color.GRAY);
		setMinimumSize(new Dimension(150,150));
		setLayout(new BorderLayout());
	}
	
	public void setDocumentView(DocumentView documentView) {
		this.documentView = documentView;
		//this.add(documentView);
	}
	
	public void addDocumentView(DocumentView documentView) {
		this.add(documentView);
	}
	
	public DocumentView getDocumentView() {
		return documentView;
	}

}