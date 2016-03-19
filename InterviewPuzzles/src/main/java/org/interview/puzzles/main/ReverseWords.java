package org.kpmg.coding.challenge.problems;

import org.apache.commons.lang.ArrayUtils;

/***
 * Challenge 3a and 3b
 * 
 * @author rithvikgopishelke
 *
 */
public class ReverseWords {

	public static void main(String[] args) {
		ReverseWords rw = new ReverseWords();
		System.out.println(rw.reverseWords("This is a test"));
		char[] input = { 'T', 'h', 'i', 's', ' ', 'i', 's', ' ', 'a', ' ', 't', 'e', 's', 't' };
		rw.reverseWords(input);
		System.out.println(new String(input));
	}

	/**
	 * Solution to 3a
	 * 
	 * @param string
	 * @return
	 */
	private String reverseWords(String string) {
		if (string == null) {
			return null;
		}
		String[] strs = string.split(" ");

		ArrayUtils.reverse(strs);
		StringBuilder reversedString = new StringBuilder();
		for (String str : strs) {
			reversedString.append(str);
			reversedString.append(" ");
		}

		return reversedString.toString().trim();
	}

	/**
	 * Solution to 3b
	 * 
	 * @param input
	 */
	private void reverseWords(char[] input) {

		int idx = 0;
		for (int i = input.length - 1; i >= input.length / 2; i--) {

			char temp = input[i];
			input[i] = input[idx];
			input[idx] = temp;
			idx++;
		}

		int indexForEndOfWord = 0;
		for (int initial = 0; initial < input.length; initial = indexForEndOfWord + 1) {
			for (indexForEndOfWord = initial; indexForEndOfWord < input.length && input[indexForEndOfWord] != ' '; indexForEndOfWord++) {
			}

			for (int i = initial, j = indexForEndOfWord - 1; i < j; i++, j--) {
				char temp = input[i];
				input[i] = input[j];
				input[j] = temp;
			}
		}
	}
}