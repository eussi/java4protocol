package com.eussi.webservice.server;

import javax.xml.ws.Endpoint;

/**
 * Created by xueming.wang on 2019/3/26.
 */
public class PublishWebService {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8888/sayhello", new SayHelloImpl());
        System.out.println("Publish Success !");
    }
}
