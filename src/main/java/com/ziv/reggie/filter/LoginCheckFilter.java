package com.ziv.reggie.filter;

import com.alibaba.fastjson.JSON;
import com.ziv.reggie.common.BaseContext;
import com.ziv.reggie.common.R;
import com.ziv.reggie.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * 检查用户是否登录的过滤器
 *
 * @author ziv
 * @version 1.0
 * @className LoginCheckFilter
 * @date 2023/1/5 12:05:25
 * @since 1.0
 */
@WebFilter(filterName = "loginCheckFilter", urlPatterns = "/*")
@Slf4j
public class LoginCheckFilter implements Filter {
    /**
     * 路径匹配器，用来进行路径比较，支持通配符
     */
    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {


        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String requestURI = request.getRequestURI();

        //设定不需要处理的请求路径
        String[] urls = {
                "/employee/login",
                "/employee/logout",
                "/backend/**",
                "/front/**",
                "/common/**",
                "/user/login",
                "/user/sendMsg"
        };

        log.info("拦截到请求：{}", requestURI);
        //判断本次请求是否需要处理
        boolean check = checkURI(urls, requestURI);

        //如果不需要处理，直接放行
        if (check) {
            log.info("本次请求{}不需要处理",requestURI);
            filterChain.doFilter(request, response);
            return;
        }

        //判断后台管理员的登录状态，如果已登录，则放行
        Long empId = (Long) request.getSession().getAttribute("employee");
        if (empId != null) {
            log.info("用户已登录，用户id为：{}",empId);
            BaseContext.setCurrentId(empId);
            filterChain.doFilter(request, response);
            return;
        }

        //判断正常用户的登录状态，如果已登录，则放行
        Long userId = (Long) request.getSession().getAttribute("user");
        if (userId != null) {
            log.info("用户已登录，用户id为：{}",userId);
            BaseContext.setCurrentId(userId);
            filterChain.doFilter(request, response);
            return;
        }

        log.info("用户未登录");
        //如果未登录，则返回未登录结果
        response.getWriter().print(JSON.toJSONString(R.error("NOTLOGIN")));
    }

    /**
     * 路径匹配，检查本次请求是否需要放行
     *
     * @param requestURI
     * @param urls
     * @return
     */
    public boolean checkURI(String[] urls, String requestURI) {
        for (String url : urls) {
            boolean match = PATH_MATCHER.match(url, requestURI);
            if (match) {
                return true;
            }
        }
        return false;
    }
}
