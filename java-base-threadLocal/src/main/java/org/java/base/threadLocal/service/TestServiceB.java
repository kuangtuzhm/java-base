package org.java.base.threadLocal.service;

import org.java.base.threadLocal.local.UserIdManage;

public class TestServiceB {

	public void setUserId(Long userId)
	{
		UserIdManage.setUserId(userId);
	}
	
	public void A()
	{
		System.out.println("TestServiceB::A="+ UserIdManage.getUserId());
	}
	
	public void B()
	{
		System.out.println("TestServiceB::B="+ UserIdManage.getUserId());
	}
}
