package com.xuxian.handler;

import com.xuxian.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JwtHandler implements HandlerInterceptor {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // System.out.println("经过JWT拦截器");
        String headerToken = request.getHeader("AuthToken");
        // System.out.println("userjwt=====>" + headerToken);
        if (headerToken != null && headerToken.startsWith("CeShi ")) {
            String token = headerToken.substring(6);
            Claims claims = jwtUtil.parseJWT(token);
            if (claims != null) {
                if ("admin".equals(claims.get("roles"))) {
                    System.out.println("admin");
                    request.setAttribute("admin_claims", claims);
                }
                if ("user".equals(claims.get("roles"))) {
                    System.out.println("user");
                    request.setAttribute("user_claims", claims);
                }
            }
        }
        return true;
    }
}
