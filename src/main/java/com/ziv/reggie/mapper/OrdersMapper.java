package com.ziv.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ziv.reggie.entity.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.core.annotation.Order;

/**
 * @author ziv
 * @version 1.0
 * @className OrderMapper
 * @date 2023/1/12 11:46:59
 * @since 1.0
 */
@Mapper
public interface OrdersMapper extends BaseMapper<Orders> {
}
