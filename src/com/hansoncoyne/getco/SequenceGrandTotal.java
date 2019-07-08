package com.hansoncoyne.getco;

/**
 * Trivial Class to used as a call back for Threaded Example.
 * 
 * @author nhanson
 *
 */
public class SequenceGrandTotal {

	/* int is thread safe */
	private int grandTotalSequences = 0;
	
	public void addToGrandTotalSequences(int sequences)
	{
			grandTotalSequences += sequences;
	}
	
	public int getGrandTotalSequences() {
		return grandTotalSequences;
	}
}
