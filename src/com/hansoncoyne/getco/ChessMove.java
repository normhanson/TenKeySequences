package com.hansoncoyne.getco;

public class ChessMove  {
	private int rowDelta;
	private int columnDelta;
	
	public ChessMove(int rowDelta, int columnDelta)	
	{
		this.rowDelta = rowDelta;
		this.columnDelta = columnDelta;
	}

	public int getRowDelta() {
		return rowDelta;
	}
	
	public int getColumnDelta() {
		return columnDelta;
	}
}
