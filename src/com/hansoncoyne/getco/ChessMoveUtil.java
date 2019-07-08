package com.hansoncoyne.getco;

import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class ChessMoveUtil {
	
	/**
	 * helper method to return the next Character based on a chessMove and the defined keypad
	 * 
	 * @param row
	 * @param column
	 * @param chessMove
	 * @param keyPad
	 * @return
	 */
	private static Character getNextCharacter(int row, int column, ChessMove chessMove, Character[][] keyPad)
	{	
		Character myChar = null;
		int newRow = row + chessMove.getRowDelta();
		int newCol = column + chessMove.getColumnDelta();
		if (newRow >= 0 && newRow < keyPad.length  && newCol >= 0 && newCol < keyPad[row].length ) {
			myChar = keyPad[newRow][newCol]; 
		}
		return myChar;

	}
	
	/**
	 * Returns a map of all possible moves given the keypad and moves
	 */
	public static TreeMap<Character, Set<Character>> buildMoveMap(Character[][] keyPad, ChessMove[] moves) {
		
		TreeMap<Character, Set<Character>> myMap = new TreeMap<Character, Set<Character>>();

		/* iterate over rows */
		for (int row = 0; row < keyPad.length; row++) {
			
			/* iterate over columns */
			for (int column = 0; column < keyPad[row].length; column++) {
				Character myChar = keyPad[row][column];
				
				/* attempt moves, if the result is not null, add to tree map */
				for (ChessMove move : moves)	{
					Character nextChar = getNextCharacter(row, column, move, keyPad);
					if ((myChar != null) && (nextChar != null)) {
						Set<Character> charList = null;
						if (myMap.containsKey(myChar)) {
							charList = myMap.get(myChar);
						} else {
							charList = new TreeSet<Character>();
							myMap.put(myChar, charList);
						}
						charList.add(nextChar);
					}
				}
			}
		}
		return myMap;
	}

}
