package com.terrydr.swsifile.fenlan;

public class FenlanTest {
	public static final String FENLAN = "/Users/taiyuan/Desktop/3.fenlan";
	public static final String FENLAN_SPLIT = "/Users/taiyuan/Desktop/fenlan_split";

	public static void main(String[] args) {
		FenlanFile ff=new FenlanFile(FENLAN);
		ff.readFile();
		ff.extractImages(FENLAN_SPLIT);
		ff.closeReader();
	}
}
