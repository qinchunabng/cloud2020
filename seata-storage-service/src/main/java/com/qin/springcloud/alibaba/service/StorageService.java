package com.qin.springcloud.alibaba.service;

/**
 * description
 *
 * @author DELL
 * @date 2021/12/25 15:25.
 */
public interface StorageService {

    /**
     * 扣减库存
     * @param productId
     * @param count
     * @return
     */
    int decrease(Long productId, Integer count);
}
