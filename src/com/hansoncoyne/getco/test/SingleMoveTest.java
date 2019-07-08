package com.hansoncoyne.getco.test;

import java.util.Set;
import java.util.TreeMap;

import junit.framework.TestCase;

import com.hansoncoyne.getco.TenKeySequences;

/**
 * testing whether the knight moves all work correctly.
 * @author nhanson
 *
 */
public class SingleMoveTest extends TestCase {
	public void testKeypressA() {
		
		TreeMap<Character, Set<Character>> moveMap = TenKeySequences.moveMap;
		Set<Character> moves = moveMap.get(new Character('A'));
		assertTrue(moves.size() == 2);
		assertTrue(moves.contains(new Character('L')));
		assertTrue(moves.contains(new Character('H')));
		
	}

	public void testKeypressB() {

		TreeMap<Character, Set<Character>> moveMap = TenKeySequences.moveMap;
		Set<Character> moves = moveMap.get(new Character('B'));
		assertTrue(moves.size() == 3);
		assertTrue(moves.contains(new Character('I')));
		assertTrue(moves.contains(new Character('M')));
		assertTrue(moves.contains(new Character('K')));
		
	}

	public void testKeypressC() {

		TreeMap<Character, Set<Character>> moveMap = TenKeySequences.moveMap;
		Set<Character> moves = moveMap.get(new Character('C'));
		assertTrue(moves.size() == 4);
		assertTrue(moves.contains(new Character('F')));
		assertTrue(moves.contains(new Character('J')));
		assertTrue(moves.contains(new Character('L')));
		assertTrue(moves.contains(new Character('N')));
		
	}

	public void testKeypressD() {

		TreeMap<Character, Set<Character>> moveMap = TenKeySequences.moveMap;
		Set<Character> moves = moveMap.get(new Character('D'));
		assertTrue(moves.size() == 3);
		assertTrue(moves.contains(new Character('O')));
		assertTrue(moves.contains(new Character('M')));
		assertTrue(moves.contains(new Character('G')));
		
	}
	
	public void testKeypressE() {

		TreeMap<Character, Set<Character>> moveMap = TenKeySequences.moveMap;
		Set<Character> moves = moveMap.get(new Character('E'));
		assertTrue(moves.size() == 2);
		assertTrue(moves.contains(new Character('N')));
		assertTrue(moves.contains(new Character('H')));
		
	}

	public void testKeypressF() {

		TreeMap<Character, Set<Character>> moveMap = TenKeySequences.moveMap;
		Set<Character> moves = moveMap.get(new Character('F'));
		assertTrue(moves.size() == 3);
		assertTrue(moves.contains(new Character('C')));
		assertTrue(moves.contains(new Character('M')));
		assertTrue(moves.contains(new Character('1')));
		
	}

	public void testKeypressG() {

		TreeMap<Character, Set<Character>> moveMap = TenKeySequences.moveMap;
		Set<Character> moves = moveMap.get(new Character('G'));
		assertTrue(moves.size() == 3);
		assertTrue(moves.contains(new Character('D')));
		assertTrue(moves.contains(new Character('N')));
		assertTrue(moves.contains(new Character('2')));
		
	}

	public void testKeypressH() {

		TreeMap<Character, Set<Character>> moveMap = TenKeySequences.moveMap;
		Set<Character> moves = moveMap.get(new Character('H'));
		assertTrue(moves.size() == 6);
		assertTrue(moves.contains(new Character('E')));
		assertTrue(moves.contains(new Character('A')));
		assertTrue(moves.contains(new Character('K')));
		assertTrue(moves.contains(new Character('O')));
		assertTrue(moves.contains(new Character('3')));
		assertTrue(moves.contains(new Character('1')));
		
	}

	public void testKeypressI() {

		TreeMap<Character, Set<Character>> moveMap = TenKeySequences.moveMap;
		Set<Character> moves = moveMap.get(new Character('I'));
		assertTrue(moves.size() == 3);
		assertTrue(moves.contains(new Character('2')));
		assertTrue(moves.contains(new Character('B')));
		assertTrue(moves.contains(new Character('L')));
		
	}

