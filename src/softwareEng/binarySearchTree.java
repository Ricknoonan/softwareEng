package softwareEng;

public class binarySearchTree {
	
	Node root;

	class Node {
		int key;
		Node left, right;
		Node(int key){
			this.key = key;
		}
	}
		
	public void addNode(int key){
		Node newNode = new Node(key);
		if(root == null){
			newNode = root;
		}
		else{
		   Node focusNode = root;
		   Node parent;
		   while(true){
			   parent = focusNode;
			   if(key < focusNode.key){
			   		focusNode = focusNode.left;
			   		if(focusNode == null){
			   			parent.left = newNode;
			   			return;
			   		}
			   	}else{
				    focusNode = focusNode.right;
				    if(focusNode == null){
					    parent.right =  newNode;
					    return;
				   }
			   }
		   }
		}
	 }
}