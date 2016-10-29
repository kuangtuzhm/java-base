package org.java.base.nio.buffer;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MappedByteBufferTest {

	public static void main(String[] args) throws Exception {
		
		RandomAccessFile raf = new RandomAccessFile( "f:\\testMappedByteBuffer.txt", "rw" );  
        FileChannel fc = raf.getChannel();  
          
        MappedByteBuffer mbb = fc.map( FileChannel.MapMode.READ_WRITE,  
          0, 1024 );  
       
        mbb.put( 0, (byte)97 );  
        mbb.put( 1, (byte)99 ); 
        mbb.put( 1023, (byte)122 );  
          
        raf.close();  
        
        System.out.println("完成。。。。。。。。。");
	}

}
