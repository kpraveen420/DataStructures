package com.praveen.interview.practise;

import java.util.LinkedList;
import java.util.List;

/**
 * PrefixTree also non as Trie data structure is mostly popular in use cases
 * related to dictionaries..
 * 
 * @author PraveenK
 *
 */
public class PrefixTree {
	private Node head;

	public PrefixTree() {
		// root node contains #
		head = new Node('#');
	}

	/**
	 * Inserts a String into {@link PrefixTree}
	 * 
	 * @param s
	 */
	public void insert(String s) {
		Node tempNode = head, child = null;
		if (s == null)
			return;
		else if (s.length() == 0)
			// Empty string
			tempNode.isEnd = true;

		for (int i = 0; i < s.length(); i++) {
			child = tempNode.subNode(s.charAt(i));
			if (child == null) {
				child = new Node(s.charAt(i));
				tempNode.cnode.add(child);
				tempNode = child;
			} else {
				tempNode = child;
				tempNode.count++;
			}
		}
		tempNode.isEnd = true;

	}

	/**
	 * Searches for a string in {@link PrefixTree}
	 * 
	 * @param s
	 * @return
	 */
	public boolean search(String s) {
		Node tempNode = head;
		while (tempNode != null) {
			for (int i = 0; i < s.length(); i++) {
				if (tempNode.subNode(s.charAt(i)) == null)
					return false;
				else
					tempNode = tempNode.subNode(s.charAt(i));
			}
			return tempNode.isEnd;
		}
		return false;
	}

	/**
	 * Deletes a {@link String} from {@link PrefixTree}
	 * 
	 * @param s
	 * @return
	 */
	public boolean delete(String s) {
		// checking whether the given string is present
		if (search(s)) {
			Node tempNode = head;
			Node t;
			while (tempNode != null) {

				for (int i = 0; i < s.length(); i++) {
					t = tempNode;
					tempNode = tempNode.subNode(s.charAt(i));
					if (tempNode == null)
						// String not present in the PrefixTree
						return false;
					tempNode.count--;
					if (tempNode.count == 0) {
						t.cnode.remove(tempNode);
						break;
					}
				}
				tempNode.isEnd = false;
				return true;
			}
		}
		return false;
	}
}

class Node {
	char ch;
	boolean isEnd;
	// indicates the no of words with the character.
	int count;
	List<Node> cnode;

	public Node(char ch) {
		cnode = new LinkedList<Node>();
		isEnd = false;
		this.ch = ch;
		count = 1;
	}

	public Node subNode(char ch) {
		if (cnode != null) {
			for (Node child : cnode) {
				if (child.ch == ch) {
					return child;
				}
			}
		}
		return null;
	}

}