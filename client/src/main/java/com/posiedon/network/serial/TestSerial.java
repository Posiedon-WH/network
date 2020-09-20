package com.posiedon.network.serial;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Posiedon.wh
 * @Date: 2020/9/20 21:31
 */
public class TestSerial {

    @Test
    public void saveTest(){
        UserInfo userInfo = new UserInfo("Posiedon.wh", 18);
        ArrayList<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("E:\\temp\\serial.text"));
            out.writeObject(userInfo);
            out.writeObject(list);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void readSerial(){
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("E:\\temp\\serial.text"));
            UserInfo userInfo=(UserInfo)inputStream.readObject();
            System.out.println(userInfo.getName());
            System.out.println(userInfo.getAge());

            List list= (List) inputStream.readObject();
            list.forEach(System.out::println);
            inputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
