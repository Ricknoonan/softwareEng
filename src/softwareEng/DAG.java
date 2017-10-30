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
		/*public boolean contains(Value v){
			
		}
		
		public void put(Value v, Value fromVal, Value toVal) {
			
		}
		*/
	}

