package com.qin.springcloud.service.impl;

import com.qin.springcloud.service.IMessageProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import java.util.UUID;

/**
 * description
 *
 * @author DELL
 * @date 2021/12/04 14:09.
 */
@EnableBinding(Source.class)
public class MessageProviderImpl implements IMessageProvider {

    private final Logger logger = LoggerFactory.getLogger(MessageProviderImpl.class);

    /**
     * 消息发送通道
     */
    @Autowired
    private MessageChannel output;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        logger.info("***** serial: {}", serial);
        return serial;
    }
}
