package com.qin.springcloud.alibaba.service.impl;

import com.qin.springcloud.alibaba.dao.StorageMapper;
import com.qin.springcloud.alibaba.service.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * description
 *
 * @author DELL
 * @date 2021/12/25 15:26.
 */
@Service
public class StorageServiceImpl implements StorageService {

    private final Logger logger = LoggerFactory.getLogger(StorageServiceImpl.class);

    @Autowired
    private StorageMapper storageMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int decrease(Long productId, Integer count) {
        logger.info("---->扣减库存start");
        int result = storageMapper.decrease(productId, count);
        logger.info("---->扣减库存end");

        return result;
    }
}
