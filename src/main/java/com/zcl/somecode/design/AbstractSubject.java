package com.zcl.somecode.design;

import java.util.Enumeration;
import java.util.Vector;

public abstract  class AbstractSubject implements Subject{
	
	private Vector<Observer> vector = new Vector<Observer>();

	public void add(Observer ob){
		vector.add(ob);
	}
	
	public void del(Observer ob){
		vector.remove(ob);
	}
	
	public void notifyOb(){
		Enumeration<Observer> enumo = vector.elements();
		while(enumo.hasMoreElements()){
			enumo.nextElement().update();
		}
	}
}
