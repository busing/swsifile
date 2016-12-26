package com.terrydr.swsifile.fenlan;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class FenlanFile {
	
	private RandomAccessFile raf;
	
	private String fenlanFile;
	
	private int version;
	
	private String company;
	
	private String device;
	
	private long date;
	
	private int width;
	
	private int height;
	
	private int maxLayer;
	
	private int minLayer;
	
	private float pixel;
	
	private int tileWidth;
	
	private int tileHeight;
	
	private int imageFormat;
	
	private int maxRate;
	
	private int labelLayer;
	
	private int labelCol;
	
	private int labelRow;
	
	private long labelPosition;
	
	private int labelLength;
	
	private int thumbLayer;
	
	private int thumbCol;
	
	private int thumbRow;
	
	private long thumbPosition;
	
	private int thumbLength;
	
	private int layerNum;
	
	private int layerMaxCol;
	
	private int layerMaxRow;
	
	private int layerImagePostion;
	
	List<LayerDynamicIndex> layerIndex;
	
	List<ImageDynamicIndex> imageIndex;
	
	public RandomAccessFile getRaf() {
		return raf;
	}

	public void setRaf(RandomAccessFile raf) {
		this.raf = raf;
	}

	public String getFenlanFile() {
		return fenlanFile;
	}

	public void setFenlanFile(String fenlanFile) {
		this.fenlanFile = fenlanFile;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getMaxLayer() {
		return maxLayer;
	}

	public void setMaxLayer(int maxLayer) {
		this.maxLayer = maxLayer;
	}

	public int getMinLayer() {
		return minLayer;
	}

	public void setMinLayer(int minLayer) {
		this.minLayer = minLayer;
	}

	public float getPixel() {
		return pixel;
	}

	public void setPixel(float pixel) {
		this.pixel = pixel;
	}

	public int getTileWidth() {
		return tileWidth;
	}

	public void setTileWidth(int tileWidth) {
		this.tileWidth = tileWidth;
	}

	public int getTileHeight() {
		return tileHeight;
	}

	public void setTileHeight(int tileHeight) {
		this.tileHeight = tileHeight;
	}

	public int getImageFormat() {
		return imageFormat;
	}

	public void setImageFormat(int imageFormat) {
		this.imageFormat = imageFormat;
	}

	public int getMaxRate() {
		return maxRate;
	}

	public void setMaxRate(int maxRate) {
		this.maxRate = maxRate;
	}

	public int getLabelLayer() {
		return labelLayer;
	}

	public void setLabelLayer(int labelLayer) {
		this.labelLayer = labelLayer;
	}

	public int getLabelCol() {
		return labelCol;
	}

	public void setLabelCol(int labelCol) {
		this.labelCol = labelCol;
	}

	public int getLabelRow() {
		return labelRow;
	}

	public void setLabelRow(int labelRow) {
		this.labelRow = labelRow;
	}

	public long getLabelPosition() {
		return labelPosition;
	}

	public void setLabelPosition(long labelPosition) {
		this.labelPosition = labelPosition;
	}

	public int getLabelLength() {
		return labelLength;
	}

	public void setLabelLength(int labelLength) {
		this.labelLength = labelLength;
	}

	public int getThumbLayer() {
		return thumbLayer;
	}

	public void setThumbLayer(int thumbLayer) {
		this.thumbLayer = thumbLayer;
	}

	public int getThumbCol() {
		return thumbCol;
	}

	public void setThumbCol(int thumbCol) {
		this.thumbCol = thumbCol;
	}

	public int getThumbRow() {
		return thumbRow;
	}

	public void setThumbRow(int thumbRow) {
		this.thumbRow = thumbRow;
	}

	public long getThumbPosition() {
		return thumbPosition;
	}

	public void setThumbPosition(long thumbPosition) {
		this.thumbPosition = thumbPosition;
	}

	public int getThumbLength() {
		return thumbLength;
	}

	public void setThumbLength(int thumbLength) {
		this.thumbLength = thumbLength;
	}
	

	public int getLayerNum() {
		return layerNum;
	}

	public void setLayerNum(int layerNum) {
		this.layerNum = layerNum;
	}

	public int getLayerMaxCol() {
		return layerMaxCol;
	}

	public void setLayerMaxCol(int layerMaxCol) {
		this.layerMaxCol = layerMaxCol;
	}

	public int getLayerMaxRow() {
		return layerMaxRow;
	}

	public void setLayerMaxRow(int layerMaxRow) {
		this.layerMaxRow = layerMaxRow;
	}

	public int getLayerImagePostion() {
		return layerImagePostion;
	}

	public void setLayerImagePostion(int layerImagePostion) {
		this.layerImagePostion = layerImagePostion;
	}
	

	public List<LayerDynamicIndex> getLayerIndex() {
		return layerIndex;
	}

	public void setLayerIndex(List<LayerDynamicIndex> layerIndex) {
		this.layerIndex = layerIndex;
	}

	public List<ImageDynamicIndex> getImageIndex() {
		return imageIndex;
	}

	public void setImageIndex(List<ImageDynamicIndex> imageIndex) {
		this.imageIndex = imageIndex;
	}

	@Override
	public String toString() {
		return "FenlanFile [version=" + version + ", company=" + company + ", device=" + device + ", date=" + date
				+ ", width=" + width + ", height=" + height + ", maxLayer=" + maxLayer + ", minLayer=" + minLayer
				+ ", \npixel=" + pixel + ", tileWidth=" + tileWidth + ", tileHeight=" + tileHeight + ", imageFormat="
				+ imageFormat + ", maxRate=" + maxRate + ", \nlabelLayer=" + labelLayer + ", labelCol=" + labelCol
				+ ", labelRow=" + labelRow + ", labelPosition=" + labelPosition + ", labelLength=" + labelLength
				+ ", \nthumbLayer=" + thumbLayer + ", thumbCol=" + thumbCol + ", thumbRow=" + thumbRow
				+ ", thumbPosition=" + thumbPosition + ", thumbLength=" + thumbLength + ", \nlayerNum=" + layerNum
				+ ", layerMaxCol=" + layerMaxCol + ", layerMaxRow=" + layerMaxRow + ", layerImagePostion="
				+ layerImagePostion + "]";
	}
	
	
	
	
	public FenlanFile(String fenlanFile) {
		this.fenlanFile=fenlanFile;
		try {
			this.raf = new RandomAccessFile(fenlanFile, "r");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	
	public void readFile() {
		try {
			//读取基本信息
			readBaseInfo();
			//读取标签信息
			readLabelInfo();
			//读取缩略图信息
			readThumbInfo();
			//读取层的动态索引信息
			readDynamicLayerIndex();
			//读取图片的动态索引信息
			readDynamicImageIndex();
			System.out.println(this);
			System.out.println(layerIndex);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 瓦片图抽取
	 * @param outputFolder	输出目录
	 */
	public void extractImages(String outputFolder)
	{
		File folder;
		File jpg;
		FileOutputStream fos;
		for (ImageDynamicIndex image : imageIndex) {
			folder=new File(outputFolder+File.separator+image.getLayer()+File.separator);
			if(!folder.exists())
			{
				folder.mkdirs();
			}
			jpg=new File(folder.getAbsolutePath()+File.separator+image.getRow()+"_"+image.getCol()+".jpg");
			byte[] b=new byte[image.getSize()];
			try {
				this.raf.seek(image.getPosition());
				this.raf.read(b,0,image.getSize());
				fos=new FileOutputStream(jpg);
				fos.write(b);
				fos.flush();
				fos.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 读取动态图片索引信息
	 * @throws IOException
	 */
	private void readDynamicImageIndex() throws IOException {
		int fileCount=0;
		ImageDynamicIndex iIndex;
		for (LayerDynamicIndex layer : layerIndex) {
			fileCount+=layer.getCol()*layer.getRow();
		}
		imageIndex=new ArrayList<ImageDynamicIndex>();
		for(int f=0;f<fileCount;f++)
		{
			iIndex=new ImageDynamicIndex();
			iIndex.setLayer(this.readUnsignShort());
			iIndex.setCol(this.readInt());
			iIndex.setRow(this.readInt());
			iIndex.setPosition(this.readLong());
			iIndex.setSize(this.readInt());
			imageIndex.add(iIndex);
		}
	}

	/**
	 * 读取动态层索引
	 * @throws IOException
	 */
	private void readDynamicLayerIndex() throws IOException {
		layerIndex=new ArrayList<LayerDynamicIndex>();
		LayerDynamicIndex dIndex;
		for (int i = this.getMaxLayer(); i <= this.getMinLayer(); i++) {
			dIndex = new LayerDynamicIndex();
			dIndex.setLayer(this.readUnsignShort());
			dIndex.setCol(this.readInt());
			dIndex.setRow(this.readInt());
			dIndex.setPosition(this.readInt());
			layerIndex.add(dIndex);
		}
	}

	private void readThumbInfo() throws IOException {
		this.setThumbLayer(this.readShort());
		this.setThumbCol(this.readInt());
		this.setThumbRow(this.readInt());
		this.setThumbPosition(this.readLong());
		this.setThumbLength(this.readInt());
	}

	/**
	 * 读取标签信息
	 * @throws IOException
	 */
	private void readLabelInfo() throws IOException {
		this.setLabelLayer(this.readShort());
		this.setLabelCol(this.readInt());
		this.setLabelRow(this.readInt());
		this.setLabelPosition(this.readLong());
		this.setLabelLength(this.readInt());
	}

	/**
	 * 读取基本信息
	 * @throws IOException
	 */
	private void readBaseInfo() throws IOException {
		this.setVersion(this.readInt());
		this.setCompany(this.readString(7));
		this.raf.skipBytes(1);
		this.setDevice(this.readString(10));
		this.setDate(this.readLong());
		this.setWidth(this.readInt());
		this.setHeight(this.readInt());
		this.setMaxLayer(this.readUnsignShort());
		this.setMinLayer(this.readUnsignShort());
		this.setPixel(Float.intBitsToFloat(this.readInt()));
		this.setTileWidth(this.readUnsignShort());
		this.setTileHeight(this.readUnsignShort());
		this.setImageFormat(this.readUnsignShort());
		this.setMaxRate(this.readInt());
	}

	private int readInt() throws IOException {
		int ch1 = raf.read();
		int ch2 = raf.read();
		int ch3 = raf.read();
		int ch4 = raf.read();
		if ((ch1 | ch2 | ch3 | ch4) < 0)
			throw new EOFException();
		return ((ch1 << 0) + (ch2 << 8) + (ch3 << 16) + (ch4 << 24));
	}

	/**
	 * 读取两位没有符号位的short
	 * @return
	 * @throws IOException
	 */
	private int readUnsignShort() throws IOException {
		int ch1 = this.raf.read();
		int ch2 = this.raf.read();
		if ((ch1 | ch2) < 0)
			throw new EOFException();
		return (ch1 << 0) + (ch2 << 8);
	}

	/**
	 * 读取两位的short
	 * @return
	 * @throws IOException
	 */
	private int readShort() throws IOException {
		int ch1 = this.raf.read();
		int ch2 = this.raf.read();
		if ((ch1 | ch2) < 0)
			throw new EOFException();
		boolean isNeg = (ch2 & 0x80) == 0x80;
		if (isNeg) {
			return (ch1 << 0) + (ch2 << 8) - 0x00010000;
		} else {
			return (ch1 << 0) + (ch2 << 8);
		}
	}

	/**
	 * 读取8位long
	 * @return
	 * @throws IOException
	 */
	public long readLong() throws IOException {
		int ch1 = this.raf.read();
		int ch2 = this.raf.read();
		int ch3 = this.raf.read();
		int ch4 = this.raf.read();
		int ch5 = this.raf.read();
		int ch6 = this.raf.read();
		int ch7 = this.raf.read();
		int ch8 = this.raf.read();
		if ((ch1 | ch2 | ch3 | ch4 | ch5 | ch6 | ch7 | ch8) < 0)
			throw new EOFException();
		return (ch1 << 0) | (ch2 << 8) | (ch3 << 16) | (ch4 << 24) | (ch5 << 32)| (ch6 << 40) | (ch7 << 48)
				| (ch8 << 56);
	}

	private String readString(int length) throws IOException {
		byte[] buffer = new byte[length];
		raf.readFully(buffer);
		return new String(buffer, "utf-8");
	}
}
