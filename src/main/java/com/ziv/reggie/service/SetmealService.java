package com.ziv.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ziv.reggie.dto.SetmealDto;
import com.ziv.reggie.entity.Setmeal;

import java.util.List;

/**
 * @author ziv
 * @version 1.0
 * @className SetmealService
 * @date 2023/1/6 21:54:22
 * @since 1.0
 */
public interface SetmealService extends IService<Setmeal> {
    /**
     * 新增套餐信息，同时新增对应的套餐内菜品信息
     * @param setmealDto
     */
    void saveWithDish(SetmealDto setmealDto);

    /**
     * 删除套餐，同时需要删除套餐和菜品的关联数据
     * @param ids
     */
    void removeWithDish(List<Long> ids);
}
