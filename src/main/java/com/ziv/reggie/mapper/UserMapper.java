package com.ziv.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ziv.reggie.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author ziv
 * @version 1.0
 * @className UserMapper
 * @date 2023/1/10 20:36:07
 * @since 1.0
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
