package com.ziv.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.ziv.reggie.entity.Setmeal;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author ziv
 * @version 1.0
 * @className Setmeal
 * @date 2023/1/6 21:53:19
 * @since 1.0
 */
@Mapper
public interface SetmealMapper extends BaseMapper<Setmeal> {
}
