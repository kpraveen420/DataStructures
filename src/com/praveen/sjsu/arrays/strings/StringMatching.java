/**
 * 
 */
package com.praveen.sjsu.arrays.strings;

/**
 * For string matching problems using KMP algorithm
 * 
 * @author PraveenK
 *
 */
public class StringMatching {
	private String text, pattern;
	int[] f;

	/**
	 * @param text
	 * @param pattern
	 */
	public StringMatching(String text, String pattern) {
		this.text = text;
		this.pattern = pattern;
		f = new int[pattern.length()];
	}

	/**
	 * Checks whether there is a match with the pattern or not. If so returns
	 * the start index.
	 * 
	 * @return
	 */
	public int isMatches() {
		preProcess(pattern);
		System.out.println("preProcess of patter done!!!");
		int i = 0, j = 0;
		while (i < text.length()) {
			if (text.charAt(i) == pattern.charAt(j)) {
				if (j == pattern.length() - 1)
					return i - j;
				i++;
				j++;
			} else if (j > 0)
				j = f[j - 1];
			else
				i++;
		}

		return -1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StringMatching stringMatching = new StringMatching("bacbabababacaca",
				"ababaca");
		System.out.println("Starting index of match is: "
				+ stringMatching.isMatches());

	}

	/**
	 * generates a prefix array by comparing pattern with itself.
	 * 
	 * @param pattern
	 */
	private void preProcess(String pattern) {
		int i = 1, j = 0;
		f[0] = 0;
		while (i < pattern.length()) {
			if (pattern.charAt(i) == pattern.charAt(j)) {
				f[i++] = ++j;
			} else {
				if (j > 0)
					j = f[j - 1];
				else {
					j = 0;
					i++;
				}
			}
		}
	}

}
