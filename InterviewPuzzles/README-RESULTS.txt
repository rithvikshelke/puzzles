**************************************************************************************************************************
--------------------------------------------------------------------------------------------------------------------------					
								Sum of Product For Preceding  C Elements Puzzle
--------------------------------------------------------------------------------------------------------------------------
**************************************************************************************************************************

#######################
Problem Statement:
#######################
You have a range of consecutive numbers, from 1 to n (inclusive). e.g. [1, 2, 3, 4... n].
We would like to calculate a sum of a function across the entire range, where the function 
returns the product of the *preceding* C elements.
If there are less than C previous elements, just use the available numbers. i.e. if you are 
processing the fourth number in the range, but C is greater than 3, then you will calculate 
the product using only the 3 available preceding numbers. In this situation as you move 
further along in this range more preceding numbers become available.
A worked example follows: if n=5 and C=2, the correct products and final sum for each 
element of the range are: 0 + 1 + 2 + 6 + 12 = 21
The solution should be implemented in Java. Initially calculate the value where n=100 and 
C=10, and let us know the answer
Please additionally tell us the values where n=1000000 and C=200, but only include the first 
10 digits of the result in your answer.
What is the algorithmic complexity of your solution? What if you needed to calculate 
n=10,000,000 and C=200?

#######################
Classes:
#######################
1. Main class - SumOfProductOfPrecedingElements.java
2. Test class - SumOfProductOfPrecedingElementsTest.java

#######################
Solution:
#######################
1. Value for n=100 and C=10 ---> 5139462350 <Ref: Junit - testWithInitialRequest100And10()>
2. Value for n=1000000 and C=200 ---> 4876116127 {First 10 digits} <Ref: Junit - testWithInitialRequest1000000And200()>
3. Value for n=10,000,000 and C=200 ---> 4965134354 {First 10 digits} <Ref: Junit - testWithInitialRequest10000000And200()>

#######################
Design (Pseudo code):
#######################
1. Iterate over the stream of number range n(exclusive).

2. 			If n == 1 
				return 0

3. 			If the value of n is lesser than or equal to the preceding element's value 
				then iterate over stream of number from 1 to current num and multiple each of the element
				return result
				
4. 			else if the value is greater
				then iterate over stream of numbers from (curr number - preceding) to current number and multiply each of the element
				return result

5.			Reduce the result by adding all elements of the list elements of the stream

6. 	Display the result.

#######################
Time Analysis :
#######################

With parallel run:
---------------------
N - C : <time in ms>
---------------------
5   -   2  :0 millisec
6   -   2  :0 millisec
7   -   2  :0 millisec
7   -   3  :0 millisec
100   -   10  :1 millisec
1000000 -   200:4708 millisec
10000000 - 200:47482 millisec


Without parallel run: 
---------------------
N - C  : <time in ms>
---------------------
5 - 2  :1 millisec
6 - 2  :0 millisec
7 - 2  :0 millisec
7 - 3  :0 millisec
100 - 10  :0 millisec
1000000 -  200:18636 millisec
10000000 - 200:205723 millisec
**************************************************************************************************************************
**************************************************************************************************************************

Some more:
-------------->

Problem 1

Write a program that takes any 10-digit phone number and produces a list of words matching first letters of the 

phone number (2 – ABC, 3 – DEF, .. 9 – WZXYZ). Use any free word list file, e.g.

http://www.thefreedictionary.com/word+list

Problem 2

Implement http://en.wikipedia.org/wiki/Huffman_coding tree construction algorithm, which takes any string and 

prints the tree.

Problem 3.a

Write a java program with reverses the words in a String. Use whatever features you feel will solve this problem 

clearly and efficiently. This is the template of the program:

public class ReverseWords { 

public static void main(String[] args) throws Exception { 

}

 

public String reverseWords(String input) { 

}

}

This is the expected printed output: 

test a is This

Problem 3.b

Write the same program as above, but now the function will work over a single char array, swapping characters 

within the array to achieve the same word reversal. Your function CANNOT use any built in Java methods and 

CANNOT allocate any free store (no use of the new keyword). Your function can allocate as many primitive 

variables as your function needs to provide this functionality. This is the template of this program:

public class ReverseWords { 

public static void main(String[] args) throws Exception { 

ReverseWords rw = new ReverseWords(); 

System.out.println(rw.reverseWords(“This is a test”)); 

// Your code here 

ReverseWords rw = new ReverseWords(); 

char[] input = {‘T’, ‘h’, ‘i’, ‘s’, ‘ ‘, ‘i’, ‘s’, ‘ ‘, ‘a’, ‘ ‘, ‘t’, ‘e’, ‘s’, ‘t’}; 

rw.reverseWords(input);

System.out.println(new String(input)); 

} 

public void reverseWords(char[] input) { 
	// Your code here
}

}
