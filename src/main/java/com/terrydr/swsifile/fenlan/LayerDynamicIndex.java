package com.terrydr.swsifile.fenlan;

public class LayerDynamicIndex {
	private int layer;
	
	private int col;
	
	private int row;
	
	private long position;
	
	public int getLayer() {
		return layer;
	}

	public void setLayer(int layer) {
		this.layer = layer;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public long getPosition() {
		return position;
	}

	public void setPosition(long position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "LayerDynamicIndex [layer=" + layer + ", col=" + col + ", row=" + row + ", position=" + position + "]\n";
	}
	
	
}
