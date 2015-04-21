/**
 * 
 */
package com.praveen.sjsu.arrays;

import java.util.ArrayList;

/**
 * Print all subsets of a set of numbers
 * 
 * @author PraveenK
 *
 */
public class SubSets {

	public ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
		ArrayList<ArrayList<Integer>> allsubsets;
		if (set.size() == index) {
			allsubsets = new ArrayList<ArrayList<Integer>>();
			allsubsets.add(new ArrayList<Integer>()); // Empty set
		} else {
			allsubsets = getSubsets(set, index + 1);
			int item = set.get(index);
			ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
			for (ArrayList<Integer> subset : allsubsets) {
				ArrayList<Integer> newsubset = new ArrayList<Integer>();
				newsubset.addAll(subset);
				newsubset.add(item);
				moresubsets.add(newsubset);
			}
			allsubsets.addAll(moresubsets);
		}
		return allsubsets;
	}

	/**
	 * Print all subsets of a set of numbers 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SubSets subSets = new SubSets();
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		ArrayList<ArrayList<Integer>> list2 = subSets.getSubsets(list, 0);
		for(ArrayList<Integer> intLst : list2){
			for(int i:intLst){
				System.out.print(i +" ");
			}
			System.out.println();
		}
		
	}

}
