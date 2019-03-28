package com.eussi.rmi.server;

import com.eussi.rmi.remote.UserHandler;
import com.eussi.rmi.remote.UserHandlerImpl;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class RunRmi {
	public static void main(String[] args) {
		UserHandler userHandler = null;
		Registry registry = null;
		try {
            userHandler = new UserHandlerImpl();

		    //不通过rmiregistry.exe单独运行，而是通过编程来实现
//            registry = LocateRegistry.createRegistry(1099);
//            registry.rebind("rmi://127.0.0.1:1099/user", userHandler);//测试使用url调用失败

            // 初始化命名空间
            Context namingContext = new InitialContext();
            // 将名称绑定到对象,即向命名空间注册已经实例化的远程服务对象
            namingContext.rebind("rmi://127.0.0.1:1099/user", userHandler);

		    System.out.println(" rmi server is ready ...");
		} catch (Exception e) {
		    e.printStackTrace();
		}
	}
}
