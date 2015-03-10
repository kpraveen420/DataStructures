/**
 * 
 */
package com.praveen.sjsu.sort;

/**
 * @author PraveenK
 *
 */
public class Heap {

	int[] data;

	/**
	 * @param data
	 */
	public Heap(int[] data) {
		super();
		this.data = data;
	}

	/**
	 * Performs heapify on specific startIndex.
	 * @param startIndex
	 * @param max
	 */
	private void heapify(int startIndex, int max) {
		int largeIndex = 2 * startIndex + 1;
		int temp = data[startIndex];
		while (largeIndex <= max) {
			if (largeIndex < max && data[largeIndex] < data[largeIndex + 1]) {
				largeIndex++;
			}

			if (temp < data[largeIndex]) {
				data[startIndex] = data[largeIndex];
				startIndex = largeIndex;
				largeIndex = 2 * startIndex + 1;

			} else
				break;

		}
		data[startIndex] = temp;
	}

	/**
	 * Builds heap
	 */
	public void buildHeap() {
		for (int i = (data.length - 1) / 2; i >= 0; i--) {
			heapify(i, data.length - 1);
		}
	}

	/**
	 * Applies heap sort algorithm.
	 */
	public void heapSort() {
		buildHeap();
		for (int lastOutofOrder = data.length - 1; lastOutofOrder > 0; lastOutofOrder--) {
			int temp = data[lastOutofOrder];
			data[lastOutofOrder] = data[0];
			data[0] = temp;
			heapify(0, lastOutofOrder-1);

		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// int i[] = { 1, 4, 3, 6, 19, 0 };
		Heap h = new Heap(new int[] { 1, 4, 3, 6, 19, 0 });
		// h.buildHeap();
		h.heapSort();
		for (int j : h.data)
			System.out.print(j + " ");

	}
}
