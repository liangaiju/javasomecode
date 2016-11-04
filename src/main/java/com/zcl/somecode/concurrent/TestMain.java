package com.zcl.somecode.concurrent;

import com.zcl.somecode.design.MySubject;
import com.zcl.somecode.design.Observer1;
import com.zcl.somecode.design.Observer2;
import com.zcl.somecode.design.Subject;

public class TestMain {
	
	public static void main(String[] args) {
//		String [] str = TestEnumSingleton.INSTANCE.buildStr();
//		System.out.print(str);
//		TestBean tb1 = new TestBean();
//		tb1.setI(1);
//		TestBean tb2 = new TestBean();
//		tb2 = tb1;
//		tb2.setI(2);
//		System.out.print(tb1.getI());
//		System.out.print(tb2.getI());
		
//		ServiceLoader<Command> serviceLoader=ServiceLoader.load(Command.class);  
//        for(Command command:serviceLoader){  
//            command.execute();  
//        }
//		Integer i = 0;
//		while(i<Integer.MAX_VALUE){
//			HashMap<Object, Object> t = new HashMap<Object, Object>(20000000);
//		}
//		int rs = -1 << 29;
//		System.out.println(rs);
//		int c0 = rs | 0;
//		System.out.println(c0);
		
		Subject su = new MySubject();
		su.add(new Observer1());
		su.add(new Observer2());
		su.operation();
	}

}


