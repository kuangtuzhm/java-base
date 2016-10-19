package org.java.base.threadLocal.service;

import org.java.base.threadLocal.local.UserIdManage;

public class TestServiceA {

	public void setUserId(Long userId)
	{
		UserIdManage.setUserId(userId);
	}
	
	public void A()
	{
		System.out.println("TestServiceA::A="+ UserIdManage.getUserId());
	}
	
	public void B()
	{
		System.out.println("TestServiceA::B="+ UserIdManage.getUserId());
	}
}
