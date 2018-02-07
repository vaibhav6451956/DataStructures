package com.vaibhav.myImpl.Stack;

public interface Stack {
	
	/*LIFO
	 * Inserts the element at the top of the stack
	 * */
	public void push(String  key);
	
	
	/*
	 * Returns the element at the top of the stack i.e. the last inserted element
	 * */
	public String top();
	
	/*
	 * Returns and removes the element at the top of the stack i.e. the last inserted element
	 * */
	public String pop();
	
	/*
	 * Checks if the stack is empty and returns the boolean status accordingly
	 * */
	public boolean empty();
	
	
	public void toStr();

}
