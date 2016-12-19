package com.terrydr.swsifile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class TileReader {
	public static final String TILE_PATH = "/Users/taiyuan/Desktop/242A5B5B-617F-45A2-ACE9-7F4FB10050F4_20161215092451337/tilesreader";

	public static final String TILE_HEAD = "/Users/taiyuan/Desktop/242A5B5B-617F-45A2-ACE9-7F4FB10050F4_20161215092451337/tiles/tiles.tdrh";
	public static final String TILE_FILE = "/Users/taiyuan/Desktop/242A5B5B-617F-45A2-ACE9-7F4FB10050F4_20161215092451337/tiles/tiles.tdrf";
	
	public static final File TILE_HEAD_F = new File(TILE_HEAD);
	public static final File TILE_FILE_F = new File(TILE_FILE);
	
	public static RandomAccessFile rafHeader;
	public static RandomAccessFile rafFile;
	
	static{
		try {
			rafHeader=new RandomAccessFile(TILE_HEAD_F, "r");
			rafFile=new RandomAccessFile(TILE_FILE_F, "r");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try {
			FileOutputStream fos;
			int headPostion=0;
			int b=0;
			while((b=rafHeader.read())!=-1)
			{
				rafHeader.seek(headPostion);
				int layer=rafHeader.readInt();
				int row=rafHeader.readInt();
				int col=rafHeader.readInt();
				int postion=rafHeader.readInt();
				int length=rafHeader.readInt();
				headPostion+=5*4;
				
				System.out.println("headPostion:"+headPostion+"\tlayer:"+layer+"\trow:"+row+"\tcol:"+col+"\tp:"+postion+"\tlength:"+length);
				
				rafFile.seek(postion);
				byte[] tileBuffer=new byte[length];
				rafFile.readFully(tileBuffer, 0, length);
				
				String tileFolder=new StringBuffer(TILE_PATH)
						.append(File.separator)
						.append(layer)
						.append(File.separator).toString();
				
				String tileFile=new StringBuffer(tileFolder)
						.append(row)
						.append("_")
						.append(col)
						.append(".jpg").toString();
				File folder=new File(tileFolder);
				folder.mkdirs();
				File tile=new File(tileFile);
				fos=new FileOutputStream(tile);
				fos.write(tileBuffer, 0, length);
				fos.close();
			}
			rafHeader.close();
			rafFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
