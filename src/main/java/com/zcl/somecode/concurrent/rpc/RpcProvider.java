package com.zcl.somecode.concurrent.rpc;

public class RpcProvider {
	public static void main(String[] args) throws Exception {  
        HelloService service = new HelloServiceImpl();  
        new HelloService() {

			public String hello(String name) {
				// TODO Auto-generated method stub
				return null;
			}
		};
        RpcFramework.export(service, 1234);  
    } 
}
