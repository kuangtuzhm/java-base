package org.java.base.proxy.cglib;

public class BookFacadeImpl2 implements BookFacadeCglib {

	@Override
	public void addBook(String name, float price) {
		
		System.out.println("实现了接口的增加方法:name="+name+",price="+price);

	}

}
