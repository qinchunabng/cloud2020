package com.qin.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * description
 *
 * @author DELL
 * @date 2021/12/25 15:20.
 */
@Mapper
public interface StorageMapper {

    /**
     * 扣库存
     * @param productId
     * @param count
     * @return
     */
    int decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
