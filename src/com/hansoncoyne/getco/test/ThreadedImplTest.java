package com.hansoncoyne.getco.test;

import junit.framework.TestCase;

import com.hansoncoyne.getco.TenKeySequences;

public class ThreadedImplTest extends TestCase {

	public void testThreadingImpl () {
		long startTimeMillis = 0;
		long endTimeMillis = 0;
		startTimeMillis = System.currentTimeMillis();
		TenKeySequences tks = new TenKeySequences(10, 2);
		int totalSequences = tks.getTotalSequencesUsingThreads();
		endTimeMillis = System.currentTimeMillis();
		long delta = endTimeMillis - startTimeMillis;
		System.out.println("time in millis Threaded Impl:" + delta);
		System.out.println("Total Using For Recursion Static Impl:" + totalSequences);
		assertTrue(totalSequences == 1013398);
	}
	
	

	
	

}
