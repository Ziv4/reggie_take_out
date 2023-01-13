package com.ziv.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ziv.reggie.common.R;
import com.ziv.reggie.entity.User;
import com.ziv.reggie.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author ziv
 * @version 1.0
 * @className UserController
 * @date 2023/1/10 20:37:20
 * @since 1.0
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Resource
    private UserService userService;

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    /**
     * 发送手机验证码
     *
     * @param user
     * @return
     */
    @PostMapping("/sendMsg")
    public R<String> sendMsg(@RequestBody User user, HttpSession session) {

        String phone = user.getPhone();
        if (StringUtils.isNotEmpty(phone)) {
            String code = "1234";
            log.info("code={}", code);
            //session.setAttribute(phone, code);
            redisTemplate.opsForValue().set(phone,code,5, TimeUnit.MINUTES);
            return R.success("短信发送成功");
        }

        return R.error("短信发送失败");
    }

    @PostMapping("/login")
    public R<User> login(@RequestBody Map<String,String> map, HttpSession session) {
        log.info(map.toString());

        String code = map.get("code");
        String phone = map.get("phone");
        //String codeInSession = (String) session.getAttribute(phone);
        String codeInSession = (String) redisTemplate.opsForValue().get(phone);
        if (code != null && code.equals(codeInSession)) {
            LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(User::getPhone, phone);
            User user = userService.getOne(queryWrapper);
            if (user == null) {
                user = new User();
                user.setPhone(phone);
                user.setStatus(1);
                userService.save(user);
            }
            session.setAttribute("user", user.getId());
            redisTemplate.delete(phone);
            return R.success(user);
        }

        return R.error("登陆失败，验证码错误");
    }
}
