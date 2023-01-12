package com.ziv.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ziv.reggie.entity.Employee;
import com.ziv.reggie.mapper.EmployeeMapper;
import com.ziv.reggie.service.EmployeeService;
import org.springframework.stereotype.Service;

/**
 * @author ziv
 * @version 1.0
 * @className EmployeeServiceImpl
 * @date 2023/1/3 20:59:36
 * @since 1.0
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

}
