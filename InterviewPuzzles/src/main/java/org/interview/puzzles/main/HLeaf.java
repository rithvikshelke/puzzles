package org.kpmg.coding.challenge.problems;
public class HLeaf extends HTree {
	public final char value;

	public HLeaf(int freq, char val) {
		super(freq);
		this.value = val;
	}
}
