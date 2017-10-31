package softwareEng;

import static org.junit.Assert.*;

import org.junit.Test;

public class LCATests {
	
	
	//Binary Tree Test 
	//----------------------------------------
	@Test
	public void findTest() {
		binarySearchTree tree = new binarySearchTree();
		tree.addNode(27, "1st");tree.addNode(5, "2nd");tree.addNode(29, "3rd");
		assertTrue(tree.findNode(27));
		assertFalse(tree.findNode(18));
	}
	
	@Test
	public void testLCA (){
		binarySearchTree tree = new binarySearchTree();
		tree.addNode(6,"p");tree.addNode(4,"e");tree.addNode(1,"s");  
		tree.addNode(11,"g");tree.addNode(34,"l");tree.addNode(7,"q"); 
		tree.addNode(51,"7"); tree.addNode(5, "R");	
		
		Node test1 = tree.lca(tree.root, 4, 11);					
		assertEquals(6, test1.key);
		assertNotEquals(9,test1.key);
		
		Node test2 = tree.lca(tree.root, 7, 34);
		assertEquals(11, test2.key);
		assertNotEquals(9,test2.key);
		
		Node test3 = tree.lca(tree.root, 1, 5);
		assertEquals(4, test3.key);
		assertNotEquals(9,test3.key);
		
		Node test4 = tree.lca(tree.root, 11, 4);
		assertEquals(6, test4.key);
		assertNotEquals(9,test4.key);
		
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
		tree.addNode(1, "");tree.addNode(16, "");tree.addNode(40, "");

		Node test1 = tree.lca2(tree.root, 3, 8, 34);
		assertEquals(34, test1.key);
		
		Node test2 = tree.lca2(tree.root, 3, 8, 10);
		assertEquals(8, test2.key);
		
		Node test3 = tree.lca2(tree.root, 40, 1, 16);
		assertEquals(34, test3.key);
		
		Node test4 = tree.lca2(tree.root, 51, 60, 40);
		assertEquals(51, test4.key);

	}
	//-----------------------------------------------------
	//DAG Test
	@Test 
	public void isEmptyTest(){
		DAG<Integer> dag = new DAG<Integer>();
		assertEquals("Testing an empty DAG", dag.isEmpty(), true);
		dag.insert(10, null, null);
		assertEquals("Testing non empty DAG", dag.isEmpty(),false);
	}
	
	@Test
	public void insertTest(){
		
	}
}


