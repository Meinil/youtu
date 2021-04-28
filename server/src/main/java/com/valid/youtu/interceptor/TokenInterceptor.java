package com.valid.youtu.interceptor;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.valid.youtu.utils.Result;
import com.valid.youtu.utils.TokenUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception{

        if(request.getMethod().equals("OPTIONS")){
            response.setStatus(200);
            return true;
        }

        Result result = new Result();
        String token = request.getHeader("Authorization");
        try {
            DecodedJWT tokenInfo = TokenUtil.verify(token);  // 获取令牌
            return true;
        } catch (SignatureVerificationException e) {
            e.printStackTrace();  // 签名异常
            result.setMsg("无效签名");
        } catch (TokenExpiredException e) {
            e.printStackTrace();  // 过期异常
            result.setMsg("令牌过期");
        } catch (AlgorithmMismatchException e) {
            e.printStackTrace();  // 算法异常
            result.setMsg("算法异常");
        } catch (Exception e) {
            e.printStackTrace();  // 总异常
            result.setMsg("令牌无效");
        }

        result.setCode(Result.NOT_AUTHORIZATION);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");

        String json = new ObjectMapper().writeValueAsString(result);
        response.getWriter().println(json);
        return false;
    }
}