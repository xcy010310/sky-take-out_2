package com.sky.interceptor;

import com.sky.constant.JwtClaimsConstant;
import com.sky.context.BaseContext;
import com.sky.properties.JwtProperties;
import com.sky.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ClassName: JwtTokenUserInterceptor
 * Package: com.sky.interceptor
 * Description: This is a program for testing.
 *
 * @Author Ben
 * @Create 2024/12/31 11:17
 * @Version 1.0
 */

/**
 * jwt令牌校验的拦截器
 */
@Component
@Slf4j
public class JwtTokenUserInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtProperties jwtProperties;

    /**
     * 校验Jwt
     * @param request
     * @param response
     * @param hanler
     * @return
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object hanler) throws Exception {
        //判断当前拦截到的是Controller的方法还是其他资源
        if(!(hanler instanceof HandlerMethod)) {
            //当前拦截到的不是动态方法，直接方形
            return true;
        }

        //1.从请求头中获取令牌
        String token = request.getHeader(jwtProperties.getUserTokenName());

        //2.校验令牌
        try{
            log.info("jwt校验：{}", token);
            Claims claims = JwtUtil.parseJWT(jwtProperties.getUserSecretKey(), token);
            Long userId = Long.valueOf(claims.get(JwtClaimsConstant.USER_ID).toString());
            log.info("当前用户的id：", userId);
            BaseContext.setCurrentId(userId);
            //3.通过，放行
            return true;
        }catch(Exception ex) {
            //4.不通过，响应401
            response.setStatus(401);
            return false;
        }
    }
}
