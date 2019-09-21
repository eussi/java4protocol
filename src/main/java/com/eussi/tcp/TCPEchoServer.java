package com.eussi.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author wangxueming
 * @create 2019-09-21 21:43
 * @description
 */
public class TCPEchoServer {
    public static void main(String[] args) throws Exception {
        int serverPort = 7;             //服务器端口
        byte[] buffer = new byte[256];  //字节缓存
        int br = 0;                     //读入的字节数

        //创建服务器套接字
        ServerSocket listenSocket = new ServerSocket(serverPort);
        for(;;) {
            //创建连接套接字为客户服务
            Socket connectSocket = listenSocket.accept();
            //创建输入和输出流以接收和发送数据
            InputStream in = connectSocket.getInputStream();
            OutputStream out = connectSocket.getOutputStream();
            //从流中读出和写入
            while((br = in.read(buffer))>0) {
                System.out.println("Client ip[" + connectSocket.getInetAddress().toString() + "]");
                System.out.println("Receive from client:" + new String(buffer, 0, br));

                out.write(buffer, 0, br);
            }
            //关闭socket
            connectSocket.close();
        }
    }
}//结束class
