package com.vaibhav.myImpl.Trees;

/**
 * @author vaibhavsharma
 *
 */
public class Node {

	private int value;

	private Node leftChild;

	private Node rightChild;

	private Node parent;

	public Node() {

		value = 0;
		leftChild = null;
		rightChild = null;

	}

	/*
	 * Node constructor with initial Node value
	 * 
	 * @param value Initial value for this node
	 */

	public Node(int key) {
		leftChild = null;
		rightChild = null;
		this.value = key;
	}

	public Node(Node left, Node right, int newValue) {

		this.value = newValue;
		this.leftChild = left;
		this.rightChild = right;
	}

	/**
	 * @return
	 */
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}

	public Node getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		String result = value + "";
		if (leftChild != null)
			result = leftChild.toString() + "-" + result;
		if (rightChild != null)
			result = result + "-" + rightChild.toString();

		return result;

	}
	
	public boolean isLessThan(Node b) {
		
		if(this.getValue() < b.getValue()) return true;
		else return false;
	}
	
	public boolean isGreaterThan(Node b) {
		
		if(this.getValue() > b.getValue()) return true;
		else return false;
	}
	
	public boolean isEqualTo(Node b) {
		
		if(this.getValue() == b.getValue()) return true;
		else return false;
	}
	
	
	public int compare(Node b) {
		
		if(this.isLessThan(b)) return -1;
		
		if(this.isGreaterThan(b)) return 1;
		
		if(this.isEqualTo(b)) return 0;
		
		return Integer.MIN_VALUE;
	}
	

}
