package com.qin.springcloud.alibaba.controller;

import com.qin.springcloud.alibaba.service.AccountService;
import com.qin.springcloud.entities.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * description
 *
 * @author DELL
 * @date 2021/12/25 15:46.
 */
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    /**
     * 扣减账户余额
     * @param userId
     * @param money
     * @return
     */
    @RequestMapping("/account/decrease")
    public CommonResult decrease(@RequestParam Long userId, @RequestParam BigDecimal money){
        accountService.decrease(userId, money);
        return new CommonResult(200,"扣减账户余额成功");
    }
}
