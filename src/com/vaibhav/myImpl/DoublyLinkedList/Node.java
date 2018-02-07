package com.vaibhav.myImpl.DoublyLinkedList;

public class Node {
	
	private int key;
	
	//Because a node in Singly linked list has to have the reference of next node as well in addition to the data it stores
	private Node nextNode;
	
	private Node previousNode;

	public Node getPreviousNode() {
		return previousNode;
	}

	public void setPreviousNode(Node previousNode) {
		this.previousNode = previousNode;
	}

	public int getData() {
		return key;
	}

	public void setData(int key) {
		this.key = key;
	}

	public Node getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}
	
	
}
