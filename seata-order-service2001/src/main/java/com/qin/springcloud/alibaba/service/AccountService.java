package com.qin.springcloud.alibaba.service;

import com.qin.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * description
 *
 * @author DELL
 * @date 2021/12/25 14:46.
 */
@FeignClient(value = "seata-account-service")
public interface AccountService {

    @RequestMapping("/account/decrease")
    CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);

}
