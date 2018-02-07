package com.vaibhav.myImpl.DoublyLinkedList;

public class test {

	
	public static void main(String args[]) {
		
		DoublyLinkedListImpl dd = new DoublyLinkedListImpl();
		dd.pushFront(10);
		dd.pushFront(20);
		dd.pushFront(30);
		dd.pushFront(40);
		dd.pushFront(70);
		
		System.out.println(dd.topFront());
		
		System.out.println(DoublyLinkedListImpl.getLen());
		dd.popFront();
		
		
		System.out.println(dd.topFront());
		
		System.out.println(DoublyLinkedListImpl.getLen());
		
		
		System.out.println(dd.find(4));
	}
}
