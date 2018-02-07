package com.vaibhav.myImpl.Stack;
import com.vaibhav.myImpl.SinglyLinkedList.*;

public class StackImpl_LinkedList implements Stack {

	LinkedList<String> list = new LinkedList<String>();
	
	private String head = "";
	
	
	@Override
	public void push(String key) {
		list.insertAtBeginning(key);
		head = key;
		
	}

	@Override
	public String top() {
		return head;
	}

	@Override
	public String pop() {
		String tmp = head;
		list.remove(head);
		head = list.getHead().getData();

		return tmp;
	}

	@Override
	public boolean empty() {
		if(list.isEmpty()) return true;
		else return false;
	}

	@Override
	public void toStr() {
		
	}

}
