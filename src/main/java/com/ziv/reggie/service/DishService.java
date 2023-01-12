package com.ziv.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ziv.reggie.dto.DishDto;
import com.ziv.reggie.entity.Dish;

import java.util.List;

/**
 * @author ziv
 * @version 1.0
 * @className DishService
 * @date 2023/1/6 21:49:28
 * @since 1.0
 */
public interface DishService extends IService<Dish> {
    /**
     * 新增菜品，同时保存相应的口味数据
     * @param dishDto
     */
    void saveWithFlavor(DishDto dishDto);

    /**
     * 根据id查询菜品信息和对应的口味信息
     * @param id
     * @return
     */
    DishDto getByIdWithFlavor(Long id);

    /**
     * 更新菜品信息，同时更新相应的口味信息
     * @param dishDto
     */
    void updateWithFlavor(DishDto dishDto);

    /**
     * 根据id删除菜品信息，同时删除对应的口味信息
     * @param ids
     */
    void delete(Long ids);

    /**
     * 查询菜品信息，并且查询对应的口味信息
     * @param dish
     * @return
     */
    List<DishDto> listWithFlavors(Dish dish);
}
