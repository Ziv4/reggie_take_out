package com.ziv.reggie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ziv.reggie.common.CustomException;
import com.ziv.reggie.entity.AddressBook;
import com.ziv.reggie.entity.Orders;
import com.ziv.reggie.entity.ShoppingCart;
import com.ziv.reggie.entity.User;
import com.ziv.reggie.mapper.OrdersMapper;
import com.ziv.reggie.service.AddressBookService;
import com.ziv.reggie.service.OrdersService;
import com.ziv.reggie.service.ShoppingCartService;
import com.ziv.reggie.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ziv
 * @version 1.0
 * @className OrderServiceImpl
 * @date 2023/1/12 11:48:28
 * @since 1.0
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {

    @Resource
    private ShoppingCartService shoppingCartService;

    @Resource
    private UserService userService;

    @Resource
    private AddressBookService addressBookService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(Orders orders) {
        LambdaQueryWrapper<ShoppingCart> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ShoppingCart::getUserId, orders.getUserId());
        List<ShoppingCart> shoppingCartList = shoppingCartService.list(queryWrapper);
        if (shoppingCartList == null || shoppingCartList.size() == 0) {
            throw new CustomException("购物车为空，不能下单");
        }
        User user = userService.getById(orders.getUserId());
        AddressBook addressBook = addressBookService.getById(orders.getAddressBookId());
        if (addressBook == null) {
            throw new CustomException("地址信息错误，不能下单");
        }



        this.save(orders);


    }
}
