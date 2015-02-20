/**
 * 
 */
package com.praveen.sjsu.trees;

/**
 * @author nagarjunak
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinarySearchTree bTree = new BinarySearchTree();
		// bTree.insert(10);
		// bTree.insert(4);
		// bTree.insert(6);
		// bTree.insert(12);
		// bTree.insert(15);
		// bTree.insert(11);
		// bTree.insert(10);
		// bTree.insert(3);
		// bTree.insert(9);
		// bTree.insert(19);

		bTree.insertIterative(10);
		bTree.insertIterative(4);
		bTree.insertIterative(6);
		bTree.insertIterative(12);
		bTree.insertIterative(15);
		bTree.insertIterative(11);
		bTree.insertIterative(10);
		bTree.insertIterative(3);
		bTree.insertIterative(9);
		bTree.insertIterative(19);

		System.out.println("Depth of binary search tree is:"
				+ bTree.depth(bTree.root));
		System.out.println(bTree.findRecursion(9));
		System.out.println(bTree.findRecursion(100));
		System.out.println();
		bTree.preOrder(bTree.root);
		System.out.println();
		bTree.inOrder(bTree.root);
		System.out.println();
		bTree.postOrder(bTree.root);
		System.out.println();
		bTree.inOrderIterative();
		System.out.println();
		bTree.preOrderIterative();
		System.out.println();
		bTree.postOrderIterative();
	}

}
