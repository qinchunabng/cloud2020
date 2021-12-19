package com.qin.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.qin.springcloud.alibaba.myhandler.CustomerBlockHandler;
import com.qin.springcloud.entities.CommonResult;
import com.qin.springcloud.entities.Payment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * description
 *
 * @author DELL
 * @date 2021/12/17 23:51.
 */
@RestController
public class FlowLimitController {

    private final Logger logger = LoggerFactory.getLogger(FlowLimitController.class);

    @GetMapping("/testA")
    public String testA(){
        return "-------testA";
    }

    @GetMapping("/testB")
    public String testB(){
        logger.info(Thread.currentThread().getName() + ": testB");
        return "-------testB";
    }

    @GetMapping("/testE")
    public String testE(){
        logger.info(Thread.currentThread().getName() + ": testE");
        int n = 10 / 0;
        return "-------testE";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "dealHotTestKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1, @RequestParam(value = "p2", required = false) String p2){
        return "testHotKey, p1=" + p1 + ",p2=" + p2;
    }

    public String dealHotTestKey(String p1, String p2, BlockException e){
        return "deal hotTestKey, p1=" + p1 + ",p2=" + p2;
    }


    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public CommonResult byResource(){
        return new CommonResult(200,"按资源名称限流测试OK", new Payment());
    }

    public CommonResult handleException(BlockException exception){
        return new CommonResult(444,exception.getClass().getCanonicalName() + "服务不可用");
    }

    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl", blockHandlerClass = CustomerBlockHandler.class, blockHandler = "handlerException2")
    public CommonResult byUrl(){
        return new CommonResult(200,"按url限流测试OK", new Payment());
    }
}
