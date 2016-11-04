package com.zcl.somecode.concurrent.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExecutorTest {  
	 public static void main(String[] args) {  
	  
	/*
	 * (1) newCachedThreadPool
	 * 创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
	 * 线程池为无限大，当执行第二个任务时第一个任务已经完成，会复用执行第一个任务的线程，而不用每次新建线程
	 */
//	  ExecutorService cachedThreadPool = Executors.newCachedThreadPool();  
//	  for (int i = 0; i < 10; i++) {  
//	   final int index = i;  
//	   try {  
//	    Thread.sleep(index * 1000);  
//	   } catch (InterruptedException e) {  
//	    e.printStackTrace();  
//	   }  
//	   cachedThreadPool.execute(new Runnable() {  
//	    public void run() {  
//	     System.out.println(index);  
//	    }  
//	   });  
//	  }  
	  
	  /*
	   * 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待
	   * 因为线程池大小为3，每个任务输出index后sleep 2秒，所以每两秒打印3个数字。
	   * 定长线程池的大小最好根据系统资源进行设置。如Runtime.getRuntime().availableProcessors()
	   */
	  ExecutorService fixedThreadPool = Executors.newFixedThreadPool(4);  
//	  for (int i = 0; i < 10; i++) {  
//	   final int index = i;  
//	   fixedThreadPool.execute(new Runnable() {  
//	    public void run() {  
//	     try {  
//	      System.out.println(index);  
//	      Thread.sleep(2000);  
//	     } catch (InterruptedException e) {  
//	      e.printStackTrace();  
//	     }  
//	    }  
//	   });  
//	  }
//		System.out.println(outputs);
	  
	  ExecutorService singleThreadExecutor = Executors.newCachedThreadPool();  
	  for (int i = 0; i < 100; i++) {  
	   final int index = i;  
	   singleThreadExecutor.execute(new Runnable() {  
	    public void run() {  
	     try {  
	      while(true) {  
	       System.out.println(index);  
	       Thread.sleep(10 * 1000);  
	      }  
	     } catch (InterruptedException e) {  
	      e.printStackTrace();  
	     }  
	    }  
	   });  
	   try {  
	    Thread.sleep(500);  
	   } catch (InterruptedException e) {  
	    e.printStackTrace();  
	   }  
	  }  
//		 System.out.println(Runtime.getRuntime().availableProcessors());
	  
	 }
} 