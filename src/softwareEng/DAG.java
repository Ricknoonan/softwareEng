package softwareEng;

	public class DAG{
		private class Node {
			private Node val;					
			private Node[] successors;			
		
			public Node(Node val) {
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
		public boolean find(Node v){
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
		public void insert(Node v, Node fromVal, Node toVal) {	
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
		public Node getNodefromVal (Node v){
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

