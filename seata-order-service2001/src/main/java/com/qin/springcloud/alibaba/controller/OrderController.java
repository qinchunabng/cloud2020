package com.qin.springcloud.alibaba.controller;

import com.qin.springcloud.alibaba.domain.Order;
import com.qin.springcloud.alibaba.service.OrderService;
import com.qin.springcloud.entities.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description
 *
 * @author DELL
 * @date 2021/12/25 15:00.
 */
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/order/create")
    public CommonResult create(Order order){
        orderService.create(order);
        return new CommonResult(200,"创建订单成功");
    }
}
