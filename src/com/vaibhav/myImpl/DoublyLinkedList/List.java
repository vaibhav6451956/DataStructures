package com.vaibhav.myImpl.DoublyLinkedList;

import com.vaibhav.myImpl.DoublyLinkedList.Node;

public interface List {


/**
 * insert the element at first position
 */
public void pushFront(int key);

/**
 * return the first element
 */
public int topFront();

/**
 * remove and return the first element
 */
public int popFront();


/**
 * insert the element at the end
 */
public void pushBack(int key);

/**
 * return the last element
 */
public int topBack();


/**
 * return & remove the last element
 */
public int popBack();


/**
 * find the provided key in the list and return True if found
 */
public boolean find(int key);

/**
 * delete the provided element
 */
public boolean delete(int key);


/**
 * Check if the list is empty
 */
public boolean isEmpty();

/**
 * Add a new node with provided key before the provided node
 */
public void addBefore(Node n,int key);


/**
 * Add a new node with provided key after the provided node
 */
public void addAfter(Node n,int key);



}
