package org.interview.puzzles.main;
public class HTree implements Comparable<HTree> {
	public final int freq; 
	public HTree(int freq) {
		this.freq = freq; 
	}

	public int compareTo(HTree tree) {
		return freq - tree.freq;
	}
}
