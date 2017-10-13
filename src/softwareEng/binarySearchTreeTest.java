package softwareEng;

import static org.junit.Assert.*;

import org.junit.Test;

public class binarySearchTreeTest {

	@Test
	public void findTest(){
		
	}
	
	@Test
	public void addTest() {
		binarySearchTree tree = new binarySearchTree();
		tree.addNode(27, "FirstNode");
		assertTrue(tree.findNode(27));
		assertFalse(tree.findNode(18));
	}
	
	@Test
	public void testLCA (){
		binarySearchTree tree = new binarySearchTree();
		tree.addNode(6,"p");tree.addNode(5,"e");tree.addNode(1,"s");tree.addNode(11,"g");
		tree.addNode(34,"l");tree.addNode(7,"q");tree.addNode(51,"7");	
		
		Node test = tree.lca(tree.root, 5, 11);
		assertEquals(6, test.key);
		assertNotEquals(9,test.key);
	}

	@Test
	public void testOrderedLCA(){
		binarySearchTree tree = new binarySearchTree();
		tree.addNode(6,"p");tree.addNode(8,"e");tree.addNode(10,"s");
		tree.addNode(34,"l");tree.addNode(42,"q");tree.addNode(51,"7");
		
		Node test = tree.lca(tree.root, 6,8);
		assertEquals (6, test.key);
		
	}
	
	@Test
	public void testMinusNumber(){
		binarySearchTree tree = new binarySearchTree();
		tree.addNode(-7,"p");tree.addNode(-6,"e");tree.addNode(10,"s");
		tree.addNode(34,"l");tree.addNode(-8,"q");tree.addNode(51,"7");
		
		Node test = tree.lca(tree.root, -8, 34);
		assertEquals(-7, test.key);
	}
	
	@Test
	public void testMoreThanTwo(){
		binarySearchTree tree = new binarySearchTree();
		tree.addNode(34,"p");tree.addNode(8,"e");tree.addNode(10,"s");
		tree.addNode(3,"l");tree.addNode(4,"q");tree.addNode(51,"7");
		tree.addNode(45,"7");tree.addNode(20,"7");tree.addNode(60,"7");
		
		Node test = tree.lca2(tree.root, 3, 10, 20);
		assertEquals(8, test.key);
	}
}
