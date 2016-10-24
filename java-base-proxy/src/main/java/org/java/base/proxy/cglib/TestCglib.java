package org.java.base.proxy.cglib;

public class TestCglib {

	public static void main(String[] args) {
		
		BookFacadeCglibProxy proxy = new BookFacadeCglibProxy();
		BookFacadeImpl1 b1 = (BookFacadeImpl1)proxy.getInstance(new BookFacadeImpl1());
		b1.addBook("金瓶梅",11112.22f);
		
		BookFacadeCglib b2 = (BookFacadeCglib)proxy.getInstance(new BookFacadeImpl2());
		b2.addBook("金瓶梅2",11112.22f);
	}

}
