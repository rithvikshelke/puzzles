package org.kpmg.coding.challenge.problems;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;


/***
 * Solution to question 2
 * @author rithvikgopishelke
 *
 */
public class HTreePrinter {
	public static HTree buildTree(int[] charFreqs, char[] chars) {
		//used instead of a heap very similar
		PriorityQueue<HTree> trees = new PriorityQueue<HTree>();
		//Multiple leaves here initially
		for (int i = 0; i < charFreqs.length; i++)
			if (charFreqs[i] > 0)
				trees.offer(new HLeaf(charFreqs[i], chars[i]));

		assert trees.size() > 0;

		//until single tree remains
		while (trees.size() > 1) {
			HTree a = trees.poll();
			HTree b = trees.poll();

			trees.offer(new HNode(a, b));
		}
		return trees.poll();
	}

	public static void displayItem(HTree tree, StringBuilder prefix) {
		assert tree != null;
		if (tree instanceof HLeaf) {
			HLeaf leaf = (HLeaf)tree;

			System.out.println(leaf.value + "\t" + prefix + "\t" + leaf.freq);

		} else if (tree instanceof HNode) {
			HNode node = (HNode)tree;

			prefix.append('0');
			displayItem(node.left, prefix);
			prefix.deleteCharAt(prefix.length()-1);

			prefix.append('1');
			displayItem(node.right, prefix);
			prefix.deleteCharAt(prefix.length()-1);
		}
	}

	public static HashMap<Character,Integer> getCharFreq(String s) {
		HashMap<Character,Integer> charFrequencyMap = new HashMap<Character,Integer>();
		if (s != null) {
			for (Character c : s.toCharArray()) {
				Integer count = charFrequencyMap.get(c);
				int newCount = (count==null ? 1 : count+1);
				charFrequencyMap.put(c, newCount);
			}
		}
		return charFrequencyMap;
	}

	public static void main(String[] args) {
		//Symbols:
		String str = "This is a test string"; 

		System.out.println("Character frequency display:");
		System.out.println("Char\tFreq");
		HashMap<Character,Integer> charFreqMap = getCharFreq(str);
		for(Entry<Character,Integer> entry: charFreqMap.entrySet()){
			System.out.println(entry.getKey()+"    \t"+entry.getValue());
		}


		char[] chars = new char[charFreqMap.size()];
		int[] charFreqs = new int[charFreqMap.size()];

		int index =0;
		//The order is not maintained within a map but the char and the freq corresp to same element
		for(Entry<Character,Integer> entry:charFreqMap.entrySet()){
			chars[index] = entry.getKey();
			charFreqs[index] = entry.getValue();
			index++;
		}


		// build tree
		HTree tree = buildTree(charFreqs,chars);
		System.out.println("\n\n*********************\n");
		System.out.println("CHAR\tHCODE\tFREQ");
		displayItem(tree, new StringBuilder());
		System.out.println("\n*********************\n");
	}

}
