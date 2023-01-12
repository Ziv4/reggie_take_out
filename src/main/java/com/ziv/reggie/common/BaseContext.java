package com.ziv.reggie.common;

/**
 * 基于ThreadLocal封装的工具类，用户保存和获取session中用户的id
 * @author ziv
 * @version 1.0
 * @className BaseContext
 * @date 2023/1/6 14:37:28
 * @since 1.0
 */
public class BaseContext {

    private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    /**
     * 设置值
     * @param id
     */
    public static void setCurrentId(Long id) {
        threadLocal.set(id);
    }

    /**
     * 获取值
     * @return
     */
    public static Long getCurrentId() {
        return threadLocal.get();
    }

}
