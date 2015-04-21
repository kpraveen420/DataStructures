/**
 * 
 */
package com.praveen.sjsu.arrays;

/**
 * @author nagarjunak
 *
 */
public class Strings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		boolean abcd[] = new boolean[256];
		// Find if string has all unique characters..
		System.out.println(isUniqueChars("ABCD6788"));
		System.out.println(isUniqueChars2("ABCD678"));

		System.out.println("1234".substring(1, 2));

		// Reversing a string..
		System.out.println(reverse("hello"));
		System.out.println(reverseRecursive("hello"));

		// Remove Duplicates in a String
		System.out.println(removeDuplicates("Abjfbjbjbhjbh"));

		System.out.println(abcd[34]);

		// Check Anagram
		System.out.println(checkAnagram("abcad", "cdaba"));

		// Replace space with %20
		System.out.println(replaceSpace("bfjd nkbkg    nknjknbkjgn"));

		int a[][] = { { 0, 1, 2 }, { 4, 5, 6 } };
		// Write an algorithm such that if an element in an MxN matrix is 0, its
		// entire row and column is set to 0.
		matrix(a);

		// check rotation
		System.out.println(checkRotation("abcd", "dabc"));
		String name = "ABCD";
		System.out.println(name.substring(name.length() - 1));
		System.out.println("HI");
		System.out.println((int)'a');
	}

	/**
	 * Checks whether the string has repetitive characters or not...
	 * 
	 * @param name
	 * @return {@code true} if no repetitive {@code false} if at least one
	 *         character is repeated.
	 */
	private static boolean isUniqueChars(String name) {
		boolean unique = true;
		for (int index = 0; index < name.length(); index++) {
			if (index != name.lastIndexOf(name.charAt(index))) {
				unique = false;
				break;
			}
		}
		return unique;
	}

	@Deprecated
	public static boolean isUniqueChars2(String str) {
		boolean[] char_set = new boolean[256];
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if (char_set[val])
				return false;
			char_set[val] = true;
		}
		return true;
	}

	private static String reverse(String temp) {
		StringBuilder sBuilder = new StringBuilder();

		for (int i = temp.length() - 1; i >= 0; i--)
			sBuilder.append(temp.charAt(i));
		return sBuilder.toString();
	}

	@Deprecated
	private static String reverseRecursive(String temp2) {
		if (temp2.length() < 2)
			return temp2;
		return reverseRecursive(temp2.substring(1)) + temp2.charAt(0);
	}

	/**
	 * Removes duplicate characters in the input String.
	 * 
	 * @param temp
	 * @return {@link String} without duplicate characters
	 */
	private static String removeDuplicates(String temp) {
		for (int i = 0; i < temp.length(); i++) {
			if (temp.lastIndexOf(temp.charAt(i)) != i)
				temp = temp.substring(0, i) + temp.substring(i-- + 1);
		}
		return temp;
	}

	/**
	 * Checks whether both the strings are anagrams or not...
	 * 
	 * @param temp1
	 * @param temp2
	 * @return {@code true} if both are anagrams {@code false} otherwise
	 */
	private static boolean checkAnagram(String temp1, String temp2) {
		if (temp1.length() != temp2.length())
			return false;
		for (char c : temp1.toCharArray()) {
			if (temp2.indexOf(c) == -1)
				return false;
			temp2 = temp2.substring(0, temp2.indexOf(c))
					+ temp2.substring(temp2.indexOf(c) + 1);
		}
		return true;
	}

	private static String replaceSpace(String temp) {
		// for(char ch : temp.toCharArray()){
		//
		// }
		// for (String s : temp.split("\\s"))
		// System.out.println(s);
		return temp.replace(" ", "%20");
	}

	private static void matrix(int a[][]) {

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}

		// int x = a.length;
		// int y = a[0].length;
		// for (int i = 0; i < x; i++)
		// for (int j = 0; j < y; j++)
		// System.out.println(a[i][j]);

		int x[] = new int[a.length];
		int y[] = new int[a[0].length];
		for (int i = 0; i < a.length; i++)
			for (int j = 0; j < a[0].length; j++)
				if (a[i][j] == 0) {
					x[i] = 1;
					y[j] = 1;
				}
		for (int i = 0; i < x.length; i++)
			if (x[i] == 1)
				for (int abcd = 0; abcd < a[i].length; abcd++)
					a[i][abcd] = 0;
		for (int i = 0; i < y.length; i++)
			if (y[i] == 1)
				for (int abcd = 0; abcd < a.length; abcd++)
					a[abcd][i] = 0;

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}

	}

	/**
	 * Checks whether one string is rotation of another string.
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	private static boolean checkRotation(String s1, String s2) {
		if (s1 == null || s2 == null || s1.length() != s2.length())
			return false;
		String s1s1 = s1 + s1;
		return s1s1.indexOf(s2) != -1;
	}
}