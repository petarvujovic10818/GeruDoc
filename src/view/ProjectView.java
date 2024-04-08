package view;

import java.awt.BorderLayout;

import javax.swing.JLabel;

import iobserver.IListener;
import tree.model.Project;

public class ProjectView extends JLabel implements IListener{
	
	private Project project;
	
	public ProjectView(Project project) {
		this.project=project;
		setLayout(new BorderLayout());
		setHorizontalAlignment(HORIZONTAL);
		this.project.addObserver(this);
	}

	@Override
	public void update(Object event) {
		this.setText(((String)event).toString());
	}
}
