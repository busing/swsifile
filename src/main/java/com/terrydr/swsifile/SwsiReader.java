package com.terrydr.swsifile;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class SwsiReader {
	private File file;
	
	private int index;
	
	private long postion;
	
	private long readLength;
	
	private RandomAccessFile raf;
	
	private boolean next;

	
	public SwsiReader(String file) {
		super();
		this.file = new File(file);
		try {
			raf=new RandomAccessFile(this.file, "r");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public long getPostion() {
		return postion;
	}

	public long getReadLength() {
		return readLength;
	}

	public RandomAccessFile getRaf() {
		return raf;
	}

	public void setRaf(RandomAccessFile raf) {
		this.raf = raf;
	}
	
	

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public void setPostion(long postion) {
		this.postion = postion;
	}

	public void setReadLength(long readLength) {
		this.readLength = readLength;
	}
	
	public boolean next()
	{
		this.next=this.file.length()>this.postion?true:false;
		return next;
	}

	public void read(){
		try {
			this.index=raf.readInt();
			this.setReadLength(raf.readInt());
			byte[] image=new byte[new Long(this.readLength).intValue()];
//			System.out.println("byte length:"+image.length);
			this.setPostion(this.getPostion()+8);
			raf.read(image, 0, new Long(this.readLength).intValue());
			this.setPostion(this.postion+this.readLength);
			File file=new File("/home/splitimage/"+this.index+".jpg");
			FileOutputStream fos=new FileOutputStream(file);
			fos.write(image);
			fos.flush();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	 public int readInt() throws IOException {
	        int ch1 = this.raf.read();
	        int ch2 = this.raf.read();
	        int ch3 = this.raf.read();
	        int ch4 = this.raf.read();
	        if ((ch1 | ch2 | ch3 | ch4) < 0)
	            throw new EOFException();
	        return ((ch1 << 24) + (ch2 << 16) + (ch3 << 8) + (ch4 << 0));
	    }

	@Override
	public String toString() {
		return "SwsiReader [index=" + index + ", postion=" + postion + ", readLength=" + readLength + ", next=" + next
				+ "]";
	}

}
