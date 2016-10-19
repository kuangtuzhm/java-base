package org.java.base.threadLocal.local;

public class UserIdManage {

	private static final ThreadLocal<Long> userIdLocal = new ThreadLocal<Long>();
	
	public static Long getUserId()
	{
		return userIdLocal.get();
	}
	
	public static void setUserId(Long userId)
	{
		userIdLocal.set(userId);
	}
}
