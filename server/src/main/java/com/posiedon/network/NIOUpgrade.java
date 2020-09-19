package com.posiedon.network;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Posiedon.wh
 * @Date: 2020/5/18 21:00
 *
 * 支持多个客户端连接，解决阻塞问题
 */
public class NIOUpgrade {

    static ByteBuffer byteBuffer=ByteBuffer.allocate(512);
    static List<SocketChannel> socketList=new ArrayList<>();
    public static void main(String[] args) {
        try {
            ServerSocketChannel socketChannel = ServerSocketChannel.open();
            InetSocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 9000);
            socketChannel.bind(socketAddress);
            //不阻塞
            socketChannel.configureBlocking(false);

            while (true){
                SocketChannel channel = socketChannel.accept();
                if(channel!=null){
                    System.out.println("conn success");
                    channel.configureBlocking(false);//解决读阻塞

                    socketList.add(channel);
                    System.out.println("conn num:"+socketList.size());
                }

                for (SocketChannel socket : socketList) {
                    int read = socket.read(byteBuffer);
                    if(read>0){
                        byteBuffer.flip();
                        byte[] bs=new byte[read];
                        byteBuffer.get(bs);
                        System.out.println(new String(bs));
                        byteBuffer.flip();
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
