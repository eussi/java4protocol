package com.eussi.rmi.client;

import com.eussi.rmi.remote.UserHandler;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


public class RmiClient {
	public static void main(String[] args) {
		try {
//            UserHandler handler = (UserHandler) Naming.lookup("rmi://127.0.0.1:1099/user");//使用url访问调用失败

            Context context = new InitialContext();
            UserHandler handler = (UserHandler) context.lookup("rmi://127.0.0.1:1099/user");

            int  count = handler.getUserCount();
		    String name = handler.getUserName(1);
		    System.out.println("name: " + name);
		    System.out.println("count: " + count);
		    System.out.println("user: " + handler.getUserByName("wangxm"));
		} catch (RemoteException e) {
		    e.printStackTrace();
		} catch (Exception e) {
            e.printStackTrace();
        }
    }
}
