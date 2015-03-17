/**
 * 
 */
package com.praveen.sjsu.sort;

/**
 * @author PraveenK
 *
 */
public class MergeSort {

	private static int[] data;
	private static int[] helper;
	public static void mergeSort(int start, int end) {
		if (start >= end)
			return;
		int middle = (start + end) / 2;
		mergeSort(start, middle);
		mergeSort(middle + 1, end);
		doMerge(start, end, middle);

	}

	private static void doMerge(int start, int end, int middle) {
		
		for (int i = start; i <= end; i++)
			helper[i] = data[i];
		int i = start, j = middle+1, k = start;
		while (i <= middle && j <= end) {
			if (helper[i] < helper[j])
				data[k++] = helper[i++];
			else
				data[k++] = helper[j++];
		}
		while (i <= middle)
			data[k++] = helper[i++];
		while (j <= end)
			data[k++] = helper[j++];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		data = new int[] { 1, 45, 10, 99, 120, 3 };
		helper = new int[data.length];
		mergeSort(0, data.length - 1);
		for (int i : data)
			System.out.println(i);

	}

}
