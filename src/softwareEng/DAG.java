package softwareEng;

import java.util.ArrayList;
import java.util.Stack;

class Node2 {
	Integer data;
	ArrayList<Node2> Node2List;
	Node2(Integer value) { 
		data = value;
		Node2List = new ArrayList<Node2>();
	}
	public void addEdge(Node2 e) {
		Node2List.add(e);
	}
} 

public class DAG<T> { 
	private Node2 root;

	public Node2 getRoot() {
		return root;
	}

	public void setRoot(Node2 root) { 
		this.root = root;
	}

	private ArrayList<Node2> DFS(Node2 Node2, Node2 target, ArrayList<Node2> list, Stack<Node2> stack) {
		stack.push(Node2);
		for (Node2 theNode2 : Node2.Node2List) {
			if (theNode2.equals(target)) {
				list.addAll(stack);
				return list;
			}
			DFS(theNode2, target, list, stack);
		}
		stack.pop();
		return list;
	}

	public Node2 lowestCommonAncestor(Node2 n1, Node2 n2) {
		return lowestCommonAncestor(getRoot(), n1, n2);
	}

	private Node2 lowestCommonAncestor(Node2 Node2, Node2 n1, Node2 n2) {
		if (Node2 == null || n1 == null || n2 == null) {
			return null;
		}
		ArrayList<Node2> list1 = DFS(Node2, n1, new ArrayList<Node2>(), new Stack<Node2>());
		ArrayList<Node2> list2 = DFS(Node2, n2, new ArrayList<Node2>(), new Stack<Node2>());
		if (list1 == null || list2 == null) {
			return null;
		}
		ArrayList<Node2> minList; 
		ArrayList<Node2> maxList;
		if (list1.size() <= list2.size()) {
			minList = list1;
			maxList = list2;
		} else {
			minList = list2;
			maxList = list1;
		}
		ArrayList<Node2> set = new ArrayList<>();
		for (Node2 n : minList) {
			set.add(n);
		}
		for (int i = maxList.size() - 1; i >= 0; i--) {
			if (set.contains(maxList.get(i))) {
				return maxList.get(i);
			}
		}
		
		return null;
	}	
}