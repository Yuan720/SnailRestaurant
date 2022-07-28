package com.woniuxy.snailrestaurant.aop;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;
import com.woniuxy.snailrestaurant.common.CurrentUserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @version 1.0
 * @date 2021/2/1 17:26
 */
@Component
@Slf4j
public class JwtAuthenticationInterceptor implements HandlerInterceptor {
    @Value("${jwt.secretkey}")
    String secretKey;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // springboot跨域请求  放行OPTIONS请求
        if (request.getMethod().toUpperCase().equals("OPTIONS")) {
            return true;//通过所有OPTION请求
        }
        // 获取请求头中的Token   参数要跟前端的设置一样
        String authorHeader = request.getHeader("Authorization");
        if (authorHeader == null) {
            return true;
            //  return false;
            // 暂时不拦截,只做封装
        }
        String token = authorHeader.substring(7);
        Algorithm alg = Algorithm.HMAC256(secretKey);
        Verification verification = JWT.require(alg);
        verification.acceptExpiresAt(System.currentTimeMillis());
        verification.acceptNotBefore(System.currentTimeMillis() - 1000 * 60 * 60 * 24 * 5);
        JWTVerifier jwtVerifier = null;
        jwtVerifier = verification.build();
        DecodedJWT decodedJWT;
        try {

            decodedJWT = jwtVerifier.verify(token);
        } catch (Exception e) {
            log.debug("token 验证无效");
            return true;

        }

        // 获取token中的用户的id
        //      String  userId = JwtUtil.parseToken(token);
        //log.info("查看token中的用户id：" + userId);
        // 获取当前操作用户信息
        // 为CurrentUserMethodArgumentResolver中的currentUserInfo设置用户信息
        CurrentUserInfo currentUserInfo = new CurrentUserInfo();
        currentUserInfo.setId(decodedJWT.getClaim("id").asInt())
                .setName(decodedJWT.getClaim("userName").asString())
                .setAccountType(decodedJWT.getClaim("accountType").asString());
        if (decodedJWT.getClaim("accountType").asString().equals("merchant")) {
            currentUserInfo.setRole(decodedJWT.getClaim("role").asInt());
        }
        request.setAttribute("currentUserInfo", currentUserInfo);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
