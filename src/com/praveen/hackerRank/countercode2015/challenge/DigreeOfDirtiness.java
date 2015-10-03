/**
 * 
 */
package com.praveen.hackerRank.countercode2015.challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
Problem Statement

There are N toilets in a row indexed from 1 to N. At a time, 2 people enter the washroom. The degree of dirtiness of each toilet is 0 initially and it increases by 1 after it is used each time. The 1st person occupies the 1st toilet with the lowest degree of dirtiness moving from 1 to N. The 2nd person occupies the toilet with the lowest degree of dirtiness moving from N to 1. The next two people enter the toilet when the first two people have left. Find the index of toilet and degree of dirtiness for the Mth person.

Note In case M is odd, the last person walks into the washroom alone and occupies the least dirty toilet moving from 1 to N.

Input Format 
The first line contains T, the number of test cases. Each test case consists of one line containing N, the number of toliets, and M, the person to enter the toilet, seperated by space.

Output Format 
The index of the toilet used by M and its degree of dirtiness D.

Constraints 
1≤T≤10 
1≤N≤50000 
1≤M≤106

Sample Input

3  
10 3  
5 8  
4 26 
Sample Output

2 0  
4 1  
4 6  
Explanation

In the second test case, 
for the first two persons, positions are 1 _ _ _ 2, degree of dirtiness 0 0 0 0 0 (dirtiness is 0 since they are the first to use it) 
for person 3 and 4, positions are _ 3 _ 4 _ , degree of dirtiness 1 0 0 0 1 
for 5 and 6, positions are _ _ 5 _ 6, degree of dirtiness 1 1 0 1 1 
for 7 and 8, positions are 7 _ _ 8 _, degree of dirtiness 1 1 1 1 2 so the answer is 4,1 * 
 * 
 * @author PraveenK
 *
 */
public class DigreeOfDirtiness {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int testCases;
		Scanner s = new Scanner(System.in);
		testCases = Integer.parseInt(s.nextLine());
		String line;

		int N, personIndex;

		List<Integer> dirty = null;
		for (int i = 0; i < testCases; i++) {
			line = s.nextLine();

			N = Integer.parseInt(line.split("\\s+")[0]);
			personIndex = Integer.parseInt(line.split("\\s+")[1]);

			dirty = new ArrayList<Integer>(N);
			for(int x=0; x<N; x++)
				dirty.add(0);
			int startIndex = 0, endIndex = N - 1;
			for (int j = 1; j <= personIndex;) {
				if (j % 2 == 0) {
					if(endIndex<N-1 && dirty.get(endIndex+1)==dirty.get(endIndex))
						endIndex = N-1;
					if (j == personIndex) {
						System.out
								.println(endIndex+1 + " " + dirty.get(endIndex));
					}
					dirty.set(endIndex, dirty.get(endIndex) + 1);
					if(endIndex-1 >=0 && dirty.get(endIndex-1) <dirty.get(endIndex) )
						endIndex--;
					else
						endIndex = N-1;
					j++;

				} else if (j % 2 == 1) {
					if(startIndex>0 && dirty.get(startIndex-1)==dirty.get(startIndex))
						startIndex = 0;
					if (j == personIndex) {
						System.out.println(startIndex+1 + " "
								+ dirty.get(startIndex));
					}
					
					dirty.set(startIndex, dirty.get(startIndex) + 1);
					
					if(startIndex+1 > N && dirty.get(startIndex+1) <dirty.get(startIndex) )
						startIndex++;
					else
						startIndex = 0;
					j++;

				}

			}

		}

	}

}
