package com.praveen.hackerRank.coding.challenge;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * For problem please refer to screen shots attached with name Stack-HackerRank
 *
 * 
 * @author Praveen
 */
public class SuperStack {
	private int maxSize;
	private long[] stackArray;
	private int top;

	public SuperStack(int s) {
		maxSize = s;
		stackArray = new long[maxSize];
		top = -1;
	}

	public void inc(int x, int d) {
		int i = 0;
		for (; i < x; i++)
			stackArray[i] += d;
		System.out.println(stackArray[top]);

	}

	public void push(long j) {
		stackArray[++top] = j;
		System.out.println(j);
	}

	public long pop() {
		if (top == 0)
			System.out.println("EMPTY");
		else
			System.out.println(stackArray[top-1]);
		return stackArray[top--];
	}

	public long peek() {
		return stackArray[top];
	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public boolean isFull() {
		return (top == maxSize - 1);
	}

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(s.readLine());
		int j = 0;
		String line;
		String words[];
		SuperStack theStack = new SuperStack(testCases);
		for (; j < testCases; j++) {
			line = s.readLine();
			words = line.trim().split("\\s+");
			if (words.length == 1 || words[0].equalsIgnoreCase("pop")) {
				theStack.pop();
			} else if (words.length == 2 || words[0].equalsIgnoreCase("push")) {
				theStack.push(Long.parseLong(words[1]));
			} else if (words.length == 3 || words[0].equalsIgnoreCase("inc")) {
				theStack.inc(Integer.parseInt(words[1]),
						Integer.parseInt(words[2]));
			} else{
				
			}

		}
		// Sanity Check code.
		// // SuperStack theStack = new SuperStack(10);
		// theStack.push(10);
		// theStack.pop();
		// theStack.push(20);
		// theStack.push(30);
		// theStack.push(40);
		// theStack.push(50);
		// theStack.inc(2, 3);
		// // while (!theStack.isEmpty()) {
		// // long value = theStack.pop();
		// // System.out.print(value);
		// // System.out.print(" ");
		// // }
		// System.out.println("");
	}
}
