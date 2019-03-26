package com.eussi.webservice.server;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by xueming.wang on 2019/3/26.
 */
@WebService //SE和SEI
public interface ISayHello {
    @WebMethod //SEI中的方法
    public String sayHello(String str);
}
