package com.zcl.somecode.concurrent.exception;

public class InsufficientFundsException extends Exception{
	 private Bank  excepbank;      // 银行对象
	   private double excepAmount;   // 要取的钱
	   InsufficientFundsException(Bank ba, double  dAmount){  excepbank=ba;
	       excepAmount=dAmount;
	   }
	   public String excepMessage(){
	   	  String  str="The balance is"+excepbank.balance
	       + "\n"+"The withdrawal was"+excepAmount;
	   	  return str; 	
	   }
}
