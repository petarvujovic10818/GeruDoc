package factory;

import tree.model.Project;

public class DocumentFactory extends NodeFactory{

	@Override
	public Node createNode(Object type) {
		Node node=null;
		if(type instanceof Project) node=new DocumentNode();
		return node;
	}

}
