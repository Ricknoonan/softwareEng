package softwareEng;

import static org.junit.Assert.*;

import org.junit.Test;

public class binarySearchTreeTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testAdd(){
		binarySearchTree tree = new binarySearchTree();
		tree.addNode(1,"Richard");
		}
	
	@Test
	public void testLCA (){
		binarySearchTree tree = new binarySearchTree();
		tree.addNode(6,"p");
		tree.addNode(5,"e");
		tree.addNode(1,"s");
		tree.addNode(9,"g");
		assertEquals(6, tree.lca(tree.root, 5, 9));
	}
}
