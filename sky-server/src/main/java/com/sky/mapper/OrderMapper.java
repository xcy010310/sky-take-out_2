package com.sky.mapper;

import com.sky.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

/**
 * ClassName: OrderMapper
 * Package: com.sky.mapper
 * Description: This is a program for testing.
 *
 * @Author Ben
 * @Create 2025/1/1 10:00
 * @Version 1.0
 */
@Mapper
public interface OrderMapper {

    /**
     * 插入订单数据
     * @param order
     */
    void insert(Orders order);
}
