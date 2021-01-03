package com.ltx.aes_demo.common.advice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ltx.aes_demo.common.annotation.Decrypt;
import com.ltx.aes_demo.common.annotation.SecurityParameter;
import com.ltx.aes_demo.common.constant.AesConstant;
import com.ltx.aes_demo.common.utils.AesEncryptUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Objects;

/**
 * @author Liutx
 * @date 2021/1/3 14:46
 * @Description
 */

@Slf4j
@ControllerAdvice(basePackages = "com.ltx.aes_demo.controller")
public class EncodeResponseBodyAdvice implements ResponseBodyAdvice {


    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        boolean encode = false;
        if (Objects.requireNonNull(methodParameter.getMethod()).isAnnotationPresent(SecurityParameter.class)) {
            //获取注解配置的包含和去除字段
            SecurityParameter serializedField = methodParameter.getMethodAnnotation(SecurityParameter.class);
            //出参是否需要加密
            encode = serializedField.outEncode();

            /**
             * 测试自定义注解，学习AES加解密可忽略删除此if
             */
            if (Objects.requireNonNull(methodParameter.getMethod()).isAnnotationPresent(Decrypt.class)){
                log.info("own @interface");
                Decrypt decryptField = methodParameter.getMethodAnnotation(Decrypt.class);
                boolean test = decryptField.test();
                if (test){
                    log.info("奥里给！");
                }
            }
        }
        if (encode) {
            log.info("对方法method :【" + methodParameter.getMethod().getName() + "】返回数据进行加密");
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                String result = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(body);
                return AesEncryptUtil.aesEncrypt(result, AesConstant.aesKey);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("对方法method :【" + methodParameter.getMethod().getName() + "】返回数据进行解密出现异常：" + e.getMessage());
            }
        }
        return body;
    }
}
