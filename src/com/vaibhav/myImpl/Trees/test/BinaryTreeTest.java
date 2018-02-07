package com.vaibhav.myImpl.Trees.test;

import com.vaibhav.myImpl.Trees.*;


public class BinaryTreeTest {
	
	public static void main(String args[]) {
		
//		 BinaryTree myTree = new BinaryTreeImpl();
//		    myTree.insert(10);
//		    myTree.insert(11);
//		    myTree.insert(9);
//		    myTree.insert(20);
//		    myTree.insert(15);
//		    System.out.println(myTree.toString());
//		    System.out.println(myTree.containsValue(10));
//		    
//		    Node n = new Node(15);
//		    
//		    System.exit(0);
//		
		
		Node a = new Node(10);
		Node b = new Node(11);
		Node c = new Node(9);
		Node d = new Node(40);
		Node e = new Node(3);
		Node f = new Node(7);
		
		Node g = new Node(1);
		Node h = new Node(15);
		Node i = new Node(17);
		
		Node j = new Node(4);
		Node k = new Node(20);
		Node l = new Node(25);
		
		
		
		BinaryTreeFullImpl bt = new BinaryTreeFullImpl();
		bt.insert(a);
		bt.insert(b);
		bt.insert(c);
		bt.insert(d);
		bt.insert(e);
		bt.insert(f);
		bt.insert(g);
		bt.insert(h);
		bt.insert(i);
		bt.insert(j);
		bt.insert(k);
		bt.insert(l);
		
		
	}
}
