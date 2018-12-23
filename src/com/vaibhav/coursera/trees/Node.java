package com.vaibhav.coursera.trees;

public class Node {

	
	public int data;
		
	public Node left;
	
	public Node right; 
	
	public Node(){}
	
	
	public  Node(int data){
		
		this.data = data;
		this.left =null;
		this.right = null;
	}


	public int getData() {
		return data;
	}


	public void setData(int data) {
		this.data = data;
	}


	public Node getLeft() {
		return left;
	}


	public void setLeft(Node left) {
		this.left = left;
	}


	public Node getRight() {
		return right;
	}


	public void setRight(Node right) {
		this.right = right;
	}
}
