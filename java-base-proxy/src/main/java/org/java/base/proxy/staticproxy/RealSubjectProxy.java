package org.java.base.proxy.staticproxy;

public class RealSubjectProxy implements Subject {

	private Subject subject;
	
	public RealSubjectProxy(Subject subject)
	{
		this.subject = subject;
	}
	
	@Override
	public void rent() {
		System.out.println("静态代理rent开始.....");
		subject.rent();
		System.out.println("静态代理rent结束.....");
	}

	@Override
	public void hello(String str) {
		System.out.println("静态代理hello开始.....");
		subject.hello(str);
		System.out.println("静态代理hello结束.....");
	}

}
