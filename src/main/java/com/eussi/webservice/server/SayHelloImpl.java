package com.eussi.webservice.server;

import javax.jws.WebService;

/**
 * Created by xueming.wang on 2019/3/26.
 */
@WebService
public class SayHelloImpl implements ISayHello{
    @Override
    public String sayHello(String str) {
        System.out.println("call sayHello()");
        return "Hello," + str + ",I am Webservice";
    }
}
