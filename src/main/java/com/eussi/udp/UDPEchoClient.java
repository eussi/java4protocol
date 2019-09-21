package com.eussi.udp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @author wangxueming
 * @create 2019-09-21 18:51
 * @description
 */
public class UDPEchoClient {
    public static void main(String[] args) throws Exception {
        int serverPort = 7;             //发送端口
        byte[] recvBuf = new byte[256]; //接收缓存
        byte[] sendBuf = new byte[256]; //发送缓存

        //创建客户套接字
        DatagramSocket socket = new DatagramSocket();

        //找出服务器地址
        InetAddress serverAddr = InetAddress.getByName("localhost");

        //输入字符串
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String sendString = in.readLine();
        sendBuf = sendString.getBytes();

        //发送数据报
        DatagramPacket sendPacket = new DatagramPacket(sendBuf, sendBuf.length, serverAddr, serverPort);
        socket.send(sendPacket);

        //接收数据报
        DatagramPacket recvPacket = new DatagramPacket(recvBuf, recvBuf.length);
        socket.receive(recvPacket);

        //输出字符串
        String recvString = new String(recvPacket.getData());
        System.out.println("Receive from server:" + recvString);

        //关闭套接字
        socket.close();
    }
}//结束class
