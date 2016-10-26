package org.java.base.threadPool.newScheduledThreadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorTest {

	public static void main(String[] args) {
		
		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
		for(int i = 0; i< 10 ; i++)
		{
//		scheduledThreadPool.schedule(new Runnable(){
//
//			@Override
//			public void run() {
//				System.out.println("task delay 3 seconds....");
//			}
//			
//		}, 3, TimeUnit.SECONDS);
		
		scheduledThreadPool.scheduleAtFixedRate(new Runnable(){

			@Override
			public void run() {
				System.out.println("线程名："+Thread.currentThread().getName()+" Time="+System.currentTimeMillis());
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
		}, 1, 1, TimeUnit.SECONDS);
		
//		scheduledThreadPool.scheduleWithFixedDelay(new Runnable(){
//
//			@Override
//			public void run() {
//				System.out.println("线程名："+Thread.currentThread().getName()+" Time="+System.currentTimeMillis());
//				try {
//					Thread.sleep(2000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			
//			
//		}, 1, 1, TimeUnit.SECONDS);
		}
	}

}
