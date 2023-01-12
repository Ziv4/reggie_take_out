package com.ziv.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ziv.reggie.entity.OrderDetail;
import com.ziv.reggie.mapper.OrderDetailMapper;
import com.ziv.reggie.service.OrderDetailService;
import org.springframework.stereotype.Service;

/**
 * @author ziv
 * @version 1.0
 * @className OrderDetailServiceImpl
 * @date 2023/1/12 11:48:58
 * @since 1.0
 */
@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {
}
