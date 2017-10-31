package softwareEng;
import java.util.Arrays;

	public class DAG <Value> {
		private class Node {
			private Value val;					
			private Node[] successors;			
		
			public Node(Value val) {
				this.val = val;
			}
		}
		
		private Node[] nodeList = new DAG.Node[0];	
		
		public boolean isEmpty() {
			if(nodeList.length == 0){
				return true;
			}else{
				return false;
			}
		}
		public boolean find(Value v){
			boolean inList = false;
			for(int i=0; i<nodeList.length;i++){
				if(nodeList[i].val==v){
					inList = true;
					break;
				}else{
					inList= false;
				}	
			}
			return inList;
		}
		public void insert(Value v, Value fromVal, Value toVal) {	
			Node n = new Node(v);
			Node from = getNodefromVal(fromVal);
			Node to = getNodefromVal(toVal);
			if (fromVal != null) {
				from.successors = extendArrayByOne(from.successors);
				from.successors[from.successors.length-1] = n;
				if (from.val == null) {
					addNode(from);
				}
			}
			if (toVal != null) {
				n.successors = extendArrayByOne(n.successors);
				n.successors[n.successors.length-1] = to;
				if (to.val == null) {
					addNode(to);
				}
			}
			addNode(n);		
		}
		public Node getNodefromVal (Value v){
			Node returnNode = new Node(null); 				
			for (int i=0; i<nodeList.length; i++){
				if (nodeList[i].val == v){
					returnNode = nodeList[i];
					break;			
				}	
			}
			return returnNode;
		}
		public void addNode (Node n) {
			nodeList = extendArrayByOne(nodeList);
			nodeList[nodeList.length-1] = n;
		}
		
		public Node[] extendArrayByOne(Node[] originalArray) {
			Node[] copyArray = new DAG.Node[originalArray.length+1];
			System.arraycopy(originalArray, 0, copyArray, 0, originalArray.length);
			return copyArray;
		}
	}

