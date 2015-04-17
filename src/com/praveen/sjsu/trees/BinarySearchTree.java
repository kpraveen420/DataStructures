package com.praveen.sjsu.trees;

import java.util.ArrayList;
import java.util.List;

import com.praveen.sjsu.queue.Queue;
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

	public boolean search(int data) {
		boolean find = false;
		Node current = root;
		while (current != null && !find)
			if (current.data == data) {
				find = true;
				break;
			} else if (current.data > data)
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
				if (temp.right != null && temp.right != lastVisitedNode)
					temp = temp.right;
				else {
					System.out.print(myStack.pop().data + " ");
					lastVisitedNode = temp;
					temp = null;
				}
			}
		}
	}

	/**
	 * Prints all paths from root to leafs
	 * 
	 * @param node
	 * @param n
	 */
	public void printAllRootToLeafPaths(Node node, List<Integer> n) {
		if (node == null) {
			return;
		}
		n.add(node.data);
		if (node.left == null && node.right == null) {
			System.out.println(n);
			return;
		} else {
			printAllRootToLeafPaths(node.left, new ArrayList<Integer>(n));
			printAllRootToLeafPaths(node.right, new ArrayList<Integer>(n));
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
	 * 
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
	}

	/**
	 * Prints elements in level order..
	 */
	public void levelOrderTraversal() {
		Node temp = root;
		Node t = null;
		Queue<Node> q = new Queue<Node>(20);
		if (temp != null)
			q.enqueue(temp);
		while (!q.isEmpty()) {
			t = q.dequeue();
			System.out.print(t.data + " ");
			if (t.left != null)
				q.enqueue(t.left);
			if (t.right != null)
				q.enqueue(t.right);
		}

	}

	/**
	 * Prints elements in level by level..
	 */
	public void levelByLevelTraversal() {
		Node temp = root;
		Node t = null;
		Queue<Node> q = new Queue<Node>(20);
		if (temp != null) {
			q.enqueue(temp);
			q.enqueue(null);
		}
		while (!q.isEmpty()) {
			t = q.dequeue();

			if (t == null) {
				System.out.println("");
				if (!q.isEmpty())
					q.enqueue(null);
			} else {
				System.out.print(t.data + " ");
				if (t.left != null)
					q.enqueue(t.left);
				if (t.right != null)
					q.enqueue(t.right);
			}
		}

	}

	/***
	 * Finds the nearest node for the given number
	 * 
	 * @param root
	 * @param x
	 * @return nearest element in BST
	 */
	public int findNearest(int x) {
		Node temp = root, nearest = root;
		int diff = Integer.MAX_VALUE;

		while (temp != null) {
			if (temp.data == x)
				return x;
			else if (temp.data > x) {
				if ((temp.data - x) < diff) {
					diff = temp.data - x;
					nearest = temp;
				}
				temp = temp.left;
			} else {
				if ((temp.data - x) < diff) {
					diff = Math.abs(temp.data - x);
					nearest = temp;
				}
				temp = temp.right;
			}
		}
		return nearest.data;
	}

	/**
	 * A binary tree T is given. A node of that tree containing value V is
	 * described as visible if the path from the root of the tree to that node
	 * does not contain a node with any value exceeding V. In particular, the
	 * root is always visible and nodes with values lower than that of the root
	 * are never visible.
	 * 
	 * 
	 * Find total number of visible nodes in the tree.
	 * 
	 * @param n
	 * @return total no of Visible Nodes
	 */
	public int visibleNodesCount(Node n) {
		if (n == null)
			return 0;
		return findVisible(n, n.data);
	}

	private int findVisible(Node n, int max) {
		if (n == null)
			return 0;
		if (n.data >= max) {
			return 1 + findVisible(n.left, n.data)
					+ findVisible(n.right, n.data);
		} else {
			return findVisible(n.left, max) + findVisible(n.right, max);
		}
	}

	static class Node {
		public int data;
		public Node left;
		public Node right;

		Node(int newData) {
			left = null;
			right = null;
			data = newData;
		}
	}

}
