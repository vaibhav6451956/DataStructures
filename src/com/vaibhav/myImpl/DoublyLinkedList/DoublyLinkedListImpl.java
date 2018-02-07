package com.vaibhav.myImpl.DoublyLinkedList;

import com.vaibhav.myImpl.DoublyLinkedList.Node;


public class DoublyLinkedListImpl implements List {
	
	private static int  len = 0;
	
	private Node head;
	
	private Node tail;

	public static int getLen() {
		return len;
	}

	public static void setLen(int len) {
		DoublyLinkedListImpl.len = len;
	}

	@Override
	public void pushFront(int key) {
		Node n = new Node();
		n.setData(key);
		len=len+1;
		
		
		if(head == null) {
			n.setNextNode(null);
			n.setPreviousNode(null);
			head = n;
			tail = n;
		}
		else {
			Node old_head = head;
			head = n;
			head.setNextNode(old_head);
			head.setPreviousNode(null);
			old_head.setPreviousNode(head);
			
		}
		
	}

	@Override
	public int topFront() {
		return head.getData();
	}

	@Override
	public int popFront() {
		len=len-1;
		int orig_head = head.getData();
		head = head.getNextNode();
		
		head.setPreviousNode(null);
		
		return orig_head;
	}

	@Override
	public void pushBack(int key) {
		Node n = new Node();
		n.setData(key);
		len=len+1;
		
		if(tail == null) {
			n.setPreviousNode(null);
			n.setNextNode(null);
			head = n;
			tail = n;
			
			
		}
		
		else {
			Node old_tail = tail;
			tail = n;
			tail.setNextNode(null);
			tail.setPreviousNode(old_tail);
			old_tail.setNextNode(tail);
			
			
		}
	}

	@Override
	public int topBack() {
	
		return tail.getData();
	}

	@Override
	public int popBack() {
		len=len-1;
		int orig_tail = tail.getData();
		tail = tail.getPreviousNode();
		tail.setNextNode(null);
		return orig_tail;
	}

	@Override
	public boolean find(int key) {
		Node n = head;
		for(int i =0; i <len; i++) {
			
			if(n.getData() == key) {
				return true;
			}
			n = n.getNextNode();
		}
		return false;
	}

	@Override
	public boolean delete(int key) {
		boolean exists = find(key);
		
		if(!exists) { 
			System.out.println("The element you are trying to delete does not exist in the list!");
			return false;
		}
		else {
			Node n = head;
			for(int i =0; i <len; i++) {
				
				if(n.getData() == key) {
					Node prev_node = n.getPreviousNode();
					prev_node.setNextNode(n.getNextNode());
					n.getNextNode().setPreviousNode(prev_node);
					return true;
				}
				n = n.getNextNode();
			}
			return true;
		}
		
	}

	@Override
	public boolean isEmpty() {
		if(head == null) return true;
		else return false;
	}

	/*
	 * Left to be implemented later
	 * */
	@Override
	public void addBefore(Node n, int key) {

		
		
	}
	

	/*
	 * Left to be implemented later
	 * */

	@Override
	public void addAfter(Node n, int key) {
		// TODO Auto-generated method stub
		
	}
	
	public int head() {
		
		return head.getData();
	}

	public int tail() {
		
		return tail.getData();
	}

}
