package softwareEng;

import java.util.ArrayList;
import java.util.Stack;

   public class DAG<T> {
	    
	   public class Node {
			int data;
		    Node left, right;
		    ArrayList<Node> nodeList;
		    
		    Node(int value) { 
		        data = value;
		        left = right = null;
		        nodeList = new ArrayList<Node>();
		    }
		    
		    public void addEdge(Node e) {
		        nodeList.add(e);
		    }
		}
	   
	   private Node root;
	    
	    //Getter and Setter Function
	    public Node getRoot() {
			return root;
		}

		public void setRoot(Node root) {
			this.root = root;
		}
		
		private ArrayList<Node> DFS(Node node, Node target, ArrayList<Node> list, Stack<Node> stack) {
	        stack.push(node);
	        for (Node theNode : node.nodeList) {
	            if (theNode.equals(target)) {
	                list.addAll(stack);
	                return list;
	            }
	            DFS(theNode, target, list, stack);
	        }
	        stack.pop();
	        return list;
	    }
		 
		public Node lowestCommonAncestor(Node n1, Node n2) {
			         return lowestCommonAncestor(getRoot(), n1, n2);
			     }
			 
			 private Node lowestCommonAncestor(Node node, Node n1, Node n2) {
			         if (node == null || n1 == null || n2 == null) {
			             return null;
			         }
			         ArrayList<Node> list1 = DFS(node, n1, new ArrayList<DAG<T>.Node>(), new Stack<DAG<T>.Node>());
			         ArrayList<Node> list2 = DFS(node, n2, new ArrayList<DAG<T>.Node>(), new Stack<DAG<T>.Node>());
			         if (list1 == null || list2 == null) {
			             return null;
			         }
			         ArrayList<Node> minList; 
			         ArrayList<Node> maxList;
			         if (list1.size() <= list2.size()) {
			             minList = list1;
			             maxList = list2;
			         } else {
			             minList = list2;
			             maxList = list1;
			         }
			         ArrayList<Node> set = new ArrayList<>();
			         for (Node n : minList) {
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