package com.qin.springcloud.alibaba.service;

import java.math.BigDecimal;

/**
 * description
 *
 * @author DELL
 * @date 2021/12/25 15:43.
 */
public interface AccountService {

    /**
     * 扣减账户余额
     * @param userId
     * @param money
     * @return
     */
    int decrease(Long userId, BigDecimal money);
}
