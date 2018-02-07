package com.vaibhav.myImpl.Trees;
import com.vaibhav.myImpl.Trees.Node;

public class BinaryTreeFullImpl {
	
	public Node root;
	
	public BinaryTreeFullImpl() {
		root = null;
	}
	
	public BinaryTreeFullImpl(Node r) {
		
		this.root = r;
	}
	
	
	public int getDepth(Node n) {
		
		if(n == null || root == null) return Integer.MIN_VALUE;
		
		int depth=0;
		while(n.getValue()!= root.getValue()) {
			n = n.getParent();
			depth++;
		}
		return depth;
		
		
	}
	
	
	public boolean isLeafNode(Node n) {
		
		if(n.getLeftChild() == null && n.getRightChild() == null) return true;
		else return false;
	}
	
	
	public boolean isInternalNode(Node n) {

		if(n.getLeftChild()!= null || n.getRightChild() != null) return true;
		else return false;
		
	}
	
	public boolean isFullInternalNode(Node n) {
		
		if(n.getLeftChild()!=null && n.getRightChild()!=null) return true;
		else return false;
	}
	
	
	public void insert(Node a) {
		
		if(a == null) return;
		
		if(root == null) {
		 
			root = a;
			root.setParent(null);
			System.out.println("insert() - Inserting the root Node"+" "+ a.getValue());
			return;
			
		 }
		boolean hasNodeBeenAdded = false;
		Node it = root;
		
		while(!hasNodeBeenAdded){
			
			switch(a.compare(it)) {
				
			     case -1:
			    	 		if(it.getLeftChild() == null) {
			    	 			it.setLeftChild(a);
			    	 			a.setParent(it);
			    	 			System.out.println("insert() - Inserting left child "+" "+ a.getValue());
			    	 			hasNodeBeenAdded = true;
			    	 		}
			    	 		else {
			    	 			it = it.getLeftChild();
			    	 			
			    	 		}
			    	 		break;
			    	 		
			    	 		
			     case 0:
			    	 
			    	       System.out.println("Error - insert() - Node Already Exists");
			    	       hasNodeBeenAdded = true;
			    	       break;
			    	       
			    	       
			     case 1:
			    	 		if(it.getRightChild()==null) {
			    	 			it.setRightChild(a);
			    	 			a.setParent(it);
			    	 			System.out.println("insert() - Inserting right child "+" "+ a.getValue());

			    	 			hasNodeBeenAdded = true;
			    	 		}
			    	 		else {
			    	 			it = it.getRightChild(); 
			    	 		}
			    	 		
			    	 		break;
			    	 		
			     case Integer.MIN_VALUE:
			    	 		System.out.println("Error - insert() - Invalid value.");
			    	 		hasNodeBeenAdded= true;
			    	 		break;
			
			}
			
			
		}
		
		
		}
	
	/*
	 * Traversal sequence--> visit Root --> Left Child --> Right Child
	 * */
	public void preOrderTraversal(Node curr) {
		
		if(curr == null) return;
		
		System.out.println("Root is "+ " "+ curr.getValue());
		preOrderTraversal(curr.getLeftChild());
		preOrderTraversal(curr.getRightChild());
		
		
	}
		

	/*
	 * Traversal sequence--> Left Child --> Visit Root --> Right Child
	 * */
	public void inOrderTraversal(Node curr) {
		
		if(curr == null) return;
		
		preOrderTraversal(curr.getLeftChild());
		System.out.println("Root is "+ " "+ curr.getValue());
		preOrderTraversal(curr.getRightChild());
		
		
	}
	
	/*
	 * Traversal sequence--> Left Child --> Right Child --> Visit Root 
	 * */
	public void postOrderTraversal(Node curr) {
		
		if(curr == null) return;
		
		preOrderTraversal(curr.getLeftChild());
		preOrderTraversal(curr.getRightChild());
		System.out.println("Root is "+ " "+ curr.getValue());
		
		
		
	}
	
}
	
	
	
	
