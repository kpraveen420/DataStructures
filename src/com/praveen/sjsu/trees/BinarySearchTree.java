package com.praveen.sjsu.trees;

import java.util.ArrayList;
import com.praveen.sjsu.stack.Stack;

/**
 * @author praveenk
 *
 */
public class BinarySearchTree {
	Node root;

	public void insertIterative(int data) {
		if (root == null) {
			root = new Node(data);
			return;
		}
		Node current = root, prev = root;
		while (current != null) {
			prev = current;
			if (data <= current.data)
				current = current.left;
			else
				current = current.right;
		}
		if (prev.data >= data)
			prev.left = new Node(data);
		else
			prev.right = new Node(data);
	}

	public void insert(int data) {
		root = insert(root, data);
	}

	/**
	 * Recursive insert -- given a node pointer, recur down and insert the given
	 * data into the tree. Returns the new node pointer (the standard way to
	 * communicate a changed pointer back to the caller).
	 */
	private Node insert(Node node, int data) {
		if (node == null)
			node = new Node(data);

		else if (data <= node.data)
			node.left = insert(node.left, data);
		else
			node.right = insert(node.right, data);
		return node;
	}

	public int depth(Node node) {
		if (node == null)
			return 0;
		return 1 + Math.max(depth(node.left), depth(node.right));

	}

	private int max(int a, int b) {
		if (a > b)
			return a;
		return b;
	}

	public boolean search(int data) {
		boolean find = false;
		Node current = root;
		while (current != null && !find)
			if (current.data == data)
				find = true;
			else if (current.data > data)
				current = current.left;
			else
				current = current.right;
		return find;
	}

	public boolean searchRecursion(int data) {
		return searchRecursion(root, data);
	}

	private boolean searchRecursion(Node node, int data) {
		if (node == null)
			return false;
		if (node.data == data)
			return true;
		if (node.data > data)
			return searchRecursion(node.left, data);
		return searchRecursion(node.right, data);

	}

	public void preOrder(Node node) {
		if (node == null)
			return;
		System.out.print(node.data + " ");
		preOrder(node.left);
		preOrder(node.right);
	}

	public void postOrder(Node node) {
		if (node == null)
			return;
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data + " ");
	}

	public void inOrder(Node node) {
		if (node == null)
			return;
		inOrder(node.left);
		System.out.print(node.data + " ");
		inOrder(node.right);

	}

	// public void inOrderIterative() {
	// Node current = root;
	// Stack<Node> nodeStack = new Stack<Node>(30);
	// nodeStack.push(current);
	// while (current.left != null) {
	// nodeStack.push(current.left);
	// current = current.left;
	// }
	// while (!nodeStack.isEmpty()) {
	// current = nodeStack.pop();
	// System.out.print(current.data + " ");
	// if (current.right != null) {
	//
	// current = current.right;
	// while (current != null) {
	// nodeStack.push(current);
	// current = current.left;
	// }
	// }
	// }
	// }

	public void inOrderIterative() {
		System.out.println("InOrder iterative");
		Stack<Node> myStack = new Stack<Node>(30);
		Node temp = root;
		while (!myStack.isEmpty() || temp != null) {
			if (temp != null) {
				myStack.push(temp);
				temp = temp.left;
			} else {
				temp = myStack.pop();
				System.out.print(temp.data + " ");
				temp = temp.right;
			}
		}
	}

	public void preOrderIterative() {
		Stack<Node> myStack = new Stack<Node>(30);
		Node temp = root;
		while (!myStack.isEmpty() || temp != null) {
			if (temp != null) {
				System.out.print(temp.data + " ");
				if (temp.right != null)
					myStack.push(temp.right);
				temp = temp.left;
			} else {
				temp = myStack.pop();
			}
		}
	}

	public void postOrderIterative() {
		Stack<Node> myStack = new Stack<Node>(30);
		Node temp = root, lastVisitedNode = null;
		while (!myStack.isEmpty() || temp != null) {
			if (temp != null) {
				myStack.push(temp);
				temp = temp.left;
			} else {
				temp = myStack.peek();
				if (temp.right == null || temp.right == lastVisitedNode) {
					lastVisitedNode = myStack.pop();
					System.out.print(lastVisitedNode.data + " ");
					temp = null;
				} else
					temp = temp.right;

			}
		}
	}

	/**
	 * Prints all paths from root to leafs
	 * 
	 * @param node
	 * @param path
	 */
	public void printAllRootToLeafPaths(Node node, ArrayList<Integer> path) {
		if (node == null) {
			return;
		}
		path.add(node.data);

		if (node.left == null && node.right == null) {
			System.out.println(path);
			return;
		} else {
			printAllRootToLeafPaths(node.left, new ArrayList<Integer>(path));
			printAllRootToLeafPaths(node.right, new ArrayList<Integer>(path));
		}
	}

	/**
	 * Prints all paths from root to leafs
	 * 
	 * @param node
	 * @param path
	 */
	public void printAllRootToLeafPaths(Node node, String path) {
		if (node == null) {
			return;
		}
		// path.add(node.data);
		path = path + ", " + node.data;

		if (node.left == null && node.right == null) {
			System.out.println(path);
			return;
		} else {
			printAllRootToLeafPaths(node.left, path);
			printAllRootToLeafPaths(node.right, path);
		}
	}

	/**
	 * Mirror the tree
	 * 
	 * @param node
	 */
	public void mirrorTree(Node node) {
		if (node == null)
			return;
		mirrorTree(node.left);
		mirrorTree(node.right);
		Node temp = node.left;
		node.left = node.right;
		node.right = temp;
	}

	/**
	 * Double the tree
	 * 
	 * @param node
	 */
	@Deprecated
	public void doubleTree(Node node) {
		Node oldLeft;

		if (node == null)
			return;

		// do the subtrees
		doubleTree(node.left);
		doubleTree(node.right);

		// duplicate this node to its left
		oldLeft = node.left;
		node.left = new Node(node.data);
		node.left.left = oldLeft;
	}

	/**
	 * Compares whether both the trees are same or not.
	 * @param node1
	 * @param node2
	 * @return
	 */
	public boolean compareTree(Node node1, Node node2) {
		if (node1 == null && node2 == null)
			return true;
		else if (node1 != null && node2 != null)
			return node1.data == node2.data
					&& compareTree(node1.left, node2.left)
					&& compareTree(node1.right, node2.right);
		else
			return false;

		// if (node1 == node2)
		// return true;
		// if (node1 != null && node2 != null && node1.data == node2.data)
		// return compareTree(node1.left, node2.left)
		// && compareTree(node1.right, node2.right);
		// else
		// return false;
	}

}

class Node {
	public int data;
	public Node left;
	public Node right;

	Node(int newData) {
		left = null;
		right = null;
		data = newData;
	}
}
