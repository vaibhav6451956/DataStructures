package com.vaibhav.myImpl.Stack;

public class StackImpl_Array implements Stack {

	private String[] arr = new String[100];
	private int size = 0;
	
	
	@Override
	public void push(String key) {
		if(size<100) {
		arr[size] = key;
		size++;
		}
		else {
			System.err.print("Stack is FULL");
		}
	}

	@Override
	public String top() {

		return arr[size];
			
	}

	@Override
	public String pop() {
		String top = arr[size];
		
		arr[size]= "";
		
		return top;
	}

	@Override
	public boolean empty() {
	
		if(arr.length>0) {
			return false;
		}
		else {
		
		return true;
		}
	}
	
	
	public void toStr() {
		//StringBuffer tmp =new StringBuffer();

		for(String m : arr) {
			
			System.out.print((m+"->"));
		
		} 
		System.out.println();
		
		
		
	}

}
