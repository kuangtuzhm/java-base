package org.java.base.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SubjectProxy implements InvocationHandler {

	private Object subject;
	
	public Object newInstance(Object obj)
	{
		this.subject = obj;
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), 
				obj.getClass().getInterfaces(), this);
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println(method.getName()+"动态代理开始..........");
		method.invoke(subject, args);
		System.out.println(method.getName()+"动态代理结束..........");
		return null;
	}

}
