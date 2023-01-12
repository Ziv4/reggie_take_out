package com.ziv.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ziv.reggie.entity.Orders;
import org.springframework.core.annotation.Order;

/**
 * @author ziv
 * @version 1.0
 * @className OrderService
 * @date 2023/1/12 11:47:47
 * @since 1.0
 */
public interface OrdersService extends IService<Orders> {
    /**
     * 提交订单，添加订单信息
     * @param orders
     */
    void add(Orders orders);
}
