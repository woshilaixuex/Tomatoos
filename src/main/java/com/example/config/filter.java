package com.example.config;

import com.example.common.JavaWebToken;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class filter implements javax.servlet.Filter {
    private JavaWebToken javaWebToken;
    private StringRedisTemplate stringRedisTemplate;
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
//        System.out.println(request.getRequestURL());
        String requestURI = request.getRequestURI();

        // 判断接口类型从而实现不同功能
        if ("/user/login".equals(requestURI) || "/unuser/register".equals(requestURI)) {
            chain.doFilter(req, res);
        } else {
            String token = request.getHeader("Authorization");
            if (stringRedisTemplate.opsForValue().get(token) != null) {
                chain.doFilter(req, res); // 判断jwt是否正确
            } else {
                res.getWriter().println("403");
            }
        }
    }
}