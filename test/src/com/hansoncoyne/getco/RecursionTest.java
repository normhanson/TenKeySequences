package com.hansoncoyne.getco.test;

import junit.framework.TestCase;

import com.hansoncoyne.getco.TenKeySequences;

public class RecursionTest extends TestCase {
	
	public void testRecursionImplLength2() {
		TenKeySequences tks = new TenKeySequences(2, 2);
		int totalSequences = tks.getTotalSequencesUsingRecursion();
		assertTrue(totalSequences > 0);
		assertTrue(totalSequences == 60);
		System.out.println("Total Using For Recursion Impl:" + totalSequences);
	}
	public void testRecursionImplLength3() {
		TenKeySequences tks = new TenKeySequences(3, 2);
		int totalSequences = tks.getTotalSequencesUsingRecursion();
		assertTrue(totalSequences > 0);
		assertTrue(totalSequences == 214);
		System.out.println("Total Using For Recursion Impl:" + totalSequences);
	}
	
	public void testRecursionImplFullMonty() {
		long startTimeMillis = 0;
		long endTimeMillis = 0;
		startTimeMillis = System.currentTimeMillis();
		TenKeySequences tks = new TenKeySequences(10, 2);
		int totalSequences = tks.getTotalSequencesUsingRecursion();
		endTimeMillis = System.currentTimeMillis();
		long delta = endTimeMillis - startTimeMillis;
		System.out.println("time in millis Recursion Impl:" + delta);
		assertTrue(totalSequences > 0);
		assertTrue(totalSequences == 1013398);
		System.out.println("Total Using For Recursion Impl:" + totalSequences);
	}
	
	public void testRecursionImplFullMontyStatic() {
		long startTimeMillis = 0;
		long endTimeMillis = 0;
		startTimeMillis = System.currentTimeMillis();
		int totalSequences = TenKeySequences.getTotalSequences(10, 2);
		endTimeMillis = System.currentTimeMillis();
		long delta = endTimeMillis - startTimeMillis;
		System.out.println("time in millis Recursion Static Impl:" + delta);
		assertTrue(totalSequences > 0);
		assertTrue(totalSequences == 1013398);
		System.out.println("Total Using For Recursion Static Impl:" + totalSequences);
	}

}
