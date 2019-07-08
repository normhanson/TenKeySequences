package com.hansoncoyne.getco;



public class SequenceThread implements Runnable {
	
	private int totalSequences = 0;
	private Character first = null; 
	private int sequenceLength;
	private int maxVowels;
	private SequenceGrandTotal grandTotal;
	
	public int getTotalSequences() { 
		return totalSequences;
	}
	public SequenceThread(Character first, int sequenceLength, int maxVowels, SequenceGrandTotal grandTotal) {
		this.first = first;
		this.maxVowels = maxVowels;
		this.sequenceLength = sequenceLength;
		this.grandTotal = grandTotal;
	}
	
	public void run() {
		totalSequences += TenKeySequences.addNextCharStatic(sequenceLength, maxVowels, 1, first, (TenKeySequences.vowelList.contains(first)?1:0));
		grandTotal.addToGrandTotalSequences(totalSequences);
		
	}

}
