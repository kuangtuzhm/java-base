package org.java.base.proxy.cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class BookFacadeCglibProxy implements MethodInterceptor {

	
	/**
	 * 创建代理对象
	 * @param target
	 * @return
	 */
	public Object getInstance(Object target)
	{

		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(target.getClass());
		//回调方法
		enhancer.setCallback(this);
		//创建代理对象
		return enhancer.create();
	}
	
	@Override
	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {

		System.out.println("开始。。。。。。。。。。。");
		Object result = proxy.invokeSuper(obj, args);
		System.out.println("结束。。。。。。。。。。。");
		return result;
	}

}
