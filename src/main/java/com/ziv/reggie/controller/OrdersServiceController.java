package com.ziv.reggie.controller;

import com.ziv.reggie.common.BaseContext;
import com.ziv.reggie.common.R;
import com.ziv.reggie.entity.Orders;
import com.ziv.reggie.service.OrderDetailService;
import com.ziv.reggie.service.OrdersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ziv
 * @version 1.0
 * @className OrderServiceController
 * @date 2023/1/12 11:49:36
 * @since 1.0
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrdersServiceController {
    @Resource
    private OrdersService ordersService;

    @Resource
    private OrderDetailService orderDetailService;

    /**
     * 提交订单
     * @param orders
     * @return
     */
    @PostMapping("/submit")
    public R<String> submit(@RequestBody Orders orders) {
        Long currentId = BaseContext.getCurrentId();
        orders.setUserId(currentId);
        ordersService.add(orders);

        return R.success("订单提交成功");
    }

}
