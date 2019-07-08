package com.hansoncoyne.getco.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import junit.framework.TestCase;

import com.hansoncoyne.getco.TenKeySequences;

public class CoupletTest extends TestCase {
	
	/*
	 * test to see if every character is in the key set
	 */
	public void testKeySet() {
		Set<Character> keys = TenKeySequences.moveMap.keySet();
		assertTrue(keys.size() == 18);
		keys.contains(new Character('A'));
		keys.contains(new Character('B'));
		keys.contains(new Character('C'));
		keys.contains(new Character('D'));
		keys.contains(new Character('E'));
		keys.contains(new Character('F'));
		keys.contains(new Character('G'));
		keys.contains(new Character('H'));
		keys.contains(new Character('I'));
		keys.contains(new Character('J'));
		keys.contains(new Character('K'));
		keys.contains(new Character('L'));
		keys.contains(new Character('M'));
		keys.contains(new Character('N'));
		keys.contains(new Character('O'));
		keys.contains(new Character('1'));
		keys.contains(new Character('2'));
		keys.contains(new Character('3'));
	}
	
	/* this test shows the second key, contains all of the first keys.
	 * just thinking out-loud (and therefore the third contains every key as well) 
	 */
	public void testSecondKey() {
		TreeMap<Character, Set<Character>> moveMap = TenKeySequences.moveMap;
		Set<Character> firstKeys = TenKeySequences.moveMap.keySet();
		Set<Character> keys = new TreeSet<Character>();
		for (Character key:firstKeys) {
			keys.addAll(moveMap.get(key));
		}
		assertTrue(keys.containsAll(firstKeys));
	}
	
	/**
	 * Brute Force pairs (no need to test vowels yet.
	 */
	public void testCoupletCount() {
		List<String> couplets = new ArrayList<String>();
		Map<Character, Set<Character>> moveMap = TenKeySequences.moveMap;
		Set<Character> firstKeys = TenKeySequences.moveMap.keySet();
		for (Character key:firstKeys) {
			for (Character second:moveMap.get(key)) {
				StringBuffer sb = new StringBuffer().append(key).append(second);
				couplets.add(sb.toString());
			}
		}
		assertTrue(couplets.size() == 60);
		TenKeySequences tqs = new TenKeySequences(2,2);
		int total = tqs.getTotalSequencesUsingRecursion();
		assertTrue(total == 60);
	}

}
