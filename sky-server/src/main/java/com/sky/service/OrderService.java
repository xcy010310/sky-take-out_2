package com.sky.service;

import com.sky.dto.OrdersSubmitDTO;
import com.sky.vo.OrderSubmitVO;

/**
 * ClassName: OrderService
 * Package: com.sky.service
 * Description: This is a program for testing.
 *
 * @Author Ben
 * @Create 2025/1/1 9:57
 * @Version 1.0
 */
public interface OrderService {

    /**
     * 用户下单
     * @param ordersSubmitDTO
     * @return
     */
    OrderSubmitVO submitOrder(OrdersSubmitDTO ordersSubmitDTO);
}
