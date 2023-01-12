package com.ziv.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ziv.reggie.entity.Dish;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author ziv
 * @version 1.0
 * @className DishMapper
 * @date 2023/1/6 21:48:41
 * @since 1.0
 */
@Mapper
public interface DishMapper extends BaseMapper<Dish> {
}
