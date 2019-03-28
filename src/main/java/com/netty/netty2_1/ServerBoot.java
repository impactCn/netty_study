package com.netty.netty2_1;

/**
 * @description:
 * @author: SY_zheng
 * @create: 2019-03-28
 */
public class ServerBoot {

    // 原生的socket编写
    private static final int PORT = 8000;

    public static void main(String[] args) {
        Server server = new Server(PORT);
        server.start();
    }

}
