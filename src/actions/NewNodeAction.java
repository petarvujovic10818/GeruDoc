package actions;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import app.MainFrame;
import factory.DocumentFactory;
import factory.NodeFactory;
import factory.PageFactory;
import factory.ProjectFactory;
import tree.model.Document;
import tree.model.Project;
import tree.model.Workspace;

public class NewNodeAction extends AbstractGetAction{
	
	public NewNodeAction() {
		putValue(SMALL_ICON,new ImageIcon("images/new_document_icon.png"));
		putValue(NAME, "New node");
		putValue(SHORT_DESCRIPTION, "New node");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object x=MainFrame.getInstance().getMyTree().getLastSelectedPathComponent();
		NodeFactory nf=returnNodeFactory(x);
		nf.deliverNode(x);
	}
	
	private static NodeFactory returnNodeFactory(Object o) {
		if(o instanceof Workspace) return new ProjectFactory();
		else if(o instanceof Project) return new DocumentFactory();
		else if(o instanceof Document) return new PageFactory();
		return null;
	}

}
