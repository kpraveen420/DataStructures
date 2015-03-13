package com.praveen.sjsu.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * @author praveenk
 *
 */
public class BSTTest {

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
		System.out.println(bTree.search(11));
		System.out.println(bTree.search(18));
		System.out.println(bTree.searchRecursion(9));
		System.out.println(bTree.searchRecursion(100));
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
		List<Integer> n = new ArrayList<Integer>();
		System.out.println("Print all the paths from root to leafs.");
		bTree.printAllRootToLeafPaths(bTree.root, n);
		System.out.println("Print all the paths from root to leafs.");
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

		System.out.println("Level order traversal");
		bTree.levelOrderTraversal();
		System.out.println();
		System.out.println("Level by level traversal");
		bTree.levelByLevelTraversal();

		System.out.println("Nearest node for 14 is: " + bTree.findNearest(14));
		// = ;
		// System.out.println(n1.data);
		System.out.println(System.nanoTime());
		Random r = new Random();
		System.out.println(r.rand());
		System.out.println(r.rand());

		int abcd = 0;
		System.out.println(~abcd);

	}
}

/**
 * Random number generator class.
 * 
 * @author PraveenK
 *
 */
class Random {
	long a = 25214903917L; // These Values for a and c are the actual values
							// found
	long c = 11; // in the implementation of java.util.Random(), see link
	long previous = 0;

	public Random() {
		previous = System.nanoTime();
	}

	void rseed(long seed) {
		previous = seed;
	}

	long rand() {
		long r = a * previous + c;
		// Note: typically, one chooses only a couple of bits of this value.
		previous = r;
		return r;
	}
}
