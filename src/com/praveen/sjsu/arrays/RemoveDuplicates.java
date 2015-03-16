/**
 * 
 */
package com.praveen.sjsu.arrays;

/**
 * @author PraveenK
 *
 */
public class RemoveDuplicates {

	/**
	 * Removes duplicates elements in the array and returns a new array.
	 * 
	 * @param input
	 * @return array without duplicates in it.
	 */
	public static int[] removeDuplicates(int[] input) {
		int size = input.length;
		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				if (input[i] == input[j]) {
					int end = j;
					for (int k = end; k < size - 1; k++)
						input[k] = input[k + 1];
					size--;
				}
			}
		}

		int nonDupli[] = new int[size];
		for (int i = 0; i < size; i++)
			nonDupli[i] = input[i];
		
		return nonDupli;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] temp = removeDuplicates(new int[] { 1, 2, 3, 4, 5, 1, 2, 0, 9, 5 });
		for (int i : temp)
			System.out.println(i);

	}

}
