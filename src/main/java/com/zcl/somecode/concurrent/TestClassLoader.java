package com.zcl.somecode.concurrent;

import java.util.ArrayList;
import java.util.HashMap;

public class TestClassLoader {
	 
    public static void main(String[] arg){
 
      ClassLoader c  = TestClassLoader.class.getClassLoader();  //获取Test类的类加载器
 
        System.out.println(c); 
 
      ClassLoader c1 = c.getParent();  //获取c这个类加载器的父类加载器
 
        System.out.println(c1);
 
      ClassLoader c2 = c1.getParent();//获取c1这个类加载器的父类加载器
      /**
       * null, extensionClassLoader 的parent 是bootstartpClassLoader
       * bootstartpClassLoader 是jvm部分，c++编写，所以下面java类为null
       */
        System.out.println(c2);
        
  }
 
}