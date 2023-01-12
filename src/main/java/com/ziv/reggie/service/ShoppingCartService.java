package com.ziv.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ziv.reggie.entity.ShoppingCart;

/**
 * @author ziv
 * @version 1.0
 * @className ShoppingCartService
 * @date 2023/1/11 14:40:12
 * @since 1.0
 */
public interface ShoppingCartService extends IService<ShoppingCart> {
    /**
     * 添加菜品或套餐到购物车，先查询购物车内有没有相同的菜品或套餐，
     * 如果有则修改对应的数量，如果没有则新增
     * @param shoppingCart
     */
    void add(ShoppingCart shoppingCart);

    /**
     * 删除购物车里的菜品或套餐信息，先判断数量，
     * 如果数量大于1，则将数量减1；如果数量等于1，则删除此信息
     * @param shoppingCart
     */
    void sub(ShoppingCart shoppingCart);
}
