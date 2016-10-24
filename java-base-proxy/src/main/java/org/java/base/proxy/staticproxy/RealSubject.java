package org.java.base.proxy.staticproxy;

public class RealSubject implements Subject {

	private String myStr;
	
	public String myStr4Public;
	
	public RealSubject()
	{
		myStr4Public = "default";
	}
	
	public RealSubject(String myStr4Public)
	{
		this.myStr4Public = myStr4Public;
	}
	
	@Override
	public void rent() {
		System.out.println("I want to rent my house");
	}

	@Override
	public void hello(String str) {
		System.out.println("hello:" +str);
	}

	public String getMyStr() {
		return myStr;
	}

	public void setMyStr(String myStr) {
		this.myStr = myStr;
	}

	
}
