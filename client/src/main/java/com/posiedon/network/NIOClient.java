package com.posiedon.network;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * @Author: Posiedon.wh
 * @Date: 2020/5/18 20:37
 */
public class NIOClient {
    public static void main(String[] args) {
        for (int i = 0; i < 1; i++) {
            new Thread(()->{
                Socket socket = null;
                 byte[] bs=new byte[1024];
                try {
                    socket = new Socket("127.0.0.1",9000);
                    socket.getOutputStream().write(("my client3").getBytes());
                    InputStream inputStream = socket.getInputStream();
                    inputStream.read(bs);
                    System.out.println("收到返回值："+new String(bs));
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }).start();
        }
    }
}
