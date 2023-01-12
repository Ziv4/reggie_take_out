package com.ziv.reggie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ziv.reggie.common.BaseContext;
import com.ziv.reggie.entity.AddressBook;
import com.ziv.reggie.mapper.AddressBookMapper;
import com.ziv.reggie.service.AddressBookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ziv
 * @version 1.0
 * @className AddressBookServiceImpl
 * @date 2023/1/11 11:18:02
 * @since 1.0
 */
@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook> implements AddressBookService {


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void setDefault(AddressBook addressBook) {
        LambdaUpdateWrapper<AddressBook> queryWrapper = new LambdaUpdateWrapper<>();
        queryWrapper.eq(AddressBook::getUserId, BaseContext.getCurrentId());
        queryWrapper.eq(AddressBook::getIsDefault, 1);
        queryWrapper.set(AddressBook::getIsDefault, 0);
        this.update(queryWrapper);
        addressBook.setIsDefault(1);
        this.updateById(addressBook);
    }
}
