/**
 * 
 */
package com.praveen.sjsu.sort;

import java.util.LinkedList;

/**
 * @author PraveenK
 *
 */
public class RadixSort {

	public static int[] radixSort(int[] input, int maxDigits) {
		LinkedList<Integer> temp[] = new LinkedList[] {
				new LinkedList<Integer>(), new LinkedList<Integer>(),
				new LinkedList<Integer>(), new LinkedList<Integer>(),
				new LinkedList<Integer>(), new LinkedList<Integer>(),
				new LinkedList<Integer>(), new LinkedList<Integer>(),
				new LinkedList<Integer>(), new LinkedList<Integer>()

		};
		int div = 1, mod = 10;
		for (int i = 0; i < maxDigits; i++, div *= 10, mod *= 10) {
			for (int a : input) {
				temp[(a % mod) / div].add(a);
			}
			int ind = 0;
			for (LinkedList<Integer> t : temp) {
				while (!t.isEmpty())
					input[ind++] = t.pop();
			}
		}

		return input;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] t = new int[] { 19, 8, 123, 56, 890, 10 };
		t= radixSort(t,3);
		for(int a: t)
			System.out.println(a);

	}

}
