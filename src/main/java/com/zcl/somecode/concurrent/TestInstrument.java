package com.zcl.somecode.concurrent;

import java.util.ArrayList;

public class TestInstrument {
	 
	 public static void main(String[] args) { 
		 ArrayList list = new ArrayList();
	        list.ensureCapacity(5000000);
	        long begin = System.currentTimeMillis();
	        for(int i=0; i<=500000000; i++){
	        	list.add(i);
	        }
	        long endtime = System.currentTimeMillis();
	        System.out.println(endtime-begin);
	    } 

}
