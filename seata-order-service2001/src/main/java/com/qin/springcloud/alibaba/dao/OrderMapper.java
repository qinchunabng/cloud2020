package com.qin.springcloud.alibaba.dao;


import com.qin.springcloud.alibaba.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * description
 *
 * @author qcb
 * @date 2021/12/25 13:37.
 */
@Mapper
public interface OrderMapper {

    /**
     * 新建订单
     * @param order
     */
    void create(Order order);

    /**
     * 修改订单状态
     * @param userId
     */
    void update(@Param("userId") Long userId,@Param("status") Integer status);
}
