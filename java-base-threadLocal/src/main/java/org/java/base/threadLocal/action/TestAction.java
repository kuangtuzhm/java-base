package org.java.base.threadLocal.action;

import java.util.Random;

import org.java.base.threadLocal.service.TestServiceA;
import org.java.base.threadLocal.service.TestServiceB;


public class TestAction implements Runnable {

	@Override
	public void run() {
		
		Random r = new Random();
		
		Long userId = r.nextLong();
		
		TestServiceA a = new TestServiceA();
		
		TestServiceB b = new TestServiceB();
		
		a.setUserId(userId);
		//UserIdManage.setUserId(userId);
		a.A();
		a.B();
		
		b.A();
		b.B();
	}

	public static void main(String[] args) {
		
		TestAction s1 = new TestAction();
		
		Thread t1 = new Thread(s1);
		t1.start();
		
		Thread t2 = new Thread(s1);
		t2.start();
	}

}
