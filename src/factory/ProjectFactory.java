package factory;

import tree.model.Workspace;

public class ProjectFactory extends NodeFactory{

	@Override
	public Node createNode(Object type) {
		Node node=null;
		if(type instanceof Workspace) node=new ProjectNode();
		return node;
	}

	

}
