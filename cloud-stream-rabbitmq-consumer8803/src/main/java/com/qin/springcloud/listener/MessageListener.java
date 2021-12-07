package com.qin.springcloud.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

/**
 * description
 *
 * @author DELL
 * @date 2021/12/04 14:49.
 */
@EnableBinding(Sink.class)
public class MessageListener {

    private final Logger logger = LoggerFactory.getLogger(MessageListener.class);

    @Value("${server.port}")
    private String serverPort;


    @StreamListener(Sink.INPUT)
    public void input(Message<String> message){
        logger.info("收到消息: {}, 服务端口: {}", message.getPayload(), serverPort);
    }
}