	public void testKeypressJ() {

		TreeMap<Character, Set<Character>> moveMap = TenKeySequences.moveMap;
		Set<Character> moves = moveMap.get(new Character('J'));
		assertTrue(moves.size() == 3);
		assertTrue(moves.contains(new Character('C')));
		assertTrue(moves.contains(new Character('M')));
		assertTrue(moves.contains(new Character('3')));
		
	}

	public void testKeypressK() {

		TreeMap<Character, Set<Character>> moveMap = TenKeySequences.moveMap;
		Set<Character> moves = moveMap.get(new Character('K'));
		assertTrue(moves.size() == 3);
		assertTrue(moves.contains(new Character('B')));
		assertTrue(moves.contains(new Character('2')));
		assertTrue(moves.contains(new Character('H')));
		
	}

	public void testKeypressL() {

		TreeMap<Character, Set<Character>> moveMap = TenKeySequences.moveMap;
		Set<Character> moves = moveMap.get(new Character('L'));
		assertTrue(moves.size() == 4);
		assertTrue(moves.contains(new Character('C')));
		assertTrue(moves.contains(new Character('A')));
		assertTrue(moves.contains(new Character('3')));
		assertTrue(moves.contains(new Character('I')));
		
	}

	public void testKeypressM() {

		TreeMap<Character, Set<Character>> moveMap = TenKeySequences.moveMap;
		Set<Character> moves = moveMap.get(new Character('M'));
		assertTrue(moves.size() == 4);
		assertTrue(moves.contains(new Character('J')));
		assertTrue(moves.contains(new Character('D')));
		assertTrue(moves.contains(new Character('B')));
		assertTrue(moves.contains(new Character('F')));
		
	}

	public void testKeypressN() {

		TreeMap<Character, Set<Character>> moveMap = TenKeySequences.moveMap;
		Set<Character> moves = moveMap.get(new Character('N'));
		assertTrue(moves.size() == 4);
		assertTrue(moves.contains(new Character('E')));
		assertTrue(moves.contains(new Character('G')));
		assertTrue(moves.contains(new Character('C')));
		assertTrue(moves.contains(new Character('1')));
		
	}

	public void testKeypressO() {

		TreeMap<Character, Set<Character>> moveMap = TenKeySequences.moveMap;
		Set<Character> moves = moveMap.get(new Character('O'));
		assertTrue(moves.size() == 3);
		assertTrue(moves.contains(new Character('D')));
		assertTrue(moves.contains(new Character('2')));
		assertTrue(moves.contains(new Character('H')));
		
	}

	public void testKeypress1() {

		TreeMap<Character, Set<Character>> moveMap = TenKeySequences.moveMap;
		Set<Character> moves = moveMap.get(new Character('1'));
		assertTrue(moves.size() == 3);
		assertTrue(moves.contains(new Character('H')));
		assertTrue(moves.contains(new Character('F')));
		assertTrue(moves.contains(new Character('N')));
		
	}

	public void testKeypress2() {

		TreeMap<Character, Set<Character>> moveMap = TenKeySequences.moveMap;
		Set<Character> moves = moveMap.get(new Character('2'));
		assertTrue(moves.size() == 4);
		assertTrue(moves.contains(new Character('I')));
		assertTrue(moves.contains(new Character('G')));
		assertTrue(moves.contains(new Character('O')));
		assertTrue(moves.contains(new Character('K')));
		
	}

	public void testKeypress3() {

		TreeMap<Character, Set<Character>> moveMap = TenKeySequences.moveMap;
		Set<Character> moves = moveMap.get(new Character('3'));
		assertTrue(moves.size() == 3);
		assertTrue(moves.contains(new Character('J')));
		assertTrue(moves.contains(new Character('H')));
		assertTrue(moves.contains(new Character('L')));
		
	}


}
