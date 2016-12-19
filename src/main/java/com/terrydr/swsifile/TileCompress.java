package com.terrydr.swsifile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class TileCompress{
	public static final String TILE_PATH = "/Users/taiyuan/Desktop/242A5B5B-617F-45A2-ACE9-7F4FB10050F4_20161215092451337/tiles";

	public static final String TILE_HEAD = "/Users/taiyuan/Desktop/242A5B5B-617F-45A2-ACE9-7F4FB10050F4_20161215092451337/tiles/tiles.tdrh";
	public static final String TILE_FILE = "/Users/taiyuan/Desktop/242A5B5B-617F-45A2-ACE9-7F4FB10050F4_20161215092451337/tiles/tiles.tdrf";
	
	public static final File TILE_HEAD_F = new File(TILE_HEAD);
	public static final File TILE_FILE_F = new File(TILE_FILE);
	
	public static RandomAccessFile rafHeader;
	public static RandomAccessFile rafFile;
	
	static{
		try {
			rafHeader=new RandomAccessFile(TILE_HEAD_F, "rw");
			rafFile=new RandomAccessFile(TILE_FILE_F, "rw");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static int CURRENT_INDEX=0;

	public static void main(String[] args) {
		try {
			readTilePath(TILE_PATH);
			rafHeader.close();
			rafFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void readTilePath(String tilePath) {
		File f = new File(tilePath);
		if (f.isDirectory()) {
			String[] tiles = f.list();
			for (String t : tiles) {
				readTilePath(tilePath + File.separator + t);
			}
		} else {
			if (tilePath.endsWith(".jpg")) {
				int layer = Integer.parseInt(tilePath.substring(tilePath.lastIndexOf("tiles/")+6, tilePath.lastIndexOf(File.separator)));
				appendTiles(tilePath, layer);
			}
		}

	}

	public static void appendTiles(String tile, int layer) {
		System.out.println("append tiles:" + tile);
		File tFile=new File(tile);
		try {
			FileInputStream fis=new FileInputStream(tFile);
			byte[] buffer=new byte[1024];
			int b=0;
			int length=0;
			while((b=fis.read(buffer, 0, 1024))!=-1)
			{
				rafFile.write(buffer, 0, b);
				length+=b;
			}
			
			String[] fileArr=tile.substring(tile.lastIndexOf("/")+1,tile.indexOf(".")).split("_");
			int row=Integer.parseInt(fileArr[0]);
			int col=Integer.parseInt(fileArr[1]);
			//layer
			rafHeader.writeInt(layer);
			rafHeader.writeInt(row);
			rafHeader.writeInt(col);
			//开始位置
			rafHeader.writeInt(CURRENT_INDEX);
			//文件长度
			rafHeader.writeInt(length);
			
			System.out.println("layer:"+layer+"\trow:"+row+"\tcol:"+col+"\tindex:"+CURRENT_INDEX);
			
			CURRENT_INDEX+=length;
			
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
