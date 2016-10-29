package org.java.base.nio.channel;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileOutputTest2 {

    static public void main( String args[] ) throws Exception {  
    	
    	String content = "测试中文nio........";
    	
        FileOutputStream fout = new FileOutputStream( "f:\\testnio_cn.txt" );  
          
        FileChannel fc = fout.getChannel();  
          
        ByteBuffer buffer = ByteBuffer.wrap(content.getBytes());
        buffer.put(content.getBytes());
        
        buffer.flip();
        
        fc.write(buffer);
        
        fc.close();
        fout.close();  
        System.out.println("完成。。。。。。。。。。");
    }  

}
