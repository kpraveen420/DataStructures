/**
 * 
 */
package com.praveen.sjsu.arrays;

/**
 * If two consecutive numbers are same then they are adjacent. What is the max
 * adjacent count by that can be obtained by reversing exactly one number. 
 * 
 * Note:
 * Array can contain either zero or one.
 * 
 * 
 * @author PraveenK
 *
 */
public class Adjucancy {

	public static void main(String args[]) {
		System.out.println(solution(new int[] { 1, 1, 1, 1 }));
	}

	static int solution(int[] A) {
		int n = A.length;
		int result = 0;
		for (int i = 0; i < n - 1; i++) {
			if (A[i] == A[i + 1])
				result = result + 1;
		}
		int r = -1;
		for (int i = 0; i < n; i++) {
			int count = 0;
			if (i > 0) {
				if (A[i - 1] != A[i])
					count = count + 1;
				else
					count = count - 1;
			}
			if (i < n - 1) {
				if (A[i + 1] != A[i])
					count = count + 1;
				else
					count = count - 1;
			}
			r = Math.max(r, count);
		}
		return result + r;
	}

}
