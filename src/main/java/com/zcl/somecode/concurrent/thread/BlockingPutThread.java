package com.zcl.somecode.concurrent.thread;

public class BlockingPutThread implements Runnable{
	private BlockingQueue bq = null;
	public BlockingPutThread(BlockingQueue b){
		this.bq = b;
	}
	public void run(){
		while(true){
			Object o = new Object();
			try {
				bq.put(o);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
