package com.ziv.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ziv.reggie.entity.DishFlavor;
import com.ziv.reggie.mapper.DishFlavorMapper;
import com.ziv.reggie.service.DishFlavorService;
import org.springframework.stereotype.Service;

/**
 * @author ziv
 * @version 1.0
 * @className DishFlavorServiceImpl
 * @date 2023/1/9 22:18:52
 * @since 1.0
 */
@Service
public class DishFlavorServiceImpl extends ServiceImpl<DishFlavorMapper, DishFlavor> implements DishFlavorService {
}
