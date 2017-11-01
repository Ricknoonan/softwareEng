package softwareEng;

public class binarySearchTree {

	Node root = null;

	public void addNode(int key, String name) {
		Node newNode = new Node(key, name);
		if (root == null) {
			root = newNode;
		} else {
			Node focusNode = root;
			Node parent;
			while (true) {
				parent = focusNode;
				if (key < focusNode.key) {
					focusNode = focusNode.leftChild;
					if (focusNode == null) {
						parent.leftChild = newNode;
						return;
					}
				} else { 
					focusNode = focusNode.rightChild;
					
					if (focusNode == null) {
						parent.rightChild = newNode;
						return; 
					}
				}
			}
		}
	}
	
	public boolean findNode(int key) {
		Node focusNode = root;
		while (focusNode.key != key) {
			if (key < focusNode.key) {
				focusNode = focusNode.leftChild;
			} else {
				focusNode = focusNode.rightChild;
			}
			if (focusNode == null)
				return false;
		}
		return true;
	}

	public Node lca(Node node, int n1, int n2) 
    {
        if (node == null)
            return null;
  
        if (node.key > n1 && node.key > n2)
            return lca(node.leftChild, n1, n2);
  
        if (node.key < n1 && node.key < n2) 
            return lca(node.rightChild, n1, n2);
  
        return node;
    }
	
	public Node lca2(Node node, int n1, int n2, int n3){
		if(node == null){
			return null;
		}
		if(node.key > n1 && node.key > n2 && node.key > n3){
			return lca2(node.leftChild, n1, n2, n3);
		}
		if(node.key < n1 && node.key < n2 && node.key < n3){
			return lca2(node.rightChild, n1, n2, n3);
		}
		return node;
	}
}
/*
	class Node {
		int key;
		String name;

		Node leftChild;
		Node rightChild;

		Node(int key) {
			this.key = key;
			this.name = name;
	}
}
*/

