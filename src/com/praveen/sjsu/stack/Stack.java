/**
 * 
 */
package com.praveen.sjsu.stack;

/**
 * @author nagarjunak
 *
 */
public class Stack<T> {

	private T[] tList;
	int position;

	public Stack(int size) {
		if (size < 0)
			throw new IllegalArgumentException("Stack size can't be negative..");
		tList = (T[]) new Object[size];
	}

	public boolean push(T t) {
		if (isFull())
			return false;
		tList[position++] = t;
		return true;
	}

	public T pop() {
		if (isEmpty())
			return null;
		return tList[--position];
	}

	public T peek() {
		if (isEmpty())
			return null;
		return tList[position-1];
	}

	public boolean isEmpty() {
		return position == 0;
	}

	public boolean isFull() {
		return position == tList.length;
	}
}
