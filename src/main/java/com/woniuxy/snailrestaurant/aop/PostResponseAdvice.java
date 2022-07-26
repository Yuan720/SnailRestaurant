package com.woniuxy.snailrestaurant.aop;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.woniuxy.snailrestaurant.common.CustomResponse;
import com.woniuxy.snailrestaurant.common.NoAdvice;
import com.woniuxy.snailrestaurant.exception.BusinessException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice(basePackages = "com.woniuxy.snailrestaurant.controller")
public class PostResponseAdvice implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        System.out.println(returnType.getMethod().getName());
        if (returnType.getMethod().isAnnotationPresent(NoAdvice.class)) {
            return false;
        }
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof Response) {
            return body;
        }
        if (body instanceof BusinessException) {
            BusinessException exception = (BusinessException) body;
            Response objectResponse = new Response<>();
            objectResponse.message = exception.getMessage();
            objectResponse.code = String.valueOf(exception.getCode());
            return objectResponse;
        }
        if (body instanceof String) {
            return body;
        }
        if (body instanceof CustomResponse){
            return body;
        }
        return Response.createResponse(body);
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Response exceptionHandler(HttpServletRequest req, Exception e) {
        e.printStackTrace();
        return new Response("500", "系统内部异常!");
    }

    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public BusinessException BusinessexceptionHandler(HttpServletRequest req, BusinessException e) {
        return e;
    }

    @Data
    @Builder
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @AllArgsConstructor
    public static class Response<T> {
        private String code;
        private String message;
        private T data;

        private Response(String code, String msg) {

            this.code = code;
            this.message = msg;
        }

        private Response() {
            this.code = "200";
            this.message = "success";
        }

        private Response(T data) {
            this();
            this.data = data;
        }

        public static <T> Response<T> createResponse(T data) {
            return new Response<>(data);
        }

    }
}