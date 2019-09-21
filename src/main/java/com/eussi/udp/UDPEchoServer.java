package com.eussi.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @author wangxueming
 * @create 2019-09-21 18:45
 * @description
 */
public class UDPEchoServer {
    public static void main(String[] args) throws Exception {
        int serverPort = 7;             //服务器端口
        byte[] recvBuf = new byte[256]; //接收缓存
        byte[] sendBuf = new byte[256]; //发送缓存

        //创建服务器套接字
        DatagramSocket socket = new DatagramSocket(serverPort);
        for(;;) {
            //收到一个数据报
            DatagramPacket receivePacket = new DatagramPacket(recvBuf, recvBuf.length);
            socket.receive(receivePacket);
            System.out.println("Client ip[" + receivePacket.getAddress() + "], port[" + receivePacket.getPort() + "]");
            System.out.println("Receive from client:" + new String(receivePacket.getData()));

            //发送这个数据
            DatagramPacket sendPacket = new DatagramPacket(recvBuf, recvBuf.length, receivePacket.getAddress(), receivePacket.getPort());
            socket.send(sendPacket);

        }//结束for循环
    }//结束main
}//结束class
