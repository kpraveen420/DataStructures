/**
 * 
 */
package com.praveen.sjsu.arrays;

/**
 * @author PraveenK
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Temp t = new Temp();
		t.i1 = 3;
		change(t);
		System.out.println(t.i1);
		
		Student16 s = new Student16();
		s.display();

	}

	public static void change(Temp t) {
		t.i1 = 10;
	}

}

class Person {
	void message() {
		System.out.println("welcome");
	}
}

class Student16 extends Person {
	int i=0;
	void message() {
//		this.message();
		int i=90;
		System.out.println("welcome to java"+i+" "+this.i);
		this.message(99);
	}

	void message(int jk) {
//		this.message();
		int i=90;
		System.out.println("welcome to java"+i+" "+jk);
	}
	
	void display() {
		message();// will invoke current class message() method
		super.message();// will invoke parent class message() method
	}

	public static void main(String args[]) {
		Student16 s = new Student16();
		s.display();
	}
}

class Temp {
	int i1;
	int i2;

}
