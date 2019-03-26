package com.eussi.webservice.client;

/**
 * Created by xueming.wang on 2019/3/27.
 */
public class Client {
    public static void main(String[] args) {
        SayHelloImplService service = new SayHelloImplService();
        SayHelloImpl sayHello = service.getSayHelloImplPort();
        System.out.println(sayHello.sayHello("wangxm"));
    }
}
