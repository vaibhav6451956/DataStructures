package com.vaibhav.coursera.trees;

/**
 * @author vaisharm
 *
 */
public class BinarySearchTreeImpl {

	public Node root;

	/**
	 * @param data
	 */
	public void insert(int data) {

		root = insert(root, data);

	}

	/**
	 * @param node
	 * @param data
	 * @return
	 */
	private Node insert(Node node, int data) {

		if (node == null) { // The node sent in param is the root. If root is
							// empty initialize it.

			node = new Node(data);
		}

		else {

			if (data < node.getData()) { // if data is smaller that root's val,
											// it should go to left as per BST
											// rule

				node.left = insert(node.left, data);

			}

			else if (data > node.getData()) {// if data is gr8r than root's val,
												// it should go to the right as
												// per BST rule

				node.right = insert(node.right, data);
			}
		}

		return node;
	}

	/**
	 * 
	 */
	public void printTree() {

		printTree(this.root);
	}

	/**
	 * @param node
	 */
	private void printTree(Node node) {

		System.out.println(node.getData());

		if (node.left != null)
			printTree(node.left);

		if (node.right != null)
			printTree(node.right);

	}

	/**
	 * @param n
	 * @return
	 */
	private boolean isNodeNull(Node n) {
		Integer val = new Integer(n.getData());

		if (val == null)
			return true;

		else
			return false;

	}

	/**
	 * @return
	 */
	public int size() {

		return (size(this.root));
	}

	/**
	 * @param n
	 * @return
	 */
	private int size(Node n) {
		if (n == null)
			return 0;

		else {

			return (size(n.left) + 1 + size(n.right));

		}
	}

	/**
	 * @param val
	 * @return
	 */
	public Node search(int val) {

		return (search(this.root, val));
	}

	/**
	 * @param n
	 * @param val
	 * @return
	 */
	private Node search(Node n, int val) {

		if (n.getData() == val)
			return n;

		if (val < n.getData()) {
			return (search(n.left, val));
		}

		return (search(n.right, val));

	}
}
