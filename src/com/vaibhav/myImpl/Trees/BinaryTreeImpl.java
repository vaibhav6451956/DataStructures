package com.vaibhav.myImpl.Trees;

import com.vaibhav.myImpl.Trees.Node;

public class BinaryTreeImpl implements BinaryTree {

	private Node rootNode;

	public boolean isEmpty() {

		return rootNode == null;
	}

	
	@Override
	public void insert(int key) {
		insertNode(new Node(key));

	}

	public void insertNode(Node newNode) {
		if(rootNode == null) {
			rootNode = new Node(newNode.getValue());
		}
		else {
			
			insertNode(rootNode, newNode);
			
			
		}
		
	}
	
	//Insertion is done like a BST where small value goes to left and the greater one goes to the right
	public void insertNode(Node rootNode, Node newNode) {
		if(newNode.getValue() < rootNode.getValue()) {
			
			if(rootNode.getLeftChild() == null) {
				rootNode.setLeftChild(newNode);
			}
			else {
				insertNode(rootNode.getLeftChild(), newNode);//Now cz rootNode's left isnt empty
				//we'll go to the left child of root and check if has an empty space depending on the value
				//comparison with newNode and adjust accordingly.
			}
		}
		
		if(newNode.getValue() > rootNode.getValue()) {
			if(rootNode.getRightChild() == null) {
				rootNode.setRightChild(newNode);
			}
			else {
				insertNode(rootNode.getRightChild(), newNode);
			}
			
		}
		
		
	}

	
	@Override
	public boolean containsValue(int key) {
		if(getNode(rootNode, key ) == null)
		return false;
		
	 return true;
	}
	
	public Node getNode(Node rootNode , int value) {
		
		if(rootNode == null) return null;
		
		if(rootNode.getValue() == value) return rootNode;
		
		if(rootNode.getValue() > value)
		{
			return getNode(rootNode.getLeftChild(), value);
		}
		
		return getNode(rootNode.getRightChild(), value);
		
	}

	@Override
	public String toString() {
		
		if(rootNode !=null) {
			
			return rootNode.toString();
		}
		return "";
	}


	@Override
	public boolean isLeafNode(Node n) {
		
		if(n.getLeftChild() == null && n.getRightChild() == null) return true;
		else return false;
	}

}
