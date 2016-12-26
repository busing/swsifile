package com.terrydr.swsifile.fenlan;

public class ImageDynamicIndex {
	private int layer;
	
	private int col;
	
	private int row;
	
	private long position;
	
	private int size;
	
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

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	@Override
	public String toString() {
		return "ImageDynamicIndex [layer=" + layer + ", col=" + col + ", row=" + row + ", position=" + position
				+ ", size=" + size + "]\n";
	}
	
	
	
}
