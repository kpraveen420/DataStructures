package com.praveen.sjsu.trees;

import java.util.ArrayList;

/**
 * @author praveenk
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinarySearchTree bTree = new BinarySearchTree();
		BinarySearchTree bTree2 = new BinarySearchTree();
		bTree.insert(10);
		bTree.insert(4);
		bTree.insert(6);
		bTree.insert(12);
		bTree.insert(15);
		bTree.insert(11);
		bTree.insert(10);
		bTree.insert(3);
		bTree.insert(9);
		bTree.insert(19);

		bTree2.insertIterative(10);
		bTree2.insertIterative(4);
		bTree2.insertIterative(6);
		bTree2.insertIterative(12);
		bTree2.insertIterative(15);
		bTree2.insertIterative(11);
		bTree2.insertIterative(10);
		bTree2.insertIterative(3);
		bTree2.insertIterative(9);
		bTree2.insertIterative(19);

		System.out.println("Depth of binary search tree is:"
				+ bTree.depth(bTree.root));
		System.out.println(bTree.findRecursion(9));
		System.out.println(bTree.findRecursion(100));
		System.out.println();
		System.out.println("PreOrder recursive");
		bTree.preOrder(bTree.root);
		System.out.println();
		System.out.println("InOrder recursive");
		bTree.inOrder(bTree.root);
		System.out.println();
		System.out.println("PostOrder recursive");
		bTree.postOrder(bTree.root);
		System.out.println();
		bTree.inOrderIterative();
		System.out.println();
		System.out.println("PreOrder iterative");
		bTree.preOrderIterative();
		System.out.println();
		System.out.println("PostOrder iterative");
		bTree.postOrderIterative();
		System.out.println();
		bTree.printAllRootToLeafPaths(bTree.root, new ArrayList<Integer>());
		bTree.printAllRootToLeafPaths(bTree.root, " ");
		bTree.mirrorTree(bTree.root);
		bTree.inOrderIterative();
		bTree.mirrorTree(bTree.root);
		System.out.println();
		bTree.inOrderIterative();
		System.out.println();
		bTree2.inOrderIterative();
		 bTree2.insert(19);
		// bTree.doubleTree(bTree.root);
		// System.out.println();
		// bTree.inOrderIterative();
		System.out.println();
		System.out.println(bTree.compareTree(bTree.root, bTree2.root));
	}

}
