package com.zcl.somecode.concurrent.thread;

public class BlockingTakeThread implements Runnable{
	private BlockingQueue bq = null;
	public BlockingTakeThread(BlockingQueue b){
		this.bq = b;
	}
	public void run(){
		while(true){
			Object o = new Object();
			try {
				bq.take();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
}
