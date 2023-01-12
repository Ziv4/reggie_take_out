package com.ziv.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ziv.reggie.entity.AddressBook;

/**
 * @author ziv
 * @version 1.0
 * @className AddressBookService
 * @date 2023/1/11 11:17:41
 * @since 1.0
 */
public interface AddressBookService extends IService<AddressBook> {
    /**
     * 设置默认收获地址
     * @param addressBook
     */
    void setDefault(AddressBook addressBook);
}
