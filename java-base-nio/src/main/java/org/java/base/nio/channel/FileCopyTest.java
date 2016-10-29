package org.java.base.nio.channel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * 中文
 * @author Administrator
 *
 */
public class FileCopyTest {

	public static void main(String[] args) throws Exception{
		
		Charset charset = Charset.forName("UTF-8");//Java.nio.charset.Charset处理了字符转换问题。它通过构造CharsetEncoder和CharsetDecoder将字符序列转换成字节和逆转换。  
        CharsetDecoder decoder = charset.newDecoder(); 
		
		FileInputStream fin = new FileInputStream("f:\\stdout.log");
		FileChannel fc = fin.getChannel();
		
		FileOutputStream fout = new FileOutputStream( "f:\\testnio_zh2.txt" );  
        FileChannel fc2 = fout.getChannel();  
		
		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
		int bytes = fc.read(byteBuffer);  
		while(bytes!=-1){  
             byteBuffer.flip();  
             fc2.write(byteBuffer);
             byteBuffer.clear();  
             bytes = fc.read(byteBuffer);  
         }  
         if(fin!=null){  
        	 fin.close();  
         } 
	}

}
