package org.java.base.nio.channel;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 不支持中文
 * @author Administrator
 *
 */
public class FileInputTest {

	public static void main(String[] args) throws Exception{
		
		FileInputStream fin = new FileInputStream("f:\\邀请码.txt");
		
		FileChannel fc = fin.getChannel();
		
		ByteBuffer buffer = ByteBuffer.allocate(1024);

		fc.read(buffer);

		buffer.flip();
		
		while(buffer.hasRemaining())
		{
			byte  b = buffer.get();
			System.out.print((char)b);
		}
		
		if(fin != null)
		{
			fin.close();
		}
	}

}
