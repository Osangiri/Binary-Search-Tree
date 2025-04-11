import java.util.*;
/**
 * Binary Search Tree
 */
public class BinarySearchTree{
	private TreeNode root;
	
	/**
	 * Constructor
	 */
	public BinarySearchTree(){
		root = null;
	}
	
	/**
	 * Searches the BST for the given value.
	 * 
	 * @param value the value to find
	 * @return true if the value exists in the BST
	 */
	public boolean contains(int value){
		return contains(value, root);
	}
	
	private boolean contains(int value, TreeNode node){
		if(node == null){
			return false;
		}
		if(value == node.getData()){
			return true;
		}
		if(value > node.getData()){
			return contains(value, node.getRight());
		}
		return contains(value, node.getLeft());
	}
	
	/**
	 * Adds a new value to the BST.
	 * 
	 * @param value The new value to be added to the BST.
	 */
	public void add(int value){
		root = add(value, root);
	}
	
	private TreeNode add(int value, TreeNode temp){
		if(temp == null){
			temp = new TreeNode(value);
		}
		else if(value <= temp.getData()){
			temp.setLeft(add(value, temp.getLeft()));
		}else{
			temp.setRight(add(value, temp.getRight()));
		}
		return temp;
	}
	/**
	 * Removes the given value from the BST.
	 * 
	 * @param value The value to remove
	 * @throws NoSuchElementException if the root is null.
	 */
	public void remove(int value){
		if(root == null){
			throw new NoSuchElementException();
		}
		root = remove(value, root);
	}
	private TreeNode remove(int value, TreeNode temp){
		if(temp == null){
			return temp;
		}
		if(value < temp.getData()){
			temp.setLeft(remove(value, temp.getLeft()));
		}else if(value > temp.getData()){
			temp.setRight(remove(value, temp.getRight()));
		}else{
			if(temp.getLeft()==null&& temp.getRight()==null){
				return null;
			}
			if(temp.getLeft()!=null && temp.getRight()==null){
				return temp.getLeft();
			}
			if(temp.getLeft()==null && temp.getRight()!=null){
				return temp.getRight();
			}
			temp.setData(max(temp.getLeft()));
			temp.setLeft(remove(temp.getData(), temp.getLeft()));
		}
		return temp;
	}
	private int max(TreeNode node){
		if(node == null){
			throw new IllegalArgumentException("max does not exist");
		}
		if(node.getRight() == null){
			return node.getData();
		}
		return max(node.getRight());
	}
	/**
	 * isFull method
	 * Full if node has 0 Or 2 children
	 * Empty tree is considered full
	 * @return true if binary tree is full and false if not
	 */
	public boolean isFull(){
		return isFull(root);
	}
	private boolean isFull(TreeNode node){
		if(node == null){
			return true;//true
		}
		if (node.getLeft() == null && node.getRight() == null )
		   return true;//true
		if (node.getLeft() != null && node.getRight() != null )
		   return isFull(node.getLeft())&& isFull(node.getRight()) ;
		
		return false;
		
	}
	/**
	 * removes leaves from trees
	 * not remove from empty
	 * 
	 */
	public void removeLeaves(){
		root = removeLeaves(root);
	}
	//helper method
	private TreeNode removeLeaves(TreeNode node){
		if(node == null){
			return null;
		}
		if(node.getLeft() == null && node.getRight() == null){
			return null;
		}
		//remove left and right recursively
		node.setLeft(removeLeaves(node.getLeft()));
		node.setRight(removeLeaves(node.getRight()));
		return node;
		
    }
    /**
     * compares a binary search tree with another
     * @param other the other binarytree to be compared
     * @return true if trees are equals and false if not
     * 
     */
     public boolean equals(BinarySearchTree other){
		 if (other instanceof BinarySearchTree) {
			BinarySearchTree otherTree = (BinarySearchTree) other;
			return equals(this.root, otherTree.root);
    }
    // Return false if other is not a BinarySearchTree
     return false;
}
	 private boolean equals(TreeNode node1, TreeNode node2){
		 if (node1 == null && node2 == null) {
			return true;
		 }	
		 if (node1 == null || node2 == null) {
			return false;
		 } 
		 return (node1.getData() == node2.getData()) &&
           equals(node1.getLeft(), node2.getLeft()) &&
           equals(node1.getRight(), node2.getRight());
}
    /**
     * 
     *@param min value
     *@param max value 
     */
	public void trim(int min, int max){  
		root = trim(root, min, max);
	}
	private TreeNode trim(TreeNode node, int min, int max){
		if (node == null) { 
         return null;
    }
		if(node.getData() < min){
			return trim(node.getRight(), min, max);
		 }
		if (node.getData() > max) {
			return trim(node.getRight(), min, max);
			 } 
		node.setLeft(trim(node.getLeft(), min, max));//recursively trim
        node.setRight(trim(node.getRight(), min, max));
        return node;
	}
	 
	/**
	 * Prints the BST to the terminal horizontally. 
	 */
	public void printBST(){
		printBST(root, "");
	}
	
	private void printBST(TreeNode temp, String padding){
		if(temp == null){
			return;
		}
		printBST(temp.getRight(), padding+ "   ");
		System.out.println(padding + temp.getData());
		printBST(temp.getLeft(), padding+ "   ");
	}
}
