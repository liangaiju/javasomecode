package com.zcl.somecode.design;

public interface Subject {
	
	public void add(Observer ob);
	
	public void del(Observer ob);
	
	public void notifyOb();
	
	public void operation();

}
