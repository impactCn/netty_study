package com.netty.netty2_1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program:
 * @description:
 * @author: SY_zheng
 * @create: 2019-03-28
 */
public class Server {

    // 使用原生的socket创建服务
    private ServerSocket serverSocket;

    public Server(int port) {
        try {
            this.serverSocket = new ServerSocket(port);
            System.out.println("服务端启动成功：端口" + port);
        } catch (IOException e) {
            System.out.println("服务端启动失败");
        }
    }

    public void start() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                doStart();
            }
        }).start();
    }

    private void doStart() {
        while (true) {
            try {
                Socket client = serverSocket.accept();
                new ClientHandler(client).start();
            } catch (IOException e) {
                System.out.println("服务端一场");
            }
        }
    }
}
