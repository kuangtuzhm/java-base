package org.java.base.nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class TCPClient {

	// 信道选择器  
    private Selector selector;  
  
    // 与服务器通信的信道  
    SocketChannel socketChannel;  
  
    // 要连接的服务器Ip地址  
    private String hostIp;  
  
    // 要连接的远程服务器在监听的端口  
    private int hostListenningPort;  
  
    public TCPClient(String HostIp, int HostListenningPort) throws IOException {  
        this.hostIp = HostIp;  
        this.hostListenningPort = HostListenningPort;  
  
        initialize();  
    }  
    /**  
     * 初始化  
     *   
     * @throws IOException  
     */  
    private void initialize() throws IOException {  
        // 打开监听信道并设置为非阻塞模式  
        socketChannel = SocketChannel.open(new InetSocketAddress(hostIp,  
                hostListenningPort));  
        socketChannel.configureBlocking(false);  
  
        // 打开并注册选择器到信道  
        selector = Selector.open();  
        socketChannel.register(selector, SelectionKey.OP_READ);  
  
        // 启动读取线程  
        new TCPClientReadThread(selector);  
    }  
    /**  
     * 发送字符串到服务器  
     *   
     * @param message  
     * @throws IOException  
     */  
    public void sendMsg(String message) throws IOException {  
        ByteBuffer writeBuffer = ByteBuffer.wrap(message.getBytes("UTF-8"));  
        socketChannel.write(writeBuffer);  
    }  
    static TCPClient client;  
    static boolean mFlag = true;  
    public static void main(String[] args) throws IOException {  
        client = new TCPClient("192.168.1.70", 1982);  
        new Thread() {  
            @Override  
            public void run() {  
                try {  
                    client.sendMsg("你好!Nio!醉里挑灯看剑,梦回吹角连营");
                    int i = 0;
                    while (mFlag) {
                    	Thread.sleep(1000);
                        client.sendMsg("客户端写入="+i++);  
                    }  
                } catch (IOException e) {  
                    mFlag = false;  
                    e.printStackTrace();  
                } catch (InterruptedException e) {
                	mFlag = false;  
					e.printStackTrace();
				} finally {  
                    mFlag = false;  
                }  
                super.run();  
            }  
        }.start();  
    }  
}
