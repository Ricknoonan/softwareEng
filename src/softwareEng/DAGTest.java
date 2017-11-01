package softwareEng;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;

public class DAGTest {

	@Test
	public void testLowestCommonAncestor() {
		DAG<Node2> dag = new DAG<Node2>();
		ArrayList<Node2> aList = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			aList.add(new Node2(i));
		}
		dag.setRoot(aList.get(0));
		aList.get(0).addEdge(aList.get(1));
		aList.get(1).addEdge(aList.get(2));
		aList.get(1).addEdge(aList.get(3));
		aList.get(2).addEdge(aList.get(4));
		aList.get(2).addEdge(aList.get(6));
		aList.get(3).addEdge(aList.get(4));
		aList.get(3).addEdge(aList.get(6));
		aList.get(4).addEdge(aList.get(5));
		aList.get(5).addEdge(aList.get(6)); 
		aList.get(5).addEdge(aList.get(8));
		aList.get(6).addEdge(aList.get(8));
		assertEquals("Check LCA for 2 and 3, ans: 1", aList.get(1),dag.lowestCommonAncestor(aList.get(2),aList.get(3)));
		assertEquals("Check LCA for 2 and 3, ans: 1", aList.get(1),dag.lowestCommonAncestor(aList.get(4),aList.get(3)));
	}

	@Test
	public void nullTester() {
		DAG<Node2> dag = new DAG<Node2>();
		ArrayList<Node2> aList = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			aList.add(new Node2(i));
		}
		dag.setRoot(aList.get(0));
		aList.get(0).addEdge(aList.get(1));
		aList.get(1).addEdge(aList.get(2));
		aList.get(1).addEdge(aList.get(3));
		aList.get(2).addEdge(aList.get(4));
		aList.get(2).addEdge(aList.get(6));
		aList.add(new Node2(null));
		assertNull("Checks two null nodes passed", dag.lowestCommonAncestor(aList.get(2), null));
		assertNull("Checks one null node passed", dag.lowestCommonAncestor(null, null));
		
		

	}
}
