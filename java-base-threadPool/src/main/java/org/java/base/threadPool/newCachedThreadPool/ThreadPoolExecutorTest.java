package org.java.base.threadPool.newCachedThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExecutorTest {

	public static void main(String[] args) {
		
		 ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		 
		 for(int i = 0; i< 10 ; i++)
		 {
			 final int index = i;
			 try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			 cachedThreadPool.execute(new Runnable(){

				@Override
				public void run() {
					System.out.println("线程名："+Thread.currentThread().getName()+";index="+index);
				}
				 
			 });
		 }
	}

}
