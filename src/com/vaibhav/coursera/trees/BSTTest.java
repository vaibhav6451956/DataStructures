package com.vaibhav.coursera.trees;

public class BSTTest {
	
	
	public static void main(String args[]){
		
		
		
		BinarySearchTreeImpl bst = new BinarySearchTreeImpl();
		
		bst.insert(10);
		bst.insert(9);
		bst.insert(11);
		bst.insert(34);
		bst.insert(4);
		bst.insert(0);
		bst.insert(7);
		bst.insert(14);
		bst.insert(99);
		bst.insert(123);
		bst.insert(97);
		bst.insert(554);
		bst.insert(78);
		bst.insert(6);

		
		
		bst.printTree();
		
		System.out.println("Size of the tree is:"+ bst.size());
		
	}

}
