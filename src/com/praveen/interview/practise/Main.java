package com.praveen.interview.practise;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Main class to find Longest Words in the file that can be constructed by
 * concatenating copies of shorter words also found in the file.
 * 
 * @author PraveenK
 *
 */
public class Main {

	private static PrefixTree prefixTree = new PrefixTree();
	private static Scanner scanner;

	public static void main(String[] args) {
		try {
			String[] sortedWords = null;
			String[] longestWords = null;
			List<String> words = new ArrayList<String>();

			scanner = new Scanner(System.in);
			System.out.println("Please Enter the file along with path: ");
			String fileLocation = scanner.nextLine();
			scanner = new Scanner(new File(fileLocation));
			while (scanner.hasNext()) {
				words.add(scanner.nextLine());
			}
			sortedWords = words.toArray(new String[words.size()]);

			// COmparator can be defined in another class also. For simplicity I
			// defined here.
			Arrays.sort(sortedWords, new Comparator<String>() {
				public int compare(String i1, String i2) {
					return i2.length() - i1.length();
				}
			});

			for (String word : sortedWords) {
				prefixTree.insert(word);
			}
			longestWords = longestWordsMadewithOthers(sortedWords);

			if (longestWords.length >= 1)
				System.out
						.println("The first longest word in the file that can be constructed by concatenating copies of shorter words also found in the file is:: "
								+ longestWords[0]);
			if (longestWords.length > 1)
				System.out
						.println("The second longest word in the file that can be constructed by concatenating copies of shorter words also found in the file is:: "
								+ longestWords[1]);
			System.out.println("Total number of words made of other words :   "
					+ longestWords.length);

		} catch (FileNotFoundException e) {
			System.out.println("Please enter a correct filename!");
		} finally {
			scanner.close();
		}
	}

	/**
	 * Returns longest words that are made up of other shorter words also in the
	 * same file.
	 * 
	 * @param list
	 * 
	 * @return
	 */
	public static String[] longestWordsMadewithOthers(String[] list) {
		List<String> words = new ArrayList<String>();
		for (String word : list) {
			if (isMadeOfOtherWords(word, true)) {
				words.add(word);
			}
		}
		return ((String[]) words.toArray(new String[words.size()]));
	}

	/**
	 * Returns longest words that are made up of other shorter words also in the
	 * same file.
	 * 
	 * @param list
	 * @param count
	 *            Number of words to found
	 * @return
	 */
	public static String[] longestWordsMadewithOthers(String[] list, int count) {
		List<String> words = new ArrayList<String>(count);
		int i = 0;
		for (String word : list) {
			if (isMadeOfOtherWords(word, true)) {
				words.add(word);
				i++;
				if (i == count)
					break;
			}
		}
		return ((String[]) words.toArray(new String[words.size()]));
	}

	/**
	 * Checks whether the input string is made of other words in the Prefix or
	 * not.
	 * 
	 * @param longestWord
	 *            String to be checked
	 * @param remove
	 *            always pass {@code true} initially
	 * @return <li>{@code true} if made of other words <li>{@code false} if not
	 *         made of other words.
	 */
	public static boolean isMadeOfOtherWords(String longestWord, boolean remove) {
		if (remove) {
			prefixTree.delete(longestWord);
		}
		for (int i = 0; i < longestWord.length(); i++) {
			if (prefixTree.search(longestWord.substring(0, i + 1))) {
				if (i == longestWord.length() - 1
						|| isMadeOfOtherWords(
								longestWord.substring(i + 1,
										longestWord.length()), false)) {
					return true;
				}
			}
		}
		if (remove) {
			prefixTree.insert(longestWord);
		}
		return false;
	}
}
