package org.java.base.proxy.dynamicproxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {
	
	private Object subject;
	
	public Object newProxyInstance(Object subject)
	{
		this.subject = subject;
		return Proxy.newProxyInstance(subject.getClass().getClassLoader(), 
				subject.getClass().getInterfaces(), this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {

		System.out.println("before invoke the method............");
		
		System.out.println("the invoked method is:"+method.getName());
		
		method.invoke(subject, args);
		
		System.out.println("after invoke the method.............");
		
		return null;
	}

}
