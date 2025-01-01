package com.sky.mapper;

import com.sky.entity.OrderDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ClassName: OrderDetailMapper
 * Package: com.sky.mapper
 * Description: This is a program for testing.
 *
 * @Author Ben
 * @Create 2025/1/1 10:00
 * @Version 1.0
 */
@Mapper
public interface OrderDetailMapper {

    /**
     * 批量插入订单明细数据
     * @param orderDetails
     */
    void insertBatch(List<OrderDetail> orderDetails);
}
