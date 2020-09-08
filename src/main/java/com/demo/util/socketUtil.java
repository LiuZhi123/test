package com.demo.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class socketUtil {
    //TCP socket
    public void reciveTcp() throws IOException {
        ServerSocket socket = new ServerSocket(33007);
        Socket accept=socket.accept();
        DataInputStream inputStream = new DataInputStream(accept.getInputStream());
        JSONObject jsonObject = JSONObject.parseObject(inputStream.readUTF());
        inputStream.close();
        System.out.println("接收到的数据为："+jsonObject.toString());
    }


    public void sendTcp(String message) throws IOException {
        Socket socket = new Socket("10.25.1.98",33007);
        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream out  = new DataOutputStream(outputStream);
        out.writeUTF(message);
        out.close();
        System.out.println("发送的数据为："+message);
    }
}
