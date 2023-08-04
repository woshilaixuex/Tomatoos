package com.example.config;

import com.example.common.JavaWebToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


//@Component
@Slf4j
public class filter implements javax.servlet.Filter {
    @Autowired
    private JavaWebToken javaWebToken;
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        System.out.println(request.getRequestURL());
        String requestURI = request.getRequestURI();
        if ("/user/login".equals(requestURI) || "/unuser/register".equals(requestURI)) {
            chain.doFilter(req, res);
        } else {
            String token = request.getHeader("Authorization");
            String num = javaWebToken.parseToken(token);
            if (num != null) {
                AuthenticatedUserContainer.setAuthenticatedUser(token,num);
                chain.doFilter(req, res);
            } else {
                res.getWriter().println("403");
            }
        }
    }
}