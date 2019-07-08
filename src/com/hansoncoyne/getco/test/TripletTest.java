package com.hansoncoyne.getco.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import junit.framework.TestCase;

import com.hansoncoyne.getco.TenKeySequences;

public class TripletTest extends TestCase {
	
	public void testTripletCount() {
		List<String> trips = new ArrayList<String>();
		Map<Character, Set<Character>> moveMap = TenKeySequences.moveMap;
		Set<Character> firstKeys = TenKeySequences.moveMap.keySet();
		for (Character key:firstKeys) {
			for (Character second:moveMap.get(key)) {
				for (Character third:moveMap.get(second)) {
					
					StringBuffer sb = new StringBuffer().append(key).append(second).append(third);
					int vowel = 0;
					if (TenKeySequences.vowelList.contains(key)) vowel++;
					if (TenKeySequences.vowelList.contains(second)) vowel++;
					if (TenKeySequences.vowelList.contains(third)) vowel++;
					
					if (vowel <= 2) {
						trips.add(sb.toString());
						assertNotNull(sb.toString());
					}
				}
			}
		}
		TenKeySequences tks = new TenKeySequences(3,2);
		int total = tks.getTotalSequencesUsingRecursion();
		assertTrue(total == trips.size());
	}
	
	/**
	 * brute force 4 
	 */
	public void testQuadCount() {
		int junitTestTotalSequences = 0;
		Map<Character, Set<Character>> moveMap = TenKeySequences.moveMap;
		Set<Character> firstKeys = TenKeySequences.moveMap.keySet();
		for (Character key:firstKeys) {
			for (Character second:moveMap.get(key)) {
				for (Character third:moveMap.get(second)) {
					for (Character fourth:moveMap.get(third)) {
						StringBuffer sb = new StringBuffer().append(key).append(second).append(third).append(fourth);
						int vowel = 0;

						if (TenKeySequences.vowelList.contains(key)) vowel++;
						if (TenKeySequences.vowelList.contains(second)) vowel++;
						if (TenKeySequences.vowelList.contains(third)) vowel++;
						if (TenKeySequences.vowelList.contains(fourth)) vowel++;
						
						if (vowel <= 2) {
							assertNotNull(sb.toString());
							junitTestTotalSequences++;
						}
					}
				}
			}
		}
		
		TenKeySequences tks = new TenKeySequences(4,2);
		int total = tks.getTotalSequencesUsingRecursion();
		assertTrue(total == junitTestTotalSequences);
	}
}
