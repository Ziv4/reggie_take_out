package com.ziv.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ziv.reggie.common.BaseContext;
import com.ziv.reggie.common.R;
import com.ziv.reggie.entity.AddressBook;
import com.ziv.reggie.service.AddressBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ziv
 * @version 1.0
 * @className AddressBookController
 * @date 2023/1/11 11:18:53
 * @since 1.0
 */
@RestController
@RequestMapping("/addressBook")
@Slf4j
public class AddressBookController {

    @Resource
    private AddressBookService addressBookService;

    /**
     * 保存地址信息
     *
     * @param addressBook
     * @return
     */
    @PostMapping
    public R<String> save(@RequestBody AddressBook addressBook) {
        addressBook.setUserId(BaseContext.getCurrentId());
        addressBookService.save(addressBook);
        return R.success("地址保存成功");
    }

    /**
     * 显示地址列表
     *
     * @return
     */
    @GetMapping("/list")
    public R<List<AddressBook>> list() {
        Long currentId = BaseContext.getCurrentId();
        LambdaQueryWrapper<AddressBook> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(AddressBook::getUserId, currentId);
        List<AddressBook> list = addressBookService.list(queryWrapper);
        return R.success(list);
    }

    /**
     * 设置默认地址
     *
     * @param addressBook
     * @return
     */
    @PutMapping("/default")
    public R<String> defaultAddress(@RequestBody AddressBook addressBook) {
        addressBookService.setDefault(addressBook);
        return R.success("设定默认地址成功");
    }

    @GetMapping("/default")
    public R<AddressBook> getDefault() {
        Long currentId = BaseContext.getCurrentId();
        LambdaQueryWrapper<AddressBook> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(AddressBook::getUserId, currentId);
        queryWrapper.eq(AddressBook::getIsDefault, 1);
        AddressBook addressBook = addressBookService.getOne(queryWrapper);
        return R.success(addressBook);
    }
}
