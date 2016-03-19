package org.kpmg.coding.challenge.problems;
public class HNode extends HTree {
	public final HTree left, right; // subtrees

	public HNode(HTree left, HTree right) {
		super(left.freq + right.freq);
		this.left = left;
		this.right = right;
	}
}