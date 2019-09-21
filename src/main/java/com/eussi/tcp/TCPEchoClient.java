package com.eussi.tcp;

import java.io.*;
import java.net.Socket;

/**
 * @author wangxueming
 * @create 2019-09-21 22:00
 * @description
 */
public class TCPEchoClient {
    public static void main(String[] args) throws Exception {
        String serverIp = "127.0.0.1";
        int serverPort = 7;             //发送端口
        byte[] recvBuf = new byte[256]; //接收缓存
        byte[] sendBuf = new byte[256]; //发送缓存
        int tbr = 0;                    //接收的字节总数
        int br;                         //接收字节数

        //创建套接字
        Socket socket = new Socket(serverIp, serverPort);
        //输入字符串
        BufferedReader buffer = new BufferedReader((new InputStreamReader(System.in)));
        String sendString = buffer.readLine();
        sendBuf = sendString.getBytes();

        //发送数据
        OutputStream out = socket.getOutputStream();
        out.write(sendBuf);

        //接收数据
        InputStream in = socket.getInputStream();
        while(tbr < sendBuf.length) {
            br = in.read(recvBuf);
            tbr = tbr + br;
        }

        //输出回送的字符串
        String recvString = new String(recvBuf);
        System.out.println("Receive from server:" + recvString);

        //关闭套接字
        socket.close();
    }//结束main
}//结束class
