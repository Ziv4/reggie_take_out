package com.ziv.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ziv.reggie.entity.AddressBook;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author ziv
 * @version 1.0
 * @className AddressBookMapper
 * @date 2023/1/11 11:17:13
 * @since 1.0
 */
@Mapper
public interface AddressBookMapper extends BaseMapper<AddressBook> {
}
