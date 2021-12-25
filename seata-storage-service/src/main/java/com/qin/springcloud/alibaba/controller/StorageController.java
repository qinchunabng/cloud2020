package com.qin.springcloud.alibaba.controller;

import com.qin.springcloud.alibaba.service.StorageService;
import com.qin.springcloud.entities.CommonResult;
import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * description
 *
 * @author DELL
 * @date 2021/12/25 15:28.
 */
@RestController
public class StorageController {

    @Autowired
    private StorageService storageService;

    @RequestMapping(value = "/storage/decrease", method = RequestMethod.POST)
    public CommonResult decrease(@RequestParam("productId") Long productId,@RequestParam("count") Integer count){
        storageService.decrease(productId, count);
        return new CommonResult(200,"扣减库存成功");
    }
}
