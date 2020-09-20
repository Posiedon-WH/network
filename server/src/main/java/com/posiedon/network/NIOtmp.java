package com.posiedon.network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: Posiedon.wh
 * @Date: 2020/5/18 20:29
 */
public class NIOtmp {
    static byte[] bs=new byte[1024];
    public static void main(String[] args) {
        int i = Runtime.getRuntime().availableProcessors();
        System.out.println("cpu核心数："+i);
        try {
            ServerSocket serverSocket = new ServerSocket(9000);
            while (true){
                System.out.println("wait conn");
                //1等待连接阻塞
                Socket serverSocketImpl = serverSocket.accept();

                //2等待数据阻塞
                System.out.println("wait data");
                serverSocketImpl.getInputStream().read(bs);
                System.out.println("data success");
                System.out.println(new String(bs));
                serverSocketImpl.getOutputStream().write("hello ".getBytes());

                //3 不支持多个客户端，如何解决，思路：解除阻塞，保存有效连接，循环读取数据
                //sun公司开发出新类——>

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
