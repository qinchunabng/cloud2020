package com.qin.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * description
 *
 * @author DELL
 * @date 2021/12/25 15:39.
 */
@Mapper
public interface AccountMapper {

    /**
     * 扣减账户余额
     * @param usedId
     * @param money
     * @return
     */
    int decrease(@Param("userId") Long usedId, @Param("money") BigDecimal money);
}
