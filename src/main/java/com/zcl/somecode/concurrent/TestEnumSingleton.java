package com.zcl.somecode.concurrent;

import java.awt.Color;

public enum TestEnumSingleton {
	INSTANCE;
	private TestEnumSingleton(){  
    } 

	public String[] buildStr(){
		final String[] animals = new String[10];  
		  
        animals[0] = new String("1");  
        animals[1] = new String("2");  
        animals[2] = new String("3"); 
        animals[3] = new String("4"); 
        animals[4] = new String("5"); 
        animals[5] = new String("6"); 
        animals[6] = new String("7"); 
        animals[7] = new String("8"); 
        animals[8] = new String("9"); 
        animals[9] = new String("10"); 
        return animals;  
	}
	
}
