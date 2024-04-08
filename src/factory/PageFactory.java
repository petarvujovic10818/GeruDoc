package factory;

import tree.model.Document;

public class PageFactory extends NodeFactory{

	@Override
	public Node createNode(Object type) {
		Node node=null;
		if(type instanceof Document) node=new PageNode();
		return node;
	}

}
