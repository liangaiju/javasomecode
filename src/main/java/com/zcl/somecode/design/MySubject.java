package com.zcl.somecode.design;

public class MySubject extends AbstractSubject{
	
	public void operation() {
		// TODO Auto-generated method stub
		System.out.println("update self!");
		notifyOb();
	}

}
