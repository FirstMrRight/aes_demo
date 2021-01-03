package com.ltx.aes_demo.common.annotation;

import org.springframework.web.bind.annotation.Mapping;

import java.lang.annotation.*;

/**
 * @author Liu-PC
 * @desc 请求数据解密
 */

@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Mapping
@Documented
public @interface SecurityParameter {
    /**
     * 入参是否解密，默认解密
     * @return
     */
    boolean inDecode() default true;

    /**
     * 出参是否加密，默认加密
     * @return
     */
    boolean outEncode() default true;
}
