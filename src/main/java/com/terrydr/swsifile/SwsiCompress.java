package com.terrydr.swsifile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author taiyuan
 * 扫描图片压缩
 */
public class SwsiCompress {
	private static final String folder="/Users/taiyuan/Desktop/73619881-4D6C-4D9A-8B09-130F3400375D_20161206165606117";
//	private static final String folder="/home/splitimage";
	
	
	private static final String target="/Users/taiyuan/Desktop/swsifile.tdr";
//	private static final String target="/terrydr-hd/wsi/2016-12-16/tdr/swsifile_new.tdr";
	
	public static void compress(){
		
		try {
			RandomAccessFile raf=new RandomAccessFile(new File(target), "rw");
			long position=0;
			File file=new File(folder);
			String[] images=file.list();
			int index;
			int size;
			File i;
			FileInputStream fis;
			for (String img : images) {
				if(!img.endsWith(".jpg"))
				{
					continue;
				}
				index=Integer.parseInt(img.substring(0,img.lastIndexOf(".")));
				i=new File(folder+File.separator+img);
				size=new Long(i.length()).intValue();
				
				raf.seek(position);
				raf.writeInt(index);
				position+=4;
				raf.writeInt(size);
				position+=4;
				
				fis=new FileInputStream(i);
				byte[] temp=new byte[1024];
				int b=0;
				while((b=fis.read(temp))!=-1)
				{
					raf.seek(position);
					raf.write(temp, 0, b);
					position+=b;
				}
				fis.close();
			}
			raf.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		long s=System.currentTimeMillis();
		compress();
		long e=System.currentTimeMillis();
		System.out.println("cost time:"+(e-s));
	}
}
