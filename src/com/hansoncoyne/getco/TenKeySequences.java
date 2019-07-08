package com.hansoncoyne.getco;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

/**
 * this class implements a ten key sequence problem outlined by getco.
 * 
 * @author nhanson
 *
 */
public class TenKeySequences {
	
	private int maxVowels = 0; 
	private int sequenceLength = 0;
	
	/*
	 * the keypad 
	 */
	private static final Character[][] keyPad = { 
							 {'A', 'B', 'C', 'D', 'E'}, 
							 {'F', 'G', 'H', 'I', 'J'}, 
							 {'K', 'L', 'M', 'N', 'O'}, 
							 {null, '1', '2', '3', null}};
	
	/*
	 * Build an array of knight, chess moves 
	 */
	private static final ChessMove[] knightMoves = {new ChessMove(-2, -1),
		  							  new ChessMove(-2, 1), 
									  new ChessMove(2, -1),
									  new ChessMove(2, 1),
									  new ChessMove(-1, -2),
									  new ChessMove(-1, 2),
									  new ChessMove(1, -2),
									  new ChessMove(1, 2)};

	/* 
	 * build a map of available moves for each letter using the key pad and knight moves 
	 */
	public static final TreeMap<Character, Set<Character>> moveMap = ChessMoveUtil.buildMoveMap(keyPad, knightMoves);
	
	/* vowels */
	private static final Character vowels[] = {new Character('A'), new Character('E'), new Character('I'), new Character('O'), new Character('U') }; 
	public static final List<Character> vowelList = Arrays.asList(vowels);
	public static final Set<Character> firstKeys = TenKeySequences.moveMap.keySet();
	
	
	/**
	 * 
	 * All three of these impls work and produce the same answer.
	 * A heads down brute force impl is in the test cases using for loops nested 10 deep.
	 * This was used to get the /right/ answer for testing purposes.
	 * 
	 * I saw no noticeable diff between the static and /normal/ object impl using recursion.
	 * The threaded impl was significantly faster on my hardware ~700 millis vs. ~1070 millis 
	 * 
	 */
	public static void main(String[] args) {
		
		
		TenKeySequences tqs = new TenKeySequences(10,2);
		int totalSequences1 = tqs.getTotalSequencesUsingRecursion();
		System.out.println( totalSequences1);

		/* 
		int totalSequences2 = tqs.getTotalSequencesUsingThreads();
		System.out.println( totalSequences2);

		int totalSequences3 = TenKeySequences.getTotalSequences(10, 2);
		System.out.println( totalSequences3);
		*/
	}
	
	public int getMaxVowels() {
		return maxVowels;
	}

	public int getSequenceLength() {
		return sequenceLength;
	}

	/** 
	 * Constructor 
	 * @param seqLength
	 * @param maxVowels
	 */
	public TenKeySequences ( int seqLength, int maxVowels) {
		this.maxVowels = maxVowels;
		this.sequenceLength = seqLength;
		
	}
	
	/**
	 * Recursive call to calc sequences.  
	 * @param currentIndex
	 * @param lastKey
	 * @param vowelCount
	 * @return
	 */
	private int addNextChar(int currentIndex, Character lastKey, int vowelCount) {
		int sequences = 0; 
		if(currentIndex < this.sequenceLength) {
			for (Character nextChar:TenKeySequences.moveMap.get(lastKey)) {
				int nextVowlCount = vowelCount + (TenKeySequences.vowelList.contains(nextChar)?1:0);
				int nextIndex = currentIndex + 1;
				if (nextVowlCount <=  this.maxVowels) {
					sequences += this.addNextChar(nextIndex, nextChar, nextVowlCount);
				}
			}
		} else {
			sequences = 1;
		}
			
		return sequences;
	}
	
	/**
	 * static impl.  was testing to see if this mad a difference, it did not.
	 * @param sequenceLength
	 * @param maxVowels
	 * @param currentIndex
	 * @param lastKey
	 * @param vowelCount
	 * @return
	 */
	public static final int addNextCharStatic(int sequenceLength, int maxVowels, int currentIndex, Character lastKey, int vowelCount) {
		int sequences = 0; 
		if(currentIndex < sequenceLength) {
			for (Character nextChar:TenKeySequences.moveMap.get(lastKey)) {
				int nextVowlCount = vowelCount + (TenKeySequences.vowelList.contains(nextChar)?1:0);
				sequences += ((nextVowlCount <=  maxVowels)?(TenKeySequences.addNextCharStatic(sequenceLength, maxVowels, currentIndex + 1, nextChar, nextVowlCount)):0);
			}
		} else {
			sequences = 1;
		}
		return sequences;
	}
	
	
	/**
	 * Standard Recursive 
	 * @return
	 */

	public int getTotalSequencesUsingRecursion() {
		
		int totalSequences = 0;
		for (Character first:TenKeySequences.firstKeys) {	
			totalSequences = totalSequences + this.addNextChar(1, first, (vowelList.contains(first)?1:0));
		}
		return totalSequences;
	}
	
	/**
	 * This implementation was the fastest in my testing.
	 * The idea here is that the first "key-press" are really independent events
	 * and therefore can be run in separate threads.  A simple (thread safe) call back is used to aggregate the total sequneces.
	 * the looped join is not ideal, but it does wait for all threads to finish.   
	 * 
	 * @return
	 */
	public int getTotalSequencesUsingThreads() {
        SequenceGrandTotal sgt = new SequenceGrandTotal();
		List<Thread> sequences = new ArrayList<Thread>(TenKeySequences.firstKeys.size());
		for (Character first:TenKeySequences.firstKeys) {
			SequenceThread seq = new SequenceThread(first, this.sequenceLength, this.maxVowels, sgt);
		    Thread t = new Thread(seq);
		    t.start();
		    sequences.add(t);
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for( Thread t : sequences ) {
			try {
				t.join();
			}
			catch( InterruptedException e) {
				System.out.println("Bad Bad Things");
			}
		} 
		return sgt.getGrandTotalSequences();
		
	}
	
	/**
	 * A fully static impl which /should/ flatten the stack, but harder to debug.
	 * no real noticeable difference in testing 
	 * 
	 * @param sequenceLength
	 * @param maxVowels
	 * @return
	 */
	public static final int getTotalSequences(int sequenceLength, int maxVowels) {
		int totalSequences = 0;
		for (Character first:TenKeySequences.firstKeys) {	
			totalSequences = totalSequences + TenKeySequences.addNextCharStatic(sequenceLength, maxVowels, 1, first, (TenKeySequences.vowelList.contains(first)?1:0));
		}
		return totalSequences;
	}
	
	public static void safeSleep(long milliseconds, String s) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			System.out.print(s);
		}
	}
}
