/**
 * 
 */
package com.praveen.hackerRank.countercode2015.challenge;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Problem Statement
 * 
 * Time is running out. You have a final match to play as a counter terrorist.
 * You have N players each having a distinct ID from 1 to N. You have to choose
 * some players on your team from these N players such that no two chosen
 * players have consecutive numbers (as they tend to kill each other). Also you
 * definitely have to choose some K players whose numbers are given. They are
 * the snipers. Find the maximum number of players that you can choose.
 * 
 * Input Format
 * 
 * The first line contains 2 space-separated integers, N and K, where N is the
 * total number of players and K is the number of players that have to be
 * definitely in the team (the snipers). The second line contains K
 * space-separated integers that are the IDs of the snipers.
 * 
 * NOTE: There are no two snipers with consecutive numbers.
 * 
 * Constraints 2≤N≤2×106 1≤K≤N/2 1≤ ID of each sniper ≤N Output Format
 * 
 * You need to print the maximum number of players that you can have in your
 * team.
 * 
 * Sample Input
 * 
 * 8 2 6 2 Sample Output
 * 
 * 4 Explanation
 * 
 * There are 8 players in total, among which you have to definitely choose
 * players with ID 2 and 6. To maximize the number of players in the team, you
 * will choose the players with IDs 4 and 8, so that you will have a total of 4
 * players.
 * 
 * Camper: A player in a professional team dedicated to using the AWP sniper
 * rifle.
 * 
 * @author PraveenK
 *
 */
public class Campers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int pleayersCount, snippersCount;
		String line = s.nextLine();
		pleayersCount = Integer.parseInt(line.split("\\s+")[0]);
		snippersCount = Integer.parseInt(line.split("\\s+")[1]);

		Set<Integer> players = new TreeSet<Integer>();

		line = s.nextLine();

		for (String player : line.split("\\s+"))
			players.add(Integer.parseInt(player));

		for (int i = 1; i <= pleayersCount; i++) {
			if (players.contains(i) || players.contains(i + 1)
					|| players.contains(i - 1))
				continue;
			players.add(i);
		}

		System.out.println(players.size());
	}

}
