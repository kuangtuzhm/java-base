package org.java.base.proxy.staticproxy;

public class TestRealSubjectProxy {

	public static void main(String[] args) {

		Subject subject = new RealSubject();
		
		Subject subjectProxy = new RealSubjectProxy(subject);
		subjectProxy.rent();
		subjectProxy.hello("11111");
		
	}

}
