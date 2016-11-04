package com.zcl.somecode.concurrent;

import java.lang.reflect.Constructor;
import java.net.URL;


/**
 * 通过一个对象获得完整的包名和类名
 * 
 * Spring IOC的原理  java 反射
 * 
 * */
class Demo{
    //other codes...
	private String name = "aaaa";
	
	public String getName(){
		return name;
	}

	public Demo() {
		super();
	}

	public Demo(String name) {
		super();
		this.name = name;
	}
	
}
 
class TestReflect{
    /**
     * @param args
     * 
     * 
     */
    public static void main(String[] args) {
    	 try {
	    	Demo demo=new Demo();
	        System.out.println(demo.getClass().getName());
	        Class<?> needObjClass = null;
	        needObjClass = Class.forName(demo.getClass().getName());
	        //class实例化demo类
	        Demo demo2 = (Demo) needObjClass.newInstance();
	        Demo demo3 = (Demo)Class.forName("me.ele.pms.test.Demo").newInstance();
			System.out.println(demo2.getName());
			
			String str = "ss";
			/*
			 * 每个 Class 对象都包含一个对定义它的 ClassLoader 的引用
			 * 
			 */
			
			for(int i=0;i<demo3.getClass().getDeclaredFields().length;i++){
				System.out.println("def: "+demo3.getClass().getDeclaredFields()[i].getName());
			}
			System.out.println("classLoader: "+demo.getClass().getClassLoader());
			
			System.out.println("fatherClassLoader : " + demo2.getClass().getClassLoader().getParent());
			
			System.out.println("grafatherClassLoader : " + str.getClass().getClassLoader());
			//获取class 代表的demo类的所有constructor构造函数
			Constructor<?> con[] = needObjClass.getConstructors();
			for(int i = 0;i<con.length ; i++){
				System.out.println(con[i]);
			}
			
			
			URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();  
			for (int i = 0; i < urls.length; i++) {  
			    System.out.println(urls[i].toExternalForm());  
			} 
     }catch(Exception e){
    	 e.printStackTrace();
     }
    }
}
