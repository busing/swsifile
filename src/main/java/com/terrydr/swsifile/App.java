package com.terrydr.swsifile;

/**
 * Hello world!
 *
 */
public class App 
{
    /**
     * @param args
     */
    public static void main( String[] args )
    {
    		SwsiReader sr=new SwsiReader("/terrydr-hd/wsi/2016-12-16/tdr/swsifile.tdr");
    		long s=System.currentTimeMillis();
    		while(sr.next())
    		{
    			sr.read();
    		}
    		System.out.println(sr.toString());
    		long e=System.currentTimeMillis();
    		System.out.println("cost time :"+(e-s));
    }
}
