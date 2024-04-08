package factory;

public abstract class NodeFactory {
	
	public Node deliverNode(Object type) {
		Node node;
		node=createNode(type);
		node.newNode(type);
		return node;
	}
	
	public abstract Node createNode(Object type);
	
}
