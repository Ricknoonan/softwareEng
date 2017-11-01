package softwareEng;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.ArrayList;
public class DAGTest {

	@Test
	public void testGetRoot() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetRoot() {
		fail("Not yet implemented");
	}

	@Test
	public void testLowestCommonAncestor() {
		DAG<Node> dag = new DAG<Node>();
		ArrayList<Node> aList = new ArrayList<>();
		assertNull(dag.lowestCommonAncestor(aList.get(9), aList.get(8)));
		for (int i = 0; i < 10; i++) {
			aList.add(new Node(i));
		}
		dag.setRoot(aList.get(0));
		aList.get(0).addEdge(aList.get(1));
		aList.get(0).addEdge(aList.get(2));
		aList.get(1).addEdge(aList.get(3));
		aList.get(1).addEdge(aList.get(4));
		aList.get(2).addEdge(aList.get(4));
		aList.get(2).addEdge(aList.get(5));
		aList.get(2).addEdge(aList.get(6));
		aList.get(5).addEdge(aList.get(8));
		aList.get(6).addEdge(aList.get(8));
		aList.get(6).addEdge(aList.get(7));
		aList.get(6).addEdge(aList.get(9));
		aList.get(7).addEdge(aList.get(9));
	}
}
