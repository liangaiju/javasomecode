package com.zcl.somecode.concurrent.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class BlockingMain {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		BlockingQueue b = new BlockingQueue(10);
//		new Thread(new BlockingTakeThread(b)).start();
//		new Thread(new BlockingPutThread(b)).start();
//		new Thread(new BlockingPutThread(b)).start();
//		new Thread(new BlockingPutThread(b)).start();
//		new Thread(new BlockingPutThread(b)).start();

//		if (b instanceof Object) {
//			System.out.println("----------");
//		}
		System.out.println("1111----"+System.currentTimeMillis());
		//Thread匿名子类，应该写个单例类
		
		ExecutorService cutor = Executors.newCachedThreadPool();
		Task task = new Task();
		Future<Integer> result = cutor.submit(task);
		cutor.shutdown();
		try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
         
//        System.out.println("主线程在执行任务");
        //如果没
//        while(!result.isDone()){
//        	System.out.println("计算中。。。。");
//        }
        try {
            System.out.println("task运行结果"+result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("所有任务执行完毕");
		
//		new Thread(){
			//匿名类不能写静态块代码，静态块，在jvm启动时加载入方法区
//			static{
//				System.out.println("xxx");
//			}
//			public void run(){
//			for(int i=0; i<10;i++){
//				System.out.println("2222----"+i);
//			}
//		 }
//		}.start();
//		System.out.println("3333----"+System.currentTimeMillis());
	}

}


class Task implements Callable<Integer>{
	
	public Integer call() throws Exception {
		System.out.println("子线程在进行计算");
		Thread.sleep(3000);
		int sum = 0;
        for(int i=0;i<100;i++)
            sum += i;
        return sum;
	}
	
}