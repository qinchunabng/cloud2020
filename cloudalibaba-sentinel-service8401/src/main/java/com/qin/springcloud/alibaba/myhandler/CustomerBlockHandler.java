package com.qin.springcloud.alibaba.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.qin.springcloud.entities.CommonResult;

/**
 * description
 *
 * @author DELL
 * @date 2021/12/19 17:10.
 */
public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException e){
        return new CommonResult(4444, "按客户定义，globalEx handlerException-----1");
    }

    public static CommonResult handlerException2(BlockException e){
        return new CommonResult(4444, "按客户定义，globalEx handlerException-----2");
    }
}
