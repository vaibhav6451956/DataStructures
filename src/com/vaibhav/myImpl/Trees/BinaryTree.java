package com.vaibhav.myImpl.Trees;

import com.vaibhav.myImpl.Trees.Node;

public interface BinaryTree {
	
	public void insert(int key);
	
	public boolean containsValue(int key);
	
	public boolean isLeafNode(Node n);
	
	

}
