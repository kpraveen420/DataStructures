/**
 * 
 */
package com.praveen.sjsu;

/**
 * @author PraveenK
 *
 */
public class IntToBinary {

	public static String intToBinary(int i) {
		String binary = "";
		if (i == 0)
			binary = "0";
		while (i > 0) {
			binary = i % 2 + binary;
			i = i / 2;
		}
		return binary;
	}

	public static double binaryToInt(String binary) {
		double num = 0;
		for (int index = 0; index < binary.length(); index++)
			if (binary.charAt(binary.length() - 1 - index) == '1')
				num += Math.pow(2, index);
		return num;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(intToBinary(6));
		System.out.println(binaryToInt(intToBinary(6)));
	}

}
