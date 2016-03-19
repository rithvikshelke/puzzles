package org.kpmg.coding.challenge.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/***
 * Solution to question 1
 * @author rithvikgopishelke
 *
 */
public class PhoneNumberWordMatcher {

	private static Map<Integer, String> telephoneNumberAlphaMap = new HashMap<Integer, String>();
	private static Map<String,ArrayList<String>> dictionary = new HashMap<String,ArrayList<String>>();


	public static void main(String[] args) throws IOException, URISyntaxException {
		if (args.length == 0) {
			System.out.println("Usage is : PhoneNumberWordMatcher <10 digit phonenumber>");
		} else {
			if (args[0].length() == 10) {
				intiHashMap();
				//				for(Integer k:telephoneNumberAlphaMap.keySet()){
				//					System.out.println("key:"+k+" , val:"+telephoneNumberAlphaMap.get(k));
				//				}
				Long phoneNumber = Long.valueOf(args[0]);
				System.out.println("Phone number: " + phoneNumber);
				Integer firstDigit = Integer.valueOf(args[0].substring(0, 1));
				System.out.println("First digit of the phone number is: "+firstDigit);
				System.out.println("Checking the whether the map contains the first digit and printing corresp alphabets");
				if(telephoneNumberAlphaMap.get(firstDigit)!=null){
					char[] alphabetsMatched = telephoneNumberAlphaMap.get(firstDigit).toCharArray();
					for(char alpha:alphabetsMatched){
						printFromWordFile(String.valueOf(alpha));
					}
				}else{
					System.out.println("The digit does not contain corresponding alphabets");
				}
			} else {
				System.err.println("The lenght of the telephone is not 10 digits");
				System.exit(1);
			}
		}
	}

	private static void printFromWordFile(String alpha) {
		if(dictionary.containsKey(alpha)){
			for(String word:dictionary.get(alpha)){
				System.out.println(word);
			}
		}
	}

	private static void intiHashMap() throws IOException, URISyntaxException {
		telephoneNumberAlphaMap.put(2, "abc");
		telephoneNumberAlphaMap.put(3, "def");
		telephoneNumberAlphaMap.put(4, "ghi");
		telephoneNumberAlphaMap.put(5, "jkl");
		telephoneNumberAlphaMap.put(6, "mno");
		telephoneNumberAlphaMap.put(7, "pqrs");
		telephoneNumberAlphaMap.put(8, "tuv");
		telephoneNumberAlphaMap.put(9, "wxyz");

		/**
		 * Setting up the dictionary
		 */

		BufferedReader reader = new BufferedReader(new InputStreamReader(PhoneNumberWordMatcher.class.getResourceAsStream("/american-words-80.txt")));
		String line = null;
		while ((line = reader.readLine()) != null) {
			if(dictionary.containsKey(String.valueOf(line.charAt(0)))){
				dictionary.get(String.valueOf(line.charAt(0))).add(line);
			}else{
				ArrayList<String> values = new ArrayList<String>();
				values.add(line);
				dictionary.put(String.valueOf(line.charAt(0)),values);
			}
		}
	}
}
