package com.posiedon.network;

import java.io.IOException;
import java.net.Socket;

/**
 * @Author: Posiedon.wh
 * @Date: 2020/5/18 20:37
 */
public class NIOClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1",9000);
            socket.getOutputStream().write("my client3".getBytes());
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
