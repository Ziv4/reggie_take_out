package com.ziv.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ziv.reggie.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author ziv
 * @version 1.0
 * @className EmployeeMapper
 * @date 2023/1/3 20:57:18
 * @since 1.0
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {



}
