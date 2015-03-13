/**
 * 
 */
package com.praveen.sjsu.queue;

/**
 * Queue
 * 
 * @author praveenk
 *
 * @param <T>
 */
class Queue<T> {
	T[] tList;
	int size;
	int front, back, count;

	public Queue(int size) {
		super();
		this.size = size;
		tList = (T[]) new Object[size];
	}

	public boolean isFull() {
		return count == size;
	}

	public boolean enqueue(T t) {
		if (!isFull()) {
			tList[front] = t;
			front = (front + 1) % size;
			count++;
			return true;
		}
		return false;
	}

	public T peek() {
		if (isEmpty())
			return null;
		return tList[back];
	}

	public T dequeue() {
		T temp;
		if (isEmpty())
			temp = null;
		temp = tList[back];
		back = (back + 1) % size;
		count--;
		return temp;
	}

	public boolean isEmpty() {
		return count == 0;
	}

	public static void main(String[] args) {
		Queue<Integer> queue = new Queue<Integer>(10);
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		int i = 5;
		while (i < 12) {
			queue.enqueue(i);
			i++;
		}
		while (!queue.isEmpty())
			System.out.println(queue.dequeue());

	}
}
