/**
 * 
 */
package com.praveen.hackerRank.coding.challenge;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Please read ValidateBST.png and ValidateBST2.png for problem description..
 * 
 * @author PraveenK
 *
 */
public class ValidBST {
	private static int index;

	static int[] d;
	static int i = 0;

	/**
	 * Constructs Binary tree from preorder array.
	 * 
	 * @param array of elements
	 * @param length 
	 * @return root of the binary search tree.
	 */
	public static Node binaryPreorderToTree(int[] arr, int length) {
		if (length <= 0) {
			return null;
		}

		return binaryPreorderToTree(arr, length, Integer.MIN_VALUE,
				Integer.MAX_VALUE);
	}

	/**
	 * Constructs Binary tree from preorder array.
	 * 
	 * @param arr
	 * @param length
	 * @param min
	 * @param max
	 * @return
	 */
	private static Node binaryPreorderToTree(int[] arr, int length, int min,
			int max) {

		if (index >= length) {
			return null;
		}

		Node root = null;

		int currentNode = arr[index];

		if (currentNode > min && currentNode < max) {
			root = new Node(currentNode);
			index++;

			if (index < length) {
				root.left = binaryPreorderToTree(arr, length, min, currentNode);
			}

			if (index < length) {
				root.right = binaryPreorderToTree(arr, length, currentNode, max);
			}
		}
		return root;
	}

	static class Node {
		int data;
		Node right, left;

		public Node(int currentNode) {
			data = currentNode;
		}
	}

	public static void inOrder(Node node) {
		if (node == null)
			return;
		inOrder(node.left);
		d[i++] = node.data;
		inOrder(node.right);
	}

	/**
	 * 
	 * @param node
	 */
	public static void preOrder(Node node) {
		if (node == null)
			return;
		d[i++] = node.data;
		preOrder(node.left);
		preOrder(node.right);
	}

	public static void main(String args[]) throws Exception {
		BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(s.readLine());
		int j = 0;
		int[] data;
		Node root;
		for (; j < testCases; j++) {
			index = 0;
			i = 0;
			root = null;
			d = null;
			data = null;
			int in = Integer.parseInt(s.readLine());
			data = new int[in];
			d = new int[in];
			String line = s.readLine();
			int a = 0;
			for (String word : line.split("\\s+")) {
				data[a++] = Integer.parseInt(word);
			}
			root = binaryPreorderToTree(data, in);
			boolean ok = true;
			preOrder(root);
			for (int i = 0; i < in; i++) {
				if (d[i] != data[i]) {
					ok = false;
				}
			}
			if (ok)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}
