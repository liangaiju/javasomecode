package com.zcl.somecode.concurrent.exception;

/**
 * 自定义 RuntimeException
 * 添加错误代码属性
 */
public class RuntimeException extends java.lang.RuntimeException { 
     //默认错误代码 
    public static final Integer GENERIC = 1000000; 
    //错误代码
    private Integer errorCode; 
     public RuntimeException(Integer errorCode, Throwable cause) {
            this(errorCode, null, cause);
     }
     public RuntimeException(String message, Throwable cause) {
            //利用通用错误代码
            this(GENERIC, message, cause);
     }
     public RuntimeException(Integer errorCode, String message, Throwable cause) {
            super(message, cause);
            this.errorCode = errorCode;
     }
     public Integer getErrorCode() {
            return errorCode;
     } 
}