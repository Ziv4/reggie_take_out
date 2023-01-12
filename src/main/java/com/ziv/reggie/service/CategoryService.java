package com.ziv.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ziv.reggie.entity.Category;

/**
 * @author ziv
 * @version 1.0
 * @className CategoryService
 * @date 2023/1/6 14:54:57
 * @since 1.0
 */
public interface CategoryService extends IService<Category> {

    /**
     * 根据id删除分类，删除之前进行判断次分类是否被dish表和setmeal表引用
     * @param id
     */
    public void remove(Long id);
}
