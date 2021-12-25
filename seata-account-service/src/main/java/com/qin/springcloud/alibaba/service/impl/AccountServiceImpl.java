package com.qin.springcloud.alibaba.service.impl;

import com.qin.springcloud.alibaba.dao.AccountMapper;
import com.qin.springcloud.alibaba.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * description
 *
 * @author DELL
 * @date 2021/12/25 15:44.
 */
@Service
public class AccountServiceImpl implements AccountService {

    private final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Autowired
    private AccountMapper accountMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int decrease(Long userId, BigDecimal money) {
        logger.info("---->扣减账户余额start");
        accountMapper.decrease(userId, money);
        logger.info("---->扣减账户余额end");
        return 0;
    }
}
