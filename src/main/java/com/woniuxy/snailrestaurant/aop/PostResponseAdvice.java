package com.woniuxy.snailrestaurant.aop;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.woniuxy.snailrestaurant.common.CustomResponse;
import com.woniuxy.snailrestaurant.common.NoAdvice;
import com.woniuxy.snailrestaurant.exception.BusinessException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    @ExceptionHandler(value =   MethodArgumentNotValidException.class)
    @ResponseBody
    public Response   methodArgumentNotValidException(HttpServletRequest req,   MethodArgumentNotValidException e) {
        e.printStackTrace();
        BindingResult bindingResult = e.getBindingResult();
        List<ObjectError> allErrors = bindingResult.getAllErrors();
       StringBuffer stringBuilder=new StringBuffer();
        for (ObjectError error:allErrors){
            stringBuilder.append(error.getObjectName()+":");
            stringBuilder.append(error.getDefaultMessage());
        }

        return new Response("400", stringBuilder.toString());
    }

    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public Response BusinessexceptionHandler(HttpServletRequest req, BusinessException e) {
        e.printStackTrace();
        return new Response(String.valueOf(e.getCode()), e.getMessage());
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
