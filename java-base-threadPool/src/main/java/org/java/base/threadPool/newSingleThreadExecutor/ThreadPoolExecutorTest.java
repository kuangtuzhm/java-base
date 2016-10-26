package org.java.base.threadPool.newSingleThreadExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExecutorTest {

	public static void main(String[] args) {
		
		ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
		
		for(int i = 0; i < 10; i++)
		{
			singleThreadExecutor.execute(new Runnable(){

				@Override
				public void run() {
					System.out.println("线程名："+Thread.currentThread().getName()+" Time="+System.currentTimeMillis());
				}
				
			});
		}
	}

}
