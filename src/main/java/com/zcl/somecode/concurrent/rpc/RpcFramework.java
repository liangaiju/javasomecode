package com.zcl.somecode.concurrent.rpc;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.ServerSocket;
import java.net.Socket;

public class RpcFramework {
	
	  /**
     * 暴露服务
     * 
     * @param service 服务实现
     * @param port 服务端口
     * @throws Exception
     */
    public static void export(final Object service, int port) throws Exception {
        if (service == null)
            throw new IllegalArgumentException("service instance == null");
        if (port <= 0 || port > 65535)
            throw new IllegalArgumentException("Invalid port " + port);
        System.out.println("Export service " + service.getClass().getName() + " on port " + port);
        ServerSocket server = new ServerSocket(port);
        for(;;) {
            try {
                final Socket socket = server.accept();
                new Thread(new Runnable() {
                    public void run() {
                        try {
                            try {
                                ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                                try {
                                    String methodName = input.readUTF();//方法名称
                                    Class<?>[] parameterTypes = (Class<?>[])input.readObject();//参数类型
                                    Object[] arguments = (Object[])input.readObject();//参数对象
                                    ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
                                    System.out.println("-----------method: "+methodName + "p:"+parameterTypes);
                                    try {
                                        Method method = service.getClass().getMethod(methodName, parameterTypes);
                                        /***
                                         * invoke
                                         * 对带有指定参数的指定对象调用由此 Method 对象表示的底层方法。个别参数被自动解包，以便与基本形参相匹配，基本参数和引用参数都随需服从方法调用转换。
											如果底层方法是静态的，那么可以忽略指定的 obj 参数。该参数可以为 null。
											
											如果底层方法所需的形参数为 0，则所提供的 args 数组长度可以为 0 或 null。
											
											如果底层方法是实例方法，则使用动态方法查找来调用它，这一点记录在 Java Language Specification, Second Edition 的第 15.12.4.4 节中；在发生基于目标对象的运行时类型的重写时更应该这样做。
											
											如果底层方法是静态的，并且尚未初始化声明此方法的类，则会将其初始化。
											
											如果方法正常完成，则将该方法返回的值返回给调用者；如果该值为基本类型，则首先适当地将其包装在对象中。但是，如果该值的类型为一组基本类型，则数组元素不 被包装在对象中；换句话说，将返回基本类型的数组。
											如果底层方法返回类型为 void，则该调用返回 null。
                                         */
                                        Object result = method.invoke(service, arguments);
                                        System.out.println("-----------result: "+result);
                                        output.writeObject(result);
                                    } catch (Throwable t) {
                                        output.writeObject(t);
                                    } finally {
                                        output.close();
                                    }
                                } finally {
                                    input.close();
                                }
                            } finally {
                                socket.close();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 引用服务
     * 
     * @param <T> 接口泛型
     * @param interfaceClass 接口类型
     * @param host 服务器主机名
     * @param port 服务器端口
     * @return 远程服务
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public static <T> T refer(final Class<T> interfaceClass, final String host, final int port) throws Exception {
        if (interfaceClass == null)
            throw new IllegalArgumentException("Interface class == null");
        if (! interfaceClass.isInterface())
            throw new IllegalArgumentException("The " + interfaceClass.getName() + " must be interface class!");
        if (host == null || host.length() == 0)
            throw new IllegalArgumentException("Host == null!");
        if (port <= 0 || port > 65535)
            throw new IllegalArgumentException("Invalid port " + port);
        System.out.println("Get remote service " + interfaceClass.getName() + " from server " + host + ":" + port);
        /*
         * public static Object newProxyInstance(ClassLoader loader,
                                      Class<?>[] interfaces,
                                      InvocationHandler h)
                               throws IllegalArgumentException
         * 返回一个指定接口的代理类实例，该接口可以将方法调用指派到指定的调用处理程序。此方法相当于：
	     * Proxy.getProxyClass(loader, interfaces).
	     *    getConstructor(new Class[] { InvocationHandler.class }).
	     *    newInstance(new Object[] { handler });
	     *    接口的类装载器、接口、代理实例都具有一个关联的调用处理程序InvocationHandler,invoke方法生成
         */
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class<?>[] {interfaceClass}, 
        		//生成一个InvocationHandler接口的实例对象
        		new InvocationHandler() {
            /**
             * 实现invoke方法
             */
        	public Object invoke(Object proxy, Method method, Object[] arguments) throws Throwable {
                Socket socket = new Socket(host, port);
                try {
                    ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
                    try {
                    	System.out.println("-----------method: "+method.getName());
                        output.writeUTF(method.getName());//写入方法名称
                        output.writeObject(method.getParameterTypes());//写入方法参数的类型
                        output.writeObject(arguments);//写入方法参数
                        ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                        try {
                            Object result = input.readObject();//服务器返回的实例对象信息
                            if (result instanceof Throwable) {
                                throw (Throwable) result;
                            }
                            return result;
                        } finally {
                            input.close();
                        }
                    } finally {
                        output.close();
                    }
                } finally {
                    socket.close();
                }
            }
        }
        );
    }


}
