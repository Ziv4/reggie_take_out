package com.ziv.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ziv.reggie.entity.Category;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author ziv
 * @version 1.0
 * @className CategoryMapper
 * @date 2023/1/6 14:54:14
 * @since 1.0
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {
}
