package com.qin.springcloud.alibaba.service.impl;

import com.qin.springcloud.alibaba.dao.OrderMapper;
import com.qin.springcloud.alibaba.domain.Order;
import com.qin.springcloud.alibaba.service.AccountService;
import com.qin.springcloud.alibaba.service.OrderService;
import com.qin.springcloud.alibaba.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * description
 *
 * @author DELL
 * @date 2021/12/25 14:43.
 */
@Service
public class OrderServiceImpl implements OrderService {

    private final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private StorageService storageService;

    @Autowired
    private AccountService accountService;

    /**
     * 创建订单->调用库存服务扣减库存->调用账户服务扣减余额->修改订单状态
     * @param order
     */
    @GlobalTransactional(name = "fsp-create-order", rollbackFor = Exception.class)
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void create(Order order) {
        logger.info("---->开始创建订单");
        orderMapper.create(order);

        logger.info("---->订单微服务开始调用库存，减库存start");
        storageService.decrease(order.getProductId(), order.getCount());
        logger.info("----> 订单微服务开始调用库存，减库存end");

        logger.info("---->订单微服务开始调用，减账户余额start");
        accountService.decrease(order.getUserId(), order.getMoney());
        logger.info("---->订单微服务开始调用，减账户余额end");

        logger.info("---->修改订单状态start");
        orderMapper.update(order.getUserId(), 0);
        logger.info("---->修改订单状态end");

        logger.info("---->创建订单结束");
    }
}
