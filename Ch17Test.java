import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.*;
import java.lang.*;

/**
 * JUnit Tests for Chapter 17
 */

public class Ch17Test {
	
	private BinarySearchTree emptyTree;
    private BinarySearchTree singleNodeTree;
    private BinarySearchTree fullTree;
    private BinarySearchTree notFullTreeOneChild;
    private BinarySearchTree notFullTree2;
	/**
	 * Reset the base data structures just in case
	 */
	@BeforeEach 
	void reset(){
		emptyTree = new BinarySearchTree();
		
		singleNodeTree = new BinarySearchTree();
        singleNodeTree.add(8);
        
        fullTree = new BinarySearchTree();
        fullTree.add(10);
        fullTree.add(5);
        fullTree.add(16);
        fullTree.printBST();
		
		notFullTreeOneChild = new BinarySearchTree();
        notFullTreeOneChild.add(16);
        notFullTreeOneChild.add(2);//one child
        
        notFullTree2 = new BinarySearchTree();
        notFullTree2.add(1);
        notFullTree2.add(2);
        notFullTree2.add(3);
        notFullTree2.add(4); // Left side only has one child
        
	}
	
	
	/**
	 * Tests the isFull method
	 */
	 @Test
	 public void testisFull(){
		 assertTrue(emptyTree.isFull(), "Empty tree should be considered full");
		 assertTrue(singleNodeTree.isFull(), "tree with only a root node should be full");
		 assertTrue(fullTree.isFull(), "Tree with a root and two children should be full");
		 assertFalse(notFullTreeOneChild.isFull(), "Tree with a node having one child should not be considered full");
		 assertFalse(notFullTree2.isFull(), "Tree with a node having one child should not be considered full");
	 }
	 /**
	 * Tests Equals method
	 */
	 @Test
	 public void testEquals(){
		assertEquals(fullTree, fullTree); 
		 
	 }
	  /**
	 * Tests removeLeaves method
	 */
	 @Test
	 public void testremoveLeaves(){
		emptyTree.removeLeaves();
        assertFalse(emptyTree.contains(10), "An empty tree should remain empty after removing leaves.");
		fullTree.removeLeaves();
        assertFalse(fullTree.contains(5), "Leaf nodes should be removed from the tree.");
        assertFalse(fullTree.contains(16), "Leaf nodes should be removed from the tree.");
        assertTrue(fullTree.contains(10), "Root node should remain if it is not a leaf.");
		singleNodeTree.removeLeaves();
        assertFalse(singleNodeTree.contains(8), "A single-node tree should become empty after removing leaves.");
	 }
	  /**
	 * Tests trim method
	 */
	 @Test
	 public void testtrim(){
		singleNodeTree.trim(5, 10);
		assertTrue(singleNodeTree.contains(8), "single node should be empty after trim");
		fullTree.trim(9, 10);
		assertFalse(fullTree.contains(8), "full tree should not contain value in the range 1-10 after trim");
		notFullTreeOneChild.trim(6,15);
		assertFalse(fullTree.contains(5), "full tree should not contain value in the range 1-10 after trim");
		assertTrue(fullTree.contains(10), "Nodes within the range should remain.");
        assertFalse(fullTree.contains(16), "Nodes outside the range should be removed.");
		
		 
	 }
}
