package com.eussi.nanomsg;

import nanomsg.exceptions.IOException;
import nanomsg.reqrep.RepSocket;
import nanomsg.reqrep.ReqSocket;

/**
 * Created by wangxueming on 2019/3/26.
 */
public class ReqRep {
    private static String url = "ipc://tmp/.proxy.ipc";

    public static void main(String[] args) {
        node0();
        node1();
    }
    private static void node1() {
        final RepSocket socket = new RepSocket();
        socket.bind(url);
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        System.out.println("node1:" + socket.recvString());
                        System.out.println(socket.getSndFd());
                        System.out.println(socket.getRcvFd());
                        System.out.println(socket.getNativeSocket());
                        Thread.sleep(1000);
                        socket.send("world");

                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    private static void node0() {
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    final ReqSocket socket = new ReqSocket();
                    socket.connect(url);
                    try {
                        socket.send("hello");
                        Thread.sleep(1000);
                        System.out.println( "node0:" + socket.recvString());  // 阻塞socket，直到超时或者有响应
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}