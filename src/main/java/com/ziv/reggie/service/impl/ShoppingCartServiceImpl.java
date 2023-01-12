package com.ziv.reggie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ziv.reggie.entity.ShoppingCart;
import com.ziv.reggie.mapper.ShoppingCartMapper;
import com.ziv.reggie.service.ShoppingCartService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * @author ziv
 * @version 1.0
 * @className ShoppingCartServiceImpl
 * @date 2023/1/11 14:40:32
 * @since 1.0
 */
@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart> implements ShoppingCartService {


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(ShoppingCart shoppingCart) {
        LambdaUpdateWrapper<ShoppingCart> queryWrapper = new LambdaUpdateWrapper<>();
        Long dishId = shoppingCart.getDishId();
        Long setmealId = shoppingCart.getSetmealId();
        queryWrapper.eq(dishId != null, ShoppingCart::getDishId, dishId);
        queryWrapper.eq(setmealId != null, ShoppingCart::getSetmealId, setmealId);
        ShoppingCart cart = this.getOne(queryWrapper);
        if (cart != null) {
            queryWrapper.set(ShoppingCart::getNumber, cart.getNumber() + 1);
            this.update(queryWrapper);
        } else {
            shoppingCart.setCreateTime(LocalDateTime.now());
            this.save(shoppingCart);
        }
    }

    @Override
    public void sub(ShoppingCart shoppingCart) {
        LambdaUpdateWrapper<ShoppingCart> queryWrapper = new LambdaUpdateWrapper<>();
        Long dishId = shoppingCart.getDishId();
        Long setmealId = shoppingCart.getSetmealId();
        queryWrapper.eq(dishId != null, ShoppingCart::getDishId, dishId);
        queryWrapper.eq(setmealId != null, ShoppingCart::getSetmealId, setmealId);
        ShoppingCart cart = this.getOne(queryWrapper);
        Integer number = cart.getNumber();
        if (number > 1) {
            queryWrapper.set(ShoppingCart::getNumber, cart.getNumber() - 1);
            this.update(queryWrapper);
        } else {
            this.remove(queryWrapper);
        }
    }
}
