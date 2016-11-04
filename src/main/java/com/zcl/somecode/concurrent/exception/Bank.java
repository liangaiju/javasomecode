package com.zcl.somecode.concurrent.exception;

public class Bank {
	double balance;// 存款数
	   Bank(double  balance){this.balance=balance;}
	   public void deposite(double dAmount){
	   	 if(dAmount>0.0) balance+=dAmount;
	   }
	   public void withdrawal(double dAmount) throws InsufficientFundsException{
	   	 if (balance<dAmount)     throw new
	          InsufficientFundsException(this, dAmount);
	      balance=balance-dAmount;
	   }
	   public void showBalance(){
	      System.out.println("The balance is "+(int)balance);
	   }
}
