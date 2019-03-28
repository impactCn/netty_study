package com.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;


/**
 * @description: 初始化连接时候的各个组件
 * @author: SY_zheng
 * @create: 2019-02-28
 */

public class MyWebsocketChannelHandler extends ChannelInitializer<SocketChannel>{


    @Override
    protected void initChannel(SocketChannel channel) throws Exception {
        channel.pipeline().addLast("http-codec", new HttpServerCodec());
        channel.pipeline().addLast("aggregator", new HttpObjectAggregator(65536));
        channel.pipeline().addLast("http-chunked", new ChunkedWriteHandler());
        channel.pipeline().addLast("handle", new MyWebsocketChannelHandler());

    }
}
