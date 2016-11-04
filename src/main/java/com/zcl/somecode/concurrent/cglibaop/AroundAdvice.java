package com.zcl.somecode.concurrent.cglibaop;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class AroundAdvice implements MethodInterceptor  {
	public Object intercept(Object target, Method method 
			 , Object[] args, MethodProxy proxy) 
			 throws Throwable
			 { 
				 System.out.println("执行目标方法之前，模拟开始事务 ..."); 
				 // 执行目标方法，并保存目标方法执行后的返回值
				 Object rvt = proxy.invokeSuper(target, args); 
				 System.out.println("执行目标方法之后，模拟结束事务 ..."); 
				 return rvt + " 新增的内容"; 
			 }

//	@Override
//	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
//		String info = methodInvocation.getMethod().getDeclaringClass()+ "." +   
//	        methodInvocation.getMethod().getName() + "()";  
//    
//	        System.out.println(info);  
//	          
//	        try{  
//	            Object result = methodInvocation.proceed();  
//	            return result;  
//	        }  
//	        finally{  
//	            System.out.println(info);  
//	        }  
//	    } 
}
