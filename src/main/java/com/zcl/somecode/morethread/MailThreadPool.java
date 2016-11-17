package com.zcl.somecode.morethread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
* @ClassName: MailThreadPool
* @Description: TODO(这里用一句话描述这个类的作用)
* @author chunliang.zhan
* @date 2016年8月25日 下午4:06:49
*
 */
public class MailThreadPool {
	//邮件发送线程池,初始化5个  --static   静态变量  放在方法区内   直到该类被卸载，一直全局可用
//	public static ExecutorService sendEmailPool = Executors.newFixedThreadPool(5);
	
	//邮件发送线程池,初始化5个   变量   堆内存对象中
	public ExecutorService sendEmailPool = Executors.newFixedThreadPool(5);
	//单例该类
	private static class SingletonHolder{
		private static final MailThreadPool INSTANCE = new MailThreadPool();
	}
	private MailThreadPool (){}
	
	public static final MailThreadPool getInstance(){
		return SingletonHolder.INSTANCE;
	}
}
