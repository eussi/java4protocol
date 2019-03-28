package com.eussi.rmi.remote;

import com.eussi.rmi.domain.User;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class UserHandlerImpl extends UnicastRemoteObject implements UserHandler {
    // 该构造期必须存在，因为集继承了UnicastRemoteObject类，其构造器要抛出RemoteException
    public UserHandlerImpl() throws RemoteException {
        super();
    }

    @Override
    public String getUserName(int id) throws RemoteException {
        return "wangxm";
    }
    @Override
    public int getUserCount() throws RemoteException{
        return 1;
    }
    @Override
    public User getUserByName(String name) throws RemoteException{
        return new User("wangxm", 1);
    }
}