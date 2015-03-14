/**
 * 
 */
package com.praveen.sjsu;

import java.util.HashSet;
import java.util.Set;

/**
 * @author PraveenK
 *
 */
public class LeetCode {

	public static boolean wordBeak(String name, Set<String> dict) {
		int startIndex = 0;
		for (int i = 0; i <= name.length(); i++) {
			if (dict.contains(name.substring(startIndex, i))) {
				startIndex = i;
			}
		}
		return startIndex == name.length();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Set<String> dict = new HashSet<String>();
		dict.add("Go");
		dict.add("Green");
		dict.add("Red");
		System.out.println(LeetCode.wordBeak("GoGreen", dict));
	}
}
