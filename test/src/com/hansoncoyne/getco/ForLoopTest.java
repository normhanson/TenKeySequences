package com.hansoncoyne.getco.test;

import java.util.Map;
import java.util.Set;

import com.hansoncoyne.getco.TenKeySequences;

import junit.framework.TestCase;

public class ForLoopTest extends TestCase {

	int execCounter = 0;	
	/**
	 * TenKeySequences Using For Loop.  Brute Force. 
	 * Only used as a reference
	 * @return
	 */
	public int getTotalSequencesUsingFoorLoop() {
		int maxVowels = 2;
		int totalSequences = 0;
		Map<Character, Set<Character>> moveMap = TenKeySequences.moveMap;
		Set<Character> firstKeys = TenKeySequences.moveMap.keySet();
		for (Character first:firstKeys) {
			for (Character second:moveMap.get(first)) {
				for (Character third:moveMap.get(second)) {
					for (Character fourth:moveMap.get(third)) {
						for (Character fifth:moveMap.get(fourth)) {
							for (Character sixth:moveMap.get(fifth)) {
								for (Character seventh:moveMap.get(sixth)) {
									for (Character eighth:moveMap.get(seventh)) {
										for (Character ninth:moveMap.get(eighth)) {
											for (Character tenth:moveMap.get(ninth)) {
												int vowelCount = 0;
												
												if (TenKeySequences.vowelList.contains(first)) vowelCount++;
												if (TenKeySequences.vowelList.contains(second)) vowelCount++;
												if (TenKeySequences.vowelList.contains(third)) vowelCount++;
												if (TenKeySequences.vowelList.contains(fourth)) vowelCount++;
												if (TenKeySequences.vowelList.contains(fifth)) vowelCount++;
												if (TenKeySequences.vowelList.contains(sixth)) vowelCount++;
												if (TenKeySequences.vowelList.contains(seventh)) vowelCount++;
												if (TenKeySequences.vowelList.contains(eighth)) vowelCount++;
												if (TenKeySequences.vowelList.contains(ninth)) vowelCount++;
												if (TenKeySequences.vowelList.contains(tenth)) vowelCount++;
												
												if (vowelCount <= maxVowels) {
													totalSequences++;
												} 
												this.execCounter++;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return totalSequences;
	}
	public void testForLoopImpl() {
		int totalSequences = getTotalSequencesUsingFoorLoop();
		assertTrue(totalSequences > 0);
		System.out.println("Total Using For Loop Impl:" + totalSequences);
		System.out.println("Executions:" + execCounter);
	}
}
